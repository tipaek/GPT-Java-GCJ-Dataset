import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        for (int i = 1; i <= t; ++i) {
            int nMatrix = scanner.nextInt();
            int kTrace = scanner.nextInt();
            int[][] latinMatrix = createLatinMatrix(nMatrix);
            if (isTracePossible(latinMatrix, kTrace)) {
                System.out.printf("Case #%d: POSSIBLE%n", i);
                printMatrix(latinMatrix);
            } else {
                rotateMatrix(latinMatrix);
                if (isTracePossible(latinMatrix, kTrace)) {
                    System.out.printf("Case #%d: POSSIBLE%n", i);
                    printMatrix(latinMatrix);
                } else {
                    System.out.printf("Case #%d: IMPOSSIBLE%n", i);
                }
            }
        }
    }

    private static int[][] createLatinMatrix(int n) {
        int[][] matrix = new int[n][n];
        int k = n + 1;

        for (int row = 0; row < n; row++) {
            int col = 0;
            int temp = k;

            while (temp <= n) {
                matrix[row][col++] = temp++;
            }

            for (int j = 1; j < k; j++) {
                matrix[row][col++] = j;
            }

            k--;
        }

        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int elem : row) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }

    private static void rotateMatrix(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }

    private static boolean isTracePossible(int[][] matrix, int trace) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum == trace;
    }
}