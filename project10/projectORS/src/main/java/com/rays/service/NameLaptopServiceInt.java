package com.rays.service;

import com.rays.common.BaseServiceInt;
import com.rays.common.UserContext;
import com.rays.dto.NameLaptopDTO;

public interface NameLaptopServiceInt extends BaseServiceInt<NameLaptopDTO> {
	public NameLaptopDTO findByName(String name, UserContext userContext);

}
