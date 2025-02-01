package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.dto.TradeHistoryDTO;
import com.rays.dto.TransactionTypeDTO;
import com.rays.form.TradeHistoryForm;
import com.rays.service.TradeHistoryServiceInt;
import com.rays.service.TransactionTypeServiceInt;

@RestController
@RequestMapping(value = "TradeHistory")
public class  TradeHistoryCtl extends BaseCtl<TradeHistoryForm, TradeHistoryDTO, TradeHistoryServiceInt> {
	
	@Autowired
	TransactionTypeServiceInt genderpreloadService;


    @GetMapping("/preload")
    public ORSResponse preload() {
        System.out.println("Inside preload Rahul");
        ORSResponse res = new ORSResponse(true);
        TransactionTypeDTO dto = new TransactionTypeDTO();
        List<DropdownList> list = genderpreloadService.search(dto, 0, 5, userContext);
        System.out.println("aaaayyyyyyyyyyyyyyyyssssssssaaaaaaaaaaaaaaaaaaaaaaaa");
        res.addResult("productpreloadList", list);
        return res;
    }

    
}