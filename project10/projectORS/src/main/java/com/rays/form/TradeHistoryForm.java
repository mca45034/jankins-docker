package com.rays.form;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.TradeHistoryDTO;
import com.rays.validation.ValidDate;
import com.rays.validation.ValidLong;

public class TradeHistoryForm extends BaseForm {

	@NotEmpty(message = "Please enter userId")
	@Pattern(regexp = "^[A-Z][a-z]+ [A-Z][a-z]+$", message = "invalid name")
	private String userId;

	// @ValidAlphabetic(message = "please enter Alphabet")
	private String transactiontypeName;

	@NotEmpty(message = "Please enter transactiontypeId")
	@ValidLong(message = "Invalid input for transactiontype id", allowEmpty = true)
	@Min(value = 1, message = "transactiontypeId should be greater than 0")
	private String transactiontypeId;

	@NotNull(message = "startDate is required")
	@ValidDate
	private String startDate;

	@NotNull(message = "endDate is required")
	@ValidDate
	private String endDate;

	@Override
	public BaseDTO getDto() {
		TradeHistoryDTO dto = initDTO(new TradeHistoryDTO());
		dto.setUserId(userId);
		if (startDate != null && !startDate.isEmpty()) {
			try {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date parsedDate = dateFormat.parse(startDate);
				dto.setStartDate(parsedDate);
			} catch (ParseException e) {
				// Handle parse exception if needed
				e.printStackTrace();
			}

		}

		if (endDate != null && !endDate.isEmpty()) {
			try {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date parsedDate = dateFormat.parse(endDate);
				dto.setEndDate(parsedDate);
			} catch (ParseException e) {
				// Handle parse exception if needed
				e.printStackTrace();
			}

		}

		if (transactiontypeId != null && !transactiontypeId.isEmpty()) {
			dto.setTransactiontypeId(Long.valueOf(transactiontypeId));
		}

		dto.setTransactiontypeName(transactiontypeName);

		return dto;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTransactiontypeName() {
		return transactiontypeName;
	}

	public void setTransactiontypeName(String transactiontypeName) {
		this.transactiontypeName = transactiontypeName;
	}

	public String getTransactiontypeId() {
		return transactiontypeId;
	}

	public void setTransactiontypeId(String transactiontypeId) {
		this.transactiontypeId = transactiontypeId;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
}
