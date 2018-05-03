package by.psu.dao;

import by.psu.model.Country;

import java.util.List;

public interface CountryDao extends CrudDao<Country> {

    List<Country> getAllCountries();

    Country getByName(String name);

}
