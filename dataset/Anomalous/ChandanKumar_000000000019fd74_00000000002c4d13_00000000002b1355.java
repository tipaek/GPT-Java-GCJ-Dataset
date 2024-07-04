import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        int[] results = new int[testCases];

        for (int t = 0; t < testCases; t++) {
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            int[][] grid = new int[rows][cols];

            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    grid[r][c] = scanner.nextInt();
                }
            }

            results[t] = calculateCompetitionSkill(grid, rows, cols);
        }

        for (int t = 0; t < testCases; t++) {
            System.out.printf("Case #%d: %d%n", t + 1, results[t]);
        }
    }

    private static int calculateCompetitionSkill(int[][] grid, int rows, int cols) {
        int totalSkill = 0;

        while (true) {
            int roundSkill = 0;
            List<MatrixIndex> cellsToEliminate = new ArrayList<>();

            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    if (grid[r][c] != -1) {
                        roundSkill += grid[r][c];
                        if (shouldEliminate(grid, r, c, rows, cols)) {
                            cellsToEliminate.add(new MatrixIndex(r, c));
                        }
                    }
                }
            }

            totalSkill += roundSkill;

            if (cellsToEliminate.isEmpty()) {
                break;
            } else {
                for (MatrixIndex cell : cellsToEliminate) {
                    grid[cell.row][cell.col] = -1;
                }
            }
        }
        return totalSkill;
    }

    private static boolean shouldEliminate(int[][] grid, int row, int col, int rows, int cols) {
        int sum = 0;
        int count = 0;

        // Check right
        for (int c = col + 1; c < cols; c++) {
            if (grid[row][c] != -1) {
                sum += grid[row][c];
                count++;
                break;
            }
        }

        // Check left
        for (int c = col - 1; c >= 0; c--) {
            if (grid[row][c] != -1) {
                sum += grid[row][c];
                count++;
                break;
            }
        }

        // Check down
        for (int r = row + 1; r < rows; r++) {
            if (grid[r][col] != -1) {
                sum += grid[r][col];
                count++;
                break;
            }
        }

        // Check up
        for (int r = row - 1; r >= 0; r--) {
            if (grid[r][col] != -1) {
                sum += grid[r][col];
                count++;
                break;
            }
        }

        if (count == 0) {
            return false;
        }

        float average = (float) sum / count;
        return average > grid[row][col];
    }

    private static class MatrixIndex {
        final int row;
        final int col;

        MatrixIndex(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}