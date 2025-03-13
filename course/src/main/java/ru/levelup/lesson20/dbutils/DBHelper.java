package ru.levelup.lesson20.dbutils;

import lombok.experimental.UtilityClass;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

@UtilityClass
public class DBHelper {
    //private static final Configuration CONFIGURATION = new Configuration().configure("hibernate.cfg.xml");
    private static final Configuration CONFIGURATION = new Configuration().configure("hibernate-ora.cfg.xml");

    public Session getSesion(){
        return CONFIGURATION.buildSessionFactory().openSession();
    }
}
