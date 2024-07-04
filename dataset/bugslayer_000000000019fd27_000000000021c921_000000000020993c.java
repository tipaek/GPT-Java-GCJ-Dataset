package com.opg.condition;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ArrayList<Integer> list = new ArrayList<Integer>();
        int i[] = { 3, 4, 1, 2, 3, 4, 2, 1, 4, 3, 3, 4, 1, 2, 4, 3, 2, 1, 4, 2, 2, 2, 2, 2, 3, 2, 3, 2, 2, 2, 3, 2, 2,
                2, 2, 3, 2, 1, 3, 1, 3, 2, 1, 2, 3 };

        for (int x = 0; x < i.length; x++) {
            list.add(i[x]);
        }

        int a = list.get(0);
        list.remove(0);
        int turn = 1;
        ArrayList<Integer> listX = new ArrayList<Integer>();
        ArrayList<Integer> listY = new ArrayList<Integer>();
        int matrix = 1;

        while (list.isEmpty() == false) {
            int size = list.get(0);
            list.remove(0);
            int duplicateX = 0;
            int duplicateY = 0;
            int total = 0;
            int rank = 0;

            // Value from Y
            for (int x = 0; x < size; x++) {
                listY.add(list.get(0));
                total = total + list.get(rank);

                // Values from` X
                for (int y = 0; y < size; y++) {

                    if (rank == 0) {
                        listX.add(list.get(0));
                    }

                    list.remove(0);
                }
                rank++;
            }
            duplicateX = duplicatecheck(listX);
            duplicateY = duplicatecheck(listY);
            System.out.println("Case #" + matrix + ":  " + total + " " + duplicateX + " " + duplicateY);
            matrix++;
            listX.removeAll(listX);
            listY.removeAll(listY);
        }
    }

    public static int duplicatecheck(ArrayList<Integer> list) {

        int duplicates = 0;

        // TODO: Write the code to get the number of duplicates in the list

        Set<Integer> uniqueSet = new HashSet<Integer>(list);
        for (int temp : uniqueSet) {
            if (Collections.frequency(list, temp) != 1) {
                duplicates = duplicates + Collections.frequency(list, temp);
            }
        }
        return duplicates;
    }

}
