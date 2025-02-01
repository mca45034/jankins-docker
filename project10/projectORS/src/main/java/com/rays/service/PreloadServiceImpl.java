package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.common.UserContext;
import com.rays.dao.PreloadDAOInt;
import com.rays.dto.PreloadDTO;

@Service
@Transactional
public class PreloadServiceImpl extends BaseServiceImpl<PreloadDTO, PreloadDAOInt> implements PreloadServiceInt {

	@Transactional(readOnly = true)
	public PreloadDTO findByName(String name, UserContext userContext) {

		return baseDao.findByUniqueKey("name", name, userContext);
	}

}
