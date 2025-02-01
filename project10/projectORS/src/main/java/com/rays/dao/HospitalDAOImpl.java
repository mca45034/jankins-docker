package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.HospitalDTO;
@Repository
public class HospitalDAOImpl extends BaseDAOImpl<HospitalDTO> implements HospitalDAOInt{
	
//	@Autowired
//	CityDAOInt cityeDao;
//	
	//@Override
//	protected void populate(HospitalDTO dto, UserContext userContext) {
//		if (dto.getCityId() != null && dto.getCityId() > 0) {
//			//CityDTO citydto = cityeDao.findByPK(dto.getCityId(), userContext);
//			dto.setCityName(citydto.getName());
//			System.out.println(dto.getCityName() + "cityName-------");
//		}
//
//	}

	@Override
	protected List<Predicate> getWhereClause(HospitalDTO dto, CriteriaBuilder builder, Root<HospitalDTO> qRoot) {
		// Create where conditions
				List<Predicate> whereCondition = new ArrayList<>();

				if (dto.getId() != null && dto.getId() > 0) {
					whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
				}

				if (!isEmptyString(dto.getNames())) {
					// Use 'like' operator for partial matching
					whereCondition.add(builder.like(qRoot.get("names"), dto.getNames() + "%"));
				}
				if (!isEmptyString(dto.getDescription())) {

					whereCondition.add(builder.like(qRoot.get("description"), dto.getDescription() + "%"));
				}

				if (!isEmptyString(dto.getHospitalName())) {
					whereCondition.add(builder.equal(qRoot.get("hospitalName"), dto.getHospitalName()));
				}
				if (!isZeroNumber(dto.getCityId())) {
					whereCondition.add(builder.equal(qRoot.get("cityId"), dto.getCityId()));
				}

				if (!isEmptyString(dto.getCityName())) {
					whereCondition.add(builder.like(qRoot.get("cityName"), dto.getCityName() + "%"));
				}

				return whereCondition;
	}

	@Override
	public Class<HospitalDTO> getDTOClass() {
		return HospitalDTO.class;
	}

}
