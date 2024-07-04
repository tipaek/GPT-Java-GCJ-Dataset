import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;

            // Calculating the trace
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            // Checking for duplicate values in rows and columns
            for (int i = 0; i < n; i++) {
                boolean[] rowCheck = new boolean[n + 1];
                boolean[] colCheck = new boolean[n + 1];
                boolean rowDuplicate = false;
                boolean colDuplicate = false;

                for (int j = 0; j < n; j++) {
                    // Check for row duplicates
                    if (!rowDuplicate && rowCheck[matrix[i][j]]) {
                        rowDuplicates++;
                        rowDuplicate = true;
                    }
                    rowCheck[matrix[i][j]] = true;

                    // Check for column duplicates
                    if (!colDuplicate && colCheck[matrix[j][i]]) {
                        colDuplicates++;
                        colDuplicate = true;
                    }
                    colCheck[matrix[j][i]] = true;
                }
            }

            // Output the result for the current test case
            System.out.println("Case #" + testCase + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }

        scanner.close();
    }
}