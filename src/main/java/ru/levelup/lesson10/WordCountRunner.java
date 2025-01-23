package ru.levelup.lesson10;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.TreeMap;

public class WordCountRunner {
    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream(args[0]);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, Charset.forName("cp1251"));
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        LinkedList<String> words = new LinkedList<>();

        bufferedReader
                .lines()
                .forEach(str -> Arrays.stream(str.split("\\s|\\.|,|-|:|!|\\[|]|\\?|№|\\n\\r\\t"))
                        .filter(s -> !s.trim().equals(""))
                        .forEach(s -> words.add(s.toLowerCase().trim())));

        TreeMap<String, Integer> wordsCount = new TreeMap<>();

        words.stream().forEach(s -> wordsCount.put(s, (wordsCount.get(s) == null ? 0 : wordsCount.get(s)) + 1));

        wordsCount.entrySet().stream()
                .sorted((o1, o2) -> o2.getValue() - o1.getValue())
                .limit(20)
                .forEach(System.out::println);

    }
}
