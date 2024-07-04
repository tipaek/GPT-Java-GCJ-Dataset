import java.math.BigInteger;
import java.util.Scanner;

class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];

            // Read matrix elements
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = sc.nextInt();
                }
            }

            int expectedSum = n * (n + 1) / 2;
            BigInteger expectedFactorial = calculateFactorial(n);

            int validRows = 0, validCols = 0;

            // Check rows and columns
            for (int k = 0; k < n; k++) {
                if (isValid(matrix[k], expectedSum, expectedFactorial)) {
                    validRows++;
                }

                int[] column = new int[n];
                for (int j = 0; j < n; j++) {
                    column[j] = matrix[j][k];
                }

                if (isValid(column, expectedSum, expectedFactorial)) {
                    validCols++;
                }
            }

            // Calculate diagonal sum
            int diagonalSum = 0;
            for (int j = 0; j < n; j++) {
                diagonalSum += matrix[j][j];
            }

            System.out.println("Case #" + i + ": " + diagonalSum + " " + (n - validRows) + " " + (n - validCols));
        }
    }

    private static BigInteger calculateFactorial(int n) {
        BigInteger factorial = BigInteger.ONE;
        for (int i = n; i > 0; i--) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        return factorial;
    }

    private static boolean isValid(int[] array, int expectedSum, BigInteger expectedFactorial) {
        int sum = 0;
        BigInteger factorial = BigInteger.ONE;

        for (int value : array) {
            sum += value;
            factorial = factorial.multiply(BigInteger.valueOf(value));
        }

        return sum == expectedSum && factorial.equals(expectedFactorial);
    }
}