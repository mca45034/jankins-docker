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
import com.rays.dto.BikeDTO;
import com.rays.dto.PreloadDTO;
import com.rays.form.BikeForm;
import com.rays.service.BikeServiceInt;
import com.rays.service.PreloadServiceInt;

@RestController
@RequestMapping(value = "Bike")

public class BikeCtl extends BaseCtl<BikeForm, BikeDTO, BikeServiceInt> {
	@Autowired
	PreloadServiceInt preloadService;

	@Autowired
	BikeServiceInt bikeService;

	@GetMapping("/preload")

	public ORSResponse preload() {
		System.out.println("inside preload Paras");
		ORSResponse res = new ORSResponse(true);
		PreloadDTO dto = new PreloadDTO();

		List<DropdownList> list = preloadService.search(dto, userContext);

		res.addResult("preloadList", list);
		return res;
	}

	@PostMapping
	public ResponseEntity<String> createSupplier(@Valid @RequestBody BikeForm bikeForm) {
		// Handle the logic to save the patient
		return new ResponseEntity<>("bike created successfully", HttpStatus.CREATED);
	}
}
