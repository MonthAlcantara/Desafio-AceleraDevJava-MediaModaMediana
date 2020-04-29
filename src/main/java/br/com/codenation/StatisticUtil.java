package br.com.codenation;

import org.w3c.dom.stylesheets.LinkStyle;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


public class StatisticUtil {

    public static int average(int[] elements) {

        return Arrays.stream(elements).sum() / elements.length;
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
        int mediana = elements.length / 2;
        return (elements.length % 2 == 0)
                ? (elements[mediana - 1] + elements[mediana]) / 2
                : elements[mediana];
    }
}