package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.common.UserContext;
import com.rays.dao.StateDAOInt;
import com.rays.dto.StateDTO;

@Service
@Transactional
public class StateServiceImpl extends BaseServiceImpl<StateDTO, StateDAOInt> implements StateServiceInt {

	@Transactional(readOnly = true)
	public StateDTO findByName(String name, UserContext userContext) {
		return baseDao.findByUniqueKey("name", name, userContext);
	}

}
