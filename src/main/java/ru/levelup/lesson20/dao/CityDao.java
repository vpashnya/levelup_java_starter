package ru.levelup.lesson20.dao;

import ru.levelup.lesson20.entities.City;

import java.util.List;

public interface CityDao {
    public List<City> getAllCities();

    public void saveCity(City city);

    public City getCity(int id);

    public City getCityByCode(String code);

    public void deleteCity(int id);
}
