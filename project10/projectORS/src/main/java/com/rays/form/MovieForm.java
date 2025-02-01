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
import com.rays.dto.MovieDTO;
import com.rays.validation.ValidDate;
import com.rays.validation.ValidLong;

public class MovieForm extends BaseForm{
	@Pattern(regexp = "^(?:[1-9]|[1-9][0-9]|[1-4][0-9]{2}|500)$", message = "Payment Term must be a number between 1 and 500")
	@NotEmpty(message = "Please enter no of person")
	private String name;

	@Pattern(regexp = "^(?:[1-9]|[1-9][0-9]|[1-4][0-9]{2}|500)$", message = "1 to 9 select person")
	@NotEmpty(message = "Please enter price Term")
	private String paymentTerm;

	@NotEmpty(message = "Please enter registration Date")
	@ValidDate(message = "Invalid date format or value")
	private String registrationDate;

	//private String categoryName;

	@NotEmpty(message = "Please enter movieName")
	@ValidLong(message = "Invalid input for movieName id", allowEmpty = true)
	@Min(value = 1, message = "movieName should be greater than 0")
	private String preloadId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPaymentTerm() {
		return paymentTerm;
	}

	public void setPaymentTerm(String paymentTerm) {
		this.paymentTerm = paymentTerm;
	}

	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getPreloadId() {
		return preloadId;
	}

	public void setPreloadId(String preloadId) {
		this.preloadId = preloadId;
	}
	
	@Override
	public BaseDTO getDto() {
		MovieDTO dto = initDTO(new MovieDTO());

		dto.setName(name);

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

		if (paymentTerm != null && !paymentTerm.isEmpty()) {
			dto.setPaymentTerm(Long.valueOf(paymentTerm));
		}

		if (preloadId != null && !preloadId.isEmpty()) {
			dto.setPreloadId(Long.valueOf(preloadId));
		}

		//dto.setCategoryName(categoryName);

		return dto;
	}

}
