package com.aml.worldCheck.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aml.worldCheck.model.AmlDataCheckModel;
import com.aml.worldCheck.model.RequestData;
import com.aml.worldCheck.model.WorldCheckCallAPI;
import com.aml.worldCheck.service.AmlDataCheckService;
import com.aml.worldCheck.service.UserService;
import com.aml.worldCheck.utility.JWTUtility;

@RestController
@RequestMapping("/api/aml")
public class AmlDataCheckController {

	private static final Logger logger = LoggerFactory.getLogger(AmlDataCheckController.class);

	@Autowired
	private AmlDataCheckService service;

	@Autowired
	private JWTUtility jwtUtility;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserService userService;

	@PostMapping("/authenticate")
	public AmlDataCheckModel authenticate(@RequestBody RequestData jwtRequest) throws Exception {

		AmlDataCheckModel model = null;
		final UserDetails userDetails = userService.loadUserByUsername(jwtRequest.getUsername());

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword()));
		} catch (BadCredentialsException e) {
			model = new AmlDataCheckModel("INVALID_CREDENTIALS", HttpStatus.BAD_GATEWAY);
		}

		final String token = jwtUtility.generateToken(userDetails);
		
		if(token != null) {
			model = new AmlDataCheckModel(token,HttpStatus.OK);
		}
		return model;
	}

	@PostMapping("/callService")
	public AmlDataCheckModel checkData(@RequestHeader(name = "Authorization") String token,
			@RequestBody WorldCheckCallAPI dataCheck) {


		String authorization = token;
		String tokenAfter = null;

		if (null != authorization && authorization.startsWith("Bearer ")) {
			tokenAfter = authorization.substring(7);
		}

		AmlDataCheckModel model;
		try {

			if (tokenAfter != null && jwtUtility.validateTokenUser(tokenAfter, dataCheck.getUser())) {
				model = service.checkData(dataCheck);
			} else {
				return new AmlDataCheckModel("UnAuthorize User details", HttpStatus.UNAUTHORIZED);
			}
		} catch (Exception e) {
			return new AmlDataCheckModel("Exception Occured ",HttpStatus.BAD_REQUEST);
		}

		return new AmlDataCheckModel(model.getReturnValue(), HttpStatus.OK);
	}

	@GetMapping("/welcome")
	public String home() {
		return "Welcome to AML WORLD CHECK Data!!";
	}

}
