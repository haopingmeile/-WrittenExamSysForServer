package com.haoping.wirttenexamination.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConnectionMaking2008 {

	public static Connection createConnection(){
		Connection connection ;
//		与数据库建立连接
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection("jdbc:sqlserver://10.0.0.2:1433;DatabaseName=PaiPaiSql", "sa",
					"Qianfan%%!%!!((");
		} catch (Exception e) {
			File file = new File("sqlerr.txt");
			try {
				FileOutputStream fileOutputStream=new FileOutputStream(file);
				try {SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
					fileOutputStream.write(("SQL ERR:"+df.format(new Date())+" "+e.toString()).getBytes());
					fileOutputStream.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			return null;
		}
		return connection;
	}
	
	public static Connection createConnection(String sqlName,String password,String port){
		Connection connection ;
//		与数据库建立连接
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriverr");
			String conn="jdbc:sqlserver://10.0.0.2:"+port+";DatabaseName=PaiPaiSql";
			connection = DriverManager.getConnection(conn,sqlName,
					password);
		} catch (Exception e) {
			File file = new File("sqlerr.txt");
			try {
				FileOutputStream fileOutputStream=new FileOutputStream(file);
				try {SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
					fileOutputStream.write(("SQL ERR:"+df.format(new Date())+" "+e.toString()).getBytes());
					fileOutputStream.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			return null;
		}
		return connection;
	}
}
