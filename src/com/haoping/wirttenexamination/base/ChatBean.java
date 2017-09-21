package com.haoping.wirttenexamination.base;

public class ChatBean {
    /**
     * roomID : 12
     * owner : 所有者
     * describe : 聊天室描述
     * roomName : 聊天室名
     */

    private int roomID;
    private String owner;
    private String describe;
    private String roomName;

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
}
