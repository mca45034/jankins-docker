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
import com.rays.dto.NameLaptopDTO;
import com.rays.form.NameLaptopForm;
import com.rays.service.NameLaptopServiceInt;

@RestController
@RequestMapping(value = "NameLaptop")
public class NameLaptopCtl extends BaseCtl<NameLaptopForm, NameLaptopDTO, NameLaptopServiceInt> {

	@Autowired
	private NameLaptopServiceInt NameLaptopService;

	@GetMapping("/preload")
	public ORSResponse preload() {
		System.out.println("inside preload");
		ORSResponse res = new ORSResponse(true);
		NameLaptopDTO dto = new NameLaptopDTO();
		List<DropdownList> list = NameLaptopService.search(dto, userContext);
		res.addResult("NameLaptopList", list);
		return res;
	}

	@GetMapping("name/{name}")
	public ORSResponse get(@PathVariable String name) {
		ORSResponse res = new ORSResponse(true);
		NameLaptopDTO dto = baseService.findByName(name, userContext);
		System.out.println("Product " + dto);
		if (dto != null) {
			res.addData(dto);
		} else {
			res.setSuccess(false);
			res.addMessage("Record not found");
		}
		return res;
	}
}
