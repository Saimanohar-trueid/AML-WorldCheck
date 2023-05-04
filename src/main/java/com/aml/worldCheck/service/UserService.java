package com.aml.worldCheck.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.aml.worldCheck.entity.UserDetailsEntity;
import com.aml.worldCheck.model.JwtRequest;
import com.aml.worldCheck.repository.UserDetailsRepository;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserDetailsRepository repository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    	
    	JwtRequest requestData = new JwtRequest();
    	
    	try {
    		UserDetailsEntity entity = repository.getUserByUsername(userName);
    		
    		 byte[] decodedBytes = Base64.getDecoder().decode(entity.getPassword().getBytes(StandardCharsets.UTF_8));
    	     String decodedString = new String(decodedBytes, StandardCharsets.UTF_8);
    	     
    	     requestData.setUsername(entity.getUsername());
    	     requestData.setPassword(decodedString);
    	        
    		
    		}catch (Exception e) {
    			e.printStackTrace();
    		}

    	
        return new User(requestData.getUsername(),requestData.getPassword(),new ArrayList<>());
    }
    
    public String dataValues(String password) {    	
    	return password;    	
    }

}