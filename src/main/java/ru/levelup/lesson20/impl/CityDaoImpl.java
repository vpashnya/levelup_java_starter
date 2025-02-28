package ru.levelup.lesson20.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ru.levelup.lesson20.dao.CityDao;
import ru.levelup.lesson20.dbutils.DBHelper;
import ru.levelup.lesson20.entities.City;
import ru.levelup.lesson20.entities.Region;

import java.util.List;

public class CityDaoImpl implements CityDao {
    @Override
    public List<City> getAllCities() {
        try (Session session = DBHelper.getSesion();) {
            session.beginTransaction();
            List<City> result = session.createQuery("from City").list();
            session.getTransaction().commit();
            return result;
        }
    }

    @Override
    public void saveCity(City city) {
        try (Session session = DBHelper.getSesion();) {
            session.beginTransaction();
            session.saveOrUpdate(city);
            session.getTransaction().commit();
        }
    }

    @Override
    public City getCity(int id) {
        try (Session session = DBHelper.getSesion();) {
            session.beginTransaction();
            City city = session.get(City.class, id);
            session.getTransaction().commit();
            return city;
        }
    }

    @Override
    public City getCityByCode(String code) {
        try (Session session = DBHelper.getSesion();) {
            session.beginTransaction();
            Query query = session.createQuery("from City where code = ?1");
            query.setParameter(1, code);
            List<City> result = query.list();
            session.getTransaction().commit();
            return result.isEmpty() ? null : result.get(0);
        }
    }

    @Override
    public void deleteCity(int id) {
        try (Session session = DBHelper.getSesion();) {
            session.beginTransaction();
            session.delete(session.get(City.class, id));
            session.getTransaction().commit();
        }
    }
}
