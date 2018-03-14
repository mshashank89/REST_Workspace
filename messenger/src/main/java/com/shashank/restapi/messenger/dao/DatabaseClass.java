package com.shashank.restapi.messenger.dao;

import java.util.HashMap;
import java.util.Map;

import com.shashank.restapi.messenger.model.Message;
import com.shashank.restapi.messenger.model.Profile;

public class DatabaseClass {
	
	private static DatabaseClass instance = new DatabaseClass();
	
	private Map<Long, Message> messageMap = new HashMap<Long, Message>();
	private Map<String, Profile> profileMap = new HashMap<String, Profile>();
	
	private DatabaseClass(){
		
	}
	
	public static DatabaseClass getInstance() {
		return instance;
	}
	
	public Map<Long, Message> getMessages(){
		return messageMap;
	}

	public Map<String, Profile> getProfiles() {
		return profileMap;
	}
	
	
	

}
