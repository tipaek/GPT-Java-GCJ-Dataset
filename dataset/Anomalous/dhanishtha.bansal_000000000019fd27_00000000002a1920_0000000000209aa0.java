import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        for (int idx = 1; idx <= testCases; idx++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            String result = isPossible(n, k) ? "POSSIBLE" : "IMPOSSIBLE";
            System.out.println("Case #" + idx + ": " + result);

            if (result.equals("POSSIBLE")) {
                int[][] matrix = createMatrix(k, n);
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
            return (k % 2 == 0 && k >= n + 2 && k <= (n * n) - 2) ||
                   (k % (n / 2) == 0 && k >= n + 2 && k <= (n * n) - 2);
        }
    }

    private static int[][] createMatrix(int k, int n) {
        int[][] mat = new int[n][n];
        if (k % n == 0) {
            int val = k / n;
            for (int i = 0; i < n; i++) {
                mat[i][i] = val;
            }
        } else {
            double c = (double) k / n;
            int mult = (int) Math.ceil(c) * n;
            int val = mult / n;
            double half = (double) k / 2.0;
            int x = (int) Math.ceil(half / val);

            for (int i = 0; i < x; i++) {
                mat[i][i] = val;
            }

            int diffN = n - x;
            int diffK = k - x * val;

            val -= 1;
            if (diffK % val != 0) {
                int y = (int) Math.ceil(half / (val + 1));
                int rest = diffK - (int) (half / (val + 1)) * val;
                for (int i = (int) half / (val + 1); i < n - 1; i++) {
                    mat[i][i] = val;
                }
                mat[n - 1][n - 1] = rest;
            } else {
                int y = (int) Math.ceil(half / (val + 1));
                for (int i = y; i < n; i++) {
                    mat[i][i] = val;
                }
            }
        }
        fillMatrix(mat, n, k);
        return mat;
    }

    private static boolean isSafe(int[][] mat, int row, int col, int num) {
        for (int d = 0; d < mat.length; d++) {
            if (mat[row][d] == num || mat[d][col] == num) {
                return false;
            }
        }
        return true;
    }

    private static boolean fillMatrix(int[][] mat, int n, int k) {
        int row = -1;
        int col = -1;
        boolean isEmpty = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
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
            if (isSafe(mat, row, col, num)) {
                mat[row][col] = num;
                if (fillMatrix(mat, n, k)) {
                    return true;
                } else {
                    mat[row][col] = 0;
                }
            }
        }
        return false;
    }

    private static void printMatrix(int[][] mat) {
        for (int[] row : mat) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}