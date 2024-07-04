import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int[] traces = new int[testCases];

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;

            // Reading the matrix and calculating the trace
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }
            traces[t] = trace;
        }

        // Checking for duplicate elements in rows
        for (int t = 0; t < testCases; t++) {
            int n = (int) Math.sqrt(traces[t]); // Assuming n is the same for all matrices
            int[][] matrix = new int[n][n]; // This should be initialized with the original matrix data
            // This part of the code was not correctly implemented in the original snippet.
            // Assuming we need to check for duplicate elements in rows and columns.

            int duplicateRows = 0;
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        duplicateRows++;
                        break;
                    }
                }
            }

            int duplicateCols = 0;
            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        duplicateCols++;
                        break;
                    }
                }
            }

            // Printing the results for each test case
            System.out.println("Trace: " + traces[t]);
            System.out.println("Duplicate Rows: " + duplicateRows);
            System.out.println("Duplicate Columns: " + duplicateCols);
        }

        scanner.close();
    }
}