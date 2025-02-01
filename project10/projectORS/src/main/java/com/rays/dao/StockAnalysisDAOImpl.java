package com.rays.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.common.UserContext;
import com.rays.dto.PreloadDTO;
import com.rays.dto.StockAnalysisDTO;

@Repository
public class StockAnalysisDAOImpl extends BaseDAOImpl<StockAnalysisDTO> implements StockAnalysisDAOInt{
	
	@Autowired
	PreloadDAOInt preloadDao;

	@Override
	protected void populate(StockAnalysisDTO dto, UserContext userContext) {
		if (dto.getPreloadId() != null && dto.getPreloadId() > 0) {
			PreloadDTO preloadDto = preloadDao.findByPK(dto.getPreloadId(), userContext);
			dto.setPreloadName(preloadDto.getName());
			System.out.println(dto.getPreloadName() + "PriorityName-------");
		}

	}

	@Override
	protected List<Predicate> getWhereClause(StockAnalysisDTO dto, CriteriaBuilder builder,Root<StockAnalysisDTO> qRoot) {
		List<Predicate> whereCondition = new ArrayList<>();

		if (dto.getId() != null && dto.getId() > 0) {
			whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
		}

		if (!isEmptyString(dto.getSymbol())) {
			// Use 'like' operator for partial matching
			whereCondition.add(builder.like(qRoot.get("symbol"), dto.getSymbol() + "%"));
		}

		if (isNotNull(dto.getStartDate())) {
			// Assuming "dateOfPurchase" field is of type java.util.Date or java.sql.Date
			Date searchDate = dto.getStartDate();

			// Define start and end dates for the search day
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(searchDate);
			calendar.set(Calendar.HOUR_OF_DAY, 0); // Start of the day
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			Date startDate = calendar.getTime();

			calendar.set(Calendar.HOUR_OF_DAY, 23); // End of the day
			calendar.set(Calendar.MINUTE, 59);
			calendar.set(Calendar.SECOND, 59);
			Date endDate = calendar.getTime();

			// Create predicate for date range
			Predicate datePredicate = builder.between(qRoot.get("startDate"), startDate, endDate);
			whereCondition.add(datePredicate);
		}
		if (isNotNull(dto.getEndDate())) {
			// Assuming "dateOfPurchase" field is of type java.util.Date or java.sql.Date
			Date searchDate = dto.getEndDate();

			// Define start and end dates for the search day
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(searchDate);
			calendar.set(Calendar.HOUR_OF_DAY, 0); // Start of the day
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			Date startDate = calendar.getTime();

			calendar.set(Calendar.HOUR_OF_DAY, 23); // End of the day
			calendar.set(Calendar.MINUTE, 59);
			calendar.set(Calendar.SECOND, 59);
			Date endDate = calendar.getTime();

			// Create predicate for date range
			Predicate datePredicate = builder.between(qRoot.get("endDate"), startDate, endDate);
			whereCondition.add(datePredicate);
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
	public Class<StockAnalysisDTO> getDTOClass() {
		// TODO Auto-generated method stub
		return StockAnalysisDTO.class;
	}

}
