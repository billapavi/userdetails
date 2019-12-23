package com.billa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billa.repo.UserPassRepo;
import com.billa.user.entities.UserPass;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class UserPassService {

	@Autowired
	private UserPassRepo repo;
	
	public void createUser(String email,String passwrod)
	{
		
	}
	
	public UserPass getUser (String email)
	{
		
		
		return null;
		
	}
	
	
	
}
