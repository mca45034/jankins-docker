package com.rays.form;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.LaptopDTO;
import com.rays.validation.ValidDate;
import com.rays.validation.ValidLong;

public class LaptopForm extends BaseForm{
	
	
	@NotEmpty(message = "Please enter laptopNameId")
	@ValidLong(message = "Invalid input for category id", allowEmpty = true)
	@Min(value = 1, message = "categoryId should be greater than 0")
	private String laptopNameId;
	
	@Pattern(regexp = "^(?:[1-9]|[1-9][0-9]|[1-4][0-9]{2}|500)$", message = "Payment Term must be a number between 1 and 500")
	@NotEmpty(message = "Please enter payment Term")
	private String price;

	@NotEmpty(message = "Please enter registration Date")
	@ValidDate(message = "Invalid date format or value")
	private String registrationDate;
    
	//@Pattern(regexp = "^[A-Z][a-z]+ [A-Z][a-z]+$", message = "invalid name")
	@Size(max = 20, message = "this field is 20 character only")
	@NotEmpty(message = "Please enter Namesss")
	private String version;
	//private String categoryName;

	

	
	

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	

	public String getLaptopNameId() {
		return laptopNameId;
	}

	public void setLaptopNameId(String laptopNameId) {
		this.laptopNameId = laptopNameId;
	}

	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

//	public String getCategoryName() {
//		return categoryName;
//	}
//
//	public void setCategoryName(String categoryName) {
//		this.categoryName = categoryName;
//	}

	@Override
	public BaseDTO getDto() {
		LaptopDTO dto = initDTO(new LaptopDTO());

		dto.setVersion(version);

		if (registrationDate != null && !registrationDate.isEmpty()) {
			try {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date parsedDate = dateFormat.parse(registrationDate);
				dto.setRegistrationDate(parsedDate);
			} catch (ParseException e) {
				// Handle parse exception if needed
				e.printStackTrace();
			}
		}

		if (price != null && !price.isEmpty()) {
			dto.setPrice(Long.valueOf(price));
		}

		if (laptopNameId != null && !laptopNameId.isEmpty()) {
			dto.setLaptopNameId(Long.valueOf(laptopNameId));
		}

		//dto.setCategoryName(categoryName);

		return dto;
	}

	
}
