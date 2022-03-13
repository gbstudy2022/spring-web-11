package com.geekbrains.spring.web.core.repositories;

import com.geekbrains.spring.web.core.dictionaries.City;
import com.geekbrains.spring.web.core.dictionaries.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitiesRepository extends JpaRepository<City, Long> {
    List<City> findAllByCountry(Country country);
}
