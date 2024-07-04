import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = readMatrix(scanner, matrixSize);
            String result = analyzeMatrix(matrix, matrixSize);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static int[][] readMatrix(Scanner scanner, int size) {
        int[][] matrix = new int[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
        return matrix;
    }

    private static String analyzeMatrix(int[][] matrix, int size) {
        int trace = 0;
        int duplicateRows = 0;
        int duplicateCols = 0;
        Set<Integer>[] columnSets = new HashSet[size];
        boolean[] hasDuplicateCol = new boolean[size];

        for (int i = 0; i < size; i++) {
            columnSets[i] = new HashSet<>();
        }

        for (int row = 0; row < size; row++) {
            Set<Integer> rowSet = new HashSet<>();
            boolean hasDuplicateRow = false;
            for (int col = 0; col < size; col++) {
                if (row == col) {
                    trace += matrix[row][col];
                }
                if (rowSet.contains(matrix[row][col])) {
                    hasDuplicateRow = true;
                }
                rowSet.add(matrix[row][col]);
                if (columnSets[col].contains(matrix[row][col])) {
                    hasDuplicateCol[col] = true;
                }
                columnSets[col].add(matrix[row][col]);
            }
            if (hasDuplicateRow) {
                duplicateRows++;
            }
        }

        for (boolean colHasDuplicate : hasDuplicateCol) {
            if (colHasDuplicate) {
                duplicateCols++;
            }
        }

        return trace + " " + duplicateRows + " " + duplicateCols;
    }
}