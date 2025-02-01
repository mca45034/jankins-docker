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
import com.rays.dto.ATMsDTO;
import com.rays.dto.LocationDTO;

@Repository
public class ATMsDAOImpl extends BaseDAOImpl<ATMsDTO> implements ATMsDAOInt {

	@Autowired

	LocationDAOInt locationDao;

	@Override
	protected void populate(ATMsDTO dto, UserContext userContext) {
		if (dto.getLocationId() != null && dto.getLocationId() > 0) {
			LocationDTO locationDto = locationDao.findByPK(dto.getLocationId(), userContext);
			dto.setLocationName(locationDto.getName());
		}

	}

	@Override
	protected List<Predicate> getWhereClause(ATMsDTO dto, CriteriaBuilder builder, Root<ATMsDTO> qRoot) {
		List<Predicate> whereCondition = new ArrayList<>();
		

		if (dto.getId() != null && dto.getId() > 0) {
			whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
		}

		if (!isZeroNumber(dto.getCashAvailable())) {
			whereCondition.add(builder.equal(qRoot.get("cashAvailable"), dto.getCashAvailable()));
		}

		if (isNotNull(dto.getLastRestockedDate())) {

			Date searchDate = dto.getLastRestockedDate();

			Calendar calendar = Calendar.getInstance();
			calendar.setTime(searchDate);
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			Date startDate = calendar.getTime();

			calendar.set(Calendar.HOUR_OF_DAY, 23);
			calendar.set(Calendar.MINUTE, 59);
			calendar.set(Calendar.SECOND, 59);
			Date endDate = calendar.getTime();

			Predicate datePredicate = builder.between(qRoot.get("lastRestockedDate"), startDate, endDate);
			whereCondition.add(datePredicate);
		}

		if (!isEmptyString(dto.getReMark())) {
			whereCondition.add(builder.like(qRoot.get("reMark"), dto.getReMark() + "%"));
		}

		if (!isZeroNumber(dto.getLocationId())) {
			whereCondition.add(builder.equal(qRoot.get("locationId"), dto.getLocationId()));
		}
		
		

		if (!isEmptyString(dto.getLocationName())) {
			whereCondition.add(builder.like(qRoot.get("locationName"), dto.getLocationName() + "%"));
		}

		return whereCondition;
	}

	@Override
	public Class<ATMsDTO> getDTOClass() {
		return ATMsDTO.class;
	}

}