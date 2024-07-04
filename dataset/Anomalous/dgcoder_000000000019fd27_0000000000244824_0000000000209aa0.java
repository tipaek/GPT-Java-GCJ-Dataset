import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            String[] temp = br.readLine().split(" ");
            int N = Integer.parseInt(temp[0]);
            int K = Integer.parseInt(temp[1]);
            int[][] matrix = new int[N][N];

            boolean isPossible = generateMatrix(matrix, 0, 0, K);

            System.out.format("Case #%d: %s\n", t, isPossible ? "POSSIBLE" : "IMPOSSIBLE");
            if (isPossible) {
                printMatrix(matrix);
            }
        }
        br.close();
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.print(row[0]);
            for (int i = 1; i < row.length; i++) {
                System.out.print(" " + row[i]);
            }
            System.out.println();
        }
    }

    private static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static boolean generateMatrix(int[][] matrix, int row, int col, int targetTrace) {
        for (int val = 1; val <= matrix.length; val++) {
            if (!isPlacementValid(matrix, val, row, col)) continue;

            matrix[row][col] = val;
            boolean isValid;
            if (col + 1 < matrix.length) {
                isValid = generateMatrix(matrix, row, col + 1, targetTrace);
            } else if (row + 1 < matrix.length) {
                isValid = generateMatrix(matrix, row + 1, 0, targetTrace);
            } else {
                isValid = calculateTrace(matrix) == targetTrace;
            }

            if (isValid) {
                return true;
            } else {
                matrix[row][col] = 0;
            }
        }
        return false;
    }

    private static boolean isPlacementValid(int[][] matrix, int value, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (matrix[i][col] == value) return false;
        }
        for (int i = 0; i < col; i++) {
            if (matrix[row][i] == value) return false;
        }
        return true;
    }
}