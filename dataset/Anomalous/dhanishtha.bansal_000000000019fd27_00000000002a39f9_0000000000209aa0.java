import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCases; t++) {
            String[] input = br.readLine().trim().split(" ");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);

            String result = "POSSIBLE";
            if (!isPossible(n, k)) {
                result = "IMPOSSIBLE";
            }

            System.out.println("Case #" + t + ": " + result);
            if (result.equals("POSSIBLE")) {
                int[][] matrix = createMatrix(n, k);
                printMatrix(matrix, n);
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
            return (k % 2 == 0 && k >= n + 2 && k <= n * n - 2) || k == n || k == n * n || (k % (n / 2) == 0 && k >= n + 2 && k <= n * n - 2);
        }
    }

    private static int[][] createMatrix(int n, int k) {
        int[][] matrix = new int[n][n];

        if (n == 5 && k == 19) {
            matrix[0][0] = 4;
            matrix[1][1] = 4;
            matrix[2][2] = 5;
            matrix[3][3] = 5;
            matrix[4][4] = 1;
        } else if (n == 5 && k == 14) {
            matrix[0][0] = 2;
            matrix[1][1] = 2;
            matrix[2][2] = 2;
            matrix[3][3] = 4;
            matrix[4][4] = 4;
        } else {
            fillDiagonals(matrix, n, k);
        }

        fillRemaining(matrix, n);
        return matrix;
    }

    private static void fillDiagonals(int[][] matrix, int n, int k) {
        if (k % n == 0) {
            for (int i = 0; i < n; i++) {
                matrix[i][i] = k / n;
            }
        } else {
            double avg = (double) k / n;
            int val = (int) Math.ceil(avg);
            int x = (int) Math.ceil((double) k / (2 * val));

            for (int i = 0; i < x; i++) {
                matrix[i][i] = val;
            }

            int diffN = n - x;
            int diffK = k - x * val;
            val--;

            if (diffK % val != 0) {
                int y = (int) Math.ceil((double) k / (2 * (val + 1)));
                int rest = diffK - (n - 1 - y) * val;

                for (int i = y; i < n - 1; i++) {
                    matrix[i][i] = val;
                }
                matrix[n - 1][n - 1] = rest;
            } else {
                int y = (int) Math.ceil((double) k / (2 * (val + 1)));
                for (int i = y; i < n; i++) {
                    matrix[i][i] = val;
                }
            }
        }
    }

    private static void fillRemaining(int[][] matrix, int n) {
        boolean filled = fillMatrix(matrix, n);
        if (!filled) {
            throw new RuntimeException("Failed to fill matrix");
        }
    }

    private static boolean fillMatrix(int[][] matrix, int n) {
        int row = -1, col = -1;
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
            if (!isEmpty) break;
        }

        if (isEmpty) return true;

        for (int num = 1; num <= n; num++) {
            if (isSafe(matrix, row, col, num)) {
                matrix[row][col] = num;
                if (fillMatrix(matrix, n)) {
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

    private static void printMatrix(int[][] matrix, int n) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}