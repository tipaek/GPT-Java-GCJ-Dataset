import java.util.*;

public class MatrixAnalysis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int r = 0;
            // Checking rows for duplicates
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        r++;
                        break;
                    }
                }
            }

            int c = 0;
            // Checking columns for duplicates
            for (int i = 0; i < n; i++) {
                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!colSet.add(matrix[j][i])) {
                        c++;
                        break;
                    }
                }
            }

            int s = 0;
            // Calculating the sum of the diagonal
            for (int i = 0; i < n; i++) {
                s += matrix[i][i];
            }

            // Printing the result
            System.out.printf("Case #%d: %d %d %d%n", t, s, r, c);
        }

        scanner.close();
    }
}