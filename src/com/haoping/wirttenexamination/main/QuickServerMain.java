package com.haoping.wirttenexamination.main;

import java.sql.Connection;
import java.util.HashMap;
import javax.swing.SwingUtilities;

import org.quickserver.net.server.ClientHandler;
import org.quickserver.net.server.QuickServer;

import com.haoping.wirttenexamination.frame.MyFrame;
//import com.qianfan.paipai.frame.MyFrame;
//import com.qianfan.paipai.util.ConnectionMaking2008;
//import com.qianfan.paipai.util.ConnectionMaking2014;
//import com.qianfan.paipai.util.TimeRecord;

public class QuickServerMain {
	public static String voicePath;
	public static String path; 
	
	public static Connection connection;
//	public static Connection connection = ConnectionMaking2014.createConnection();
	public static QuickServer myServer;
	public static MyFrame myFrame;
	public static boolean limitUserEnable;

	public static void main(String[] args) {
//		new Thread(new TimeRecord()).start();
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				QuickServerMain.myFrame = new MyFrame();
			}
		});
	}
}
