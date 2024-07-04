import java.util.Arrays;
import java.util.Scanner;

public class Vestigium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int n = scanner.nextInt();
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;
            int[][] matrix = new int[n][n];

            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            // Calculating the trace
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            // Checking for row duplicates
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[n];
                for (int j = 0; j < n; j++) {
                    if (seen[matrix[i][j] - 1]) {
                        rowDuplicates++;
                        break;
                    }
                    seen[matrix[i][j] - 1] = true;
                }
            }

            // Checking for column duplicates
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[n];
                for (int j = 0; j < n; j++) {
                    if (seen[matrix[j][i] - 1]) {
                        colDuplicates++;
                        break;
                    }
                    seen[matrix[j][i] - 1] = true;
                }
            }

            // Printing the result
            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
            caseNumber++;
        }
    }
}