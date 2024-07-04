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

            boolean possible = false;
            int[][] matrix = null;
            for (List<Integer> diagonal : diagonals(n, k, n, 1)) {
                matrix = createMatrix(n, diagonal);
                possible = fill(matrix, 0, 0);
                if (possible) break;
            }

            System.out.println("Case #" + test + ": " + (possible ? "" : "IM") + "POSSIBLE");
            if (possible) print(matrix);
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

    private static List<List<Integer>> diagonals(int n, int k, int count, int min) {
        if (n * count < k || count > k) return new LinkedList<>();
        if (count == 1) {
            return k >= min ? Collections.singletonList(Collections.singletonList(k)) : new LinkedList<>();
        }
        List<List<Integer>> result = new LinkedList<>();
        for (int i = min; i <= n; i++) {
            List<List<Integer>> diagonals = diagonals(n, k - i, count - 1, i);
            for (List<Integer> d : diagonals) {
                if (d.size() == count - 1) {
                    List<Integer> newD = new LinkedList<>();
                    newD.add(i);
                    newD.addAll(d);
                    result.add(newD);
                }
            }
        }

        return result;
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
