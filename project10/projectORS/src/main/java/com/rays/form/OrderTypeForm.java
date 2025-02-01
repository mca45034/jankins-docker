package com.rays.form;


import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.OrderTypeDTO;

public class OrderTypeForm extends BaseForm {
	
	public static final int MARKET = 1;
	public static final int LIMIT = 2;
	
	@NotEmpty(message= "please enter name")
	private String name;
	
	@NotEmpty(message= "please enter description")
	private String description;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	@Override
	public BaseDTO getDto() {

		OrderTypeDTO dto = initDTO(new OrderTypeDTO());
	dto.setDescription(description);
	System.out.println(dto.getDescription()+"___________");
	dto.setName(name);
	return dto;
	
}
	
}
