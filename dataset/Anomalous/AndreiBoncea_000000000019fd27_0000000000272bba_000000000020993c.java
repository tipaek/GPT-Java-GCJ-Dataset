package com.google;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws NumberFormatException {
        HashSet<Integer> uniqueElements = new HashSet<>();
        int[][] matrix = new int[100][100];
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            int diagonalSum = 0, duplicateRows = 0, duplicateColumns = 0;
            int matrixSize = scanner.nextInt();

            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            for (int i = 0; i < matrixSize; i++) {
                diagonalSum += matrix[i][i];
            }

            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    uniqueElements.add(matrix[row][col]);
                }
                if (uniqueElements.size() != matrixSize) duplicateRows++;
                uniqueElements.clear();
            }

            for (int col = 0; col < matrixSize; col++) {
                for (int row = 0; row < matrixSize; row++) {
                    uniqueElements.add(matrix[row][col]);
                }
                if (uniqueElements.size() != matrixSize) duplicateColumns++;
                uniqueElements.clear();
            }

            System.out.println();
            System.out.println("Case #" + caseNumber + ": " + diagonalSum + " " + duplicateRows + " " + duplicateColumns);
        }
    }
}