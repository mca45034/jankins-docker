package com.rays.form;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.LaptopDTO;
import com.rays.dto.StockAnalysisDTO;
import com.rays.validation.ValidDate;
import com.rays.validation.ValidLong;

public class StockAnalysisForm extends BaseForm {
	@Size(max = 5, message = "this field is 5 character only")
	@NotEmpty(message = "Please enter symbol type")

	private String symbol;

	@NotEmpty(message = "Please enter startDate")
	@ValidDate(message = "Invalid date format or value")
	private String startDate;

	@NotEmpty(message = "Please enter endDate")
	@ValidDate(message = "Invalid date format or value")
	private String endDate;

	@NotEmpty(message = "Please enter Analysis type")
	@ValidLong(message = "Invalid input for category id", allowEmpty = true)
	@Min(value = 1, message = "Analysis should be greater than 0")
	private String preloadId;

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
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

	public String getPreloadId() {
		return preloadId;
	}

	public void setPreloadId(String preloadId) {
		this.preloadId = preloadId;
	}

	@Override
	public BaseDTO getDto() {
		StockAnalysisDTO dto = initDTO(new StockAnalysisDTO());

		dto.setSymbol(symbol);

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

		if (preloadId != null && !preloadId.isEmpty()) {
			dto.setPreloadId(Long.valueOf(preloadId));
		}

		return dto;
	}

}
