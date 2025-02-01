package com.rays.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.common.UserContext;
import com.rays.dto.CategoryDTO;
import com.rays.dto.LaptopDTO;
import com.rays.dto.SupplierDTO;
@Repository
public class LaptopDAOImpl extends BaseDAOImpl<LaptopDTO> implements LaptopDAOInt{
	@Autowired
	CategoryDAOInt categoryDao;

	@Override
	protected void populate(LaptopDTO dto, UserContext userContext) {
//		if (dto.getCategoryId() != null && dto.getCategoryId() > 0) {
//			CategoryDTO categoryDto = categoryDao.findByPK(dto.getCategoryId(), userContext);
//			dto.setCategoryName(categoryDto.getName());
//			System.out.println(dto.getCategoryName() + "PriorityName-------");
//		}

	}

	@Override
	protected List<Predicate> getWhereClause(LaptopDTO dto, CriteriaBuilder builder, Root<LaptopDTO> qRoot) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<LaptopDTO> getDTOClass() {
		return LaptopDTO.class;
	}

}
