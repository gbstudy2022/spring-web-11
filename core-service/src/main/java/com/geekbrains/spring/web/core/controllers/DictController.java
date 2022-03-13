package com.geekbrains.spring.web.core.controllers;

import com.geekbrains.spring.web.api.core.CityDto;
import com.geekbrains.spring.web.api.core.CountryDto;
import com.geekbrains.spring.web.api.dto.StringResponse;
import com.geekbrains.spring.web.core.converters.DictConverter;
import com.geekbrains.spring.web.core.services.DictService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/dict")
@RequiredArgsConstructor
public class DictController {

    private final DictService dictService;
    private final DictConverter converter;

    @GetMapping("/countries")
    public List<CountryDto> getCountries() {
        return dictService.getCountries().stream()
                .map(converter::countryEntityToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/countries/{id}/cities")
    public List<CityDto> getCitiesForCountry(@PathVariable Long id) {
        return dictService.getCitiesForCountry(id).stream()
                .map(converter::cityEntityToDto)
                .collect(Collectors.toList());
    }
}
