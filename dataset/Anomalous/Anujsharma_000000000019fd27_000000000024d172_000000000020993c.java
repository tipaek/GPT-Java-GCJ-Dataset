import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = sc.nextInt();
                }
            }

            int expectedSum = (n * (n + 1)) / 2;
            long expectedProduct = 1;
            for (int num = 1; num <= n; num++) {
                expectedProduct *= num;
            }

            int validRows = 0, validCols = 0;

            for (int index = 0; index < n; index++) {
                int rowSum = 0, colSum = 0;
                long rowProduct = 1, colProduct = 1;

                for (int col = 0; col < n; col++) {
                    rowSum += matrix[index][col];
                    rowProduct *= matrix[index][col];
                }

                for (int row = 0; row < n; row++) {
                    colSum += matrix[row][index];
                    colProduct *= matrix[row][index];
                }

                if (rowSum == expectedSum && rowProduct == expectedProduct) {
                    validRows++;
                }

                if (colSum == expectedSum && colProduct == expectedProduct) {
                    validCols++;
                }
            }

            int mainDiagonalSum = 0;
            for (int diag = 0; diag < n; diag++) {
                mainDiagonalSum += matrix[diag][diag];
            }

            System.out.println("Case #" + i + ": " + mainDiagonalSum + " " + (n - validRows) + " " + (n - validCols));
        }
    }
}