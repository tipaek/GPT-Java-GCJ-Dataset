import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, { -1, 0}};

    public double calculateAverageSkill(double[][] grid, int row, int col) {
        int neighborCount = 0;
        int totalSkill = 0;

        for (int[] direction : DIRECTIONS) {
            int x = row + direction[0];
            int y = col + direction[1];

            while (x >= 0 && y >= 0 && x < grid.length && y < grid[row].length) {
                if (grid[x][y] != 0) {
                    neighborCount++;
                    totalSkill += grid[x][y];
                    break;
                }

                x += direction[0];
                y += direction[1];
            }
        }

        return neighborCount == 0 ? 0 : (double) totalSkill / neighborCount;
    }

    public int calculateScore(double[][] grid) {
        int totalScore = 0;
        boolean updateNeeded = false;

        while (true) {
            totalScore = 0;
            for (double[] row : grid) {
                for (double cell : row) {
                    totalScore += cell;
                }
            }

            HashSet<Integer> cellsToZero = new HashSet<>();
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] != 0) {
                        double avgSkill = calculateAverageSkill(grid, i, j);
                        if (grid[i][j] < avgSkill) {
                            cellsToZero.add(i * grid[i].length + j);
                            updateNeeded = true;
                        }
                    }
                }
            }

            for (int cellIndex : cellsToZero) {
                int x = cellIndex / grid[0].length;
                int y = cellIndex % grid[0].length;
                grid[x][y] = 0;
            }

            if (!updateNeeded) return totalScore;
            updateNeeded = false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            double[][] grid = new double[rows][cols];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    grid[i][j] = scanner.nextDouble();
                }
            }

            int result = new Solution().calculateScore(grid);
            System.out.println("Case #" + testCase + ": " + result);
        }
    }
}