package com.aml.worldCheck.service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aml.worldCheck.entity.UserDetailsEntity;
import com.aml.worldCheck.model.JwtRequest;
import com.aml.worldCheck.repository.UserDetailsRepository;

@Service
public class UserDetailsService {

	@Autowired
	private UserDetailsRepository detailsRepository;

	public String addUser(JwtRequest userDetails) {
		UserDetailsEntity entity = new UserDetailsEntity();

		Date date = new Date(System.currentTimeMillis());

		try {
			byte[] inputBytes = userDetails.getPassword().getBytes(StandardCharsets.UTF_8);
			String encodedString = Base64.getEncoder().encodeToString(inputBytes);
			entity.setUsername(userDetails.getUsername());
			entity.setPassword(encodedString);
			entity.setCreatedDate(date);

			if (!"".equals(entity) && entity != null)
				detailsRepository.save(entity);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "User has inserted !!";
	}

	public JwtRequest getUserDataByName(String username) {

		JwtRequest requestData = new JwtRequest();

		try {
			UserDetailsEntity entity = detailsRepository.getUserByUsername(username);

			byte[] decodedBytes = Base64.getDecoder().decode(entity.getPassword().getBytes(StandardCharsets.UTF_8));
			String decodedString = new String(decodedBytes, StandardCharsets.UTF_8);

			requestData.setUsername(entity.getUsername());
			requestData.setPassword(decodedString);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return requestData;
	}

}
