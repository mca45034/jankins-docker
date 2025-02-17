package com.rays.service;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.StateDTO;

public class StateForm extends BaseForm {
	public static final int OUTSIDER = 1;
	public static final int INSIDER = 2;
	public static final int ALIEN = 3;

	@NotEmpty(message = "please enter name")
	private String name;

	@NotEmpty(message = "please enter description")
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

		StateDTO dto = initDTO(new StateDTO());
		dto.setDescription(description);
		System.out.println(dto.getDescription() + "___________");
		dto.setName(name);
		return dto;

	}

}
