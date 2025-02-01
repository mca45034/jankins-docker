package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.CityDTO;

public class CityForm extends BaseForm {
//	@Pattern(regexp = "^[A-Z][a-z]+ [A-Z][a-z]+$", message = "invalid name")
//	@Size(max = 20, message = "this field is 20 character only")
	@NotEmpty(message = "Please enter Name")
	private String name;

//	@Pattern(regexp = "^[A-Z][a-z]+ [A-Z][a-z]+$", message = "invalid name")
//	@Size(max = 20, message = "this field is 20 character only")
	@NotEmpty(message = "Please enter Name")
	private String description;

//	@Pattern(regexp = "^[A-Z][a-z]+ [A-Z][a-z]+$", message = "invalid name")
//	@Size(max = 20, message = "this field is 20 character only")
	@NotEmpty(message = "Please enter Name")
	private String cityName;

	// private String categoryName;

	@NotEmpty(message = "Please enter categoryId")
//	@ValidLong(message = "Invalid input for category id", allowEmpty = true)
//	@Min(value = 1, message = "categoryId should be greater than 0")
	private String stateId;

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

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getStateId() {
		return stateId;
	}

	public void setStateId(String stateId) {
		this.stateId = stateId;
	}

	@Override
	public BaseDTO getDto() {
		CityDTO dto = initDTO(new CityDTO());
		dto.setCityName(cityName);
		dto.setName(name);

		dto.setDescription(description);

		if (stateId != null && !stateId.isEmpty()) {
			dto.setStateId(Long.valueOf(stateId));
		}

		// dto.setCategoryName(categoryName);

		return dto;
	}

}
