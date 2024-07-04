import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();

        for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int traceValue = calculateTrace(matrix);
            int rowRepetitions = countRowRepetitions(matrix);
            int columnRepetitions = countColumnRepetitions(matrix);

            System.out.printf("Case #%d: %d %d %d%n", caseIndex, traceValue, rowRepetitions, columnRepetitions);
        }
    }

    private static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRowRepetitions(int[][] matrix) {
        int repetitions = 0;
        for (int[] row : matrix) {
            if (containsRepetitions(row)) {
                repetitions++;
            }
        }
        return repetitions;
    }

    private static int countColumnRepetitions(int[][] matrix) {
        int repetitions = 0;
        int matrixSize = matrix.length;

        for (int col = 0; col < matrixSize; col++) {
            int[] column = new int[matrixSize];
            for (int row = 0; row < matrixSize; row++) {
                column[row] = matrix[row][col];
            }
            if (containsRepetitions(column)) {
                repetitions++;
            }
        }
        return repetitions;
    }

    private static boolean containsRepetitions(int[] array) {
        boolean[] seen = new boolean[array.length];
        for (int value : array) {
            if (seen[value - 1]) {
                return true;
            }
            seen[value - 1] = true;
        }
        return false;
    }
}