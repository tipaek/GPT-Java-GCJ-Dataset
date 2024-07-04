import java.util.Scanner;

public class Vestigium {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;
            int rowCount = 0;
            int colCount = 0;
            long expectedSum = n * (n + 1L) / 2;

            for (int i = 0; i < n; i++) {
                int rowSum = 0;
                boolean[] rowCheck = new boolean[n + 1];

                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    rowSum += matrix[i][j];
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    if (rowCheck[matrix[i][j]]) {
                        rowCount++;
                        break;
                    }
                    rowCheck[matrix[i][j]] = true;
                }

                if (rowSum != expectedSum) {
                    rowCount++;
                }
            }

            for (int j = 0; j < n; j++) {
                int colSum = 0;
                boolean[] colCheck = new boolean[n + 1];

                for (int i = 0; i < n; i++) {
                    colSum += matrix[i][j];
                    if (colCheck[matrix[i][j]]) {
                        colCount++;
                        break;
                    }
                    colCheck[matrix[i][j]] = true;
                }

                if (colSum != expectedSum) {
                    colCount++;
                }
            }

            System.out.println("Case #" + testCase + ": " + trace + " " + rowCount + " " + colCount);
        }
        scanner.close();
    }
}