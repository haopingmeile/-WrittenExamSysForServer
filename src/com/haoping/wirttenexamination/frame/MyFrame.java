package com.haoping.wirttenexamination.frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;

import org.quickserver.net.AppException;
import org.quickserver.net.server.QuickServer;

import com.haoping.wirttenexamination.main.QuickServerMain;
import com.haoping.wirttenexamination.utils.ConnectionMaking2008;
//import com.qianfan.paipai.handler.MyCommandHandler;
//import com.qianfan.paipai.main.QuickServerMain;
//import com.qianfan.paipai.util.ConnectionMaking2008;
//import com.qianfan.paipai.util.ConnectionMaking2014;
//import com.qianfan.paipai.util.DevicePolling;
//import com.qianfan.paipai.util.UnAcceptMsgPolling;

public class MyFrame extends JFrame {
	boolean running = false;
	JLabel portLabel, filePath, onlineUsers, sqlPortTxt, sqlNameTxt, passwordTxt;
	// JLabel portLabel, filePath, onlineUsers;
	// JTextField portTxt, pathTxt;
	JTextField portTxt, pathTxt, sqlPort, sqlName;
	JPasswordField password;
	public JTextArea content;
	JButton start, choosePath;
	public JList userList;
	JCheckBox limitBox;
	// HashMap<String, String> clients = new HashMap<String, String>();

