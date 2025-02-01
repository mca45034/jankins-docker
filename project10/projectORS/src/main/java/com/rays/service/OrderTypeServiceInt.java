package com.rays.service;

import com.rays.common.BaseServiceInt;
import com.rays.common.UserContext;
import com.rays.dto.OrderTypeDTO;


public interface OrderTypeServiceInt extends BaseServiceInt<OrderTypeDTO> {

	
	public OrderTypeDTO findByName(String name, UserContext userContext);

}
