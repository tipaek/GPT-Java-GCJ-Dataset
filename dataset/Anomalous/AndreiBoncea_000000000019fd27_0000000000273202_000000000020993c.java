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
            int sum = 0, duplicateRows = 0, duplicateCols = 0;
            int matrixSize = scan.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scan.nextInt();
                }
            }

            for (int k = 0; k < matrixSize; k++) {
                sum += matrix[k][k];
            }

            for (int row = 0; row < matrixSize; row++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int col = 0; col < matrixSize; col++) {
                    rowSet.add(matrix[row][col]);
                }
                if (rowSet.size() != matrixSize) duplicateRows++;
            }

            for (int col = 0; col < matrixSize; col++) {
                HashSet<Integer> colSet = new HashSet<>();
                for (int row = 0; row < matrixSize; row++) {
                    colSet.add(matrix[row][col]);
                }
                if (colSet.size() != matrixSize) duplicateCols++;
            }

            System.out.println("Case #" + i + ": " + sum + " " + duplicateRows + " " + duplicateCols);
        }

        scan.close();
    }
}