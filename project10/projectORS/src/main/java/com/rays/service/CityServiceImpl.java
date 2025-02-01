package com.rays.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.CityDAOInt;
import com.rays.dto.CityDTO;

@Service
@Transactional
public class CityServiceImpl extends BaseServiceImpl<CityDTO, CityDAOInt> implements CityServiceInt {
	@Autowired
	CityDAOInt cityDAO;

}

