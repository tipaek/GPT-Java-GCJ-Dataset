import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            int[] results = calculateTraceAndLatinProperties(matrix, matrixSize);
            System.out.printf("Case #%d: %d %d %d%n", caseNum, results[0], results[1], results[2]);
        }
    }

    private static int[] calculateTraceAndLatinProperties(int[][] matrix, int size) {
        int[] results = new int[3];
        results[0] = calculateTrace(matrix, size);

        for (int i = 0; i < size; i++) {
            if (hasDuplicate(matrix[i])) {
                results[1]++;
            }

            int[] column = new int[size];
            for (int j = 0; j < size; j++) {
                column[j] = matrix[j][i];
            }

            if (hasDuplicate(column)) {
                results[2]++;
            }
        }

        return results;
    }

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static boolean hasDuplicate(int[] array) {
        boolean[] seen = new boolean[array.length + 1];
        for (int value : array) {
            if (seen[value]) {
                return true;
            }
            seen[value] = true;
        }
        return false;
    }
}