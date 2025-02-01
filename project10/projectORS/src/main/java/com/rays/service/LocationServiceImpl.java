package com.rays.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.common.UserContext;
import com.rays.dao.LocationDAOInt;
import com.rays.dto.LocationDTO;

@Service
@Transactional
public class LocationServiceImpl extends BaseServiceImpl<LocationDTO, LocationDAOInt> implements LocationServiceInt {

	

}
