package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter the test cases: ");
        int testCases = scan.nextInt();
        
        System.out.print("Enter the size of matrix: ");
        int size = scan.nextInt();
        
        int[][] matrix = new int[size][size];

        for (int t = 1; t <= testCases; t++) {
            System.out.println("Enter values for test case #" + t + ":");
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scan.nextInt();
                }
            }
            
            int trace = calculateTrace(matrix);
            int rowRepeats = findDuplicateInRows(matrix);
            int colRepeats = findDuplicateInColumns(matrix);
            
            System.out.println("Case #" + t + ": trace = " + trace + ", row repeats = " + rowRepeats + ", column repeats = " + colRepeats);
        }
    }

    private static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int findDuplicateInRows(int[][] matrix) {
        int repeats = 0;
        int size = matrix.length;

        for (int i = 0; i < size; i++) {
            boolean[] seen = new boolean[size];
            for (int j = 0; j < size; j++) {
                if (seen[matrix[i][j] - 1]) {
                    repeats++;
                    break;
                }
                seen[matrix[i][j] - 1] = true;
            }
        }
        return repeats;
    }

    private static int findDuplicateInColumns(int[][] matrix) {
        int repeats = 0;
        int size = matrix.length;

        for (int i = 0; i < size; i++) {
            boolean[] seen = new boolean[size];
            for (int j = 0; j < size; j++) {
                if (seen[matrix[j][i] - 1]) {
                    repeats++;
                    break;
                }
                seen[matrix[j][i] - 1] = true;
            }
        }
        return repeats;
    }
}