package com.codejam;

import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCasesNumber = in.nextInt();
        for (int i = 0; i < testCasesNumber; i++) {
            int n = in.nextInt();
            int[][] matrix = new int[n][];
            for (int j  = 0; j < n; j++) {
                matrix[j] = new int[n];
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = in.nextInt();
                }
            }
            analyzeMatrix(matrix, n, i);
        }
    }

    public static void analyzeMatrix(int[][] matrix, int n, int testCase) {
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }
        int wrongRows = 0;
        for (int i = 0; i < n; i++) {
            HashSet<Integer> numbersAlreadyMet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (numbersAlreadyMet.contains(matrix[i][j])) {
                    wrongRows++;
                    break;
                }
                numbersAlreadyMet.add(matrix[i][j]);
            }
        }
        int wrongColumns = 0;
        for (int i = 0; i < n; i++) {
            HashSet<Integer> numbersAlreadyMet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (numbersAlreadyMet.contains(matrix[j][i])) {
                    wrongColumns++;
                    break;
                }
                numbersAlreadyMet.add(matrix[j][i]);
            }
        }
        System.out.println("Case #" + testCase + ": " + trace + " " + wrongRows + " " + wrongColumns);
    }
}
