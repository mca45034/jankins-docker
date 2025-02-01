package com.rays.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.StockPurchaseDAOInt;
import com.rays.dto.StockPurchaseDTO;

@Service
@Transactional
public class StockPurchaseServiceImp extends BaseServiceImpl<StockPurchaseDTO, StockPurchaseDAOInt> implements StockPurchaseServiceInt {

	@Autowired
	StockPurchaseDAOInt projectDAO;

}
