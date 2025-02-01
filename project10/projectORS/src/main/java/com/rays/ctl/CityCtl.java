package com.rays.ctl;

import javax.validation.Valid;
import java.util.List;
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
import com.rays.dto.StateDTO;
import com.rays.form.CityForm;
import com.rays.service.CityServiceInt;
import com.rays.service.StateServiceInt;


@RestController
@RequestMapping(value = "City")
public class CityCtl extends BaseCtl<CityForm, CityDTO, CityServiceInt>{
	@Autowired
	StateServiceInt stateService;
	
	@Autowired
	CityServiceInt cityService;
	
	
	@GetMapping("/preload")
	public ORSResponse preload() {
		System.out.println("inside preload");
		ORSResponse res = new ORSResponse(true);
		StateDTO dto = new StateDTO();
		List <DropdownList> list = stateService.search(dto, userContext);
		res.addResult("stateList", list);
		return res;
	}
	
	@PostMapping
	public ResponseEntity<String> createSupplier(@Valid @RequestBody CityForm cityForm) {
		// Handle the logic to save the patient
		return new ResponseEntity<>("City created successfully", HttpStatus.CREATED);
	}
	
//	@GetMapping("/preload")
//	public ORSResponse preload() {
//		System.out.println("inside preload");
//		ORSResponse res = new ORSResponse(true);
//		CityDTO dto = new CityDTO();
//		@SuppressWarnings("unchecked")
//		List<DropdownList> list = cityService.search(dto, userContext);
//		res.addResult("cityList", list);
//		return res;
//	}
	
}

