import java.util.Scanner;

public class MatrixTrace {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases > 0) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n + 1][n + 1];
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            // Reading matrix and calculating trace
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            // Checking for repeated elements in rows
            for (int i = 1; i <= n; i++) {
                boolean[] seen = new boolean[n + 1];
                for (int j = 1; j <= n; j++) {
                    if (seen[matrix[i][j]]) {
                        rowRepeats++;
                        break;
                    }
                    seen[matrix[i][j]] = true;
                }
            }

            // Checking for repeated elements in columns
            for (int i = 1; i <= n; i++) {
                boolean[] seen = new boolean[n + 1];
                for (int j = 1; j <= n; j++) {
                    if (seen[matrix[j][i]]) {
                        colRepeats++;
                        break;
                    }
                    seen[matrix[j][i]] = true;
                }
            }

            // Printing result for the current test case
            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowRepeats + " " + colRepeats);
            testCases--;
            caseNumber++;
        }
        scanner.close();
    }
}