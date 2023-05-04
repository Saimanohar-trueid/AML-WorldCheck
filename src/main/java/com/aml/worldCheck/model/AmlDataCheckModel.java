package com.aml.worldCheck.model;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

public class AmlDataCheckModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String returnValue;
	
	private HttpStatus responseCode;
	
	public AmlDataCheckModel() {
	}

	public AmlDataCheckModel(String returnValue, HttpStatus responseCode) {
		super();
		this.returnValue = returnValue;
		this.responseCode = responseCode;
	}

	public String getReturnValue() {
		return returnValue;
	}

	public void setReturnValue(String returnValue) {
		this.returnValue = returnValue;
	}

	public HttpStatus getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(HttpStatus responseCode) {
		this.responseCode = responseCode;
	}


	

}
