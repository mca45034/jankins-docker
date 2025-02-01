package com.rays.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.CarDAOInt;
import com.rays.dto.CarDTO;

@Service
@Transactional
public class CarServiceImpl extends BaseServiceImpl<CarDTO, CarDAOInt> implements CarServiceInt {
	@Autowired
	CarDAOInt carDAO;

}
