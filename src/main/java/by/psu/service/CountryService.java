package by.psu.service;

import by.psu.model.Country;

import java.util.List;

public interface CountryService {

    void addCountry(Country country);

    Country getCountryById(int id);

    void updateCountry(Country country);

    void removeCountry(int id);

    List<Country> getAllCountries();

    Country getByName(String name);

}
