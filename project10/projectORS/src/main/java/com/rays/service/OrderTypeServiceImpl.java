package com.rays.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.common.UserContext;
import com.rays.dao.OrderTypeDAOInt;
import com.rays.dto.OrderTypeDTO;

@Service
@Transactional
public class  OrderTypeServiceImpl extends BaseServiceImpl<OrderTypeDTO, OrderTypeDAOInt> implements OrderTypeServiceInt {


	@Transactional(readOnly = true)
	public OrderTypeDTO findByName(String name, UserContext userContext) {
		return baseDao.findByUniqueKey("name", name, userContext);
	}

}
