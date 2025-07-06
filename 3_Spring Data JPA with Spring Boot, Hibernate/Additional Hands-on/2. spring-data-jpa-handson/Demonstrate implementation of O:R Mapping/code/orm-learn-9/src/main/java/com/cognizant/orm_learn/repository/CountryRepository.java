package com.cognizant.orm_learn.repository;

import com.cognizant.orm_learn.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {


    List<Country> findByNameContainingIgnoreCase(String keyword);


    List<Country> findByNameContainingIgnoreCaseOrderByNameAsc(String keyword);


    List<Country> findByNameStartingWith(String prefix);


    List<Country> findAllByOrderByNameAsc();

    List<Country> findTop3ByOrderByNameAsc();
}
