import java.util.Scanner;

public class Vestigium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
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

            // Counting rows with repeated elements
            int rowCount = 0;
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    if (seen[matrix[i][j]]) {
                        rowCount++;
                        break;
                    }
                    seen[matrix[i][j]] = true;
                }
            }

            // Counting columns with repeated elements
            int colCount = 0;
            for (int j = 0; j < n; j++) {
                boolean[] seen = new boolean[n + 1];
                for (int i = 0; i < n; i++) {
                    if (seen[matrix[i][j]]) {
                        colCount++;
                        break;
                    }
                    seen[matrix[i][j]] = true;
                }
            }

            // Printing the result for the current test case
            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowCount + " " + colCount);
        }

        scanner.close();
    }
}