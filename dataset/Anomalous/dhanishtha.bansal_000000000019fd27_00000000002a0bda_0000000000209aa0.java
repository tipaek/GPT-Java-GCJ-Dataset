import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            String[] input = br.readLine().trim().split(" ");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);

            String result = isPossible(n, k) ? "POSSIBLE" : "IMPOSSIBLE";
            System.out.println("Case #" + testCase + ": " + result);

            if (result.equals("POSSIBLE")) {
                int[][] matrix = generateMatrix(n, k);
                printMatrix(matrix);
            }
        }
    }

    private static boolean isPossible(int n, int k) {
        if (n == 2) {
            return k == 2 || k == 4;
        } else if (n == 3) {
            return k == 3 || k == 6 || k == 9;
        } else if (n % 2 != 0) {
            return (k >= n + 2 && k <= n * n - 2) || k == n || k == n * n;
        } else {
            return (k % 2 == 0 && k >= n + 2 && k <= n * n - 2) || (k % (n / 2) == 0 && k >= n + 2 && k <= n * n - 2);
        }
    }

    private static int[][] generateMatrix(int n, int k) {
        int[][] matrix = new int[n][n];
        if (k % n == 0) {
            for (int i = 0; i < n; i++) {
                matrix[i][i] = k / n;
            }
        } else {
            int val = (int) Math.ceil((double) k / n);
            int half = (int) Math.ceil((double) k / 2.0);
            int x = half / val;

            for (int i = 0; i < x; i++) {
                matrix[i][i] = val;
            }

            int remainingN = n - x;
            int remainingK = k - x * val;
            val--;

            if (remainingK % val != 0) {
                int rest = remainingK - (half / (val + 1)) * val;
                for (int i = half / (val + 1); i < n - 1; i++) {
                    matrix[i][i] = val;
                }
                matrix[n - 1][n - 1] = rest;
            } else {
                for (int i = half / (val + 1); i < n; i++) {
                    matrix[i][i] = val;
                }
            }
        }
        fillMatrix(matrix, n);
        return matrix;
    }

    private static void fillMatrix(int[][] matrix, int n) {
        if (!fillValues(matrix, n)) {
            throw new IllegalStateException("Failed to fill matrix");
        }
    }

    private static boolean fillValues(int[][] matrix, int n) {
        int row = -1;
        int col = -1;
        boolean isEmpty = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row = i;
                    col = j;
                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty) {
                break;
            }
        }

        if (isEmpty) {
            return true;
        }

        for (int num = 1; num <= n; num++) {
            if (isSafe(matrix, row, col, num)) {
                matrix[row][col] = num;
                if (fillValues(matrix, n)) {
                    return true;
                } else {
                    matrix[row][col] = 0;
                }
            }
        }
        return false;
    }

    private static boolean isSafe(int[][] matrix, int row, int col, int num) {
        for (int d = 0; d < matrix.length; d++) {
            if (matrix[row][d] == num || matrix[d][col] == num) {
                return false;
            }
        }
        return true;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}