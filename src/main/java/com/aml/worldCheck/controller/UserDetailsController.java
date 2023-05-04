package com.aml.worldCheck.controller;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aml.worldCheck.entity.UserDetailsEntity;
import com.aml.worldCheck.model.JwtRequest;
import com.aml.worldCheck.model.JwtResponse;
import com.aml.worldCheck.service.UserDetailsService;

@RestController
@RequestMapping("/api/v1")
public class UserDetailsController {
	
	@Autowired
	private UserDetailsService service;
	
	@PostMapping("/create")
	public ResponseEntity<?> addUserCreadentials(@RequestBody JwtRequest request)
	{
		JwtResponse response = new JwtResponse();
		String resp=null;
		try {
			resp = service.addUser(request);
			response.setResponse(resp);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(response.getResponse(),HttpStatus.OK);
		
	}

}
