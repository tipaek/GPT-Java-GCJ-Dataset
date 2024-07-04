import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int target = in.nextInt();
            String result = "IMPOSSIBLE";
            int[][] grid = new int[n][n];

            if (solve(grid, target, 0, 0)) {
                result = "POSSIBLE";
                System.out.println("Case #" + i + ": " + result);
                printGrid(grid);
            } else {
                System.out.println("Case #" + i + ": " + result);
            }
        }
    }

    private static boolean solve(int[][] grid, int target, int currentSum, int index) {
        int n = grid.length;
        if (index == n * n && target == currentSum) {
            return true;
        }
        if (index == n * n || target <= currentSum) {
            return false;
        }

        int row = index / n;
        int col = index % n;

        for (int num = 1; num <= n; num++) {
            if (isValid(grid, target, currentSum, num, index)) {
                grid[row][col] = num;
                if (row == col) {
                    currentSum += num;
                }
                if (solve(grid, target, currentSum, index + 1)) {
                    return true;
                }
                if (row == col) {
                    currentSum -= num;
                }
                grid[row][col] = 0;
            }
        }
        return false;
    }

    private static boolean isValid(int[][] grid, int target, int currentSum, int num, int index) {
        int n = grid.length;
        int row = index / n;
        int col = index % n;

        for (int i = 0; i < n; i++) {
            if (grid[row][i] == num || grid[i][col] == num) {
                return false;
            }
        }

        return row != col || target >= currentSum + num;
    }

    private static void printGrid(int[][] grid) {
        for (int[] row : grid) {
            for (int i = 0; i < row.length; i++) {
                if (i > 0) {
                    System.out.print(" ");
                }
                System.out.print(row[i]);
            }
            System.out.println();
        }
    }
}