package com.rays.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.BikeDAOInt;
import com.rays.dto.BikeDTO;

@Service
@Transactional
public class BikeServiceImpl extends BaseServiceImpl<BikeDTO, BikeDAOInt> implements BikeServiceInt {

	@Autowired
	BikeDAOInt bikeDAO;
}
