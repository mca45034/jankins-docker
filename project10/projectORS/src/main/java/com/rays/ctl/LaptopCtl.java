package com.rays.ctl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.dto.LaptopDTO;
import com.rays.dto.NameLaptopDTO;
import com.rays.form.LaptopForm;
import com.rays.service.LaptopServiceInt;
import com.rays.service.NameLaptopServiceInt;

@RestController
@RequestMapping(value = "Laptop")
public class LaptopCtl extends BaseCtl<LaptopForm, LaptopDTO, LaptopServiceInt>{
	@Autowired
	NameLaptopServiceInt NameLaptopService;
	

	@Autowired
	LaptopServiceInt LaptopService;
	

	@GetMapping("/preload")
	public ORSResponse preload() {
		System.out.println("inside preload Paras");
		ORSResponse res = new ORSResponse(true);
		NameLaptopDTO dto = new NameLaptopDTO();
		
		List<DropdownList> list = NameLaptopService.search(dto, userContext);
		
		res.addResult("nameLaptopList", list);
		return res;
	}

	@PostMapping
	public ResponseEntity<String> createSupplier(@Valid @RequestBody LaptopForm supplierForm) {
		// Handle the logic to save the patient
		return new ResponseEntity<>("Supplier created successfully", HttpStatus.CREATED);
	}
	

}
