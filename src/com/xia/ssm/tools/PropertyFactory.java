package com.xia.ssm.tools;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * Description:加载配置文件
 * 
 */
public class PropertyFactory {

    private static Log logger = LogFactory.getLog(PropertyFactory.class);

    private static java.util.Properties pros = new java.util.Properties();
    
    private static String fileName = "db.properties";

    /**
     * @param filePaths
     *            参数文件路径
     */
    public PropertyFactory(List<String> filePaths) {
        if (filePaths != null) {
            for (int i = 0; i < filePaths.size(); i++) {
                String filePath = filePaths.get(i);
                InputStream in = null;
                
                try {
                    in = new BufferedInputStream(new FileInputStream(getfile(filePath)));
                    pros.load(in);
                } catch (Exception e) {
                    logger.error("加载配置文件出错 ：\n", e);
                } finally {
                    if (in != null) {
                        try {
                            in.close();
                        } catch (IOException e) {
                            logger.error("关闭输入流出错 ：\n", e);
                        }
                    }
                }
            }
        }
        fileName = getfile(fileName);

    }
    
    /**
     * 获取文件路径
     * @param filePath
     * @return
     */
    private String getfile(String filePath) {
        URL url = Thread.currentThread().getContextClassLoader().getResource(filePath);
        if (null == url) {
            url = this.getClass().getClassLoader().getResource(filePath);
        }
        if (null == url) {
            url = this.getClass().getResource(filePath);
        }

        // 解决文件路径可能出现空格的问题
        String path = url.getFile();
        if (!"".equals(path)) {
            path = path.replace("%20", " ");
        }
        return path;
    }

    /**
     * Description:通过key获取参数值。
     * 
     * @param key
     *            参数文件key
     * @return String
     * @throws
     * @Author hzl Create Date: 2013-1-5 上午11:46:19
     */
    public static String getProperty(String key) {
        return pros.getProperty(key);
    }

    /**
     * Description:
     * 
     * @param key
     *            key
     * @param value
     *            value
     * @return 
     * @throws
     * @Author hzl Create Date: 2013-1-5 上午11:46:22
     */
    public static void setProperty(String key, String value) {
        pros.setProperty(key, value);
        writeProperties();
    }

    /**
     * 回写配置文件
     */
    private synchronized static void writeProperties() {
        OutputStream out = null;
        try {
            out = new FileOutputStream(fileName);
            pros.store(out, "");
        } catch (IOException e) {
            logger.error(e.getMessage());
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    logger.error(e.getMessage());
                }
            }
        }
    }

    /**
     * Description:读取参数文件
     * 
     * @param path
     *            参数文件路径
     * @param fileName
     *            参数文件名
     * @return HashMap<String,String>
     * @throws
     * @Author hzl Create Date: 2013-1-5 上午11:46:25
     */
    public HashMap<String, String> readProperty(String path, String fileName) {
        HashMap<String, String> map = new HashMap<String, String>();
        InputStream in = null;
        java.util.Properties p = new java.util.Properties();
        URL url = Thread.currentThread().getContextClassLoader().getResource(path + fileName);
        if (null == url) {
            url = this.getClass().getClassLoader().getResource(path + fileName);
        }

        // 解决文件路径可能出现空格的问题
        String filepath = url.getFile();
        if (!"".equals(filepath)) {
            path = path.replace("%20", " ");
        }

        try {
            in = new BufferedInputStream(new FileInputStream(filepath));
            p.load(in);
            Enumeration<?> e = p.propertyNames();
            while (e.hasMoreElements()) {
                String key = (String) e.nextElement();
                String ruleStr = p.getProperty(key);
                map.put(key, ruleStr);
            }
        } catch (Exception e) {
            logger.error("加载验证文件出错 ：\n", e);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    logger.error("关闭输入流出错 ：\n", e);
                }
            }
        }

        return map;
    }

    /**
     * Description:加载XML文件
     * 
     * @param path
     *            参数文件路径
     * @param fileName
     *            参数文件名
     * @return List<HashMap<String,String>>
     * @throws
     * @Author hzl Create Date: 2013-1-5 上午11:47:54
     */
    @SuppressWarnings("unchecked")
    public List<HashMap<String, String>> readValidateXml(String path, String fileName) {
        URL url = Thread.currentThread().getContextClassLoader().getResource(path + fileName);
        if (null == url) {
            url = this.getClass().getClassLoader().getResource(path + fileName);
        }
        InputStream in = null;
        List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        String name = "";
        String condition = "";
        String notNull = "";
        String express = "";
        String message = "";
        String nameStr = "";
        try {
            in = new BufferedInputStream(new FileInputStream(url.getFile()));
            SAXReader sReader = new SAXReader();
            Document document = sReader.read(in);
            Element root = document.getRootElement();
            List<Element> fields = root.elements("field");
            for (Element field : fields) {
                HashMap<String, String> ruleMap = new HashMap<String, String>();
                name = field.attributeValue("name");
                condition = field.elementText("condition");
                express = field.elementText("express");
                notNull = field.elementText("notNull");
                message = field.elementText("message");
                nameStr = field.elementText("nameStr");
                ruleMap.put("name", name);
                ruleMap.put("condition", condition);
                ruleMap.put("express", express);
                ruleMap.put("notNull", notNull);
                ruleMap.put("message", message);
                ruleMap.put("nameStr", nameStr);
                list.add(ruleMap);
            }
        } catch (Exception e) {
            logger.error("加载验证XML文件出错 ：\n", e);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    logger.error("关闭输入流出错 ：\n", e);
                }
            }
        }

        return list;
    }

    /**
     * 重新加载/config.properties配置信息。
     * 
     */
    public synchronized void reloadProperties() {
        HashMap<String, String> properties = this.readProperty("", fileName);
        pros.putAll(properties);
    }
}