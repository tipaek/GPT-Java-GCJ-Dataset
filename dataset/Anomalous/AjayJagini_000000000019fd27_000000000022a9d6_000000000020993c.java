import java.util.Scanner;

public class MatrixTrace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];

        // Read the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Calculate the trace of the matrix
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }

        // Count rows and columns with repeated elements
        int repeatedRows = 0;
        int repeatedColumns = 0;

        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (!rowSet.add(matrix[i][j])) {
                    repeatedRows++;
                    break;
                }
            }
            for (int j = 0; j < n; j++) {
                if (!colSet.add(matrix[j][i])) {
                    repeatedColumns++;
                    break;
                }
            }
        }

        // Output results for each test case
        for (int i = 1; i <= t; i++) {
            System.out.println("Case #" + i + ": " + trace + " " + repeatedRows + " " + repeatedColumns);
        }

        scanner.close();
    }
}