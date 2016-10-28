package com.xia.ssm.test;

public enum ColorEnum {
    
    RED("红色",1),GREEN("绿色",2),BLANK("黑色",3),YELLO("黄色",4);
    
    private ColorEnum(String color,int index){
        this.color = color;
        this.index = index;
    }
    
    private String color;
    private int index;
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
    
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.valueOf(this.index);
    }
    
    

}
