package com.rays.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.HospitalDAOInt;
import com.rays.dto.HospitalDTO;

@Service
@Transactional
public class HospitalServiceImpl extends BaseServiceImpl<HospitalDTO, HospitalDAOInt> implements HospitalServiceInt {
	@Autowired
	HospitalDAOInt hospitalDAO;
}
