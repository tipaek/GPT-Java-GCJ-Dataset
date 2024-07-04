package problem;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseIndex = 0; caseIndex < testCases; caseIndex++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int diagonalSum = 0, rowDuplicates = 0, columnDuplicates = 0;

            // Reading matrix and calculating the diagonal sum
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                    if (row == col) {
                        diagonalSum += matrix[row][col];
                    }
                }
            }

            // Checking for duplicate values in each row
            for (int row = 0; row < matrixSize; row++) {
                boolean[] seen = new boolean[101];
                for (int col = 0; col < matrixSize; col++) {
                    if (seen[matrix[row][col]]) {
                        rowDuplicates++;
                        break;
                    }
                    seen[matrix[row][col]] = true;
                }
            }

            // Checking for duplicate values in each column
            for (int col = 0; col < matrixSize; col++) {
                boolean[] seen = new boolean[101];
                for (int row = 0; row < matrixSize; row++) {
                    if (seen[matrix[row][col]]) {
                        columnDuplicates++;
                        break;
                    }
                    seen[matrix[row][col]] = true;
                }
            }

            System.out.println("Case #" + (caseIndex + 1) + ": " + diagonalSum + " " + rowDuplicates + " " + columnDuplicates);
        }
        
        scanner.close();
    }
}