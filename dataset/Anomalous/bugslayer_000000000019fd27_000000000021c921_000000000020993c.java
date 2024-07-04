package com.opg.condition;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(3, 4, 1, 2, 3, 4, 2, 1, 4, 3, 3, 4, 1, 2, 4, 3, 2, 1, 4, 2, 2, 2, 2, 2, 3, 2, 3, 2, 2, 2, 3, 2, 2, 2, 2, 3, 2, 1, 3, 1, 3, 2, 1, 2, 3));

        int matrix = 1;

        while (!list.isEmpty()) {
            int size = list.remove(0);
            List<Integer> listX = new ArrayList<>();
            List<Integer> listY = new ArrayList<>();
            int total = 0;

            for (int x = 0; x < size; x++) {
                listY.add(list.get(0));
                total += list.get(0);

                for (int y = 0; y < size; y++) {
                    if (x == 0) {
                        listX.add(list.get(0));
                    }
                    list.remove(0);
                }
            }

            int duplicateX = duplicateCheck(listX);
            int duplicateY = duplicateCheck(listY);
            System.out.println("Case #" + matrix + ":  " + total + " " + duplicateX + " " + duplicateY);
            matrix++;
        }
    }

    public static int duplicateCheck(List<Integer> list) {
        int duplicates = 0;
        Set<Integer> uniqueSet = new HashSet<>(list);

        for (int temp : uniqueSet) {
            int frequency = Collections.frequency(list, temp);
            if (frequency > 1) {
                duplicates += frequency;
            }
        }
        return duplicates;
    }
}