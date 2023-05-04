package com.aml.worldCheck.model;

public class JwtResponse {
	
	private String jwtToken;
	
	private String response;
	
	public JwtResponse() {
		// TODO Auto-generated constructor stub
	}

	public JwtResponse(String jwtToken,String response) {
		super();
		this.jwtToken = jwtToken;
		this.response = response;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}
	
	

}
