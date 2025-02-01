package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.dto.PreloadDTO;
import com.rays.dto.StockAnalysisDTO;
import com.rays.form.StockAnalysisForm;
import com.rays.service.PreloadServiceInt;
import com.rays.service.StockAnalysisServiceInt;

@RestController
@RequestMapping(value = "StockAnalysis")
public class StockAnalysisCtl  extends BaseCtl<StockAnalysisForm, StockAnalysisDTO, StockAnalysisServiceInt>{
	@Autowired
	StockAnalysisServiceInt StockAnalysisServiceInt;
	
	@Autowired
	PreloadServiceInt analysisService;
	
	@GetMapping("/preload")

	public ORSResponse preload() {

		System.out.println("inside preload Paras");

		ORSResponse res = new ORSResponse(true);

		PreloadDTO dto = new PreloadDTO();

		List<DropdownList> list = analysisService.search(dto, userContext);

		res.addResult("preloadList", list);
		return res;
	}


}
