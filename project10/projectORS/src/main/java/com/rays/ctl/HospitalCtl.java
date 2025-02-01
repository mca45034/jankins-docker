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
import com.rays.dto.CityDTO;
import com.rays.dto.HospitalDTO;
import com.rays.form.HospitalForm;
import com.rays.service.CityServiceInt;
import com.rays.service.HospitalServiceInt;

@RestController
@RequestMapping(value = "Hospital")
public class HospitalCtl extends BaseCtl<HospitalForm, HospitalDTO, HospitalServiceInt> {
	@Autowired
	CityServiceInt cityService;

	@Autowired
	HospitalServiceInt hospitalService;

	@GetMapping("/preload")
	public ORSResponse preload() {
		System.out.println("inside preload");
		ORSResponse res = new ORSResponse(true);
		CityDTO dto = new CityDTO();
		List<DropdownList> list = cityService.search(dto, userContext);
		res.addResult("cityList", list);
		return res;
	}

//	@GetMapping("/preload")
//	public ORSResponse preload() {
//		System.out.println("inside preload");
//		ORSResponse res = new ORSResponse(true);
//		HospitalDTO dto = new HospitalDTO();
//		List<DropdownList> list = hospitalService.search(dto, userContext);
//		res.addResult("hospitalList", list);
//		return res;
//	}

	@PostMapping
	public ResponseEntity<String> createSupplier(@Valid @RequestBody HospitalForm hospitalForm) {
		// Handle the logic to save the patient
		return new ResponseEntity<>("Hospital created successfully", HttpStatus.CREATED);
	}
}
