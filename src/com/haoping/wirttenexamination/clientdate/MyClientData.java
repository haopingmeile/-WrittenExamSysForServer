package com.haoping.wirttenexamination.clientdate;

//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.ArrayList;

import org.quickserver.net.server.*;

public class MyClientData implements ClientData{

//	用户名会在用户登录验证通过时进行绑定
	private String username;
	
	private String userId;


	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}