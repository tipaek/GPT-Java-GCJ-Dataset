import java.util.HashSet;
import java.util.Scanner;

public class Matrix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = 0, duplicateRows = 0, duplicateColumns = 0;

            // Calculate trace
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            // Check for duplicate values in rows
            for (int i = 0; i < n; i++) {
                HashSet<Integer> rowValues = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!rowValues.add(matrix[i][j])) {
                        duplicateRows++;
                        break;
                    }
                }
            }

            // Check for duplicate values in columns
            for (int i = 0; i < n; i++) {
                HashSet<Integer> columnValues = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!columnValues.add(matrix[j][i])) {
                        duplicateColumns++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + caseNumber++ + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }

        scanner.close();
    }
}