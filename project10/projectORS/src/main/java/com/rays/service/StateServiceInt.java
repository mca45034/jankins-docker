package com.rays.service;

import com.rays.common.BaseServiceInt;
import com.rays.common.UserContext;
import com.rays.dto.StateDTO;

public interface StateServiceInt extends BaseServiceInt<StateDTO> {

	public StateDTO findByName(String name, UserContext userContext);

}
