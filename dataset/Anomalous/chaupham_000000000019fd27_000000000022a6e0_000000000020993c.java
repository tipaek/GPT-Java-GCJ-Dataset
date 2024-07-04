import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        List<String> results = new ArrayList<>();

        for (int i = 1; i <= testCases; ++i) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            results.add(processMatrix(matrix, matrixSize, i));
        }

        for (String result : results) {
            System.out.println(result);
        }
    }

    private static String processMatrix(int[][] matrix, int size, int testCaseNumber) {
        int trace = 0;
        int rowDuplicates = 0;
        int colDuplicates = 0;

        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }

        for (int i = 0; i < size; i++) {
            if (hasDuplicates(matrix[i])) {
                rowDuplicates++;
            }
        }

        for (int i = 0; i < size; i++) {
            if (hasDuplicates(getColumn(matrix, i))) {
                colDuplicates++;
            }
        }

        return formatResult(testCaseNumber, trace, rowDuplicates, colDuplicates);
    }

    private static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[array.length + 1];
        for (int value : array) {
            if (seen[value]) {
                return true;
            }
            seen[value] = true;
        }
        return false;
    }

    private static int[] getColumn(int[][] matrix, int colIndex) {
        int[] column = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][colIndex];
        }
        return column;
    }

    private static String formatResult(int testCaseNumber, int trace, int rowDuplicates, int colDuplicates) {
        return String.format("Case #%d: %d %d %d", testCaseNumber, trace, rowDuplicates, colDuplicates);
    }
}