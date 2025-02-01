package com.rays.ctl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.dto.CarDTO;
import com.rays.dto.GenderDTO;
import com.rays.form.CarForm;
import com.rays.service.CarServiceInt;
import com.rays.service.GenderServiceInt;
import com.rays.service.PreloadServiceInt;

@RestController
@RequestMapping(value = "Car")
public class CarCtl extends BaseCtl<CarForm, CarDTO, CarServiceInt>{
	@Autowired
	CarServiceInt carService;
	@Autowired
	PreloadServiceInt preloadService;
	
	@Autowired
	private GenderServiceInt genderService;

	
	
	@GetMapping("/preload")

	public ORSResponse preload() {
	
		System.out.println("inside preload Paras");
		
		
		ORSResponse res = new ORSResponse(true);
		
		GenderDTO dto1 = new GenderDTO();
		List<DropdownList> list1 = genderService.search(dto1, userContext);
		res.addResult("genderList", list1);
		
		
		
//		PreloadDTO dto = new PreloadDTO();
//
//		List<DropdownList> list = preloadService.search(dto, userContext);
//
//		res.addResult("preloadList", list);
//		return res;
		CarDTO dto=new CarDTO();
//		List<String> list=new ArrayList<>();
//	     list.add("aaaaaaaa");
//	     list.add("bbbbb");
//	     list.add("ccccc");
//	     
//		res.addResult("preloadList", list);
//		return res;
		
		List list=new ArrayList();
		list.add("aaaaa");
		list.add("bbbb");
		list.add("ccccc");
		res.addResult("preloadList", list);
		return res;
	}
	

}
