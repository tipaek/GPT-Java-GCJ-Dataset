import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public double getAvgSkill(double[][] grid, int m, int n) {
        int neighbors = 0;
        double totalSkill = 0;

        for (int[] dir : DIRECTIONS) {
            int x = m + dir[0];
            int y = n + dir[1];

            while (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length) {
                if (grid[x][y] != 0) {
                    neighbors++;
                    totalSkill += grid[x][y];
                    break;
                }

                x += dir[0];
                y += dir[1];
            }
        }

        return neighbors == 0 ? 0 : totalSkill / neighbors;
    }

    public int getScore(double[][] grid) {
        int result = 0;

        while (true) {
            boolean hasChanges = false;
            HashSet<Integer> markZero = new HashSet<>();

            for (double[] row : grid) {
                for (double cell : row) {
                    result += cell;
                }
            }

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] != 0) {
                        double avgSkill = getAvgSkill(grid, i, j);
                        if (grid[i][j] < avgSkill) {
                            markZero.add(i * grid[i].length + j);
                            hasChanges = true;
                        }
                    }
                }
            }

            for (int pos : markZero) {
                int x = pos / grid[0].length;
                int y = pos % grid[0].length;
                grid[x][y] = 0;
            }

            if (!hasChanges) {
                return result;
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int ks = 1; ks <= T; ks++) {
            int rows = input.nextInt();
            int cols = input.nextInt();
            double[][] grid = new double[rows][cols];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    grid[i][j] = input.nextDouble();
                }
            }

            int result = new Solution().getScore(grid);
            System.out.println("Case #" + ks + ": " + result);
        }
        input.close();
    }
}