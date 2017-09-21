package com.haoping.wirttenexamination.base;

public class Constant {

	/**
	 * 
	 */
//	命令类型
	public static final String COM_LOGIN="Login";
	public static final String COM_HEART_BEAT="HeartBeat";
	public static final String COM_GET_VERSION_INFO="GetVersionInfo";
	public static final String COM_GET_METHODS="GetMethods";
	public static final String COM_METHOD_NAME="MethodName";
	public static final String COM_GET_CHATROOMS="GetChatRooms";
	public static final String COM_ENTER_CHATROOM="EnterChatRoom";
	public static final String COM_UPLOAD_FILE="UpLoadFIle";
	public static final String COM_GET_MESSAGE="GetMessage";
	public static final String COM_SEND_MESSAGE="SendMessage";
	public static final String COM_SEND_FILE_TO_PC="SendFileToPC";
	public static final String COM_EXIT_CHATROOM="ExitChatRoom";
	public static final String COM_PUSH_MESSAGE="PushMessage";
	public static final String COM_PUSH_IMAGE="PushImage";
	public static final String COM_PUSH_FILE="PushFile";
	
	
//	返回
	public static final String RETURN_ERR="{\"type\":\"TYPE\",\"content\":\"CONTENT\",\"list\":\"LIST\",\"errCode\":\"ERRCODE\",\"errMsg\":\"ERRMSG\"}";
	public static final String RETURN_ERR501="{\"type\":\"TYPE\",\"content\":\"\",\"list\":\"\",\"errCode\":\"501\",\"errMsg\":\"格式错误\"}";
	public static final String RETURN_ERR201="{\"type\":\"Login\",\"content\":\"\",\"list\":\"\",\"errCode\":\"201\",\"errMsg\":\"您的姓名和学号不匹配\"}";
	public static final String RETURN_ERR301="{\"type\":\"UpLoadFIle\",\"content\":\"\",\"list\":\"\",\"errCode\":\"301\",\"errMsg\":\"文件发送失败，文件不存在\"}";
	public static final String RETURN_ERR0="{\"type\":\"TYPE\",\"content\":\"CONTENT\",\"list\":\"LIST\",\"errCode\":\"0\",\"errMsg\":\"ok\"}";
	
	//返回指令
//	{"type":"HeartBeat","content":"","list":"","errCode":"","errMsg":""}
	public static final String RETURN_HEART_BEAT="{\"type\":\"HeartBeat\",\"content\":\"\",\"list\":\"\",\"errCode\":\"\",\"errMsg\":\"\"}";
	public static final String RETURN_GET_VERSION_INFO="{\"type\":\"GetVersionInfo\",\"content\":\"CONTENT\",\"list\":\"\",\"errCode\":\"0\",\"errMsg\":\"ok\"}";
	
//	SQL
	public static final String SQL_FIND_USER="select userName from Users where userId='USERID'";
	public static final String SQL_INSERT_USER="insert into Users (userId,userName) values('USERID','USERNAME');";
	public static final String SQL_FIND_VERSION_INFO="select versionCode,downloadPath,importance from Version where type='TYPE';";
	public static final String SQL_GET_METHODS="select id,messageName,describe,input from Methods;";
	public static final String SQL_GET_CHATROOMS="select id,owner,describe,roomName from ChatRooms;";
	public static final String SQL_FIND_CHATROOM="select id from ChatRoomOrder where userid='USERID' and roomId=ROOMID;";
	public static final String SQL_INSERT_CHATROOM_ORDER="insert into ChatRoomOrder (userId,roomId) values ('USERID',ROOMID);";
	public static final String SQL_INSERT_MESSAGE="insert into Message (userId,userName,type,content,times) values (CONTENTS);";
	
//	文件夹位置
	public static final String DirPath="c:/wirttensystem/usersdir";
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
