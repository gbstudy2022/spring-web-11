package com.geekbrains.spring.web.core.repositories;

import com.geekbrains.spring.web.core.dictionaries.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountriesRepository extends JpaRepository<Country, Long> {
}
