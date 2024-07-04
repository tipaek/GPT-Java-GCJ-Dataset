import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        StringBuilder resultBuilder = new StringBuilder();
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = readMatrix(matrixSize, scanner);
            resultBuilder.append(solveCase(matrixSize, caseNum, matrix));
        }

        scanner.close();
        System.out.print(resultBuilder.toString());
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

    private static String solveCase(int matrixSize, int caseNum, int[][] matrix) {
        int diagonalSum = 0;
        int duplicateRows = 0;
        int duplicateCols = 0;

        for (int i = 0; i < matrixSize; i++) {
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();
            boolean duplicateRowFound = false;
            boolean duplicateColFound = false;

            for (int j = 0; j < matrixSize; j++) {
                if (i == j) {
                    diagonalSum += matrix[i][j];
                }

                if (!rowSet.add(matrix[i][j]) && !duplicateRowFound) {
                    duplicateRows++;
                    duplicateRowFound = true;
                }

                if (!colSet.add(matrix[j][i]) && !duplicateColFound) {
                    duplicateCols++;
                    duplicateColFound = true;
                }
            }
        }

        return formatResult(caseNum, diagonalSum, duplicateRows, duplicateCols);
    }

    private static String formatResult(int caseNum, int diagonalSum, int duplicateRows, int duplicateCols) {
        return String.format("Case #%d: %d %d %d%n", caseNum, diagonalSum, duplicateRows, duplicateCols);
    }
}