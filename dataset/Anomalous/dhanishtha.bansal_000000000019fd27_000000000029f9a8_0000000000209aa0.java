import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        for (int idx = 1; idx <= testCases; idx++) {
            String[] input = br.readLine().trim().split(" ");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);

            String result = "IMPOSSIBLE";
            boolean possible = false;

            if (n == 2) {
                possible = (k == 2 || k == 4);
            } else if (n == 3) {
                possible = (k == 3 || k == 6 || k == 9);
            } else if (n % 2 != 0) {
                possible = (k >= n + 2 && k <= n * n - 2) || k == n || k == n * n;
            } else {
                possible = (k % 2 == 0 && k >= n + 2 && k <= n * n - 2) || (k % (n / 2) == 0);
            }

            if (possible) {
                result = "POSSIBLE";
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
            double quotient = (double) k / n;
            int value = (int) Math.ceil(quotient);
            int halfK = k / 2;
            int x = halfK / value;

            for (int i = 0; i < x; i++) {
                matrix[i][i] = value;
            }

            int remainingN = n - x;
            int remainingK = k - x * value;

            value--;
            if (remainingK % value != 0) {
                int rest = remainingK - (halfK / (value + 1)) * value;
                for (int i = halfK / (value + 1); i < n - 1; i++) {
                    matrix[i][i] = value;
                }
                matrix[n - 1][n - 1] = rest;
            } else {
                for (int i = halfK / (value + 1); i < n; i++) {
                    matrix[i][i] = value;
                }
            }
        }

        boolean filled = fillMatrix(matrix, n);
        if (filled) {
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
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}