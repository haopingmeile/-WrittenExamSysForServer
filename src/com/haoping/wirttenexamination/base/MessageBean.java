package com.haoping.wirttenexamination.base;

public class MessageBean {
    /**
     * messageID : 356
     * content : 内容
     * type : 类型
     * userId : 发送者学号|姓名
     * time : 2017-09-20 17:13:25.124
     */

    private int messageID;
    private String content;
    private String type;
    private String userId;
    private String time;

    public int getMessageID() {
        return messageID;
    }

    public void setMessageID(int messageID) {
        this.messageID = messageID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
