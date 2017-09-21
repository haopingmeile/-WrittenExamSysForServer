package com.haoping.wirttenexamination.handler;

//import java.awt.EventFilter.FilterAction;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
//import java.time.Period;
import java.util.logging.Level;

import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingUtilities;

//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
import org.quickserver.net.server.ClientCommandHandler;
import org.quickserver.net.server.ClientHandler;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.haoping.wirttenexamination.base.ChatBean;
import com.haoping.wirttenexamination.base.CommandBean;
import com.haoping.wirttenexamination.base.Constant;
import com.haoping.wirttenexamination.base.MethodBean;
import com.haoping.wirttenexamination.clientdate.ClientMapOperator;
import com.haoping.wirttenexamination.clientdate.MyClientData;
import com.haoping.wirttenexamination.main.QuickServerMain;
import com.haoping.wirttenexamination.utils.ConnectionMaking2008;
//import com.qianfan.paipai.clientdata.MyClientData;
//import com.qianfan.paipai.main.QuickServerMain;
//import com.qianfan.paipai.util.HttpUpload;
//import com.qianfan.paipai.clientdata.MyClientData;
//import com.qianfan.paipai.main.QuickServerMain;

public class MyCommandHandler implements ClientCommandHandler {
	// 接受命令
	@Override
	public void handleCommand(ClientHandler handler, String command) throws SocketTimeoutException, IOException {

		try {
			command = new String(command.getBytes("ISO-8859-1"), "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommandBean mCommandBean;

		mCommandBean = JSONObject.parseObject(command, CommandBean.class);

		String type = mCommandBean.getType();
		if (Constant.COM_LOGIN.equals(type)) {

		} else if (Constant.COM_HEART_BEAT.equals(type)) {

		} else if (Constant.COM_GET_VERSION_INFO.equals(type)) {

		} else if (Constant.COM_GET_METHODS.equals(type)) {

		} else if (Constant.COM_METHOD_NAME.equals(type)) {

		} else if (Constant.COM_GET_CHATROOMS.equals(type)) {

		} else if (Constant.COM_ENTER_CHATROOM.equals(type)) {

		} else if (Constant.COM_UPLOAD_FILE.equals(type)) {

		} else if (Constant.COM_GET_CHATROOMS.equals(type)) {

		} else if (Constant.COM_GET_CHATROOMS.equals(type)) {

		} else if (Constant.COM_GET_MESSAGE.equals(type)) {

		} else if (Constant.COM_SEND_FILE_TO_PC.equals(type)) {

		} else if (Constant.COM_EXIT_CHATROOM.equals(type)) {

		} else if (Constant.COM_PUSH_MESSAGE.equals(type)) {

		} else if (Constant.COM_PUSH_IMAGE.equals(type)) {

		} else if (Constant.COM_PUSH_FILE.equals(type)) {

		} else {

		}

		// SwingUtilities.invokeLater(new Runnable() {
		// @Override
		// public void run() {
		// try {
		// String s=new String(command.getBytes("ISO-8859-1"),"utf-8");
		// QuickServerMain.myFrame.content.append(s+"\r\n");
		// } catch (UnsupportedEncodingException e) {
		// e.printStackTrace();
		// }
		// }
		// });
		// 20170803 haoping 账户限制功能添加
		// MyClientData myClientData = (MyClientData) handler.getClientData();
		// if (QuickServerMain.limitUserEnable && !myClientData.isEnable()) {
		// handler.sendClientMsg(limitErr);
		// return;
		// }

		// JSONObject json;
		// String type;
		// try {
		//// json =
		// } catch (JSONException e1) {
		// String formatErr501 =
		// "{'type':'FormatError','errCode':'0','errMsg':'" + command + "'}";
		// handler.sendClientMsg(formatErr501);
		// handler.sendSystemMsg(e1 + "\r\n");
		// return;
		// }
		//
		// try {
		// type = json.getString("type");
		//
		// } catch (JSONException e1) {
		// // errCode未完成
		// try {
		// type = json.getString("errCode");
		// String content = json.getString("content");
		// handler.sendSystemMsg(content);
		// } catch (JSONException e) {
		// // handler.sendClientMsg(err501);
		// handler.sendSystemMsg(e + "\r\n");
		// }
		// }

		// connection.close();
	}

	// 用户开始连接
	public void gotConnected(ClientHandler handler) throws SocketTimeoutException, IOException {
		// 设置超时时间600000ms
		handler.setTimeout(60000);
		// handler.setCharset("utf-8");
		handler.sendSystemMsg("New Client : " + handler.getSocket().getInetAddress().getHostAddress() + "\r\n",
				Level.INFO);
	}

	// 失去连接
	public void lostConnection(ClientHandler handler) throws IOException {
		// MyClientData myClientData = (MyClientData) handler.getClientData();
		// Connection connection = QuickServerMain.connection;
		// PreparedStatement preparedStatement =
		// myClientData.getPreparedStatement();
		// ResultSet resultSet = myClientData.getResultSet();
		// String username = myClientData.getUsername();
		// // 将用户从clientmap中删除
		// QuickServerMain.clientMap.remove(username);
		// // 将用户状态从1（在线）改回0（下线）
		// String sql = "update CarerStatus set Online=0 where userId='" +
		// username + "';";
		// try {
		// preparedStatement = connection.prepareStatement(sql);
		// preparedStatement.executeUpdate();
		// } catch (SQLException e) {
		// e.printStackTrace();
		// handler.sendSystemMsg(e + "\r\n");
		// } finally {
		// sqlClose(preparedStatement, resultSet);
		// }
		// SwingUtilities.invokeLater(new Runnable() {
		// @Override
		// public void run() {
		// QuickServerMain.myFrame.userList
		// .setModel(new DefaultComboBoxModel(new
		// Vector<String>(QuickServerMain.clientMap.keySet())));
		// }
		// });
		// handler.sendSystemMsg("Connection lost : " +
		// handler.getSocket().getInetAddress() + "\r\n");
	}

	// 用户关闭连接
	public void closingConnection(ClientHandler handler) throws IOException {
		// MyClientData myClientData = (MyClientData) handler.getClientData();
		// Connection connection = QuickServerMain.connection;
		// PreparedStatement preparedStatement =
		// myClientData.getPreparedStatement();
		// ResultSet resultSet = myClientData.getResultSet();
		// String username = myClientData.getUsername();
		// QuickServerMain.clientMap.remove(username);
		// String sql = "update CarerStatus set Online=0 where userId='" +
		// username + "';";
		// try {
		// preparedStatement = connection.prepareStatement(sql);
		// preparedStatement.executeUpdate();
		// } catch (SQLException e) {
		// e.printStackTrace();
		// handler.sendSystemMsg(e + "\r\n");
		// } finally {
		// sqlClose(preparedStatement, resultSet);
		// }
		//
		// SwingUtilities.invokeLater(new Runnable() {
		// @Override
		// public void run() {
		// QuickServerMain.myFrame.userList
		// .setModel(new DefaultComboBoxModel(new
		// Vector<String>(QuickServerMain.clientMap.keySet())));
		// }
		// });
		// handler.sendSystemMsg("Closing connection : " +
		// handler.getSocket().getInetAddress() + "\r\n");
	}

	private void login(CommandBean mCommandBean, ClientHandler handler) {
		MyClientData myClientData = (MyClientData) handler.getClientData();
		String[] contents = mCommandBean.getContent().split("|");
		String userId = mCommandBean.getUserId();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			if (contents.length != 2) {
				handler.sendClientMsg(Constant.RETURN_ERR501.replace("TYPE", Constant.COM_LOGIN));
				return;
			}
			connection = ConnectionMaking2008.createConnection();
			preparedStatement = connection.prepareStatement(Constant.SQL_FIND_USER.replace("USERID", userId));
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				String userName = resultSet.getString(1);
				if (userName.equals(contents[0])) {
					myClientData.setUserId(userId);
					myClientData.setUsername(contents[0]);
					ClientMapOperator.getInstance().addAndroidClient(userId, handler);
					handler.sendClientMsg(Constant.RETURN_ERR0.replace("TYPE", Constant.COM_LOGIN));
				} else {
					handler.sendClientMsg(Constant.RETURN_ERR201);
				}
			} else {
				myClientData.setUserId(userId);
				myClientData.setUsername(contents[0]);
				preparedStatement = connection.prepareStatement(
						Constant.SQL_INSERT_USER.replace("USERID", userId).replace("USERNAME", contents[0]));
				int i = preparedStatement.executeUpdate();
				if (i != 0) {
					ClientMapOperator.getInstance().addAndroidClient(userId, handler);
					handler.sendClientMsg(Constant.RETURN_ERR0.replace("TYPE", Constant.COM_LOGIN));
				} else {
					handler.sendClientMsg(Constant.RETURN_ERR501.replace("TYPE", Constant.COM_LOGIN));
				}
			}

			closeSQLConnection(connection, preparedStatement, resultSet);
		} catch (IOException e) {
			closeSQLConnection(connection, preparedStatement, resultSet);
		} catch (SQLException e) {
			try {
				handler.sendClientMsg(Constant.RETURN_ERR501.replace("TYPE", Constant.COM_LOGIN));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			closeSQLConnection(connection, preparedStatement, resultSet);
		}
	}

	private void heartBeat(ClientHandler handler) {
		try {
			handler.sendClientMsg(Constant.RETURN_HEART_BEAT);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void getVersionInfo(CommandBean mCommandBean, ClientHandler handler) {
		String content = mCommandBean.getContent();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionMaking2008.createConnection();
			preparedStatement = connection.prepareStatement(Constant.SQL_FIND_VERSION_INFO.replace("TYPE", content));
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				String versionCode = resultSet.getString(1);
				String downloadPath = resultSet.getString(2);
				String importance = resultSet.getString(3);
				String con = versionCode + "|" + downloadPath + "|" + importance;
				handler.sendClientMsg(Constant.RETURN_GET_VERSION_INFO.replace("CONTENT", con));
			} else {
				handler.sendClientMsg(Constant.RETURN_ERR501.replace("TYPE", Constant.COM_GET_VERSION_INFO));
			}
			closeSQLConnection(connection, preparedStatement, resultSet);
		} catch (SQLException e) {
			try {
				handler.sendClientMsg(Constant.RETURN_ERR501.replace("TYPE", Constant.COM_GET_VERSION_INFO));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			closeSQLConnection(connection, preparedStatement, resultSet);
		} catch (IOException e) {
			closeSQLConnection(connection, preparedStatement, resultSet);
		}
	}

	private void getMethods(CommandBean mCommandBean, ClientHandler handler) {
		JSONArray jsonArray = new JSONArray();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionMaking2008.createConnection();
			preparedStatement = connection.prepareStatement(Constant.SQL_GET_METHODS);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				MethodBean bean = new MethodBean();
				bean.setMethodID(resultSet.getInt(1));
				bean.setMethodName(resultSet.getString(2));
				bean.setDescribe(resultSet.getString(3));
				bean.setInput(resultSet.getBoolean(4));
				jsonArray.add(bean);
			}

			handler.sendClientMsg(Constant.RETURN_ERR0.replace("TYPE", Constant.COM_GET_METHODS).replace("LIST",
					jsonArray.toJSONString()));
			closeSQLConnection(connection, preparedStatement, resultSet);
		} catch (SQLException e) {
			try {
				handler.sendClientMsg(Constant.RETURN_ERR501.replace("TYPE", Constant.COM_GET_METHODS));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			closeSQLConnection(connection, preparedStatement, resultSet);
		} catch (IOException e) {
			closeSQLConnection(connection, preparedStatement, resultSet);
			e.printStackTrace();
		}
	}

	private void methodName(CommandBean mCommandBean, ClientHandler handler) {
		String[] contents = mCommandBean.getContent().split("|");
		switch (Integer.parseInt(contents[0])) {
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		}
	}

	private void getChatRooms(CommandBean mCommandBean, ClientHandler handler) {
		JSONArray jsonArray = new JSONArray();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionMaking2008.createConnection();
			preparedStatement = connection.prepareStatement(Constant.SQL_GET_CHATROOMS);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				ChatBean bean = new ChatBean();
				bean.setRoomID(resultSet.getInt(1));
				bean.setOwner(resultSet.getString(2));
				bean.setDescribe(resultSet.getString(3));
				bean.setRoomName(resultSet.getString(4));
				jsonArray.add(bean);
			}

			handler.sendClientMsg(Constant.RETURN_ERR0.replace("TYPE", Constant.COM_GET_CHATROOMS).replace("LIST",
					jsonArray.toJSONString()));
			closeSQLConnection(connection, preparedStatement, resultSet);
		} catch (SQLException e) {
			try {
				handler.sendClientMsg(Constant.RETURN_ERR501.replace("TYPE", Constant.COM_GET_CHATROOMS));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			closeSQLConnection(connection, preparedStatement, resultSet);
		} catch (IOException e) {
			closeSQLConnection(connection, preparedStatement, resultSet);
			e.printStackTrace();
		}
	}

