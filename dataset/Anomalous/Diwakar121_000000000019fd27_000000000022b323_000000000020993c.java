import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int requiredXOR = computeXOR(n);
            int rowCount = 0, colCount = 0, trace = 0;

            // Input matrix and calculate trace and row XORs
            for (int i = 0; i < n; i++) {
                int rowXOR = 0;
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    rowXOR ^= matrix[i][j];
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
                if (rowXOR != requiredXOR) {
                    rowCount++;
                }
            }

            // Calculate column XORs
            for (int j = 0; j < n; j++) {
                int colXOR = 0;
                for (int i = 0; i < n; i++) {
                    colXOR ^= matrix[i][j];
                }
                if (colXOR != requiredXOR) {
                    colCount++;
                }
            }

            System.out.println("Case #" + testCase + ": " + trace + " " + rowCount + " " + colCount);
        }

        scanner.close();
    }

    public static int computeXOR(int n) {
        switch (n % 4) {
            case 0: return n;
            case 1: return 1;
            case 2: return n + 1;
            default: return 0;
        }
    }
}