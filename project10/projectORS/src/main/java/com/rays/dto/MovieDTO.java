package com.rays.dto;

import java.util.Date;
import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;
@Entity
@Table(name = "ST_MOVIE")
public class MovieDTO extends BaseDTO{
	@Column(name = "NAME")
	private String name;

	@Column(name = "PAYMENTTERM")
	private Long paymentTerm;

	@Column(name = "REGISTRATIONDATE")
	private Date registrationDate;

	@Column(name = "MOVIE_NAME", length = 20)
	private String preloadName = null;

	@Column(name = "MOVIE_ID")
	private Long preloadId;

	@Column(name = "ORG_NAME", length = 50)
	private String orgName;
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPaymentTerm() {
		return paymentTerm;
	}

	public void setPaymentTerm(Long paymentTerm) {
		this.paymentTerm = paymentTerm;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getPreloadName() {
		return preloadName;
	}

	public void setPreloadName(String preloadName) {
		this.preloadName = preloadName;
	}

	public Long getPreloadId() {
		return preloadId;
	}

	public void setPreloadId(Long preloadId) {
		this.preloadId = preloadId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getKey() {
		return id + "";
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return "preloadName";
	}

	@Override
	public String getUniqueKey() {
		// TODO Auto-generated method stub
		return "orgName";
	}

	@Override
	public String getUniqueValue() {
		// TODO Auto-generated method stub
		return "orgName";
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return "orgName";
	}

	@Override
	public LinkedHashMap<String, String> orderBY() {
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		map.put("name", "asc");
		map.put("preloadName", "asc");
		return map;
	}

	@Override
	public LinkedHashMap<String, Object> uniqueKeys() {
		LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("modifiedBy", modifiedBy);
		return map;
	}
}
