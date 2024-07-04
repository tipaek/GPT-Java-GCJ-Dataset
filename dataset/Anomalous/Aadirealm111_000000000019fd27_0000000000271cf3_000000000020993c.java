import java.util.Scanner;

public class Codejam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;

            // Read the matrix and calculate the trace
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = scanner.nextInt();
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                }
            }

            // Check for duplicate values in rows
            for (int row = 0; row < n; row++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int col = 0; col < n; col++) {
                    rowSet.add(matrix[row][col]);
                }
                if (rowSet.size() != n) {
                    rowDuplicates++;
                }
            }

            // Check for duplicate values in columns
            for (int col = 0; col < n; col++) {
                Set<Integer> colSet = new HashSet<>();
                for (int row = 0; row < n; row++) {
                    colSet.add(matrix[row][col]);
                }
                if (colSet.size() != n) {
                    colDuplicates++;
                }
            }

            // Print the result for the current test case
            System.out.println("Case #" + i + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }

        scanner.close();
    }
}