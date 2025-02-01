package com.rays.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.common.UserContext;
import com.rays.dao.NameLaptopDAOInt;
import com.rays.dto.NameLaptopDTO;
@Service
@Transactional
public class NameLaptopServiceImpl extends BaseServiceImpl<NameLaptopDTO, NameLaptopDAOInt> implements NameLaptopServiceInt{

	private static Logger log = LoggerFactory.getLogger(NameLaptopServiceImpl.class);

	@Transactional(readOnly = true)
	public NameLaptopDTO findByName(String name, UserContext userContext) {
		return baseDao.findByUniqueKey("name", name, userContext);
	}

}
