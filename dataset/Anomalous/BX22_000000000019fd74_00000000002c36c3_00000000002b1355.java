import java.util.*;
import java.io.*;

public class Solution {
    static int totalSum = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; ++i) {
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            int[][] grid = new int[rows][cols];
            int previousSum = 0;

            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    int value = scanner.nextInt();
                    grid[row][col] = value;
                    previousSum += value;
                }
            }

            List<Point> skipList = new ArrayList<>();
            int roundSum = 0;

            do {
                previousSum -= roundSum;
                totalSum += previousSum;
                roundSum = processRound(previousSum, grid, skipList);
            } while (roundSum != 0);

            System.out.println("Case #" + i + ": " + totalSum);
            totalSum = 0;
        }
    }

    public static int processRound(int sum, int[][] grid, List<Point> skipList) {
        List<Point> toRemove = new ArrayList<>();

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] != -1 && !shouldKeep(row, col, grid)) {
                    toRemove.add(new Point(row, col));
                }
            }
        }

        int deductedSum = 0;
        for (Point point : toRemove) {
            deductedSum += grid[point.row][point.col];
            grid[point.row][point.col] = -1;
        }

        return deductedSum;
    }

    public static boolean shouldKeep(int row, int col, int[][] grid) {
        int neighborCount = 0;
        int skillSum = 0;

        // Check above
        for (int i = row - 1; i >= 0; i--) {
            if (grid[i][col] != -1) {
                neighborCount++;
                skillSum += grid[i][col];
                break;
            }
        }

        // Check below
        for (int i = row + 1; i < grid.length; i++) {
            if (grid[i][col] != -1) {
                neighborCount++;
                skillSum += grid[i][col];
                break;
            }
        }

        // Check right
        for (int i = col + 1; i < grid[0].length; i++) {
            if (grid[row][i] != -1) {
                neighborCount++;
                skillSum += grid[row][i];
                break;
            }
        }

        // Check left
        for (int i = col - 1; i >= 0; i--) {
            if (grid[row][i] != -1) {
                neighborCount++;
                skillSum += grid[row][i];
                break;
            }
        }

        if (neighborCount == 0) {
            return true;
        }

        double currentSkill = grid[row][col];
        double averageSkill = (double) skillSum / neighborCount;
        return currentSkill >= averageSkill;
    }

    static class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}