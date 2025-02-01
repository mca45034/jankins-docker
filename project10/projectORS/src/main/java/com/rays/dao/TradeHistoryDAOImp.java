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
import com.rays.dto.TradeHistoryDTO;
import com.rays.dto.TransactionTypeDTO;

@Repository
public class TradeHistoryDAOImp extends BaseDAOImpl<TradeHistoryDTO> implements TradeHistoryDAOInt {
	
	@Override
	public Class<TradeHistoryDTO> getDTOClass() {
		return TradeHistoryDTO.class;
	}

	@Autowired
	TransactionTypeDAOInt transactionTypeDAOInt;

	@Override
	protected void populate(TradeHistoryDTO dto, UserContext userContext) {
		if (dto.getTransactiontypeId() != null && dto.getTransactiontypeId() > 0) {
			TransactionTypeDTO categoryDto = transactionTypeDAOInt.findByPK(dto.getTransactiontypeId(), userContext);
			dto.setTransactiontypeName(categoryDto.getName());
		}

	}

	

	@Override
	protected List<Predicate> getWhereClause(TradeHistoryDTO dto, CriteriaBuilder builder, Root<TradeHistoryDTO> qRoot) {
		List<Predicate> whereCondition = new ArrayList<>();

		if (!isEmptyString(dto.getUserId())) {

			whereCondition.add(builder.like(qRoot.get("userId"), dto.getUserId() + "%"));
		}
		if (isNotNull(dto.getStartDate())) {

			whereCondition.add(builder.equal(qRoot.get("startDate"), dto.getStartDate()));
		}
		if (isNotNull(dto.getEndDate())) {

			whereCondition.add(builder.equal(qRoot.get("endDate"), dto.getEndDate()));
		}
		if (!isEmptyString(dto.getTransactiontypeName())) {

			whereCondition.add(builder.like(qRoot.get("transactiontypeName"), dto.getTransactiontypeName() + "%"));
		}
		if (!isZeroNumber(dto.getTransactiontypeId())) {

			whereCondition.add(builder.equal(qRoot.get("transactiontypeId"), dto.getTransactiontypeId()));
		}


		return whereCondition;
	}

	
	
}