	public MyFrame() {
		Font font = new Font("宋体", Font.BOLD, 20);
		portLabel = new JLabel("端口:");
		portLabel.setFont(font);
		filePath = new JLabel("声音路径:");
		filePath.setFont(font);
		onlineUsers = new JLabel("在线用户:");
		onlineUsers.setFont(font);
		portTxt = new JTextField("4123");
		portTxt.setFont(font);
		pathTxt = new JTextField("D:/paipai");
		pathTxt.setFont(font);
		content = new JTextArea("服务器未运行...\r\n");
		content.setFont(font);
		start = new JButton("启动");
		start.setBackground(Color.GREEN);
		start.setFont(font);
		start.setForeground(Color.white);
		choosePath = new JButton("位置选择");

		sqlName = new JTextField("sa");
		sqlPort = new JTextField("1433");
		// password=new JPasswordField("Wjb6558941");
		password = new JPasswordField("55151199");
		sqlNameTxt = new JLabel("SQL账号：");
		passwordTxt = new JLabel("SQL密码：");
		sqlPortTxt = new JLabel("SQL端口:");

		limitBox = new JCheckBox("账号限制");

		portLabel.setBounds(30, 500, 60, 40);
		filePath.setBounds(220, 500, 100, 40);
		onlineUsers.setBounds(620, 40, 120, 30);
		portTxt.setBounds(90, 500, 100, 40);
		pathTxt.setBounds(320, 500, 190, 40);
		choosePath.setBounds(520, 500, 80, 40);
		start.setBounds(640, 500, 120, 40);
		// content.setBounds(25, 40, 560, 385);
		//// content.setBounds(25, 40, 560, 445);

		// ceshi
		// sqlName.setBounds(110, 460, 80, 30);
		// password.setBounds(260, 460, 100, 30);
		// sqlPort.setBounds(450, 460, 100, 30);
		// sqlNameTxt.setBounds(40, 460, 70, 30);
		// passwordTxt.setBounds(200, 460, 80, 30);
		// sqlPortTxt.setBounds(380, 460, 80, 30);

		sqlName.setBounds(90, 460, 80, 30);
		password.setBounds(240, 460, 100, 30);
		sqlPort.setBounds(430, 460, 60, 30);
		sqlNameTxt.setBounds(20, 460, 70, 30);
		passwordTxt.setBounds(180, 460, 80, 30);
		sqlPortTxt.setBounds(360, 460, 80, 30);
		limitBox.setBounds(510, 460, 80, 30);

		JScrollPane scrollContent = new JScrollPane(content);

		// ceshi
		scrollContent.setBounds(25, 40, 560, 405);
		// scrollContent.setBounds(25, 40, 560, 445);
		ListModel model = new DefaultComboBoxModel(new Vector<String>(QuickServerMain.androidClientMap.keySet()));
		userList = new JList<String>();
		userList.setFont(font);
		userList.setModel(model);
		JScrollPane listScroll = new JScrollPane(userList);
		listScroll.setBounds(620, 70, 140, 415);
		this.setLayout(null);
		this.setResizable(false);
		this.add(portLabel);
		this.add(filePath);
		this.add(onlineUsers);
		this.add(portTxt);
		this.add(pathTxt);
		this.add(scrollContent);
		this.add(choosePath);
		this.add(listScroll);
		this.add(start);

		// 修改部分
		this.add(sqlName);
		this.add(sqlPort);
		this.add(password);
		this.add(sqlNameTxt);
		this.add(sqlPortTxt);
		this.add(passwordTxt);
		
		this.add(limitBox);

		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setTitle("PaiPaiServer");

		StartListener listener = new StartListener();
		start.setActionCommand("start");
		start.addActionListener(listener);
		choosePath.setActionCommand("choose");
		choosePath.addActionListener(listener);

		userList.addMouseListener(new ListListenner());

		limitBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (limitBox.isSelected()) {
					QuickServerMain.limitUserEnable = true;
				} else {
					QuickServerMain.limitUserEnable = false;
				}
			}
		});
	}

	class ListListenner implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getClickCount() == 2) {
				JList list = (JList) e.getSource();
				String name = list.getSelectedValue().toString();
				// System.out.println(s);
				// JDialog dialog=new JDialog
				// dialog.setVisible(true);
				String sql = "select users.username,CONVERT(varchar(19), carerstatus.logintime,120) from users inner join carerstatus on users.userid=carerstatus.userid and users.userid='"
						+ name + "'";
				String sql1 = "select deviceId,sickroom,sickbed from device where userId='" + name + "'";
				PreparedStatement preparedStatement = null;
				ResultSet resultSet = null;
				try {
					preparedStatement = QuickServerMain.connection.prepareStatement(sql);
					resultSet = preparedStatement.executeQuery();
					String userName = null;
					String loginTime = null;
					if (resultSet.next()) {
						userName = resultSet.getString(1);
						loginTime = resultSet.getString(2);
					}

					preparedStatement = QuickServerMain.connection.prepareStatement(sql1);
					resultSet = preparedStatement.executeQuery();

					String s = userName + "登录时间：" + loginTime + "\r\n绑定的设备：\r\n";
					while (resultSet.next()) {
						String deviceId = resultSet.getString(1);
						String sickRoom = resultSet.getString(2);
						String sickBed = resultSet.getString(3);
						s += "    设备编号：" + deviceId + " 病房：" + sickRoom + " 病床：" + sickBed + "\r\n";
					}
					System.out.println(s);
					JTextArea jTextArea = new JTextArea();
					jTextArea.setFont(new Font("宋体", Font.BOLD, 15));
					jTextArea.setText(s);
					JFrame frame = new JFrame("用户" + name);
					frame.add(new JScrollPane(jTextArea));
					// frame.setDefaultCloseOperation(JFrame.);
					frame.setSize(400, 600);
					frame.setVisible(true);

					// JPanel jPanel=new JPanel();
					// jPanel.add(new JScrollPane(jTextArea));
					// jPanel.setSize(400,600);
					// jPanel.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally {
//					MyCommandHandler.sqlClose(preparedStatement, resultSet);
				}
				JPanel panel = new JPanel();
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}

	class StartListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("start")) {
				if (running == false) {
					QuickServerMain.connection = ConnectionMaking2008.createConnection(sqlName.getText(),
							password.getText(), sqlPort.getText());
					QuickServerMain.path = pathTxt.getText();
					QuickServerMain.voicePath = QuickServerMain.path + "/voices";
					File saveDir = new File(QuickServerMain.voicePath);
					if (!saveDir.exists()) {
						saveDir.mkdir();
					}

					content.append("声音文件存储在：" + pathTxt.getText() + "\r\n");

					// 创建QuickServer
					QuickServerMain.myServer = new QuickServer("com.qianfan.paipai.handler.MyCommandHandler");

					// 创建日志文件
					Logger logger = null;
					FileHandler xmlLog = null;
					File log = new File("./log/");
					if (!log.canRead())
						log.mkdir();
					try {
						logger = Logger.getLogger("");
						logger.setLevel(Level.INFO);
						xmlLog = new FileHandler("log/EchoServer.xml");
						logger.addHandler(xmlLog);
					} catch (IOException e1) {
						// System.err.println("could not create xmlLog
						// Filehandler:"+e);
						content.append("无法创建looger!!!\r\n");
					}
					QuickServerMain.myServer.setConsoleLoggingLevel(Level.INFO);

//					// 设置登录验证֤
//					QuickServerMain.myServer
//							.setClientAuthenticationHandler("com.qianfan.paipai.handler.MyAuthenticator");

					// 设置用户数据池
					QuickServerMain.myServer.setClientData("com.qianfan.paipai.clientdata.MyClientPoolableData");

					// 设置端口和超时时间并启动QuickServer服务器
					try {
						int prot = Integer.parseInt(portTxt.getText().trim());
						QuickServerMain.myServer.setPort(prot);
//						86400000
						QuickServerMain.myServer.setTimeout(60000);
						QuickServerMain.myServer.setName("EchoServer v 1.0");
						try {
							QuickServerMain.myServer.startServer();
							start.setText("ֹͣ关闭程序");
							start.setBackground(Color.RED);

//							// 开启线程不断接收新报警消息
//							new Thread(new DevicePolling()).start();
//							// 开启线程推送超时消息
//							new Thread(new UnAcceptMsgPolling()).start();
							running = true;
							content.append("服务器正在运行...\r\n");
						} catch (Exception e2) {
							// System.out.println("Error!");
							content.append("启动失败，请检查网络或端口!!!\r\n");
						}
					} catch (NumberFormatException e1) {
						content.append("端口号填写有误！！\r\n");
						e1.printStackTrace();
					}
				} else {
					System.exit(0);
				}
			} else if (e.getActionCommand().equals("choose")) {
				JFileChooser fc = new JFileChooser();
				fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				File f = null;
				int flag = 0;
				try {
					flag = fc.showOpenDialog(null);
				} catch (HeadlessException head) {
					// System.out.println("Open File Dialog ERROR!");
					content.append("文件选择器打开失败！！！");
				}
				if (flag == JFileChooser.APPROVE_OPTION) {
					f = fc.getSelectedFile();
					pathTxt.setText(f.getPath());
				}
			}
		}
	}
}
