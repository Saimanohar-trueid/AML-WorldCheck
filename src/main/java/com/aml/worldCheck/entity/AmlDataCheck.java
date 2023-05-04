package com.aml.worldCheck.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AMLDATACHECK")
public class AmlDataCheck {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name ="AMLACHECKID")
	private Long checkId;
	
	@Column(name = "AML_FIRSTNAME")
	private String firstName;
	
	@Column(name = "AML_LASTNAME")
	private String lastName;
	
	@Column(name = "AML_MOTHERNAME")
	private String motherName;
	
	@Column(name = "AML_DOB")
	private String dob;
	
	public AmlDataCheck() {
	}

	public AmlDataCheck(Long checkId, String firstName, String lastName, String motherName, String dob) {
		super();
		this.checkId = checkId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.motherName = motherName;
		this.dob = dob;
	}

	public Long getCheckId() {
		return checkId;
	}

	public void setCheckId(Long checkId) {
		this.checkId = checkId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	
	
	

}
