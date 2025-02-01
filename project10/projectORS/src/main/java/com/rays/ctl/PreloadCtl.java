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
import com.rays.dto.PreloadDTO;
import com.rays.form.PreloadForm;
import com.rays.service.PreloadServiceInt;

@RestController
@RequestMapping(value = "Preload")
public class PreloadCtl extends BaseCtl<PreloadForm, PreloadDTO, PreloadServiceInt> {
	@Autowired
	private PreloadServiceInt preloadService;

	@GetMapping("/preload")

	public ORSResponse preload() {

		System.out.println("inside preload");

		ORSResponse res = new ORSResponse(true);

		PreloadDTO dto = new PreloadDTO();

		List<DropdownList> list = preloadService.search(dto, userContext);

		res.addResult("preloadList", list);

		return res;
	}

	@GetMapping("name/{name}")
	public ORSResponse get(@PathVariable String name) {
		ORSResponse res = new ORSResponse(true);
		PreloadDTO dto = preloadService.findByName(name, userContext);
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
