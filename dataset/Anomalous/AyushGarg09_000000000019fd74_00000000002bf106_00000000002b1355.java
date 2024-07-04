import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, { -1, 0}};

    public double calculateAverageSkill(int[][] grid, int row, int col) {
        int neighborCount = 0;
        int totalSkill = 0;

        for (int[] dir : DIRECTIONS) {
            int x = row + dir[0];
            int y = col + dir[1];
            int p = row;
            int q = col;

            while (x >= 0 && y >= 0 && x < grid.length && y < grid[row].length) {
                if (grid[x][y] != 0) {
                    neighborCount++;
                    totalSkill += grid[x][y];
                    break;
                }

                if (x == p - 1) {
                    p = x;
                    x--;
                } else if (x == p + 1) {
                    p = x;
                    x++;
                } else if (y == q - 1) {
                    q = y;
                    y--;
                } else if (y == q + 1) {
                    q = y;
                    y++;
                }
            }
        }

        return neighborCount == 0 ? 0 : (double) totalSkill / neighborCount;
    }

    public int calculateScore(int[][] grid) {
        int score = 0;
        boolean shouldContinue = false;
        HashSet<Integer> cellsToZero = new HashSet<>();

        while (true) {
            for (int[] row : grid) {
                for (int cell : row) {
                    score += cell;
                }
            }

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] != 0) {
                        double averageSkill = calculateAverageSkill(grid, i, j);
                        if (grid[i][j] < averageSkill) {
                            cellsToZero.add(i * grid[i].length + j);
                            shouldContinue = true;
                        }
                    }
                }
            }

            for (int cell : cellsToZero) {
                int x = cell / grid[0].length;
                int y = cell % grid[0].length;
                grid[x][y] = 0;
            }

            if (!shouldContinue) {
                return score;
            }
            shouldContinue = false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            int[][] grid = new int[rows][cols];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    grid[i][j] = scanner.nextInt();
                }
            }

            int result = new Solution().calculateScore(grid);
            System.out.println("Case #" + testCase + ": " + result);
        }

        scanner.close();
    }
}