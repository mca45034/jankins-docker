package com.rays.service;

import com.rays.common.BaseServiceInt;
import com.rays.common.UserContext;
import com.rays.dto.ExperienceDTO;

public interface ExperienceServiceInt extends BaseServiceInt<ExperienceDTO> {

	
	public ExperienceDTO findByName(String name, UserContext userContext);

}
