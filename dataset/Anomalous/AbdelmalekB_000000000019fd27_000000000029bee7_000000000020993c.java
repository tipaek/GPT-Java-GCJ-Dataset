package com.company;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int diagonalSum = 0, repeatedRows = 0, repeatedCols = 0;
        int[][] matrix = new int[n][n];

        // Read matrix and calculate diagonal sum
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
            diagonalSum += matrix[i][i];

            if (hasRepeatedElements(matrix[i])) {
                repeatedRows++;
            }
        }

        // Check for repeated elements in columns
        for (int j = 0; j < n; j++) {
            if (hasRepeatedElementsInColumn(matrix, j)) {
                repeatedCols++;
            }
        }

        System.out.println(repeatedCols);
    }

    private static boolean hasRepeatedElements(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean hasRepeatedElementsInColumn(int[][] matrix, int col) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                if (matrix[i][col] == matrix[j][col]) {
                    return true;
                }
            }
        }
        return false;
    }
}