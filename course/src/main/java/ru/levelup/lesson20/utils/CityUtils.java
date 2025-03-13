package ru.levelup.lesson20.utils;

import lombok.experimental.UtilityClass;
import ru.levelup.lesson20.dao.CityDao;
import ru.levelup.lesson20.dao.RegionDao;
import ru.levelup.lesson20.entities.City;
import ru.levelup.lesson20.entities.Region;
import ru.levelup.lesson20.impl.CityDaoImpl;
import ru.levelup.lesson20.impl.RegionDaoImpl;

@UtilityClass
public class CityUtils {
    private static CityDao cityDao = new CityDaoImpl();
    private static RegionDao regionDao = new RegionDaoImpl();

    public static void deleteCitysWithEmptyName() {
        cityDao.getAllCities().stream().filter(it -> it.getNameRus().trim().equals("")).forEach(it -> {
            System.out.println("Удалил " + it);
            cityDao.deleteCity(it.getId());
        });
    }

    public static void saveCity(String... cityInfo) {
        try {
            Region region = regionDao.getRegionByCode(cityInfo[4]);
            if (region == null) {
                region = new Region(null, cityInfo[4]);
                regionDao.saveRegion(region);
            }

            City city = cityDao.getCityByCode(cityInfo[0]);
            if (city == null) {
                city = new City();
            }

            city.setCode(cityInfo[0]);
            city.setNameRus(cityInfo[1]);
            city.setNameEng(cityInfo[2]);
            city.setPopulation(Integer.parseInt(cityInfo[3].trim()));
            city.setRegion(region);

            cityDao.saveCity(city);
        } catch (Exception e) {
            System.out.println("!!! Ошибка при сохранении инфомации о городе : " + e.getMessage());
        }

    }

    public static void printAllCities() {
        cityDao.getAllCities().stream().forEach(System.out::println);
    }
}
