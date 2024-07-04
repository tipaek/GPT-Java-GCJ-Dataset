package code_jam.year_2020.round_qualification.vestigium;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            for (int t = 1; t <= testCases; ++t) {
                int trace = 0, rowDuplicates = 0, colDuplicates = 0;
                System.out.print("Case #" + t + ": ");
                int matrixSize = scanner.nextInt();
                int[][] matrix = new int[matrixSize][matrixSize];
                
                for (int i = 0; i < matrixSize; i++) {
                    for (int j = 0; j < matrixSize; j++) {
                        matrix[i][j] = scanner.nextInt();
                    }
                }
                
                for (int i = 0; i < matrixSize; i++) {
                    trace += matrix[i][i];
                }
                
                int expectedXor = 0;
                for (int i = 1; i <= matrixSize; i++) {
                    expectedXor ^= i;
                }
                
                for (int i = 0; i < matrixSize; i++) {
                    int rowXor = 0, colXor = 0;
                    for (int j = 0; j < matrixSize; j++) {
                        rowXor ^= matrix[i][j];
                        colXor ^= matrix[j][i];
                    }
                    if (rowXor != expectedXor) {
                        rowDuplicates++;
                    }
                    if (colXor != expectedXor) {
                        colDuplicates++;
                    }
                }
                
                System.out.println(trace + " " + rowDuplicates + " " + colDuplicates);
            }
        }
    }
}