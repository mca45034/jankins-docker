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
import com.rays.dto.StockPurchaseDTO;
import com.rays.validation.ValidDate;
import com.rays.validation.ValidLong;

public class StockPurchaseForm extends BaseForm {

	@NotEmpty(message = "Please enter Purchaseprice")
	@Pattern(regexp = "^(10000|[1-4]\\d{4}|500000)$", message = "enter purchase price between 10000 to 50000")
	private String purcahsePrice;

	// @ValidAlphabetic(message = "please enter Alphabet")
	private String ordertypeName;

	@NotEmpty(message = "Please enter ordertypeId")
	@ValidLong(message = "Invalid input for ordertype id", allowEmpty = true)
	@Min(value = 1, message = "ordertypeId should be greater than 0")
	private String ordertypeId;

	@NotNull(message = "purchaseDate is required")
	@ValidDate
	private String purchaseDate;

	@NotNull(message = "Please enter quantity")
	// @Pattern(regexp = "^([0-9]|[1-2][0-9]|3[0-5])$", message = "please enter
	// exprience after 40 years")
//	@ValidLong
	private String quantity;

	public String getPurcahsePrice() {
		return purcahsePrice;
	}

	public void setPurcahsePrice(String purcahsePrice) {
		this.purcahsePrice = purcahsePrice;
	}

	public String getOrdertypeName() {
		return ordertypeName;
	}

	public void setOrdertypeName(String ordertypeName) {
		this.ordertypeName = ordertypeName;
	}

	public String getOrdertypeId() {
		return ordertypeId;
	}

	public void setOrdertypeId(String ordertypeId) {
		this.ordertypeId = ordertypeId;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	@Override
	public BaseDTO getDto() {
		StockPurchaseDTO dto = initDTO(new StockPurchaseDTO());

		dto.setQuantity(quantity);
		if (purchaseDate != null && !purchaseDate.isEmpty()) {
			try {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date parsedDate = dateFormat.parse(purchaseDate);
				dto.setPurchaseDate(parsedDate);
			} catch (ParseException e) {
				// Handle parse exception if needed
				e.printStackTrace();
			}

		}

		if (purcahsePrice != null && !purcahsePrice.isEmpty()) {
			dto.setPurcahsePrice(Long.valueOf(purcahsePrice));
		}

		if (ordertypeId != null && !ordertypeId.isEmpty()) {
			dto.setOrdertypeId(Long.valueOf(ordertypeId));
		}
		dto.setOrdertypeName(ordertypeName);

		return dto;
	}
}
