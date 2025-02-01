package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.dto.OrderTypeDTO;
import com.rays.dto.StockPurchaseDTO;
import com.rays.form.StockPurchaseForm;
import com.rays.service.OrderTypeServiceInt;
import com.rays.service.StockPurchaseServiceInt;

@RestController
@RequestMapping(value = "StockPurchase")
public class StockPurchaseCtl extends BaseCtl<StockPurchaseForm, StockPurchaseDTO, StockPurchaseServiceInt> {

	@Autowired
	OrderTypeServiceInt ordertypeService;

	@Autowired
	StockPurchaseServiceInt stockpurchaseService;

	@GetMapping("/preload")
	public ORSResponse preload() {
		System.out.println("Inside preload Rahul");
		ORSResponse res = new ORSResponse(true);
		OrderTypeDTO dto = new OrderTypeDTO();
		List<DropdownList> list = ordertypeService.search(dto, 0, 5, userContext);
		System.out.println("aaaayyyyyyyyyyyyyyyyssssssssaaaaaaaaaaaaaaaaaaaaaaaa");
		res.addResult("stockpurchaseList", list);
		return res;
	}

}