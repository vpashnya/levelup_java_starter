package ru.levelup.lesson20;


import ru.levelup.lesson20.utils.CityUtils;

import java.util.Scanner;

public class CityDictionaryHibernateRunner {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Class.forName("oracle.jdbc.OracleDriver");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("----------------------------------------------------------------------");
            System.out.println("Введите информацию о городе в формате:");
            System.out.println("КОД ; НАЗВАНИЕ ; АНГЛ.НАЗВАНИЕ ; ЧИСЛЕННОСТЬ НАСЕЛЕНИЯ ; КОД РЕГИОНА ");
            String str = scanner.nextLine();

            if ("exit".equals(str)) {
                break;
            }

            CityUtils.saveCity(str.split(";"));

        }

        System.out.println("----------------------------------------------------------------------");
        System.out.println("Удалим города с пустым наименованием:");
        CityUtils.deleteCitysWithEmptyName();

        System.out.println("----------------------------------------------------------------------");
        System.out.println("Содержание справочника");
        CityUtils.printAllCities();

    }

}
