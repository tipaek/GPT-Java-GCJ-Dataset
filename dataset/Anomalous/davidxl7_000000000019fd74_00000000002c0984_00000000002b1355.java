import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        
        for (int testCase = 0; testCase < testCaseCount; testCase++) {
            System.out.print("Case #" + (testCase + 1) + ": ");
            processTestCase(scanner);
        }
    }

    private static void processTestCase(Scanner scanner) {
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int totalInterest = 0;
        int tempInterest = 0;
        int[][] grid = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                grid[row][col] = scanner.nextInt();
                tempInterest += grid[row][col];
            }
        }

        totalInterest = tempInterest;

        while (true) {
            List<Point> pointsToRemove = new ArrayList<>();
            
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    if (grid[row][col] == -1) {
                        continue;
                    }
                    
                    int neighborCount = 0;
                    double neighborSum = 0;

                    // Check downward
                    for (int r = row + 1; r < rows; r++) {
                        if (grid[r][col] != -1) {
                            neighborSum += grid[r][col];
                            neighborCount++;
                            break;
                        }
                    }

                    // Check upward
                    for (int r = row - 1; r >= 0; r--) {
                        if (grid[r][col] != -1) {
                            neighborSum += grid[r][col];
                            neighborCount++;
                            break;
                        }
                    }

                    // Check rightward
                    for (int c = col + 1; c < cols; c++) {
                        if (grid[row][c] != -1) {
                            neighborSum += grid[row][c];
                            neighborCount++;
                            break;
                        }
                    }

                    // Check leftward
                    for (int c = col - 1; c >= 0; c--) {
                        if (grid[row][c] != -1) {
                            neighborSum += grid[row][c];
                            neighborCount++;
                            break;
                        }
                    }

                    double avgNeighborValue = neighborSum / neighborCount;
                    if (grid[row][col] < avgNeighborValue) {
                        pointsToRemove.add(new Point(row, col));
                    }
                }
            }

            if (pointsToRemove.isEmpty()) {
                break;
            }

            for (Point point : pointsToRemove) {
                tempInterest -= grid[point.x][point.y];
                grid[point.x][point.y] = -1;
            }

            totalInterest += tempInterest;
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