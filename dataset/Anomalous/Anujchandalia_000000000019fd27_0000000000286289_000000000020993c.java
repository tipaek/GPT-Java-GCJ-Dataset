import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int caseNumber = 0;

        while (t-- > 0) {
            caseNumber++;
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0, duplicateRows = 0, duplicateCols = 0;

            // Read matrix and calculate trace
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            // Check for duplicate elements in rows
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    if (seen[matrix[i][j]]) {
                        duplicateRows++;
                        break;
                    }
                    seen[matrix[i][j]] = true;
                }
            }

            // Check for duplicate elements in columns
            for (int j = 0; j < n; j++) {
                boolean[] seen = new boolean[n + 1];
                for (int i = 0; i < n; i++) {
                    if (seen[matrix[i][j]]) {
                        duplicateCols++;
                        break;
                    }
                    seen[matrix[i][j]] = true;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }

        scanner.close();
    }
}