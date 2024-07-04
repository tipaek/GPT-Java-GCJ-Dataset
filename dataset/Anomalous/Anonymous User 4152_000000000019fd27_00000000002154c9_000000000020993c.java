import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int n = scanner.nextInt();
            int trace = 0, rowRepeats = 0, colRepeats = 0;
            int[][] matrix = new int[n][n];

            // Read the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            // Calculate the trace
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            // Check for row repetitions
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[n];
                for (int j = 0; j < n; j++) {
                    if (seen[matrix[i][j] - 1]) {
                        rowRepeats++;
                        break;
                    }
                    seen[matrix[i][j] - 1] = true;
                }
            }

            // Check for column repetitions
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[n];
                for (int j = 0; j < n; j++) {
                    if (seen[matrix[j][i] - 1]) {
                        colRepeats++;
                        break;
                    }
                    seen[matrix[j][i] - 1] = true;
                }
            }

            // Output the result for the current case
            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowRepeats + " " + colRepeats);
            caseNumber++;
        }

        scanner.close();
    }
}