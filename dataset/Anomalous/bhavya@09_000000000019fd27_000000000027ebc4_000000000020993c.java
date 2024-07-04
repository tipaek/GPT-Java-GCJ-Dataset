import java.util.Scanner;

public class Code4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            // Read the matrix
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
                boolean[] seen = new boolean[n];
                for (int j = 0; j < n; j++) {
                    if (seen[matrix[i][j] - 1]) {
                        repeatedRows++;
                        break;
                    }
                    seen[matrix[i][j] - 1] = true;
                }
            }

            // Calculate columns with repeated elements
            int repeatedColumns = 0;
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[n];
                for (int j = 0; j < n; j++) {
                    if (seen[matrix[j][i] - 1]) {
                        repeatedColumns++;
                        break;
                    }
                    seen[matrix[j][i] - 1] = true;
                }
            }

            // Print the result for the current test case
            System.out.println("Case #" + caseNumber + ": " + trace + " " + repeatedRows + " " + repeatedColumns);
            caseNumber++;
        }

        scanner.close();
    }
}