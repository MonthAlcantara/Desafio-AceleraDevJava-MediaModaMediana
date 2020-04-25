package br.com.codenation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class StatisticUtil {

    public static int average(int[] elements) {
        int total = 0;
        for (int e : elements) {
            total += e;
        }
        return total / elements.length;
    }

    public static int mode(int[] elements) {
        int repetidos = elements[0];
        int total = 0;
        Arrays.sort(elements);
        if (elements.length == 1) {
            return elements[0];
        }
        for (int x = 0; x < elements.length; x++) {
            int contador = 0;
            for (int i = 0; i < elements.length; i++) {
                if (elements[x] == elements[i]) {
                    contador++;
                }
                if (contador > total) {
                    repetidos = elements[x];
                    total = contador;
                }
            }
        }
        return repetidos;
    }

    public static int median(int[] elements) {
        Arrays.sort(elements);
        int mediana = elements.length / 2;
        return (elements.length % 2 == 0)
                ? (elements[mediana - 1] + elements[mediana]) / 2
                : elements[mediana];
    }
}