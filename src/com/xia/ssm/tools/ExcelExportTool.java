package com.xia.ssm.tools;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.text.SimpleDateFormat;
import java.util.List;

import jxl.format.VerticalAlignment;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;


/**
 * Excel导出工具类
 * @description: 
 * @version 1.0
 * @company：jy
 * @createDate 2015-1-5;下午04:26:48
 * @author wangzhandong
 */
public class ExcelExportTool {
	/**
	 * Excel导出　JXL方式
	 * @param dataMap
	 */
	@SuppressWarnings({ "unused", "unchecked" })
	public static void exportExcelWithJXL(WritableWorkbook wwb,String fileName, String[] titleArray, String[] columnArray, List dataList){
		//得到第一个sheet
		WritableSheet ws = wwb.createSheet(fileName, 0);
		//设置默认宽度		
		ws.getSettings().setDefaultColumnWidth(18);
        //设置默认高度
		ws.getSettings().setDefaultRowHeight(2000);
		ws.setColumnView(0, 14);              
		try {
			ws.setRowView(0, 500);
			//是否显示网格
			ws.getSettings().setShowGridLines(true);
			WritableFont fonte= new WritableFont(WritableFont.createFont("宋体"),12,WritableFont.NO_BOLD);
			WritableCellFormat cellFormat=new jxl.write.WritableCellFormat(fonte);
			cellFormat.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
			//水平居中
			cellFormat.setAlignment(jxl.format.Alignment.CENTRE);
			//垂直居中
			cellFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
			jxl.write.Label label = null;
			
			//拼装表头
			for(int i=0; i<titleArray.length; i++){
				String title = titleArray[i];
				label=new jxl.write.Label(i,0,title,cellFormat);
				ws.addCell(label);
			}
			
			//拼装数据
			for(int j=0; j<dataList.size(); j++){
				Object obj = dataList.get(j);
				PropertyDescriptor[] props = null;
				try {
					props = Introspector.getBeanInfo(obj.getClass(), Object.class).getPropertyDescriptors();
				} catch (IntrospectionException e) {
				}
				
				//字段名称
				Object tmpObj = null;
				String columnName = null;
				String columnValue = null;
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				 
				for(int n=0; n<columnArray.length; n++){
					if (props != null) {
						for (int m = 0; m < props.length; m++) {
							try {
								columnName = props[m].getName();
								tmpObj = props[m].getReadMethod().invoke(obj);
								
								if(props[m].getReadMethod().invoke(obj) instanceof java.util.Date) {
									columnValue = sdf.format((java.util.Date)tmpObj);
									if(columnValue!=null){
										String[] dateArray = columnValue.split(" ");
										if(dateArray.length==2){
											if("00:00:00".equals(dateArray[1])){
												columnValue=dateArray[0];
											}
										}
									}
								} else {
									columnValue = "" + tmpObj;
								}
								if(columnArray[n].equals(columnName.trim())){
									label=new jxl.write.Label(n,j+1,StringUtils.notEmpty(columnValue)?columnValue:"",cellFormat);
									ws.addCell(label);
								}
							}catch(Exception ex){
								ex.printStackTrace();
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}      
	}
	
	/**
	 * Excel导出　JXL方式
	 * @param dataMap
	 */
	@SuppressWarnings({ "unused", "unchecked" })
	public static void exportExcelWithJXL(WritableWorkbook wwb,String fileName, String[] titleArray, String[] columnArray, List dataList,String[] appendTitle,String[] appendValue){
		//得到第一个sheet
		WritableSheet ws = wwb.createSheet(fileName, 0);
		//设置默认宽度		
		ws.getSettings().setDefaultColumnWidth(18);
        //设置默认高度
		ws.getSettings().setDefaultRowHeight(2000);
		ws.setColumnView(0, 14);              
		try {
			ws.setRowView(0, 500);
			//是否显示网格
			ws.getSettings().setShowGridLines(true);
			WritableFont fonte= new WritableFont(WritableFont.createFont("宋体"),12,WritableFont.NO_BOLD);
			WritableCellFormat cellFormat=new jxl.write.WritableCellFormat(fonte);
			cellFormat.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
			//水平居中
			cellFormat.setAlignment(jxl.format.Alignment.CENTRE);
			//垂直居中
			cellFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
			jxl.write.Label label = null;
			int rown=0;
			if( appendValue!=null ){
				//拼装统计信息表头
				for(int i=0; i<appendValue.length; i++){
					String title = appendTitle[i];
					label=new jxl.write.Label(i,0,title,cellFormat);
					ws.addCell(label);
					label=new jxl.write.Label(i,1,appendValue[i],cellFormat);
					ws.addCell(label);
				}
				rown=3;
			}
			
			//拼装表头
			for(int i=0; i<titleArray.length; i++){
				String title = titleArray[i];
				label=new jxl.write.Label(i,0+rown,title,cellFormat);
				ws.addCell(label);
			}
			
			//拼装数据
			for(int j=0; j<dataList.size(); j++){
				Object obj = dataList.get(j);
				PropertyDescriptor[] props = null;
				try {
					props = Introspector.getBeanInfo(obj.getClass(), Object.class).getPropertyDescriptors();
				} catch (IntrospectionException e) {
				}
				
				//字段名称
				Object tmpObj = null;
				String columnName = null;
				String columnValue = null;
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				 
				for(int n=0; n<columnArray.length; n++){
					if (props != null) {
						for (int m = 0; m < props.length; m++) {
							try {
								columnName = props[m].getName();
								tmpObj = props[m].getReadMethod().invoke(obj);
								
								if(props[m].getReadMethod().invoke(obj) instanceof java.util.Date) {
									columnValue = sdf.format((java.util.Date)tmpObj);
									if(columnValue!=null){
										String[] dateArray = columnValue.split(" ");
										if(dateArray.length==2){
											if("00:00:00".equals(dateArray[1])){
												columnValue=dateArray[0];
											}
										}
									}
								} else {
									columnValue = "" + tmpObj;
								}
								if(columnArray[n].equals(columnName.trim())){
									label=new jxl.write.Label(n,j+(rown+1),StringUtils.notEmpty(columnValue)?columnValue:"",cellFormat);
									ws.addCell(label);
								}
							}catch(Exception ex){
								ex.printStackTrace();
							}
						}
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}      
	}
	
	public static String toUtf8String(String s){ 
	     StringBuffer sb = new StringBuffer(); 
	       for (int i=0;i<s.length();i++){ 
	          char c = s.charAt(i); 
	          if (c >= 0 && c <= 255){sb.append(c);} 
	        else{ 
	        byte[] b; 
	         try { b = Character.toString(c).getBytes("utf-8");} 
	         catch (Exception ex) { 
	                  b = new byte[0]; 
	         } 
	            for (int j = 0; j < b.length; j++) { 
	             int k = b[j]; 
	              if (k < 0) k += 256; 
	              sb.append("%" + Integer.toHexString(k).toUpperCase()); 
	              } 
	     } 
	  } 
	  return sb.toString(); 
	}
}
