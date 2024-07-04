import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = scan.nextInt();
        for (int test = 1; test <= tests; test++) {
            int n = scan.nextInt();
            int k = scan.nextInt();

            List<Integer> diagonal = findDiagonal(n , k);
            if (diagonal == null)
                System.out.println("Case #" + test + ": " + "IMPOSSIBLE");
            else {
                int[][] matrix = createMatrix(n, diagonal);
                boolean possible = fill(matrix, 0, 0);
                System.out.println("Case #" + test + ": " + (possible ? "" : "IM") + "POSSIBLE");
                if (possible) print(matrix);
            }
        }
    }

    private static void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }


    private static List<Integer> findDiagonal(int n, int k) {
        if (n < 4 && k % n != 0) return null;
        if (k == n + 1 || k == n * n - 1) return null;
        int avg = k / n;
        List<Integer> diagonal = new ArrayList<>();
        for (int i = 0; i < n - 2; i++) {
            diagonal.add(avg);
        }
        if (k % n == 0) {
            diagonal.add(avg);
            diagonal.add(avg);
        } else {
            int rest = k - (n - 2) * avg;
            if (avg != 1) {
                diagonal.add(1);
                diagonal.add(rest - 1);
            } else {
                diagonal.add(2);
                diagonal.add(rest - 2);
            }
        }
        return diagonal;
    }

    private static int[][] createMatrix(int n, List<Integer> diagonal) {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            matrix[i][i] = diagonal.get(i);
        }
        return matrix;
    }

    private static boolean fill(int[][] matrix, int row, int col) {
        if (row == col) {
            if (row == matrix.length - 1) return true;
            else return fill(matrix, row, col + 1);
        } else {
            boolean[] taken = new boolean[matrix.length + 1];
            for (int i = 0; i < row; i++) {
                taken[matrix[i][col]] = true;
            }
            for (int i = 0; i < col; i++) {
                taken[matrix[row][i]] = true;
            }
            taken[matrix[col][col]] = true;
            taken[matrix[row][row]] = true;

            for (int i = 1; i < taken.length; i++) {
                if (!taken[i]) {
                    matrix[row][col] = i;
                    int nextRow = col == matrix.length - 1 ? row + 1 : row;
                    int nextCol = (col + 1) % matrix.length;
                    boolean success = fill(matrix, nextRow, nextCol);
                    if (success) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
