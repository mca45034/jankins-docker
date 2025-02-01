package com.rays.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.common.UserContext;
import com.rays.dao.LaptopDAOInt;
import com.rays.dto.LaptopDTO;

@Service
@Transactional
public class LaptopServiceImpl extends BaseServiceImpl<LaptopDTO,LaptopDAOInt> implements LaptopServiceInt {

	@Autowired
	LaptopDAOInt LaptopDAO;

	
}
