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
import com.rays.dto.CustomerDTO;
import com.rays.dto.GenderDTO;
import com.rays.dto.OrderTypeDTO;
import com.rays.dto.StockPurchaseDTO;

@Repository
public class StockPurchaseDAOImp extends BaseDAOImpl<StockPurchaseDTO> implements StockPurchaseDAOInt {
	
	@Override
	public Class<StockPurchaseDTO> getDTOClass() {
		return StockPurchaseDTO.class;
	}

	@Autowired
	OrderTypeDAOInt shoppingcartDao;

	@Override
	protected void populate(StockPurchaseDTO dto, UserContext userContext) {
		if (dto.getOrdertypeId() != null && dto.getOrdertypeId() > 0) {
			OrderTypeDTO categoryDto = shoppingcartDao.findByPK(dto.getOrdertypeId(), userContext);
			dto.setOrdertypeName(categoryDto.getName());
			System.out.println(dto.getOrdertypeName() + "PriorityName-------");
		}

	}


	
	
	
	
	
	
	

	@Override
	protected List<Predicate> getWhereClause(StockPurchaseDTO dto, CriteriaBuilder builder, Root<StockPurchaseDTO> qRoot) {
		List<Predicate> whereCondition = new ArrayList<>();

		if (!isZeroNumber(dto.getPurcahsePrice())) {

			whereCondition.add(builder.equal(qRoot.get("purcahsePrice"), dto.getPurcahsePrice()));
		}
		if (isNotNull(dto.getPurchaseDate())) {

			whereCondition.add(builder.equal(qRoot.get("purchaseDate"), dto.getPurchaseDate()));
		}
		if (!isEmptyString(dto.getQuantity())) {

			whereCondition.add(builder.like(qRoot.get("quantity"), dto.getQuantity() + "%"));
		}
		if (!isEmptyString(dto.getOrdertypeName())) {

			whereCondition.add(builder.like(qRoot.get("ordertypeName"), dto.getOrdertypeName() + "%"));
		}
		if (!isZeroNumber(dto.getOrdertypeId())) {

			whereCondition.add(builder.equal(qRoot.get("ordertypeId"), dto.getOrdertypeId()));
		}

		return whereCondition;
	}

	
	
}
