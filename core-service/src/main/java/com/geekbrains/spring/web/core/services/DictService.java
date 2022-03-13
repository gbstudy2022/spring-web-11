package com.geekbrains.spring.web.core.services;

import com.geekbrains.spring.web.api.exceptions.ResourceNotFoundException;
import com.geekbrains.spring.web.core.dictionaries.City;
import com.geekbrains.spring.web.core.dictionaries.Country;
import com.geekbrains.spring.web.core.repositories.CitiesRepository;
import com.geekbrains.spring.web.core.repositories.CountriesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DictService {
    private final CountriesRepository countriesRepository;
    private final CitiesRepository citiesRepository;

    public List<Country> getCountries() {
        return countriesRepository.findAll();
    }

    public List<City> getCitiesForCountry(Long id) {
        countriesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Country not found"));
        return citiesRepository.findAllByCountry(countriesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Country not found")));
    }

    public City getCityById(Long id) {
        return citiesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("City not found"));
    }
}
