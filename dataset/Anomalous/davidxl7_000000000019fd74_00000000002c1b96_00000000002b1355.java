import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            System.out.print("Case #" + (i + 1) + ": ");
            solve(scanner);
        }
    }

    public static void solve(Scanner scanner) {
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        long totalInterest = 0L;
        long currentInterest = 0L;
        int[][] grid = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = scanner.nextInt();
                currentInterest += grid[i][j];
            }
        }

        boolean[][] removed = new boolean[rows][cols];

        while (true) {
            totalInterest += currentInterest;
            List<Point> toRemove = new ArrayList<>();

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (removed[i][j]) {
                        continue;
                    }

                    int count = 0;
                    double average = 0;

                    for (int x = i + 1; x < rows; x++) {
                        if (!removed[x][j]) {
                            average += grid[x][j];
                            count++;
                            break;
                        }
                    }

                    for (int x = i - 1; x >= 0; x--) {
                        if (!removed[x][j]) {
                            average += grid[x][j];
                            count++;
                            break;
                        }
                    }

                    for (int y = j + 1; y < cols; y++) {
                        if (!removed[i][y]) {
                            average += grid[i][y];
                            count++;
                            break;
                        }
                    }

                    for (int y = j - 1; y >= 0; y--) {
                        if (!removed[i][y]) {
                            average += grid[i][y];
                            count++;
                            break;
                        }
                    }

                    if (count != 0) {
                        average /= count;
                    }

                    if ((double) grid[i][j] < average) {
                        toRemove.add(new Point(i, j));
                    }
                }
            }

            if (toRemove.isEmpty()) {
                break;
            }

            for (Point point : toRemove) {
                currentInterest -= grid[point.x][point.y];
                removed[point.x][point.y] = true;
            }
        }

        System.out.println(totalInterest);
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}