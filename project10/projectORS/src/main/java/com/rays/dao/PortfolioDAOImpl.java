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
import com.rays.dto.PortfolioDTO;
import com.rays.dto.PreloadDTO;

@Repository
public class PortfolioDAOImpl extends BaseDAOImpl<PortfolioDTO> implements PortfolioDAOInt {

	@Autowired
	PreloadDAOInt preloadDao;

	@Override
	protected void populate(PortfolioDTO dto, UserContext userContext) {
		if (dto.getPreloadId() != null && dto.getPreloadId() > 0) {
			PreloadDTO preloadDto = preloadDao.findByPK(dto.getPreloadId(), userContext);
			dto.setPreloadName(preloadDto.getName());
			System.out.println(dto.getPreloadName() + "PriorityName-------");
		}

	}

	@Override
	protected List<Predicate> getWhereClause(PortfolioDTO dto, CriteriaBuilder builder, Root<PortfolioDTO> qRoot) {
		List<Predicate> whereCondition = new ArrayList<>();

		if (dto.getId() != null && dto.getId() > 0) {
			whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
		}

		if (!isEmptyString(dto.getName())) {
			// Use 'like' operator for partial matching
			whereCondition.add(builder.like(qRoot.get("name"), dto.getName() + "%"));
		}

		if (!isZeroNumber(dto.getPaymentTerm())) {
			whereCondition.add(builder.equal(qRoot.get("paymentTerm"), dto.getPaymentTerm()));
		}

		if (!isEmptyString(dto.getStrategy())) {
			// Use 'like' operator for partial matching
			whereCondition.add(builder.like(qRoot.get("strategy"), dto.getStrategy() + "%"));
		}

		if (!isZeroNumber(dto.getPreloadId())) {
			whereCondition.add(builder.equal(qRoot.get("preloadId"), dto.getPreloadId()));
		}

		if (!isEmptyString(dto.getPreloadName())) {
			whereCondition.add(builder.like(qRoot.get("preloadName"), dto.getPreloadName() + "%"));
		}

		return whereCondition;
	}

	@Override
	public Class<PortfolioDTO> getDTOClass() {
		return PortfolioDTO.class;
	}

}
