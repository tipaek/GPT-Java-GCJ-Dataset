import java.util.Scanner;

public class Google {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            // Calculating the trace
            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            // Counting the number of rows with repeated elements
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

            // Counting the number of columns with repeated elements
            int repeatedColumns = 0;
            for (int j = 0; j < n; j++) {
                Set<Integer> columnSet = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    if (!columnSet.add(matrix[i][j])) {
                        repeatedColumns++;
                        break;
                    }
                }
            }

            // Output the result for the current test case
            System.out.println("Case #" + (t + 1) + ": " + trace + " " + repeatedRows + " " + repeatedColumns);
        }

        scanner.close();
    }
}