import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int targetXor = 0;

            for (int i = 0; i < n; i++) {
                targetXor ^= (i + 1);
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            int mainDiagonalSum = 0;
            for (int i = 0; i < n; i++) {
                mainDiagonalSum += matrix[i][i];
            }

            int rowMismatchCount = 0;
            for (int i = 0; i < n; i++) {
                int rowXor = 0;
                for (int j = 0; j < n; j++) {
                    rowXor ^= matrix[i][j];
                }
                if (rowXor != targetXor) {
                    rowMismatchCount++;
                }
            }

            int columnMismatchCount = 0;
            for (int i = 0; i < n; i++) {
                int columnXor = 0;
                for (int j = 0; j < n; j++) {
                    columnXor ^= matrix[j][i];
                }
                if (columnXor != targetXor) {
                    columnMismatchCount++;
                }
            }

            System.out.println("Case #" + (t + 1) + ": " + mainDiagonalSum + " " + rowMismatchCount + " " + columnMismatchCount);
        }

        sc.close();
    }
}