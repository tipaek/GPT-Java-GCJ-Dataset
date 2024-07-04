package com.company;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int numCases = scanner.nextInt();
        scanner.nextLine();
        
        for (int i = 0; i < numCases; i++) {
            int matrixSize = scanner.nextInt();
            scanner.nextLine();
            int[][] matrix = new int[matrixSize][matrixSize];
            
            for (int row = 0; row < matrixSize; row++) {
                String[] rowNumbers = scanner.nextLine().split(" ");
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = Integer.parseInt(rowNumbers[col]);
                }
            }

            int trace = calculateMatrixTrace(matrixSize, matrix);
            int repeatedInRows = countRepeatedInRows(matrixSize, matrix);
            int repeatedInCols = countRepeatedInCols(matrixSize, matrix);

            System.out.println("Case #" + (i + 1) + ": " + trace + " " + repeatedInRows + " " + repeatedInCols);
        }
    }

    static int calculateMatrixTrace(int matrixSize, int[][] matrix) {
        int matrixTrace = 0;
        for (int i = 0; i < matrixSize; i++) {
            matrixTrace += matrix[i][i];
        }
        return matrixTrace;
    }

    static int countRepeatedInRows(int matrixSize, int[][] matrix) {
        int repeatedInRows = 0;
        for (int row = 0; row < matrixSize; row++) {
            Set<Integer> numbersInRows = new HashSet<>();
            for (int col = 0; col < matrixSize; col++) {
                int currentNumber = matrix[row][col];
                if (!numbersInRows.add(currentNumber)) {
                    repeatedInRows++;
                    break;
                }
            }
        }
        return repeatedInRows;
    }

    static int countRepeatedInCols(int matrixSize, int[][] matrix) {
        int repeatedInCols = 0;
        for (int col = 0; col < matrixSize; col++) {
            Set<Integer> numbersInCols = new HashSet<>();
            for (int row = 0; row < matrixSize; row++) {
                int currentNumber = matrix[row][col];
                if (!numbersInCols.add(currentNumber)) {
                    repeatedInCols++;
                    break;
                }
            }
        }
        return repeatedInCols;
    }
}