package ru.levelup.lesson20;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.levelup.lesson20.dbutils.DBHelper;
import ru.levelup.lesson20.entities.City;


import java.util.List;

public class TestCrashTransaction {
    public static void main(String[] args) {

        try (Session session = DBHelper.getSesion()) {
            session.beginTransaction();
            System.out.println("Начало транзакции");
            try {
                System.out.println("Попытка вставки записи которая взорвется на constraint");
                session.saveOrUpdate(new City(null, "55", "", "", 55, null));
            } catch (Exception e) {
               // System.out.println("Отловили и заглушили исключение");
                System.out.println("Отловили  исключение и сделали роллбэк");
                session.getTransaction().rollback();
            }

            System.out.println("Выполнение sql-команды");
            List<City> result = session.createQuery("from City").list();
            result.stream().forEach(System.out::println);

            System.out.println("Конец выполнения ");

        }
    }
}