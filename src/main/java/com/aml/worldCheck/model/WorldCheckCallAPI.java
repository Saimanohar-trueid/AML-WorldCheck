package com.aml.worldCheck.model;

import com.aml.worldCheck.entity.CheckCallEN;
import com.aml.worldCheck.entity.CheckCallOther;

public class WorldCheckCallAPI {
	
	private Long id;
	private CheckCallOther n_ar;
	private CheckCallEN n_en;
	private String dob;
	private String country;
	private String user;
	
	public WorldCheckCallAPI() {}

	public WorldCheckCallAPI(Long id, CheckCallOther callOther, CheckCallEN callEN, String dob, String country,String user) {
		super();
		this.id = id;
		this.n_ar = callOther;
		this.n_en = callEN;
		this.dob = dob;
		this.country = country;
		this.user = user;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public CheckCallOther getN_ar() {
		return n_ar;
	}

	public void setN_ar(CheckCallOther n_ar) {
		this.n_ar = n_ar;
	}

	public CheckCallEN getN_en() {
		return n_en;
	}

	public void setN_en(CheckCallEN n_en) {
		this.n_en = n_en;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	
	
}
