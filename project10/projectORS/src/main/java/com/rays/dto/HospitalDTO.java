package com.rays.dto;

import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "ST_HOSPITAL")
public class HospitalDTO extends BaseDTO {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String YES = "Y";
	public static String NO = "N";
	public static String ACTIVE = "Active";
	public static String INACTIVE = "Inactive";

	@Column(name = "NAME", length = 50)
	private String names;

	@Column(name = "DESCRIPTION", length = 100)
	private String description = null;
	
	@Column(name="HOSPITAL_NAME",length = 50)
	private String hospitalName;

	@Column(name = "CITY_NAME", length = 50)
	private String cityName = null;

	@Column(name = "CITY_ID")
	private Long cityId;

	@Column(name = "CAN_READ", length = 1)
	private String canRead = YES;

	@Column(name = "CAN_WRITE", length = 1)
	private String canWrite = YES;

	@Column(name = "CAN_UPDATE", length = 1)
	private String canUpdate = YES;

	@Column(name = "CAN_DELETE", length = 1)
	private String canDelete = YES;

	public static String getYES() {
		return YES;
	}

	public static void setYES(String yES) {
		YES = yES;
	}

	public static String getNO() {
		return NO;
	}

	public static void setNO(String nO) {
		NO = nO;
	}

	public static String getACTIVE() {
		return ACTIVE;
	}

	public static void setACTIVE(String aCTIVE) {
		ACTIVE = aCTIVE;
	}

	public static String getINACTIVE() {
		return INACTIVE;
	}

	public static void setINACTIVE(String iNACTIVE) {
		INACTIVE = iNACTIVE;
	}

	

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}
	
	

	 public String getHospitalName() {
	        return hospitalName;
	    }

	    public void setHospitalName(String hospitalName) {
	        this.hospitalName = hospitalName;
	    }

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public String getCanRead() {
		return canRead;
	}

	public void setCanRead(String canRead) {
		this.canRead = canRead;
	}

	public String getCanWrite() {
		return canWrite;
	}

	public void setCanWrite(String canWrite) {
		this.canWrite = canWrite;
	}

	public String getCanUpdate() {
		return canUpdate;
	}

	public void setCanUpdate(String canUpdate) {
		this.canUpdate = canUpdate;
	}

	public String getCanDelete() {
		return canDelete;
	}

	public void setCanDelete(String canDelete) {
		this.canDelete = canDelete;
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return id + "";
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return names;
	}

	@Override
	public String getUniqueKey() {
		// TODO Auto-generated method stub
		return names;
	}

	@Override
	public String getUniqueValue() {
		// TODO Auto-generated method stub
		return names;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return "Hospital Name";
	}

	@Override
	public LinkedHashMap<String, String> orderBY() {
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		map.put("names", "asc");
		map.put("HospitalName", "asc");
		return map;
	}

	@Override
	public LinkedHashMap<String, Object> uniqueKeys() {
		LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("modifiedBy", modifiedBy);
		return map;
	}

}
