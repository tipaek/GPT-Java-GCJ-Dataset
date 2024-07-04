import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, { -1, 0}};

    public double getAvgSkill(double[][] grid, int m, int n) {
        int neighbors = 0;
        double totalSkill = 0;

        for (int[] direction : DIRECTIONS) {
            int x = m + direction[0];
            int y = n + direction[1];
            int p = m;
            int q = n;

            while (x >= 0 && y >= 0 && x < grid.length && y < grid[m].length) {
                if (grid[x][y] != 0) {
                    neighbors++;
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

        return neighbors == 0 ? 0 : totalSkill / neighbors;
    }

    public int getScore(double[][] grid) {
        int result = 0;
        boolean go;

        while (true) {
            for (double[] row : grid) {
                for (double cell : row) {
                    result += cell;
                }
            }

            HashSet<Integer> markZero = new HashSet<>();
            go = false;

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] != 0) {
                        double avgSkill = getAvgSkill(grid, i, j);
                        if (grid[i][j] < avgSkill) {
                            markZero.add(i * grid[i].length + j);
                            go = true;
                        }
                    }
                }
            }

            for (int pos : markZero) {
                int x = pos / grid[0].length;
                int y = pos % grid[0].length;
                grid[x][y] = 0;
            }

            if (!go) {
                return result;
            }

            result = 0; // Reset result for the next iteration
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int ks = 1; ks <= T; ks++) {
            int r = input.nextInt();
            int c = input.nextInt();

            double[][] grid = new double[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    grid[i][j] = input.nextDouble();
                }
            }

            int result = new Solution().getScore(grid);
            System.out.println("Case #" + ks + ": " + result);
        }
    }
}