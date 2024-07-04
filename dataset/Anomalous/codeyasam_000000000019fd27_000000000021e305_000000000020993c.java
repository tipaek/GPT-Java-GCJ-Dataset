import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = readMatrix(matrixSize, scanner);
            calculateVestigium(matrix, matrixSize, caseNumber);
        }
    }

    private static void calculateVestigium(int[][] matrix, int size, int caseNumber) {
        int trace = 0;
        int rowRepeats = 0;
        int columnRepeats = 0;

        for (int i = 0; i < size; i++) {
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> columnSet = new HashSet<>();
            boolean rowHasDuplicate = false;
            boolean columnHasDuplicate = false;

            for (int j = 0; j < size; j++) {
                int rowValue = matrix[i][j];
                int columnValue = matrix[j][i];

                if (i == j) {
                    trace += rowValue;
                }

                if (!rowHasDuplicate && !rowSet.add(rowValue)) {
                    rowRepeats++;
                    rowHasDuplicate = true;
                }

                if (!columnHasDuplicate && !columnSet.add(columnValue)) {
                    columnRepeats++;
                    columnHasDuplicate = true;
                }
            }
        }

        System.out.println("Case #" + caseNumber + ": " + trace + " " + rowRepeats + " " + columnRepeats);
    }

    private static int[][] readMatrix(int size, Scanner scanner) {
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }
}