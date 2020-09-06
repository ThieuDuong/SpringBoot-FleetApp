package com.fleet.thieuduong.fleetapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fleet.thieuduong.fleetapp.models.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {
//	@Query("SELECT count(i) FROM information_schema.columns i WHERE table_name = #{#entityName}")
//	@Query("SELECT count(i) FROM INFORMATION_SCHEMA.COLUMNS i")
	@Query("FROM INFORMATION_SCHEMA.COLUMNS")
	public Integer countCountryColumn();
}
