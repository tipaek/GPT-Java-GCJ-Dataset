import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, { -1, 0}};

    private double calculateAverageSkill(int[][] grid, int row, int col) {
        int neighbors = 0;
        int totalSkill = 0;

        for (int[] direction : DIRECTIONS) {
            int x = row + direction[0];
            int y = col + direction[1];
            int p = row;
            int q = col;

            while (x >= 0 && y >= 0 && x < grid.length && y < grid[row].length) {
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

        return neighbors == 0 ? 0 : (double) totalSkill / neighbors;
    }

    private int calculateScore(int[][] grid) {
        int totalScore = 0;
        boolean hasChanges;

        do {
            hasChanges = false;
            totalScore += sumGrid(grid);
            HashSet<Integer> cellsToZero = new HashSet<>();

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] != 0) {
                        double avgSkill = calculateAverageSkill(grid, i, j);
                        if (grid[i][j] < avgSkill) {
                            cellsToZero.add(i * grid[i].length + j);
                            hasChanges = true;
                        }
                    }
                }
            }

            for (int cell : cellsToZero) {
                int x = cell / grid[0].length;
                int y = cell % grid[0].length;
                grid[x][y] = 0;
            }

        } while (hasChanges);

        return totalScore;
    }

    private int sumGrid(int[][] grid) {
        int sum = 0;
        for (int[] row : grid) {
            for (int cell : row) {
                sum += cell;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int testCases = input.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int rows = input.nextInt();
            int cols = input.nextInt();
            int[][] grid = new int[rows][cols];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    grid[i][j] = input.nextInt();
                }
            }

            Solution solution = new Solution();
            int result = solution.calculateScore(grid);
            System.out.println("Case #" + testCase + ": " + result);
        }
        input.close();
    }
}