package com.codejam;

import java.util.Scanner;

public class Vestigium {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        byte totalTestCases = scanner.nextByte();

        for (byte testCase = 1; testCase <= totalTestCases; testCase++) {
            byte size = scanner.nextByte();
            int trace = 0;
            byte rowDuplicateCount = 0;
            byte columnDuplicateCount = 0;
            byte[][] matrix = new byte[size][size];

            // Read the matrix and calculate the trace
            for (byte row = 0; row < size; row++) {
                boolean[] rowSeen = new boolean[size + 1];
                boolean rowHasDuplicate = false;
                for (byte col = 0; col < size; col++) {
                    byte value = scanner.nextByte();
                    if (rowSeen[value] && !rowHasDuplicate) {
                        rowDuplicateCount++;
                        rowHasDuplicate = true;
                    } else {
                        rowSeen[value] = true;
                    }
                    if (row == col) {
                        trace += value;
                    }
                    matrix[row][col] = value;
                }
            }

            // Check for column duplicates
            for (byte col = 0; col < size; col++) {
                boolean[] colSeen = new boolean[size + 1];
                boolean colHasDuplicate = false;
                for (byte row = 0; row < size; row++) {
                    byte value = matrix[row][col];
                    if (colSeen[value] && !colHasDuplicate) {
                        columnDuplicateCount++;
                        colHasDuplicate = true;
                    } else {
                        colSeen[value] = true;
                    }
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", testCase, trace, rowDuplicateCount, columnDuplicateCount);
        }
        
        scanner.close();
    }
}