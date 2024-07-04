import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int diagonalSum = 0;
            int repeatedRowsCount = 0;
            int repeatedColumnsCount = 0;

            boolean[] rowHasDuplicate = new boolean[matrixSize];
            boolean[] columnHasDuplicate = new boolean[matrixSize];

            for (int rowIndex = 0; rowIndex < matrixSize; rowIndex++) {
                for (int colIndex = 0; colIndex < matrixSize; colIndex++) {
                    matrix[rowIndex][colIndex] = scanner.nextInt();
                    if (rowIndex == colIndex) {
                        diagonalSum += matrix[rowIndex][colIndex];
                    }
                }
            }

            for (int rowIndex = 0; rowIndex < matrixSize; rowIndex++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int colIndex = 0; colIndex < matrixSize; colIndex++) {
                    if (!rowSet.add(matrix[rowIndex][colIndex])) {
                        rowHasDuplicate[rowIndex] = true;
                    }
                }
            }

            for (int colIndex = 0; colIndex < matrixSize; colIndex++) {
                Set<Integer> columnSet = new HashSet<>();
                for (int rowIndex = 0; rowIndex < matrixSize; rowIndex++) {
                    if (!columnSet.add(matrix[rowIndex][colIndex])) {
                        columnHasDuplicate[colIndex] = true;
                    }
                }
            }

            for (boolean hasDuplicate : rowHasDuplicate) {
                if (hasDuplicate) {
                    repeatedRowsCount++;
                }
            }

            for (boolean hasDuplicate : columnHasDuplicate) {
                if (hasDuplicate) {
                    repeatedColumnsCount++;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + diagonalSum + " " + repeatedColumnsCount + " " + repeatedRowsCount);
        }
    }
}