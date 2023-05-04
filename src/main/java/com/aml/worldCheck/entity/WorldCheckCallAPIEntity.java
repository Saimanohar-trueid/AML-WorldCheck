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
@Table(name="AML_NAME_DATA")
public class WorldCheckCallAPIEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="seq_gen")
	@SequenceGenerator(name="seq_gen", sequenceName="SEQ_AML_ID", allocationSize=1)
	@Column(name="AML_ID")
	private Long amlId;
	
	@Column(name="AML_RECORD_ID")
	private Long id;
	
	@Column(name="N_AR")
	private String n_ar;
	
	@Column(name="AR_NAME1")
	private String ar_name1;
	
	@Column(name="AR_NAME2")
	private String ar_name2;
	
	@Column(name="AR_NAME3")
	private String ar_name3;
	
	@Column(name="N_EN")
	private String n_en;
	
	@Column(name="EN_NAME1")
	private String en_name1;
	
	@Column(name="EN_NAME2")
	private String en_name2;
	
	@Column(name="EN_NAME3")
	private String en_name3;
	
	@Column(name="AML_DOB")
	private String dob;
	
	@Column(name="AML_COUNTRY")
	private String country;
	
	@Column(name="AML_MAKERSTAMP")
	private Date makerstamp;
	
	
	public WorldCheckCallAPIEntity() {	}


	public WorldCheckCallAPIEntity(Long amlId, Long id, String n_ar, String ar_name1, String ar_name2,
			String ar_name3, String n_en, String en_name1, String en_name2, String en_name3, String dob,
			String country) {
		super();
		this.amlId = amlId;
		this.id = id;
		this.n_ar = n_ar;
		this.ar_name1 = ar_name1;
		this.ar_name2 = ar_name2;
		this.ar_name3 = ar_name3;
		this.n_en = n_en;
		this.en_name1 = en_name1;
		this.en_name2 = en_name2;
		this.en_name3 = en_name3;
		this.dob = dob;
		this.country = country;
	}


	public Long getAmlId() {
		return amlId;
	}


	public void setAmlId(Long amlId) {
		this.amlId = amlId;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public String getN_ar() {
		return n_ar;
	}


	public void setN_ar(String n_ar) {
		this.n_ar = n_ar;
	}


	public String getN_en() {
		return n_en;
	}


	public void setN_en(String n_en) {
		this.n_en = n_en;
	}


	public String getAr_name1() {
		return ar_name1;
	}


	public void setAr_name1(String ar_name1) {
		this.ar_name1 = ar_name1;
	}


	public String getAr_name2() {
		return ar_name2;
	}


	public void setAr_name2(String ar_name2) {
		this.ar_name2 = ar_name2;
	}


	public String getAr_name3() {
		return ar_name3;
	}


	public void setAr_name3(String ar_name3) {
		this.ar_name3 = ar_name3;
	}

	public String getEn_name1() {
		return en_name1;
	}


	public void setEn_name1(String en_name1) {
		this.en_name1 = en_name1;
	}


	public String getEn_name2() {
		return en_name2;
	}


	public void setEn_name2(String en_name2) {
		this.en_name2 = en_name2;
	}


	public String getEn_name3() {
		return en_name3;
	}


	public void setEn_name3(String en_name3) {
		this.en_name3 = en_name3;
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


	public Date getMakerstamp() {
		return makerstamp;
	}


	public void setMakerstamp(Date makerstamp) {
		this.makerstamp = makerstamp;
	}
	
	
	
	
}
