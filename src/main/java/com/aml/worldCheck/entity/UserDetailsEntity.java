package com.aml.worldCheck.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "AML_USERDETAILS")
public class UserDetailsEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="seq_gen")
	@SequenceGenerator(name="seq_gen", sequenceName="SEQ_USERID", allocationSize=1)
	@Column(name="USER_ID")
	private Long id;
	
	@Column(name = "AUTH_USERNAME")
	private String username;
	
	@Column(name = "AUTH_PASSWORD")
	private String password;
	
	@Column(name = "AUTH_CREATED")
	private Date createdDate;
	
	public UserDetailsEntity() {
		// TODO Auto-generated constructor stub
	}

	public UserDetailsEntity(Long id, String username, String password, Date createdDate) {
		//super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.createdDate = createdDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	

}
