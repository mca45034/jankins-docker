package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.PreloadDTO;

@Repository
public class PreloadDAOImpl extends BaseDAOImpl<PreloadDTO> implements PreloadDAOInt {

	@Override
	protected List<Predicate> getWhereClause(PreloadDTO dto, CriteriaBuilder builder, Root<PreloadDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isEmptyString(dto.getName())) {

			whereCondition.add(builder.like(qRoot.get("name"), dto.getName() + "%"));
		}
		if (!isEmptyString(dto.getPreloadName())) {

			whereCondition.add(builder.like(qRoot.get("preloadName"), dto.getPreloadName() + "%"));
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
	public Class<PreloadDTO> getDTOClass() {
		return PreloadDTO.class;
	}

}
