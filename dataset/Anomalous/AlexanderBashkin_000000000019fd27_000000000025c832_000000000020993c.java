import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        new Solution().execute();
    }

    private void execute() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int testCases = Integer.parseInt(reader.readLine());
            for (int t = 1; t <= testCases; t++) {
                int n = Integer.parseInt(reader.readLine());
                int[][] matrix = new int[n][n];
                for (int i = 0; i < n; i++) {
                    StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                    for (int j = 0; j < n; j++) {
                        matrix[i][j] = Integer.parseInt(tokenizer.nextToken());
                    }
                }
                processTestCase(t, n, matrix);
            }
        }
    }

    private void processTestCase(int testCaseNumber, int size, int[][] matrix) {
        int diagonalSum = calculateDiagonalSum(size, matrix);
        int duplicateRows = countDuplicateRows(size, matrix);
        int duplicateColumns = countDuplicateColumns(size, matrix);
        printResult(testCaseNumber, diagonalSum, duplicateRows, duplicateColumns);
    }

    private int calculateDiagonalSum(int size, int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private int countDuplicateRows(int size, int[][] matrix) {
        int duplicateRows = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < size; j++) {
                uniqueElements.add(matrix[i][j]);
            }
            if (uniqueElements.size() != size) {
                duplicateRows++;
            }
        }
        return duplicateRows;
    }

    private int countDuplicateColumns(int size, int[][] matrix) {
        int duplicateColumns = 0;
        for (int j = 0; j < size; j++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int i = 0; i < size; i++) {
                uniqueElements.add(matrix[i][j]);
            }
            if (uniqueElements.size() != size) {
                duplicateColumns++;
            }
        }
        return duplicateColumns;
    }

    private void printResult(int testCaseNumber, int diagonalSum, int duplicateRows, int duplicateColumns) {
        System.out.printf("Case #%d: %d %d %d%n", testCaseNumber, diagonalSum, duplicateRows, duplicateColumns);
    }
}