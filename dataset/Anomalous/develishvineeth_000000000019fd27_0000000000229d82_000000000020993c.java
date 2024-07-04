import java.util.Scanner;

public class Solution {
    static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int n = scanner.nextInt();
            int repeatedRows = 0;
            int repeatedColumns = 0;
            int trace = 0;
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            int expectedXorSum = 0;
            for (int i = 1; i <= n; i++) {
                expectedXorSum ^= i;
            }

            for (int i = 0; i < n; i++) {
                int rowXorSum = 0;
                for (int j = 0; j < n; j++) {
                    rowXorSum ^= matrix[i][j];
                }
                if (expectedXorSum != rowXorSum) {
                    repeatedRows++;
                }
            }

            for (int i = 0; i < n; i++) {
                int columnXorSum = 0;
                for (int j = 0; j < n; j++) {
                    columnXorSum ^= matrix[j][i];
                }
                if (expectedXorSum != columnXorSum) {
                    repeatedColumns++;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + repeatedRows + " " + repeatedColumns);
            caseNumber++;
        }
    }
}