package com.appsdeveloperblog.photoapp.api.users.service;

import java.util.UUID;

import com.appsdeveloperblog.photoapp.api.users.shared.UserDto;

public class UserServiceImpl implements UsersService {

	@Override
	public UserDto createUser(UserDto userDetails) {
		// TODO Auto-generated method stub
		
		//To generate a random unique Alphanumeric User ID
		userDetails.setUserId(UUID.randomUUID().toString());
		
		return null;
	}
	
}
