package by.psu.service.impl;

import by.psu.dao.CountryDao;
import by.psu.model.Country;
import by.psu.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryDao countryDao;

    @Override
    @Transactional
    public void addCountry(Country country) {
        countryDao.add(country);
    }

    @Override
    @Transactional
    public Country getCountryById(int id) {
        return countryDao.getById(id);
    }

    @Override
    @Transactional
    public void updateCountry(Country country) {
        countryDao.update(country);
    }

    @Override
    @Transactional
    public void removeCountry(int id) {
        countryDao.remove(id);
    }

    @Override
    @Transactional
    public List<Country> getAllCountries() {
        return countryDao.getAllCountries();
    }

    @Override
    @Transactional
    public Country getByName(String name) {
        return countryDao.getByName(name);
    }

}
