package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.GenderDTO;
import com.rays.dto.OrderTypeDTO;
/**
Rahul Gurjar
 *
 */
@Repository
public class OrderTypeDAOImpl extends BaseDAOImpl<OrderTypeDTO> implements OrderTypeDAOInt {

	@Override
	public Class<OrderTypeDTO> getDTOClass() {
		return OrderTypeDTO.class;
	}
	
	
	@Override
	protected List<Predicate> getWhereClause(OrderTypeDTO dto, CriteriaBuilder builder, Root<OrderTypeDTO> qRoot) {
		// Create where conditions
		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isEmptyString(dto.getName())) {

			whereCondition.add(builder.like(qRoot.get("name"), dto.getName() + "%"));
		}
		if (!isEmptyString(dto.getOrdertypeName())) {

			whereCondition.add(builder.like(qRoot.get("ordertypeName"), dto.getOrdertypeName() + "%"));
		}

		if (!isEmptyString(dto.getDescription())) {

			whereCondition.add(builder.like(qRoot.get("description"), dto.getDescription() + "%"));
		}

		if (!isZeroNumber(dto.getId())) {

			whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
		}


		return whereCondition;
	}

}
