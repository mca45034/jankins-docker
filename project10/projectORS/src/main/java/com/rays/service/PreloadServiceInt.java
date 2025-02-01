package com.rays.service;

import com.rays.common.BaseServiceInt;
import com.rays.common.UserContext;
import com.rays.dto.PreloadDTO;

public interface PreloadServiceInt extends BaseServiceInt<PreloadDTO> {

	public PreloadDTO findByName(String name, UserContext userContext);
}
