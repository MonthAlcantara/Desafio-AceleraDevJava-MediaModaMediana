package br.com.codenation;

import java.util.ArrayList;
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
        List<Integer> repetidos = new ArrayList<>();
        for (int x = 1; x < elements.length; x++) {
            for (int i = 0; i < x; i++) {
                if (elements[x] == elements[i]) {
                    repetidos.add(x);
                }
            }
        }
        return repetidos.get(0);
    }

    public static int median(int[] elements) {
        int mediana, x;
        if (elements.length % 2 == 1) {
            x = (elements.length - ((elements.length - 1) / 2)) - 1;
            mediana = elements[x];
        } else {
            x = elements.length - ((elements.length - 2) / 2);
            mediana = elements[x - 1] + elements[x - 2];
        }
        return mediana;
    }
}