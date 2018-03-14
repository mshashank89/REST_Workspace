package com.shashank.restapi.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.shashank.restapi.messenger.dao.DatabaseClass;
import com.shashank.restapi.messenger.model.Profile;

public class ProfileService {
	
	private Map<String, Profile> profiles = DatabaseClass.getInstance().getProfiles();
	

	public ProfileService(){
		profiles.put("Shashank", new Profile(1L, "Shashank", "Shashank", "M"));
		profiles.put("Anusha", new Profile(1L, "Anusha", "Anusha", "S"));
	}
	
	public List<Profile> getProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String profileName){
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile){
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile){
		if ("".equals(profile.getProfileName())){
			return null;
		}
		
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile removeProfile(long id){
		return profiles.remove(id);
	}
}



