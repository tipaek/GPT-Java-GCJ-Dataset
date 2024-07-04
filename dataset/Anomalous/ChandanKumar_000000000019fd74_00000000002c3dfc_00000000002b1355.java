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
                        grid[cell.getRow()][cell.getCol()] = -1;
                    }
                }
            }

            results[t] = totalSkill;
        }

        for (int t = 0; t < testCases; t++) {
            System.out.printf("Case #%d: %d%n", t + 1, results[t]);
        }
    }

    private static boolean shouldEliminate(int[][] grid, int row, int col, int totalRows, int totalCols) {
        int sum = 0;
        int count = 0;

        for (int r = row + 1; r < totalRows; r++) {
            if (grid[r][col] != -1) {
                sum += grid[r][col];
                count++;
                break;
            }
        }

        for (int r = row - 1; r >= 0; r--) {
            if (grid[r][col] != -1) {
                sum += grid[r][col];
                count++;
                break;
            }
        }

        for (int c = col + 1; c < totalCols; c++) {
            if (grid[row][c] != -1) {
                sum += grid[row][c];
                count++;
                break;
            }
        }

        for (int c = col - 1; c >= 0; c--) {
            if (grid[row][c] != -1) {
                sum += grid[row][c];
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
        private final int row;
        private final int col;

        public MatrixIndex(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }
    }
}