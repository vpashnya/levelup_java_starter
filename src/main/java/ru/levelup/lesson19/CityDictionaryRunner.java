package ru.levelup.lesson19;

import ru.levelup.lesson19.dbutils.DictionaryDBHelper;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class CityDictionaryRunner {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        Class.forName("org.postgresql.Driver");
        try (
                Scanner scanner = new Scanner(System.in);
                DictionaryDBHelper dictHelper = new DictionaryDBHelper();
        ) {
            while (true) {
                System.out.println("----------------------------------------------------------------------");
                System.out.println("Введите информацию о городе в формате:");
                System.out.println("КОД ; НАЗВАНИЕ ; АНГЛ.НАЗВАНИЕ ; ЧИСЛЕННОСТЬ НАСЕЛЕНИЯ ; КОД РЕГИОНА ");
                String str = scanner.nextLine();

                if (str.equals("exit")) {
                    break;
                }
                dictHelper.save2DBCityInfo(str.split(";"));
            }

            dictHelper.printDictionary();
        }
    }
}
