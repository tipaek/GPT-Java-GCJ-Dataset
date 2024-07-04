package com.google;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws NumberFormatException {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int inputCases = scan.nextInt();

        for (int i = 1; i <= inputCases; i++) {
            int nrMatrice = scan.nextInt();
            int[][] matrix = new int[nrMatrice][nrMatrice];

            // Read matrix
            for (int linie = 0; linie < nrMatrice; linie++) {
                for (int col = 0; col < nrMatrice; col++) {
                    matrix[linie][col] = scan.nextInt();
                }
            }

            int sum = calculateDiagonalSum(matrix, nrMatrice);
            int nrPeLin = calculateDuplicateRows(matrix, nrMatrice);
            int nrPeCol = calculateDuplicateColumns(matrix, nrMatrice);

            System.out.println("Case #" + i + ": " + sum + " " + nrPeLin + " " + nrPeCol);
        }
    }

    private static int calculateDiagonalSum(int[][] matrix, int size) {
        int sum = 0;
        for (int k = 0; k < size; k++) {
            sum += matrix[k][k];
        }
        return sum;
    }

    private static int calculateDuplicateRows(int[][] matrix, int size) {
        int duplicateRows = 0;
        HashSet<Integer> uniqueElements = new HashSet<>();

        for (int linie = 0; linie < size; linie++) {
            for (int col = 0; col < size; col++) {
                uniqueElements.add(matrix[linie][col]);
            }
            if (uniqueElements.size() != size) {
                duplicateRows++;
            }
            uniqueElements.clear();
        }

        return duplicateRows;
    }

    private static int calculateDuplicateColumns(int[][] matrix, int size) {
        int duplicateColumns = 0;
        HashSet<Integer> uniqueElements = new HashSet<>();

        for (int col = 0; col < size; col++) {
            for (int linie = 0; linie < size; linie++) {
                uniqueElements.add(matrix[linie][col]);
            }
            if (uniqueElements.size() != size) {
                duplicateColumns++;
            }
            uniqueElements.clear();
        }

        return duplicateColumns;
    }
}