package com.cognizant.orm_learn.repository;

import com.cognizant.orm_learn.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

    // 1️⃣ Search countries containing a keyword (case-insensitive)
    List<Country> findByNameContainingIgnoreCase(String keyword);

    // 2️⃣ Search and return sorted by name
    List<Country> findByNameContainingIgnoreCaseOrderByNameAsc(String keyword);

    // 3️⃣ Filter countries starting with a specific prefix
    List<Country> findByNameStartingWith(String prefix);

    // 4️⃣ Return all countries sorted by name
    List<Country> findAllByOrderByNameAsc();

    // 5️⃣ Return top 3 countries sorted by name
    List<Country> findTop3ByOrderByNameAsc();
}
