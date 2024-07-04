package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        ArrayList<String> results = new ArrayList<>();

        for (int i = 0; i < testCases; i++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }
            results.add(analyzeMatrix(matrix, matrixSize));
        }

        for (String result : results) {
            System.out.println(result);
        }
    }

    public static String analyzeMatrix(int[][] matrix, int size) {
        int trace = calculateTrace(matrix, size);
        int rowDuplicates = countRowDuplicates(matrix, size);
        int columnDuplicates = countColumnDuplicates(matrix, size);
        return trace + " " + rowDuplicates + " " + columnDuplicates;
    }

    public static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    public static int countRowDuplicates(int[][] matrix, int size) {
        int duplicates = 0;
        for (int row = 0; row < size; row++) {
            Map<Integer, Integer> valueMap = new HashMap<>();
            for (int col = 0; col < size; col++) {
                if (valueMap.containsKey(matrix[row][col])) {
                    duplicates++;
                    break;
                } else {
                    valueMap.put(matrix[row][col], 0);
                }
            }
        }
        return duplicates;
    }

    public static int countColumnDuplicates(int[][] matrix, int size) {
        int duplicates = 0;
        for (int col = 0; col < size; col++) {
            Map<Integer, Integer> valueMap = new HashMap<>();
            for (int row = 0; row < size; row++) {
                if (valueMap.containsKey(matrix[row][col])) {
                    duplicates++;
                    break;
                } else {
                    valueMap.put(matrix[row][col], 0);
                }
            }
        }
        return duplicates;
    }
}