package com.rays.dto;

import java.util.Date;
import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "ST_stockanaylsis")
public class StockAnalysisDTO extends BaseDTO{
	
	@Column(name = "SYMBOL", length = 5)
	private String symbol = null;
	
	@Column(name = "START_DATE")
	private Date startDate;
	
	@Column(name = "END_DATE")
	private Date endDate;

	@Column(name = "ANALYSIS_NAME", length = 20)
	private String preloadName = null;

	@Column(name = "ANALYSIS_ID")
	private Long preloadId;
	
	@Column(name = "ORG_NAME", length = 50)
	private String orgName;

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
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
		return orgName;
	}

	@Override
	public String getUniqueValue() {
		// TODO Auto-generated method stub
		return orgName;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return orgName;
	}

	@Override
	public LinkedHashMap<String, String> orderBY() {
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		map.put("symbol", "asc");
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
