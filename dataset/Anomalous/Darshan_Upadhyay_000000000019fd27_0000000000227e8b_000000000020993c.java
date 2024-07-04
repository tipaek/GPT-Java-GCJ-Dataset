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
            int diagonalSum = 0;
            int rowDuplicates = 0;
            int columnDuplicates = 0;

            // Reading the matrix and calculating the diagonal sum
            for (int rowIndex = 0; rowIndex < matrixSize; rowIndex++) {
                for (int colIndex = 0; colIndex < matrixSize; colIndex++) {
                    matrix[rowIndex][colIndex] = scanner.nextInt();
                    if (rowIndex == colIndex) {
                        diagonalSum += matrix[rowIndex][colIndex];
                    }
                }
            }

            // Checking for duplicate values in each row
            for (int rowIndex = 0; rowIndex < matrixSize; rowIndex++) {
                boolean[] seen = new boolean[101];
                for (int colIndex = 0; colIndex < matrixSize; colIndex++) {
                    int value = matrix[rowIndex][colIndex];
                    if (seen[value]) {
                        rowDuplicates++;
                        break;
                    }
                    seen[value] = true;
                }
            }

            // Checking for duplicate values in each column
            for (int colIndex = 0; colIndex < matrixSize; colIndex++) {
                boolean[] seen = new boolean[101];
                for (int rowIndex = 0; rowIndex < matrixSize; rowIndex++) {
                    int value = matrix[rowIndex][colIndex];
                    if (seen[value]) {
                        columnDuplicates++;
                        break;
                    }
                    seen[value] = true;
                }
            }

            // Printing the result for the current test case
            System.out.println("Case " + (caseIndex + 1) + ": " + diagonalSum + " " + rowDuplicates + " " + columnDuplicates);
        }

        scanner.close();
    }
}