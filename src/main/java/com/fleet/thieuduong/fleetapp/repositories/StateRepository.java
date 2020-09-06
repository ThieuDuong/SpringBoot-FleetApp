package com.fleet.thieuduong.fleetapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fleet.thieuduong.fleetapp.models.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer>{
	@Query("SELECT s.name FROM State s WHERE s.countryid = :countryid")
	public List<String> findStateNameByCountryId(@Param("countryid") Integer State );
}
