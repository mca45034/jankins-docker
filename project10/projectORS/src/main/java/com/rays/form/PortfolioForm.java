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
import com.rays.dto.CarDTO;
import com.rays.dto.PortfolioDTO;
import com.rays.validation.ValidLong;

public class PortfolioForm extends BaseForm {
	@Size(max = 20, message = "this field is 20 character only")
	@NotEmpty(message = "Please enter name type")

	private String name;

	@NotEmpty(message = "Please enter strategy type")

	private String strategy;

	@Pattern(regexp = "^(?:[1-9]|[1-9][0-9]|[1-4][0-9]{2}|500)$", message = "Payment Term must be a number between 1 and 500")

	@NotEmpty(message = "Please enter payment Term")
	private String paymentTerm;

	@NotEmpty(message = "Please enter tolrence Name")
	@ValidLong(message = "Invalid input for category id", allowEmpty = true)
	@Min(value = 1, message = "categoryId should be greater than 0")
	private String preloadId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStrategy() {
		return strategy;
	}

	public void setStrategy(String strategy) {
		this.strategy = strategy;
	}

	public String getPaymentTerm() {
		return paymentTerm;
	}

	public void setPaymentTerm(String paymentTerm) {
		this.paymentTerm = paymentTerm;
	}

	public String getPreloadId() {
		return preloadId;
	}

	public void setPreloadId(String preloadId) {
		this.preloadId = preloadId;
	}
	
	@Override
	public BaseDTO getDto() {
		PortfolioDTO dto = initDTO(new PortfolioDTO());

		dto.setName(name);
		dto.setStrategy(strategy);
		

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
