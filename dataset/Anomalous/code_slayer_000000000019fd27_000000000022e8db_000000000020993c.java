import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases > 0) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int rowRepeats = 0;
            // Check for duplicate elements in rows
            for (int i = 0; i < n; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        rowRepeats++;
                        break;
                    }
                }
            }

            int colRepeats = 0;
            // Check for duplicate elements in columns
            for (int j = 0; j < n; j++) {
                HashSet<Integer> colSet = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        colRepeats++;
                        break;
                    }
                }
            }

            int diagonalSum = 0;
            // Calculate the sum of the main diagonal
            for (int i = 0; i < n; i++) {
                diagonalSum += matrix[i][i];
            }

            // Print the result for the current test case
            System.out.printf("Case #%d: %d %d %d%n", caseNumber, diagonalSum, rowRepeats, colRepeats);

            testCases--;
            caseNumber++;
        }
    }
}