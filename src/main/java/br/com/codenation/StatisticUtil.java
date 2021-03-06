package br.com.codenation;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


public class StatisticUtil {

    public static int average(int[] elements) {

        return (int) Arrays.stream(elements).average().getAsDouble();
    }

    public static int mode(int[] elements) {

        return Arrays.stream(elements)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .get()
                .getKey();
    }

    public static int median(int[] elements) {
        Arrays.sort(elements);
        int mediana = elements.length % 2 == 0 ? elements.length / 2 : (elements.length / 2) + 1;
        return Arrays.stream(elements)
                .filter(e -> elements.length % 2 == 0)
                .map(e -> (elements[mediana - 1] + elements[mediana]) / 2)
                .findFirst()
                .orElse(elements[mediana - 1]);
    }
}