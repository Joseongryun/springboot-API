package com.infranics.api.asset.controller;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.infranics.api.asset.model.UserModel;
import com.infranics.api.asset.service.UserService;
import com.infranics.api.asset.tool.MD5Tool;

@Transactional
@RestController
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/user/join", method = RequestMethod.POST)
	public void join(@RequestParam("email") String email, @RequestParam("password") String password,
			@RequestParam("name") String name, @RequestParam("photo") MultipartFile photo)
			throws NoSuchAlgorithmException{
		UserModel userModel = new UserModel();
		try {
			userModel.setEmail(email);
			userModel.setName(name);
			userModel.setPassword(password);
			userModel.setPhoto(photo.getBytes());
			userModel.setCertification(MD5Tool.md5(email));
		} catch (Exception exception) {
			exception.printStackTrace();
		}
				
		userService.join(userModel);
	}

	@RequestMapping(value = "/user/login", method = RequestMethod.POST)	
	public String login(@RequestParam("email") String email, @RequestParam("password") String password) throws Exception {
		UserModel userModel = new UserModel();
		userModel.setEmail(email);
		userModel.setPassword(password);
		
		String result = userService.login(userModel);
		if (result == null) {
			throw new Exception();
		}
		
		return result;
	}
	
	@RequestMapping(value = "/user/photo", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getPhoto(@RequestHeader(value = "token", defaultValue = "") String token) {		
		byte[] photoContent = userService.getPhoto(token);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.IMAGE_JPEG);
		return new ResponseEntity<byte[]>(photoContent, httpHeaders, HttpStatus.OK);
	}

	@RequestMapping(value="/user/info", method = RequestMethod.GET)
	public UserModel userinfo(@RequestHeader(value = "token", defaultValue = "") String token) throws Exception {
		UserModel userModel = userService.getUser(token);
		if (userModel == null) {
			throw new Exception();
		}
		return userModel;
	}
}
