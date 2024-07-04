package com.crazystudio.vestigium;

import java.util.Scanner;

public class Solution {
    private static final String OUTPUT_FORMAT = "Case #%d: %d %d %d";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            Solution solution = new Solution();
            for (int caseNum = 1; caseNum <= testCases; caseNum++) {
                solution.processCase(caseNum, scanner);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void processCase(int caseNum, Scanner scanner) {
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        
        // Reading the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int diagonalSum = calculateDiagonalSum(matrix, n);
        int rowDuplicates = countRowDuplicates(matrix, n);
        int columnDuplicates = countColumnDuplicates(matrix, n);

        System.out.printf(OUTPUT_FORMAT, caseNum, diagonalSum, rowDuplicates, columnDuplicates);
        System.out.println();
    }

    private int calculateDiagonalSum(int[][] matrix, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private int countRowDuplicates(int[][] matrix, int n) {
        int duplicates = 0;
        for (int i = 0; i < n; i++) {
            boolean[] seen = new boolean[n + 1];
            for (int j = 0; j < n; j++) {
                if (seen[matrix[i][j]]) {
                    duplicates++;
                    break;
                }
                seen[matrix[i][j]] = true;
            }
        }
        return duplicates;
    }

    private int countColumnDuplicates(int[][] matrix, int n) {
        int duplicates = 0;
        for (int i = 0; i < n; i++) {
            boolean[] seen = new boolean[n + 1];
            for (int j = 0; j < n; j++) {
                if (seen[matrix[j][i]]) {
                    duplicates++;
                    break;
                }
                seen[matrix[j][i]] = true;
            }
        }
        return duplicates;
    }
}