package com.infranics.api.asset.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infranics.api.asset.mapper.UserMapper;
import com.infranics.api.asset.model.UserModel;

@Service
public class UserService {
	@Autowired
	UserMapper userMapper;

	public boolean join(UserModel userModel) {
		return userMapper.join(userModel);
	}

	public String login(UserModel userModel) {
		return userMapper.login(userModel);
	}

	public UserModel getUser(String token) {
		return userMapper.getUser(token);
	}

	public byte[] getPhoto(String token) {
		byte[] photoContent = (byte[]) userMapper.getPhoto(token).get("photo");
		return photoContent;
	}
}
