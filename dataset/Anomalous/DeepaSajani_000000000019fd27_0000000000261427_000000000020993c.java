import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }
            System.out.println("Case #" + caseNumber + ": " + analyzeMatrix(matrix));
        }
        scanner.close();
    }

    private static String analyzeMatrix(int[][] matrix) {
        int duplicateRows = 0;
        int duplicateCols = 0;
        int trace = 0;
        int size = matrix.length;

        for (int i = 0; i < size; i++) {
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();
            boolean rowHasDuplicate = false;
            boolean colHasDuplicate = false;

            for (int j = 0; j < size; j++) {
                int rowElement = matrix[i][j];
                int colElement = matrix[j][i];

                if (!rowSet.add(rowElement)) {
                    rowHasDuplicate = true;
                }
                if (!colSet.add(colElement)) {
                    colHasDuplicate = true;
                }
                if (i == j) {
                    trace += rowElement;
                }
            }

            if (rowHasDuplicate) {
                duplicateRows++;
            }
            if (colHasDuplicate) {
                duplicateCols++;
            }
        }

        return trace + " " + duplicateRows + " " + duplicateCols;
    }
}