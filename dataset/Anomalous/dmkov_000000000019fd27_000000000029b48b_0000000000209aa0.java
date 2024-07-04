import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; ++t) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            
            int[][] matrix = generateMatrix(n, k);
            if (matrix == null) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + t + ": POSSIBLE");
                printMatrix(matrix);
            }
        }
    }

    private static int[][] generateMatrix(int n, int k) {
        boolean[][] rowUsed = new boolean[n][n];
        boolean[][] colUsed = new boolean[n][n];
        int[][] matrix = new int[n][n];
        
        if (solve(0, 0, matrix, rowUsed, colUsed, n, k, 0)) {
            return matrix;
        } else {
            return null;
        }
    }

    private static boolean solve(int row, int col, int[][] matrix, boolean[][] rowUsed, boolean[][] colUsed, int n, int k, int sum) {
        if (row == n) {
            return sum == k;
        }
        if (col == n) {
            return solve(row + 1, 0, matrix, rowUsed, colUsed, n, k, sum);
        }

        for (int num = 1; num <= n; num++) {
            if (!rowUsed[row][num - 1] && !colUsed[col][num - 1]) {
                matrix[row][col] = num;
                rowUsed[row][num - 1] = true;
                colUsed[col][num - 1] = true;
                
                if (solve(row, col + 1, matrix, rowUsed, colUsed, n, k, (row == col) ? sum + num : sum)) {
                    return true;
                }
                
                rowUsed[row][num - 1] = false;
                colUsed[col][num - 1] = false;
            }
        }
        return false;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            StringBuilder sb = new StringBuilder();
            for (int num : row) {
                sb.append(num).append(" ");
            }
            sb.setLength(sb.length() - 1);
            System.out.println(sb.toString());
        }
    }
}