	private void enterChatRoom(CommandBean mCommandBean, ClientHandler handler) {
		int roomId = Integer.parseInt(mCommandBean.getContent());
		String userId = mCommandBean.getUserId();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionMaking2008.createConnection();
			preparedStatement = connection.prepareStatement(
					Constant.SQL_FIND_CHATROOM.replace("USERID", userId).replace("ROOMID", roomId + ""));
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				handler.sendClientMsg(Constant.RETURN_ERR0.replace("TYPE", Constant.COM_ENTER_CHATROOM)
						.replace("CONTENT", resultSet.getInt(1) + ""));
			} else {
				preparedStatement = connection.prepareStatement(
						Constant.SQL_INSERT_CHATROOM_ORDER.replace("USERID", userId).replace("ROOMID", roomId + ""));
				int num = preparedStatement.executeUpdate();
				if (num != 0) {
					handler.sendClientMsg(Constant.RETURN_ERR0.replace("TYPE", Constant.COM_ENTER_CHATROOM)
							.replace("CONTENT", resultSet.getInt(1) + ""));
					// 发送给其他用户通知
				} else {
					handler.sendClientMsg(Constant.RETURN_ERR501.replace("TYPE", Constant.COM_ENTER_CHATROOM));
				}
			}
			closeSQLConnection(connection, preparedStatement, resultSet);
		} catch (SQLException e) {
			try {
				handler.sendClientMsg(Constant.RETURN_ERR501.replace("TYPE", Constant.COM_ENTER_CHATROOM));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			closeSQLConnection(connection, preparedStatement, resultSet);
		} catch (IOException e) {
			closeSQLConnection(connection, preparedStatement, resultSet);
		}
	}

	private void uploadFile(CommandBean mCommandBean, ClientHandler handler) {
		MyClientData myClientData = (MyClientData) handler.getClientData();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String fileName = mCommandBean.getContent();
		String userId = mCommandBean.getUserId();
		String filePath = Constant.DirPath + "/" + fileName;
		File file = new File(filePath);
		String userName=myClientData.getUsername();
		try {
			if (!file.exists()) {
				handler.sendClientMsg(Constant.RETURN_ERR301);
				return;
			}
//			else{
//				handler.sendClientMsg(Constant.RETURN_ERR0.replace("TYPE", Constant.COM_UPLOAD_FILE));
//			}
			String[] fileTypes = fileName.split(".");
			String fileType = fileTypes[fileTypes.length - 1];
			String type;
			if ("txt".equalsIgnoreCase(fileType)) {
				type="TXT";
			} else if ("jpg".equalsIgnoreCase(fileType) || "png".equalsIgnoreCase(fileType)) {
				type="IMG";
			} else {
				type="FILE";
			}
			
			String contents="'"+userId+"','"+userName+"','"+type+"','"+fileName+",now()";
			connection=ConnectionMaking2008.createConnection();
			preparedStatement=connection.prepareStatement(Constant.SQL_INSERT_MESSAGE.replace("CONTENTS", contents));
			int n= preparedStatement.executeUpdate();
			if(n!=0){
				handler.sendClientMsg(Constant.RETURN_ERR0.replace("TYPE", Constant.COM_UPLOAD_FILE));
				
			}else{
				
			}
		} catch (IOException e) {

		}catch(SQLException e){
			
		}
	}

	private void getMessage(CommandBean mCommandBean, ClientHandler handler) {

	}

	private void sendMessage(CommandBean mCommandBean, ClientHandler handler) {

	}

	private void sendFileToPC(CommandBean mCommandBean, ClientHandler handler) {

	}

	private void exitChatRoom(CommandBean mCommandBean, ClientHandler handler) {

	}

	public static void closeSQLConnection(Connection connection, PreparedStatement preparedStatement,
			ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (preparedStatement != null) {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}