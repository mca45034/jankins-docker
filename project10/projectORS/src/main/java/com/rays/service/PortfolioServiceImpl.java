package com.rays.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.PortfolioDAOInt;
import com.rays.dto.PortfolioDTO;
@Service
@Transactional
public class PortfolioServiceImpl extends BaseServiceImpl<PortfolioDTO, PortfolioDAOInt> implements PortfolioServiceInt {
	@Autowired
	PortfolioDAOInt portfolioDAOInt;
}
