package com.fleet.thieuduong.fleetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fleet.thieuduong.fleetapp.models.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer>{

}
