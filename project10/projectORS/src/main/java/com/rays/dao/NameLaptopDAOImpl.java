package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.NameLaptopDTO;
@Repository
public class NameLaptopDAOImpl extends BaseDAOImpl<NameLaptopDTO> implements NameLaptopDAOInt{

	@Override
	protected List<Predicate> getWhereClause(NameLaptopDTO dto, CriteriaBuilder builder, Root<NameLaptopDTO> qRoot) {
		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isEmptyString(dto.getName())) {

			whereCondition.add(builder.like(qRoot.get("name"), dto.getName() + "%"));
		}
		if (!isEmptyString(dto.getlaptopName())) {

			whereCondition.add(builder.like(qRoot.get("laptopName"), dto.getlaptopName() + "%"));
		}

		if (!isEmptyString(dto.getDescription())) {

			whereCondition.add(builder.like(qRoot.get("description"), dto.getDescription() + "%"));
		}

		if (!isZeroNumber(dto.getId())) {

			whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
		}

		return whereCondition;
	}
	

	@Override
	public Class<NameLaptopDTO> getDTOClass() {
		return NameLaptopDTO.class;
	}

}
