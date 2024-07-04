import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int[][] results = new int[testCases][3];

        for (int testCase = 0; testCase < testCases; testCase++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            // Read the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int value = scanner.nextInt();
                    if (value > 0 && value <= n) {
                        matrix[i][j] = value;
                    }
                }
            }

            // Calculate the trace
            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }
            results[testCase][0] = trace;

            // Count repeated rows
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
            results[testCase][1] = repeatedRows;

            // Count repeated columns
            int repeatedColumns = 0;
            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        repeatedColumns++;
                        break;
                    }
                }
            }
            results[testCase][2] = repeatedColumns;
        }

        // Print results
        for (int i = 0; i < testCases; i++) {
            System.out.printf("Case #%d: %d %d %d%n", i + 1, results[i][0], results[i][1], results[i][2]);
        }

        scanner.close();
    }
}