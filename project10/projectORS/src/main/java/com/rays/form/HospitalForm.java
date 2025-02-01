package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.HospitalDTO;


public class HospitalForm extends BaseForm {
//	@Pattern(regexp = "^[A-Z][a-z]+ [A-Z][a-z]+$", message = "invalid name")
//	@Size(max = 20, message = "this field is 20 character only")

	//@NotEmpty(message = "Please enter Name")
	private String names;

//	@Pattern(regexp = "^[A-Z][a-z]+ [A-Z][a-z]+$", message = "invalid name")
//	@Size(max = 20, message = "this field is 20 character only")
	@NotEmpty(message = "Please enter Name")
	private String description;

//	@Pattern(regexp = "^[A-Z][a-z]+ [A-Z][a-z]+$", message = "invalid name")
//	@Size(max = 20, message = "this field is 20 character only")
	@NotEmpty(message = "Please enter Name")
	private String hospitalName;

	// private String categoryName;

	@NotEmpty(message = "Please enter CityId")
//	@ValidLong(message = "Invalid input for category id", allowEmpty = true)
//	@Min(value = 1, message = "categoryId should be greater than 0")
	private String cityId;

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	 public String getHospitalName() {
	        return hospitalName;
	    }

	    public void setHospitalName(String hospitalName) {
	        this.hospitalName = hospitalName;
	    }

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	@Override
	public BaseDTO getDto() {
		HospitalDTO dto = initDTO(new HospitalDTO());
		dto.setNames(names);
		dto.setHospitalName(hospitalName);

		dto.setDescription(description);

		if (cityId != null && !cityId.isEmpty()) {
			dto.setCityId((Long.valueOf(cityId)));
		}

		// dto.setCategoryName(categoryName);

		return dto;
	}

}
