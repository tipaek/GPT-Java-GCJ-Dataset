import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();  // Number of test cases

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();  // Size of the matrix
            int[][] matrix = new int[n][n];

            // Read the matrix
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    matrix[r][c] = scanner.nextInt();
                }
            }

            int trace = 0;
            int rRepeats = 0;
            int cRepeats = 0;

            // Calculate the trace
            for (int k = 0; k < n; k++) {
                trace += matrix[k][k];
            }

            // Check for row repeats
            for (int r = 0; r < n; r++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int c = 0; c < n; c++) {
                    if (!rowSet.add(matrix[r][c])) {
                        rRepeats++;
                        break;
                    }
                }
            }

            // Check for column repeats
            for (int c = 0; c < n; c++) {
                Set<Integer> colSet = new HashSet<>();
                for (int r = 0; r < n; r++) {
                    if (!colSet.add(matrix[r][c])) {
                        cRepeats++;
                        break;
                    }
                }
            }

            // Output the result for the current test case
            System.out.printf("Case #%d: %d %d %d%n", i + 1, trace, rRepeats, cRepeats);
        }

        scanner.close();
    }
}