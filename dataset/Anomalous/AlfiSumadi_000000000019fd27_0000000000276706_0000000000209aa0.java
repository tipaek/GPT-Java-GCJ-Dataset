import java.util.*;
import java.io.*;

public class Solution {
    static Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        long t = sc.nextLong();
        for (int x = 1; x <= t; x++) {
            solve(x);
        }
    }

    private static void solve(long caseNumber) {
        int n = sc.nextInt();
        int k = sc.nextInt();
        boolean possible = false;

        int[][] matrix = new int[n][n];
        initializeMatrix(matrix, n);

        Random random = new Random();
        int attempts = 0;
        while (trace(matrix) != k && attempts < 1000) {
            shuffleMatrix(matrix, n, random);
            if (trace(matrix) == k) {
                possible = true;
                break;
            }
            attempts++;
        }

        if (possible) {
            System.out.println("Case #" + caseNumber + ": POSSIBLE");
            printMatrix(matrix);
        } else {
            System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
        }
    }

    private static void initializeMatrix(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    matrix[i][j] = 1;
                } else if (j > i) {
                    matrix[i][j] = n - j + 1 + i;
                } else {
                    matrix[i][j] = 1 + i - j;
                }
            }
        }
    }

    private static long trace(int[][] matrix) {
        long sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private static void shuffleMatrix(int[][] matrix, int n, Random random) {
        int randX1 = random.nextInt(n);
        int randY1 = random.nextInt(n);
        swapRows(matrix, randX1, randY1);

        int randX2 = random.nextInt(n);
        int randY2 = random.nextInt(n);
        swapColumns(matrix, randX2, randY2);
    }

    private static void swapRows(int[][] matrix, int row1, int row2) {
        int[] temp = matrix[row1];
        matrix[row1] = matrix[row2];
        matrix[row2] = temp;
    }

    private static void swapColumns(int[][] matrix, int col1, int col2) {
        for (int i = 0; i < matrix.length; i++) {
            int temp = matrix[i][col1];
            matrix[i][col1] = matrix[i][col2];
            matrix[i][col2] = temp;
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}