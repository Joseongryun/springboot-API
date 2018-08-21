package com.infranics.api.asset.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.infranics.api.asset.model.UserModel;

@Mapper
public interface UserMapper {
	
	boolean join(UserModel userModel);
	
	String login(UserModel userModel);
	
	UserModel getUser(String token);
	
	Map<String, Object> getPhoto(String token);
}
