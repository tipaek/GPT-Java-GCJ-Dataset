import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        for (int idx = 1; idx <= testCases; idx++) {
            String[] inputs = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputs[0]);
            int k = Integer.parseInt(inputs[1]);
            StringBuilder result = new StringBuilder();
            boolean possible = false;

            if (n == 2) {
                possible = (k == 2 || k == 4);
            } else if (n == 3) {
                possible = (k == 3 || k == 6 || k == 9);
            } else if (n % 2 != 0) {
                possible = ((k >= n + 2 && k <= n * n - 2) || k == n || k == n * n);
            } else {
                possible = (k % 2 == 0 && k >= n + 2 && k <= n * n - 2) || (k % (n / 2) == 0);
            }

            if (possible) {
                result.append("POSSIBLE");
            } else {
                result.append("IMPOSSIBLE");
            }

            System.out.println("Case #" + idx + ": " + result);

            if (possible) {
                createMatrix(k, n);
            }
        }
    }

    static void createMatrix(int k, int n) {
        int[][] matrix = new int[n][n];

        if (k % n == 0) {
            int value = k / n;
            for (int i = 0; i < n; i++) {
                matrix[i][i] = value;
            }
        } else {
            int val = (int) Math.ceil((double) k / n);
            int x = (int) Math.ceil((double) k / (2 * val));
            for (int i = 0; i < x; i++) {
                matrix[i][i] = val;
            }
            int remainingK = k - x * val;
            val--;

            if (remainingK % val != 0) {
                int rest = remainingK - (k / (val + 1)) * val;
                for (int i = k / (val + 1); i < n - 1; i++) {
                    matrix[i][i] = val;
                }
                matrix[n - 1][n - 1] = rest;
            } else {
                for (int i = k / (val + 1); i < n; i++) {
                    matrix[i][i] = val;
                }
            }
        }

        if (fillMatrix(matrix, n)) {
            printMatrix(matrix, n);
        }
    }

    static boolean isSafe(int[][] matrix, int row, int col, int num) {
        for (int d = 0; d < matrix.length; d++) {
            if (matrix[row][d] == num || matrix[d][col] == num) {
                return false;
            }
        }
        return true;
    }

    static boolean fillMatrix(int[][] matrix, int n) {
        int row = -1, col = -1;
        boolean isEmpty = true;

        for (int i = 0; i < n && isEmpty; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row = i;
                    col = j;
                    isEmpty = false;
                    break;
                }
            }
        }

        if (isEmpty) {
            return true;
        }

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

    static void printMatrix(int[][] matrix, int n) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}