package com.geekbrains.spring.web.api.core;

public class OrderDetailsDto {
    private String address;
    private CityDto city;
    private CountryDto country;
    private Integer postalCode;
    private String phone;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public CityDto getCity() {
        return city;
    }

    public OrderDetailsDto(String address, CityDto city, CountryDto country, Integer postalCode, String phone) {
        this.address = address;
        this.city = city;
        this.country = country;
        this.postalCode = postalCode;
        this.phone = phone;
    }

    public void setCity(CityDto city) {
        this.city = city;
    }

    public CountryDto getCountry() {
        return country;
    }

    public void setCountry(CountryDto country) {
        this.country = country;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public OrderDetailsDto() {
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

}
