package com.xia.base.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Description:多语言工具类，通过该类，获取本地多语言。
 * 
 * @version 1.0
 * 
 */
public class ResourceBundleHelper {
    private static ResourceBundle resourceBundle = null;

    private String baseName;

    /**
     * 构造方法，通过多语言文件位置创建对象。
     * 
     * @param baseName
     *            多语言文件路径。
     */
    public ResourceBundleHelper(String baseName) {
        this.baseName = baseName;
        loadBundle();
    }
    
    public ResourceBundleHelper() {
        this.baseName = "i18n.multilang";
        loadBundle();
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }

    /**
     * 构造方法，通过多语言文件位置、Locale创建对象。
     */
    public synchronized void loadBundle() {
        resourceBundle = ResourceBundle.getBundle(baseName, Locale.getDefault());
    }

    /**
     * Description:根据多语言文件中的key，获取对应的值。
     * 
     * @param key
     *            多语言文件中的key。
     * @return String 从多语言文件中，根据key得到的值。
     * @Author hzl Create Date: 2013-1-11 下午3:36:10
     */
    public static String getString(String key) {
        return resourceBundle.getString(key);
    }
}