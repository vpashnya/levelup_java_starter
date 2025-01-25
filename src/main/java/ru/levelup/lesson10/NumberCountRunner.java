package ru.levelup.lesson10;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class NumberCountRunner {
    public static void main(String[] args) {
        List<Integer> list = new Random()
                .ints(0, 1000)
                .limit(1000)
                .boxed().toList();

        System.out.println(list);

        System.out.println("Максимальное значение " + list.stream().max(Integer::compare).orElse(0));
        System.out.println("Минимальное значение  " + list.stream().min(Integer::compare).orElse(0));
        System.out.println("Среднее значение      " + list.stream().collect(Collectors.averagingInt(i -> i)));

        AtomicBoolean odd = new AtomicBoolean(false);
        ToIntFunction<Integer> addOdd = new ToIntFunction<>() {
            @Override
            public int applyAsInt(Integer value) {
                odd.set(!odd.get());
                return odd.get() ? value : 0;
            }
        };

        System.out.println("Сумма нечетных элементов " + list.stream().collect(Collectors.summingInt(addOdd::applyAsInt)));

        Function<Integer, Integer> digsSum = new Function<>() {
            @Override
            public Integer apply(Integer integer) {
                int inValue = integer;
                int retValue = 0;
                do {
                    retValue += inValue % 10;
                    inValue /= 10;
                } while (inValue > 0);

                return retValue;
            }
        };

        Map<Integer, Integer> map = list.stream().distinct().collect(Collectors.toMap(i -> i, digsSum::apply));

        System.out.println("Карта из значений из стрима " + map);

    }
}
