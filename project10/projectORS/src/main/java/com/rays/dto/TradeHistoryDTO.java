package com.rays.dto;

import java.util.Date;
import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "ST_TRADEHISTORY")
public class TradeHistoryDTO extends BaseDTO {

	public String getKey() {
		return id + "";
	}

	@Column(name = "NAME")
	private String userId;

	@Column(name = "STARTDATE")
	private Date startDate;

	@Column(name = "ENDDATE")
	private Date endDate;

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	@Column(name = "TRANSACRTIONTYPENAME", length = 50)
	private String transactiontypeName = null;

	@Column(name = "TRANSACTIONTYPE_ID")
	private Long transactiontypeId;

	@Column(name = "ORG_NAME", length = 50)
	private String orgName;

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return "orgName";
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
		map.put("userId", "asc");
		map.put("transactiontypeName", "asc");
		return map;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getTransactiontypeName() {
		return transactiontypeName;
	}

	public void setTransactiontypeName(String transactiontypeName) {
		this.transactiontypeName = transactiontypeName;
	}

	public Long getTransactiontypeId() {
		return transactiontypeId;
	}

	public void setTransactiontypeId(Long transactiontypeId) {
		this.transactiontypeId = transactiontypeId;
	}

	@Override
	public LinkedHashMap<String, Object> uniqueKeys() {
		LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("modifiedBy", modifiedBy);
		return map;
	}

}
