package com.cognizant.orm_learn.service;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.repository.CountryRepository;
import com.cognizant.orm_learn.service.exception.CountryNotFoundException;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Transactional
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Transactional
    public Country findCountryByCode(String countryCode) throws CountryNotFoundException {
        Optional<Country> result = countryRepository.findById(countryCode);

        if (!result.isPresent()) {
            throw new CountryNotFoundException("Country not found with code: " + countryCode);
        }

        return result.get();
    }
    @Transactional
    public void updateCountryName(String code, String newName) throws CountryNotFoundException {
        Optional<Country> optional = countryRepository.findById(code);

        if (!optional.isPresent()) {
            throw new CountryNotFoundException("Country not found with code: " + code);
        }

        Country country = optional.get();
        country.setName(newName);
        countryRepository.save(country); // Save updated country
    }

    public List<Country> getCountriesByNameContaining(String keyword) {
        return countryRepository.findByNameContainingIgnoreCase(keyword);
    }

    public List<Country> getCountriesByNameContainingSorted(String keyword) {
        return countryRepository.findByNameContainingIgnoreCaseOrderByNameAsc(keyword);
    }

    public List<Country> getCountriesStartingWith(String prefix) {
        return countryRepository.findByNameStartingWith(prefix);
    }

}
