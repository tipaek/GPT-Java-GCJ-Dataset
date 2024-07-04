import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            int diagonalSum = 0;

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    arr[row][col] = sc.nextInt();
                    if (row == col) {
                        diagonalSum += arr[row][col];
                    }
                }
            }

            int expectedSum = n * (n + 1) / 2;
            int expectedProduct = 1;

            for (int j = 2; j <= n; j++) {
                expectedProduct *= j;
            }

            int invalidRows = 0, invalidCols = 0;

            for (int k = 0; k < n; k++) {
                int rowSum = 0, rowProduct = 1;
                int colSum = 0, colProduct = 1;

                for (int j = 0; j < n; j++) {
                    rowSum += arr[k][j];
                    rowProduct *= arr[k][j];
                    colSum += arr[j][k];
                    colProduct *= arr[j][k];
                }

                if (rowSum != expectedSum || rowProduct != expectedProduct) {
                    invalidRows++;
                }

                if (colSum != expectedSum || colProduct != expectedProduct) {
                    invalidCols++;
                }
            }

            System.out.println("Case #" + i + ": " + diagonalSum + " " + invalidRows + " " + invalidCols);
        }
    }
}