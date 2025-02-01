package com.rays.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.MovieDAOInt;
import com.rays.dto.MovieDTO;

@Service
@Transactional
public class MovieServiceImpl extends BaseServiceImpl<MovieDTO, MovieDAOInt> implements MovieServiceInt {
	@Autowired
	MovieDAOInt movieDAO;
}
