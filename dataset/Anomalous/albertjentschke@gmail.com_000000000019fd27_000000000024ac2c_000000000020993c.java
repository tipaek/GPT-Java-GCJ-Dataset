import java.util.*;

public class Solution {

    public static void vestigium() {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // Number of test cases

        List<String> results = new ArrayList<>();
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt(); // Size of the matrix
            int[][] matrix = new int[N][N];
            int diagonalSum = 0;
            int rowCount = 0;
            int colCount = 0;

            // Read matrix
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                }
            }

            // Check for duplicate rows
            for (int i = 0; i < N; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < N; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        rowCount++;
                        break;
                    }
                }
            }

            // Check for duplicate columns
            for (int j = 0; j < N; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int i = 0; i < N; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        colCount++;
                        break;
                    }
                }
            }

            results.add(String.format("Case #%d: %d %d %d", t + 1, diagonalSum, rowCount, colCount));
        }

        // Print results
        for (String result : results) {
            System.out.println(result);
        }

        scanner.close();
    }

    public static void main(String[] args) {
        vestigium();
    }
}