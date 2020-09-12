package com.fleet.thieuduong.fleetapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fleet.thieuduong.fleetapp.models.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {
	
	@Query(value = "select column_name from information_schema.columns where table_name = '#{#entityName}' order by ordinal_position", nativeQuery=true)
	public List<String> getColumnName();
	
}
