package com.rays.dto;

import java.util.Date;
import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "ST_STOCKPURCHASE")
public class StockPurchaseDTO extends BaseDTO {

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getKey() {
		return id + "";
	}

	@Column(name = "PURCHASEPRICE")
	private long purcahsePrice;

	@Column(name = "purchaseDATE")
	private Date purchaseDate;

	@Column(name = "QUANTITY")
	private String quantity;

	@Column(name = "ORDERTYPENAME", length = 50)
	private String ordertypeName;

	@Column(name = "ORDERTYPE_ID")
	private Long ordertypeId;

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
		map.put("ordertypeName", "asc");
		return map;
	}

	public long getPurcahsePrice() {
		return purcahsePrice;
	}

	public void setPurcahsePrice(long purcahsePrice) {
		this.purcahsePrice = purcahsePrice;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getOrdertypeName() {
		return ordertypeName;
	}

	public void setOrdertypeName(String ordertypeName) {
		this.ordertypeName = ordertypeName;
	}

	public Long getOrdertypeId() {
		return ordertypeId;
	}

	public void setOrdertypeId(Long ordertypeId) {
		this.ordertypeId = ordertypeId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	@Override
	public LinkedHashMap<String, Object> uniqueKeys() {
		LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("modifiedBy", modifiedBy);
		return map;
	}

}
