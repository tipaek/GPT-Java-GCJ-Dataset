import java.util.Scanner;

public class MatrixAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            // Read the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int rowDuplicates = 0;
            int colDuplicates = 0;
            int trace = 0;

            // Calculate trace and row duplicates
            for (int i = 0; i < n; i++) {
                boolean[] rowCheck = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    if (rowCheck[matrix[i][j]]) {
                        rowDuplicates++;
                        break;
                    }
                    rowCheck[matrix[i][j]] = true;
                }
                trace += matrix[i][i];
            }

            // Calculate column duplicates
            for (int j = 0; j < n; j++) {
                boolean[] colCheck = new boolean[n + 1];
                for (int i = 0; i < n; i++) {
                    if (colCheck[matrix[i][j]]) {
                        colDuplicates++;
                        break;
                    }
                    colCheck[matrix[i][j]] = true;
                }
            }

            System.out.println(trace + " " + rowDuplicates + " " + colDuplicates);
        }

        scanner.close();
    }
}