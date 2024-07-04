import java.util.Scanner;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            long diagonalSum = 0;

            // Reading matrix and calculating diagonal sum
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                }
            }

            long repeatedRows = 0;
            long repeatedCols = 0;
            int[] rowCheck = new int[n];
            int[] colCheck = new int[n];

            // Checking for repeated elements in rows
            for (int i = 0; i < n; i++) {
                Arrays.fill(rowCheck, 0);
                for (int j = 0; j < n; j++) {
                    rowCheck[matrix[i][j] - 1]++;
                    if (rowCheck[matrix[i][j] - 1] > 1) {
                        repeatedRows++;
                        break;
                    }
                }
            }

            // Checking for repeated elements in columns
            for (int i = 0; i < n; i++) {
                Arrays.fill(colCheck, 0);
                for (int j = 0; j < n; j++) {
                    colCheck[matrix[j][i] - 1]++;
                    if (colCheck[matrix[j][i] - 1] > 1) {
                        repeatedCols++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + caseNumber + ": " + diagonalSum + " " + repeatedRows + " " + repeatedCols);
            caseNumber++;
        }

        scanner.close();
    }
}