package ru.levelup.lesson10;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class WordCountRunner {
    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream(args[0]);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, Charset.forName("cp1251"));
        StringWriter stringWriter = new StringWriter();
        inputStreamReader.transferTo(stringWriter);

        Arrays.stream(stringWriter.getBuffer().toString().split("\\s|\\.|,|-|:|!|\\[|]|\\?|№|\\n\\r\\t"))
                .filter(s -> !s.trim().equals(""))
                .collect(Collectors.groupingBy(k -> k, Collectors.counting()))
                .entrySet().stream()
                .sorted((o1, o2) -> Math.toIntExact(o2.getValue() - o1.getValue()))
                .limit(20)
                .forEach((stringLongEntry) -> System.out.println(stringLongEntry.getKey() + "  -  " + stringLongEntry.getValue()));

    }
}
