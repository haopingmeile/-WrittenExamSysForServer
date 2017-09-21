package com.haoping.wirttenexamination.clientdate;

import java.util.HashMap;
import java.util.Set;

import org.quickserver.net.server.ClientHandler;

public class ClientMapOperator {
	private static HashMap<String, ClientHandler> androidClientMap = new HashMap<String, ClientHandler>();
	private static HashMap<String, ClientHandler> pcClientMap = new HashMap<String, ClientHandler>();
	private static ClientMapOperator mClientMapOperator=new ClientMapOperator();
	private ClientMapOperator(){
		
	}
	
	public static ClientMapOperator getInstance(){
		return mClientMapOperator;
	}
	
	public void addAndroidClient(String userId,ClientHandler clientHandler){
		ClientHandler oldClientHandler=androidClientMap.get(userId);
		if(oldClientHandler!=null){
			oldClientHandler.closeConnection();
		}
		androidClientMap.put(userId, clientHandler);
	}
	
	public void removeAndroidClient(String userId){
		androidClientMap.remove(userId);
	}
	
	public void addPCClient(String userId,ClientHandler clientHandler){
		ClientHandler oldClientHandler=androidClientMap.get(userId);
		if(oldClientHandler!=null){
			oldClientHandler.closeConnection();
		}
		pcClientMap.put(userId, clientHandler);
	}
	
	public void removePCClient(String userId){
		pcClientMap.remove(userId);
	}
	
	public Set<String> getAndroidMap(){
		return androidClientMap.keySet();
	}
}
