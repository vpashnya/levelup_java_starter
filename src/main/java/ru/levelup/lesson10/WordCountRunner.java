package ru.levelup.lesson10;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class WordCountRunner {
    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream(args[0]);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, Charset.forName("cp1251"));
        StringWriter stringWriter = new StringWriter();
        inputStreamReader.transferTo(stringWriter);

        Map<String, Long> wordsCount = Arrays.stream(stringWriter.getBuffer().toString().split("\\s|\\.|,|-|:|!|\\[|]|\\?|№|\\n|\\r|\\t"))
                .filter(s -> !s.trim().equals(""))
                .collect(Collectors.groupingBy(k -> k, Collectors.counting()));

        Consumer<Map.Entry<String, Long>> consumer = new Consumer<Map.Entry<String, Long>>() {
            @Override
            public void accept(Map.Entry<String, Long> stringLongEntry) {
                System.out.println(stringLongEntry.getKey() + "  -  " + stringLongEntry.getValue());
            }
        };

        System.out.println("20 самых популярных слов из файла");
        wordsCount.entrySet().stream()
                .sorted((o1, o2) -> Math.toIntExact(o2.getValue() - o1.getValue()))
                .limit(20)
                .forEach(consumer::accept);

    }
}
