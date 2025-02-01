package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.dto.PortfolioDTO;
import com.rays.dto.PreloadDTO;
import com.rays.form.PortfolioForm;
import com.rays.service.PortfolioServiceInt;
import com.rays.service.PreloadServiceInt;

@RestController
@RequestMapping(value = "Portfolio")
public class PortfolioCtl extends BaseCtl<PortfolioForm, PortfolioDTO, PortfolioServiceInt> {
	@Autowired
	PreloadServiceInt preloadService;
	@Autowired
	PortfolioServiceInt portfolioServiceInt;

	@GetMapping("/preload")

	public ORSResponse preload() {

		System.out.println("inside preload Paras");

		ORSResponse res = new ORSResponse(true);

		PreloadDTO dto = new PreloadDTO();

		List<DropdownList> list = preloadService.search(dto, userContext);

		res.addResult("preloadList", list);
		return res;
	}

}
