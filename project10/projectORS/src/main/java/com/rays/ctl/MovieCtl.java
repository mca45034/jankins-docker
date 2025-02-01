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
import com.rays.dto.MovieDTO;
import com.rays.dto.PreloadDTO;
import com.rays.form.MovieForm;
import com.rays.service.MovieServiceInt;
import com.rays.service.PreloadServiceInt;

@RestController
@RequestMapping(value = "Movie")
public class MovieCtl extends BaseCtl<MovieForm, MovieDTO, MovieServiceInt> {

	@Autowired
	PreloadServiceInt preloadServies;

	@Autowired
	MovieServiceInt movieService;

	@GetMapping("/preload")
	public ORSResponse preload() {
		System.out.println("inside preload Paras");
		ORSResponse res = new ORSResponse(true);
		PreloadDTO dto = new PreloadDTO();
		List<DropdownList> list = preloadServies.search(dto, userContext);
		res.addResult("preloadList", list);
		return res;
	}

	@PostMapping
	public ResponseEntity<String> createSupplier(@Valid @RequestBody MovieForm movieForm) {
		// Handle the logic to save the patient
		return new ResponseEntity<>("Movies created successfully", HttpStatus.CREATED);
	}
}
