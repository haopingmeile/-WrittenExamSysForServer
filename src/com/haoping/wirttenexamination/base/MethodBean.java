package com.haoping.wirttenexamination.base;

public class MethodBean {
	 /**
     * methodID : 11
     * methodName : 方法名
     * describe : 方法的详细描述
     * input : false
     */

    private int methodID;
    private String methodName;
    private String describe;
    private boolean input;

    public int getMethodID() {
        return methodID;
    }

    public void setMethodID(int methodID) {
        this.methodID = methodID;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public boolean isInput() {
        return input;
    }

    public void setInput(boolean input) {
        this.input = input;
    }
}
