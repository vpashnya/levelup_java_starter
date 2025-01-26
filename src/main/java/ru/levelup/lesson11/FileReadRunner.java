package ru.levelup.lesson11;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.stream.Collectors;

public class FileReadRunner {
    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            throw new RuntimeException("Не указаны параметры запуска !");
        }

        File fileIn = new File(args[0]);
        if (!fileIn.exists()) {
            throw new RuntimeException("Файл %s не существует!".formatted(args[0]));
        }

        File fileOut = new File(args[1]);

        try (
                FileReader fileReader = new FileReader(fileIn, Charset.forName("cp1251"));
                FileWriter fileWriter = new FileWriter(fileOut, Charset.forName("cp1251"));
        ) {
            StringBuffer stringBuffer = new StringBuffer();
            char[] ch = new char[1];
            while (fileReader.read(ch) >= 0) {
                stringBuffer.append(ch);
            }

            Arrays.stream(stringBuffer
                            .toString()
                            .split("\\s|\\.|,|-|:|!|\\[|]|\\?|№|\\n|\\r|\\t"))
                    .collect(Collectors.toList())
                    .reversed()
                    .stream()
                    .forEach((str) -> {
                        System.out.print(str + " ");
                        try {
                            fileWriter.append(str + " ");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        }
    }
}
