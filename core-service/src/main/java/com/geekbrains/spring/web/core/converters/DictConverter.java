package com.geekbrains.spring.web.core.converters;

import com.geekbrains.spring.web.api.core.CityDto;
import com.geekbrains.spring.web.api.core.CountryDto;
import com.geekbrains.spring.web.core.dictionaries.City;
import com.geekbrains.spring.web.core.dictionaries.Country;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DictConverter {
    public CountryDto countryEntityToDto(Country country) {
        return new CountryDto(country.getId(), country.getName(), country.getCode());
    }

    public CityDto cityEntityToDto(City city) {
        return new CityDto(city.getId(), city.getName());
    }
}
