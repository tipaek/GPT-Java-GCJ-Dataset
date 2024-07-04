import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseCount = scanner.nextInt();
        int[] results = new int[testCaseCount];

        for (int t = 0; t < testCaseCount; t++) {
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            int[][] grid = new int[rows][cols];

            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    grid[r][c] = scanner.nextInt();
                }
            }

            int totalSkill = 0;

            while (true) {
                int roundSkill = 0;
                List<Coordinate> toEliminate = new ArrayList<>();
                boolean hasEliminations = false;

                for (int r = 0; r < rows; r++) {
                    for (int c = 0; c < cols; c++) {
                        if (grid[r][c] != -1) {
                            roundSkill += grid[r][c];
                            if (shouldEliminate(grid, r, c, rows, cols)) {
                                toEliminate.add(new Coordinate(r, c));
                                hasEliminations = true;
                            }
                        }
                    }
                }

                totalSkill += roundSkill;

                for (Coordinate coord : toEliminate) {
                    grid[coord.row][coord.col] = -1;
                }

                if (!hasEliminations) {
                    break;
                }
            }

            results[t] = totalSkill;
        }

        for (int t = 0; t < testCaseCount; t++) {
            System.out.printf("Case #%d: %d%n", t + 1, results[t]);
        }
    }

    private static boolean shouldEliminate(int[][] grid, int row, int col, int rows, int cols) {
        int sum = 0;
        int count = 0;

        // Check above
        for (int r = row - 1; r >= 0; r--) {
            if (grid[r][col] != -1) {
                sum += grid[r][col];
                count++;
                break;
            }
        }
        // Check below
        for (int r = row + 1; r < rows; r++) {
            if (grid[r][col] != -1) {
                sum += grid[r][col];
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
        // Check right
        for (int c = col + 1; c < cols; c++) {
            if (grid[row][c] != -1) {
                sum += grid[row][c];
                count++;
                break;
            }
        }

        if (count == 0) {
            return false;
        } else {
            double average = (double) sum / count;
            return average > grid[row][col];
        }
    }

    private static class Coordinate {
        final int row;
        final int col;

        Coordinate(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}