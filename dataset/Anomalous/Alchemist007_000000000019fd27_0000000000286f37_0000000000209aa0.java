import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);
    private static int targetTrace;

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int gridSize = scanner.nextInt();
            targetTrace = scanner.nextInt();
            int[][] grid = new int[gridSize][gridSize];
            if (solveSudoku(grid, 0, 0)) {
                System.out.println("Case #" + testCase + ": POSSIBLE");
                printGrid(grid);
            } else {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            }
        }
    }

    private static boolean solveSudoku(int[][] grid, int row, int col) {
        if (col == grid[row].length) {
            row++;
            col = 0;
        }

        if (row == grid.length) {
            return checkTrace(grid);
        }

        if (grid[row][col] == 0) {
            for (int num = 1; num <= grid.length; num++) {
                if (isSafe(grid, row, col, num)) {
                    grid[row][col] = num;
                    if (solveSudoku(grid, row, col + 1)) {
                        return true;
                    }
                    grid[row][col] = 0;
                }
            }
            return false;
        } else {
            return solveSudoku(grid, row, col + 1);
        }
    }

    private static boolean isSafe(int[][] grid, int row, int col, int num) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][col] == num || grid[row][i] == num) {
                return false;
            }
        }
        return true;
    }

    private static void printGrid(int[][] grid) {
        for (int[] row : grid) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    private static boolean checkTrace(int[][] grid) {
        int traceSum = 0;
        for (int i = 0; i < grid.length; i++) {
            traceSum += grid[i][i];
        }
        return traceSum == targetTrace;
    }
}