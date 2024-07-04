import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int matrixSize = scanner.nextInt();
            int key = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int k = (int) Math.sqrt(key);
            int neg = (k - 1 > 0) ? 1 : 0;
            int pos = (k - 1 > 0) ? 0 : 1;

            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    if (i == j) {
                        matrix[i][j] = k;
                    } else if (neg > 0) {
                        matrix[i][j] = k - 1;
                        neg--;
                        if (neg == 0) pos = 2;
                    } else if (pos > 0) {
                        matrix[i][j] = k + 1;
                        pos--;
                        if (pos == 0) neg = 2;
                    }
                }
            }
            checkDiagonalSum(matrix, matrixSize, 0, 0, 0, key, testCase);
        }
        scanner.close();
    }

    public static void checkDiagonalSum(int[][] matrix, int size, int row, int col, int sum, int key, int testCase) {
        if (row < size && col < size) {
            sum += matrix[row][col];
            checkDiagonalSum(matrix, size, row + 1, col + 1, sum, key, testCase);
        } else if (row == size && col == size) {
            if (sum != key) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + testCase + ": POSSIBLE");
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        System.out.print(matrix[i][j] + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
}