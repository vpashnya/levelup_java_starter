package ru.levelup.lesson20.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ru.levelup.lesson20.dao.RegionDao;
import ru.levelup.lesson20.dbutils.DBHelper;
import ru.levelup.lesson20.entities.Region;

import java.util.List;

public class RegionDaoImpl implements RegionDao {
    @Override
    public List<Region> getAllRegion() {
        try (Session session = DBHelper.getSesion();) {
            session.beginTransaction();
            List<Region> result = session.createQuery("from Region").list();
            session.getTransaction().commit();
            return result;
        }

    }

    @Override
    public void saveRegion(Region region) {
        try (Session session = DBHelper.getSesion();) {
            session.beginTransaction();
            session.saveOrUpdate(region);
            session.getTransaction().commit();
        }
    }

    @Override
    public Region getRegion(int id) {
        try (Session session = DBHelper.getSesion();) {
            session.beginTransaction();
            Region region = session.get(Region.class, id);
            session.getTransaction().commit();
            return region;
        }
    }

    @Override
    public Region getRegionByCode(String code) {
        try (Session session = DBHelper.getSesion();) {
            session.beginTransaction();
            Query query = session.createQuery("from Region where code = ?1");
            query.setParameter(1, code);
            List<Region> result = query.list();
            session.getTransaction().commit();
            return result.isEmpty() ? null : result.get(0);
        }
    }

    @Override
    public void deleteRegion(int id) {
        try (Session session = DBHelper.getSesion();) {
            session.beginTransaction();
            session.delete(session.get(Region.class, id));
            session.getTransaction().commit();
        }
    }
}
