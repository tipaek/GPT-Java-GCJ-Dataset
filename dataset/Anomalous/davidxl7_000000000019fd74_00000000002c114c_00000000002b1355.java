import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int t = 0; t < testCases; t++) {
            System.out.print("Case #" + (t + 1) + ": ");
            solve(scanner);
        }
    }

    public static void solve(Scanner scanner) {
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int totalInterest = 0;
        int currentInterest = 0;
        int[][] grid = new int[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                grid[r][c] = scanner.nextInt();
                currentInterest += grid[r][c];
            }
        }

        boolean[][] removed = new boolean[rows][cols];

        while (true) {
            totalInterest += currentInterest;
            List<Point> toRemove = new ArrayList<>();

            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    if (removed[r][c]) continue;

                    int count = 0;
                    double average = 0;

                    average += getNeighborValue(r + 1, c, rows, cols, grid, removed);
                    if (average > 0) count++;

                    average += getNeighborValue(r - 1, c, rows, cols, grid, removed);
                    if (average > 0) count++;

                    average += getNeighborValue(r, c + 1, rows, cols, grid, removed);
                    if (average > 0) count++;

                    average += getNeighborValue(r, c - 1, rows, cols, grid, removed);
                    if (average > 0) count++;

                    if (count > 0) average /= count;

                    if (grid[r][c] < average) {
                        toRemove.add(new Point(r, c));
                    }
                }
            }

            if (toRemove.isEmpty()) break;

            for (Point point : toRemove) {
                currentInterest -= grid[point.x][point.y];
                removed[point.x][point.y] = true;
            }
        }

        System.out.println(totalInterest);
    }

    private static double getNeighborValue(int r, int c, int rows, int cols, int[][] grid, boolean[][] removed) {
        if (r >= 0 && r < rows && c >= 0 && c < cols && !removed[r][c]) {
            return grid[r][c];
        }
        return 0;
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}