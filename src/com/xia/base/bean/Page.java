package com.xia.base.bean;

import java.util.List;

/**
 * Description:分页类。request传过来的参数必须是page（第几页）、rows（每页行数）。
 * 
 * @version 1.0
 * 
 */
public class Page {
    /**
     * 页码, 默认为第一页。
     */
    private int draw = 1;

    /**
     * 每页行数, 默认每页10行。
     */
    private int length = 10;

    /**
     * 符合条件的所有记录的行数。
     */
    private long recordsFiltered;
    
    /**
     * 所有记录的行数。
     */
    private long recordsTotal;
    
	/**
     * 记录开始行数
     */
    private int start;

    /**
     * 结果集
     */
    private List<?> data;
    
    /**
     * Page 返回List的类型
     */
    private String returnClass;
    
    public String getReturnClass() {
        return returnClass;
    }

    public void setReturnClass(String returnClass) {
        this.returnClass = returnClass;
    }
    
    public void setReturnClass(Class<?> returnClass) {
        this.returnClass = returnClass.getName();
    }
    
    public Class<?> getReturnClassType() {
        Class<?> c = null;
        try {
            if(returnClass != null)
                c = Class.forName(returnClass);
        } catch (ClassNotFoundException e) {
            c = null;
        }
        return c;
    }

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public long getRecordsFiltered() {
		return recordsTotal;
	}

	public void setRecordsFiltered(long recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	public long getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(long recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public List<?> getData() {
		return data;
	}

	public void setData(List<?> data) {
		this.data = data;
	}
}
