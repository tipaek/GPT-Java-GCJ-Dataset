import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;

            // Reading matrix and calculating trace
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            int rowCount = countRepeatedRowsOrColumns(matrix, n);
            int[][] transposedMatrix = transposeMatrix(matrix, n);
            int colCount = countRepeatedRowsOrColumns(transposedMatrix, n);

            System.out.println("Case #" + testCase + ": " + trace + " " + rowCount + " " + colCount);
        }
    }

    private static int[][] transposeMatrix(int[][] matrix, int n) {
        int[][] transposedMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                transposedMatrix[i][j] = matrix[j][i];
            }
        }
        return transposedMatrix;
    }

    private static int countRepeatedRowsOrColumns(int[][] matrix, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < n; j++) {
                uniqueElements.add(matrix[i][j]);
            }
            if (uniqueElements.size() != n) {
                count++;
            }
        }
        return count;
    }
}