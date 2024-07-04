package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int matrixSize = scanner.nextInt();
            boolean[][] rowCheck = new boolean[matrixSize][matrixSize];
            boolean[][] colCheck = new boolean[matrixSize][matrixSize];
            boolean[] rowDuplicates = new boolean[matrixSize];
            boolean[] colDuplicates = new boolean[matrixSize];

            int trace = 0, duplicateRows = 0, duplicateCols = 0;

            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    int value = scanner.nextInt();

                    if (row == col) {
                        trace += value;
                    }

                    if (rowCheck[row][value - 1]) {
                        if (!rowDuplicates[row]) {
                            rowDuplicates[row] = true;
                            duplicateRows++;
                        }
                    } else {
                        rowCheck[row][value - 1] = true;
                    }

                    if (colCheck[col][value - 1]) {
                        if (!colDuplicates[col]) {
                            colDuplicates[col] = true;
                            duplicateCols++;
                        }
                    } else {
                        colCheck[col][value - 1] = true;
                    }
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", testCase, trace, duplicateRows, duplicateCols);
        }
    }
}