import java.io.*;
import java.util.*;

class Solution {

    private static boolean isValid(int[][] grid, int row, int col, int choice) {
        for (int j = col - 1; j >= 0; j--) {
            if (grid[row][j] == choice) return false;
        }
        for (int i = row - 1; i >= 0; i--) {
            if (grid[i][col] == choice) return false;
        }
        return true;
    }

    private static void printAnswer(int[][] grid, int caseNumber) {
        System.out.println("Case #" + caseNumber + ": POSSIBLE");
        for (int[] row : grid) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    private static boolean foundSolution = false;

    private static void findSolution(int[][] grid, int row, int col, int trace, int caseNumber, int targetTrace) {
        if (row == grid.length && col == 0) {
            if (trace == targetTrace) {
                foundSolution = true;
                printAnswer(grid, caseNumber);
            }
            return;
        }

        if (col == grid[0].length - 1) {
            for (int choice = 1; choice <= grid.length; choice++) {
                if (isValid(grid, row, col, choice)) {
                    grid[row][col] = choice;
                    if (row == col) trace += choice;
                    findSolution(grid, row + 1, 0, trace, caseNumber, targetTrace);
                    if (foundSolution) return;
                    if (row == col) trace -= choice;
                    grid[row][col] = 0;
                }
            }
        } else {
            for (int choice = 1; choice <= grid.length; choice++) {
                if (isValid(grid, row, col, choice)) {
                    grid[row][col] = choice;
                    if (row == col) trace += choice;
                    findSolution(grid, row, col + 1, trace, caseNumber, targetTrace);
                    if (foundSolution) return;
                    if (row == col) trace -= choice;
                    grid[row][col] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            foundSolution = false;
            int gridSize = scanner.nextInt();
            int targetTrace = scanner.nextInt();
            int[][] grid = new int[gridSize][gridSize];

            findSolution(grid, 0, 0, 0, caseNumber, targetTrace);
            if (!foundSolution) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }
        }
    }
}