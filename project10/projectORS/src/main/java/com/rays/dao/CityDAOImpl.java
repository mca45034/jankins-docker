package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.common.UserContext;

import com.rays.dto.CityDTO;
import com.rays.dto.StateDTO;

@Repository
public class CityDAOImpl extends BaseDAOImpl<CityDTO> implements CityDAOInt {

	@Autowired
	StateDAOInt stateDao;

	@Override
	protected void populate(CityDTO dto, UserContext userContext) {
		if (dto.getStateId() != null && dto.getStateId() > 0) {
			StateDTO stateDto = stateDao.findByPK(dto.getStateId(), userContext);
			dto.setStateName(stateDto.getName());
			System.out.println(dto.getStateName() + "PriorityName-------");
		}

	}

	@Override
	protected List<Predicate> getWhereClause(CityDTO dto, CriteriaBuilder builder, Root<CityDTO> qRoot) {
		// Create where conditions
		List<Predicate> whereCondition = new ArrayList<>();

		if (dto.getId() != null && dto.getId() > 0) {
			whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
		}

		if (!isEmptyString(dto.getName())) {
			// Use 'like' operator for partial matching
			whereCondition.add(builder.like(qRoot.get("name"), dto.getName() + "%"));
		}
		if (!isEmptyString(dto.getDescription())) {

			whereCondition.add(builder.like(qRoot.get("description"), dto.getDescription() + "%"));
		}

		if (!isEmptyString(dto.getCityName())) {
			whereCondition.add(builder.equal(qRoot.get("cityName"), dto.getCityName()));
		}
		if (!isZeroNumber(dto.getStateId())) {
			whereCondition.add(builder.equal(qRoot.get("stateId"), dto.getStateId()));
		}

		if (!isEmptyString(dto.getStateName())) {
			whereCondition.add(builder.like(qRoot.get("stateName"), dto.getStateName() + "%"));
		}

		return whereCondition;
	}

	@Override
	public Class<CityDTO> getDTOClass() {
		return CityDTO.class;
	}

}
