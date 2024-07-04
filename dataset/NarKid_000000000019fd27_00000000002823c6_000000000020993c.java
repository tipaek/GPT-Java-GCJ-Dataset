package com.vivek;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        int n;
        int element;
        boolean flag;
        int rowCount = 0, colCount = 0, diagonal = 0;
        int [][] array = new int[100][100];
        Set<Integer> set = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        while (testCase != 0) {
            testCase--;
            colCount = 0;
            rowCount = 0;
            diagonal = 0;
            n = scanner.nextInt();
            for (int i = 0 ; i < n ; i++) {
                set.clear();
                flag = false;
                for (int j = 0 ; j < n ; j++) {
                    element = scanner.nextInt();
                    array[i][j] = element;
                    if (!set.add(element)) {
                        flag = true;
                    }
                }
                if (flag) {
                    rowCount++;
                }
                diagonal += array[i][i];
            }
            for (int i = 0 ; i < n ; i++) {
                set.clear();
                flag = false;
                for (int j = 0 ; j < n ; j++) {
                    if (!set.add(array[j][i])) {
                        flag = true;
                    }
                }
                if (flag) {
                    colCount++;
                }
            }
            System.out.println("" + diagonal + " " + rowCount + " " + colCount);
        }
    }
}
