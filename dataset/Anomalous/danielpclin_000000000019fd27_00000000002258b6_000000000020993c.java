package code_jam.year_2020.round_qualification.vestigium;

import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            
            for (int t = 1; t <= testCases; t++) {
                int matrixSize = scanner.nextInt();
                int[][] matrix = new int[matrixSize][matrixSize];
                int trace = 0, rowRepeats = 0, colRepeats = 0;
                
                // Reading matrix elements
                for (int i = 0; i < matrixSize; i++) {
                    for (int j = 0; j < matrixSize; j++) {
                        matrix[i][j] = scanner.nextInt();
                    }
                }
                
                // Calculating trace
                for (int i = 0; i < matrixSize; i++) {
                    trace += matrix[i][i];
                }
                
                // XOR value for comparison
                int expectedXor = 0;
                for (int i = 1; i <= matrixSize; i++) {
                    expectedXor ^= i;
                }
                
                // Checking for repeated elements in rows and columns
                for (int i = 0; i < matrixSize; i++) {
                    int rowXor = 0, colXor = 0;
                    for (int j = 0; j < matrixSize; j++) {
                        rowXor ^= matrix[i][j];
                        colXor ^= matrix[j][i];
                    }
                    if (rowXor != expectedXor) {
                        rowRepeats++;
                    }
                    if (colXor != expectedXor) {
                        colRepeats++;
                    }
                }
                
                // Output the result for the current test case
                System.out.printf("Case #%d: %d %d %d%n", t, trace, rowRepeats, colRepeats);
            }
        }
    }
}