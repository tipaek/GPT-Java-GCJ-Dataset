import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int l = 1; l <= t; l++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            // Calculate trace
            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            // Calculate rows with repeated elements
            int repeatedRows = 0;
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        repeatedRows++;
                        break;
                    }
                }
            }

            // Calculate columns with repeated elements
            int repeatedCols = 0;
            for (int i = 0; i < n; i++) {
                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!colSet.add(matrix[j][i])) {
                        repeatedCols++;
                        break;
                    }
                }
            }

            // Output the result for the current case
            System.out.println("Case #" + l + ": " + trace + " " + repeatedRows + " " + repeatedCols);
        }
    }
}