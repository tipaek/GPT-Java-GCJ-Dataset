import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = scanner.nextInt();

        for (int caseIndex = 0; caseIndex < numCases; caseIndex++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            analyzeMatrix(matrix, matrixSize, caseIndex + 1);
        }
        scanner.close();
    }

    private static void analyzeMatrix(int[][] matrix, int size, int caseNumber) {
        int diagonalSum = 0;
        int repeatedRows = 0;
        int repeatedCols = 0;

        // Calculate diagonal sum
        for (int i = 0; i < size; i++) {
            diagonalSum += matrix[i][i];
        }

        // Check for repeated elements in rows
        for (int row = 0; row < size; row++) {
            if (hasDuplicates(matrix[row])) {
                repeatedRows++;
            }
        }

        // Check for repeated elements in columns
        for (int col = 0; col < size; col++) {
            int[] column = new int[size];
            for (int row = 0; row < size; row++) {
                column[row] = matrix[row][col];
            }
            if (hasDuplicates(column)) {
                repeatedCols++;
            }
        }

        System.out.println("Case #" + caseNumber + ": " + diagonalSum + " " + repeatedRows + " " + repeatedCols);
    }

    private static boolean hasDuplicates(int[] array) {
        Map<Integer, Boolean> elementMap = new HashMap<>();
        for (int element : array) {
            if (elementMap.containsKey(element)) {
                return true;
            }
            elementMap.put(element, true);
        }
        return false;
    }
}