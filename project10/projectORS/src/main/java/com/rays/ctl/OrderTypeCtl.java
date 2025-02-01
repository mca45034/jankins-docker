package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.dto.OrderTypeDTO;
import com.rays.form.OrderTypeForm;
import com.rays.service.OrderTypeServiceInt;


@RestController
@RequestMapping(value = "OrderType")
public class  OrderTypeCtl extends BaseCtl<OrderTypeForm, OrderTypeDTO, OrderTypeServiceInt> {

		@Autowired
	private OrderTypeServiceInt ordertypeService;
	
	@GetMapping("/preload")
	public ORSResponse preload() {
		System.out.println("inside preload");
		ORSResponse res = new ORSResponse(true);
		OrderTypeDTO dto = new OrderTypeDTO();
		dto.setStatus(OrderTypeDTO.ACTIVE);
		List<DropdownList> list = ordertypeService.search(dto, userContext);
		res.addResult("stockpurchaseList", list);
		return res;
	}

	@GetMapping("name/{name}")
	public ORSResponse get(@PathVariable String name) {
		ORSResponse res = new ORSResponse(true);
		OrderTypeDTO dto = baseService.findByName(name, userContext);
		System.out.println("Role " + dto);
		if (dto != null) {
			res.addData(dto);
		} else {
			res.setSuccess(false);
			res.addMessage("Record not found");
		}
		return res;
	}

}
