import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }
            Result result = new Checker(n, matrix).computeResult();
            System.out.printf("Case #%d: %d %d %d%n", i, result.sum, result.invalidRows, result.invalidCols);
        }
    }

    static class Checker {
        private final int[][] matrix;
        private final int size;

        Checker(int size, int[][] matrix) {
            this.size = size;
            this.matrix = matrix;
        }

        Result computeResult() {
            int diagonalSum = 0;
            BigInteger[] columnBits = new BigInteger[size];
            BigInteger[] rowBits = new BigInteger[size];
            for (int i = 0; i < size; i++) {
                columnBits[i] = BigInteger.ZERO;
                rowBits[i] = BigInteger.ZERO;
            }

            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    int value = matrix[row][col];
                    columnBits[row] = columnBits[row].setBit(value);
                    rowBits[col] = rowBits[col].setBit(value);
                    if (row == col) {
                        diagonalSum += value;
                    }
                }
            }

            int invalidRows = 0;
            int invalidCols = 0;
            BigInteger expectedBits = BigInteger.valueOf(2).pow(size + 1).subtract(BigInteger.TWO);

            for (int i = 0; i < size; i++) {
                if (!columnBits[i].equals(expectedBits)) {
                    invalidRows++;
                }
                if (!rowBits[i].equals(expectedBits)) {
                    invalidCols++;
                }
            }

            return new Result(diagonalSum, invalidRows, invalidCols);
        }
    }

    static class Result {
        final int sum;
        final int invalidRows;
        final int invalidCols;

        Result(int sum, int invalidRows, int invalidCols) {
            this.sum = sum;
            this.invalidRows = invalidRows;
            this.invalidCols = invalidCols;
        }
    }
}