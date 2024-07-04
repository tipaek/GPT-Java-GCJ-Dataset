import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int l = 1; l <= t; l++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            // Read matrix
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

            // Calculate row repetitions
            int rowRepetitions = 0;
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        rowRepetitions++;
                        break;
                    }
                }
            }

            // Calculate column repetitions
            int colRepetitions = 0;
            for (int i = 0; i < n; i++) {
                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!colSet.add(matrix[j][i])) {
                        colRepetitions++;
                        break;
                    }
                }
            }

            // Print result
            System.out.println("Case #" + l + ": " + trace + " " + rowRepetitions + " " + colRepetitions);
        }
    }
}