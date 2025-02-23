package ru.levelup.lesson19.dbutils;

import lombok.SneakyThrows;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;

public class DictionaryDBHelper implements Closeable {
    private Connection connection;

    @SneakyThrows
    public DictionaryDBHelper() {
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres_db?user=root&password=root");
        connection.setAutoCommit(false);
    }

    public void save2DBCityInfo(String[] cityInfo) throws SQLException {
        Savepoint savepoint = null;
        try {
            savepoint = connection.setSavepoint("saveCity");
            save2DBCityInfoTransaction(cityInfo);
            connection.commit();
        } catch (Exception e) {
            connection.rollback(savepoint);
            System.out.println("Ошибка заполнения справочника : " + e.getMessage());
        }
    }

    private void save2DBCityInfoTransaction(String[] cityInfo) throws SQLException {
        cityInfo[4] = Integer.toString(getRegionId(cityInfo[4]));

        try (PreparedStatement selectStatement = connection.prepareStatement("select id from city where code = ?");) {

            selectStatement.setString(1, cityInfo[0]);

            try (ResultSet resultSet = selectStatement.executeQuery();) {

                if (resultSet.next()) {
                    updateCity(cityInfo);
                } else {
                    insertCity(cityInfo);
                }
            }

        }
    }

    private int getRegionId(String regionCode) throws SQLException {

        try (PreparedStatement selectStatement = connection.prepareStatement("select id from region where code = ?");) {

            selectStatement.setString(1, regionCode);

            try (ResultSet resultSet = selectStatement.executeQuery();) {

                if (resultSet.next()) {
                    return resultSet.getInt(1);
                } else {
                    return insertRegion(regionCode);
                }
            }

        }
    }

    private int insertRegion(String regionCode) throws SQLException {
        String[] retId = new String[]{"id"};

        try (PreparedStatement insRegion = connection.prepareStatement("insert into region(code) values(?)", retId);) {
            insRegion.setString(1, regionCode);
            insRegion.execute();

            ResultSet rs = insRegion.getGeneratedKeys();
            rs.next();
            System.out.println("Добавлена запись в region c id : " + rs.getInt(1));
            return rs.getInt(1);
        }
    }

    private void insertCity(String[] cityInfo) throws SQLException {
        String[] retId = new String[]{"id"};

        try (PreparedStatement insCity = connection.prepareStatement("insert into city(code ,name_rus, name_eng, population, region) values(?, ?, ?, ?, ?)", retId);) {
            insCity.setString(1, cityInfo[0]);
            insCity.setString(2, cityInfo[1]);
            insCity.setString(3, cityInfo[2]);
            insCity.setInt(4, Integer.parseInt(cityInfo[3]));
            insCity.setInt(5, Integer.parseInt(cityInfo[4]));
            insCity.execute();

            ResultSet rs = insCity.getGeneratedKeys();
            rs.next();
            System.out.println("Добавлена запись в city c id : " + rs.getInt(1));
        }
    }

    private void updateCity(String[] cityInfo) throws SQLException {
        String[] retId = new String[]{"id"};

        try (PreparedStatement updCity = connection.prepareStatement(""" 
                update city
                 set 
                     name_rus = ?
                   , name_eng = ?
                   , population = ?
                   , region = ?
                where code = ?
                """, retId);) {
            updCity.setString(1, cityInfo[1]);
            updCity.setString(2, cityInfo[2]);
            updCity.setInt(3, Integer.parseInt(cityInfo[3]));
            updCity.setInt(4, Integer.parseInt(cityInfo[4]));
            updCity.setString(5, cityInfo[0]);
            updCity.execute();

            ResultSet rs = updCity.getGeneratedKeys();
            rs.next();
            System.out.println("Обновлена запись в city c id : " + rs.getInt(1));
        }
    }

    final static String DICTIONARY_PRINT_FROMAT = "%-10s | %-20s | %-20s | %-20s | %-10s ";

    public void printDictionary() throws SQLException {

        System.out.println(DICTIONARY_PRINT_FROMAT.formatted("КОД", "НАЗВАНИЕ", "АНГЛ.НАЗВАНИЕ", "НАСЕЛЕНИЕ", "КОД РЕГИОНА"));
        System.out.println();
        try (PreparedStatement selectStatement = connection.prepareStatement("""
                select  c.code
                	,	c.name_rus
                	,	c.name_eng
                	,	c.population
                	,   r.code
                from region r
                join city c on c.region  = r.id
                order by r.code, c.code
                """);) {

            try (ResultSet resultSet = selectStatement.executeQuery();) {
                while (resultSet.next()) {
                    System.out.println(DICTIONARY_PRINT_FROMAT.formatted(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5)));
                }
            }


        }
    }

    @SneakyThrows
    @Override
    public void close() throws IOException {
        connection.close();
    }
}