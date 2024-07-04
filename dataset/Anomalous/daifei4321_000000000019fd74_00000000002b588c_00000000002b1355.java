import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int rows = scanner.nextInt();
            int columns = scanner.nextInt();
            int[][] grid = readGrid(scanner, rows, columns);
            boolean[][] markedForRemoval = new boolean[rows][columns];
            long totalValue = 0;

            while (true) {
                int removalCount = 0;

                for (int r = 0; r < rows; r++) {
                    for (int c = 0; c < columns; c++) {
                        int currentValue = grid[r][c];
                        if (currentValue == 0) continue;

                        int sumAdjacentValues = 0;
                        int adjacentCount = 0;

                        // Check up
                        for (int y = r - 1; y >= 0; y--) {
                            if (grid[y][c] > 0) {
                                sumAdjacentValues += grid[y][c];
                                adjacentCount++;
                                break;
                            }
                        }

                        // Check down
                        for (int y = r + 1; y < rows; y++) {
                            if (grid[y][c] > 0) {
                                sumAdjacentValues += grid[y][c];
                                adjacentCount++;
                                break;
                            }
                        }

                        // Check left
                        for (int x = c - 1; x >= 0; x--) {
                            if (grid[r][x] > 0) {
                                sumAdjacentValues += grid[r][x];
                                adjacentCount++;
                                break;
                            }
                        }

                        // Check right
                        for (int x = c + 1; x < columns; x++) {
                            if (grid[r][x] > 0) {
                                sumAdjacentValues += grid[r][x];
                                adjacentCount++;
                                break;
                            }
                        }

                        if (adjacentCount > 0 && currentValue * adjacentCount < sumAdjacentValues) {
                            markedForRemoval[r][c] = true;
                            removalCount++;
                        }
                    }
                }

                // Add current grid values to totalValue
                for (int r = 0; r < rows; r++) {
                    for (int c = 0; c < columns; c++) {
                        totalValue += grid[r][c];
                    }
                }

                if (removalCount == 0) break;

                // Remove marked cells
                for (int r = 0; r < rows; r++) {
                    for (int c = 0; c < columns; c++) {
                        if (markedForRemoval[r][c]) {
                            grid[r][c] = 0;
                        }
                    }
                }

                // Reset markedForRemoval array
                for (int r = 0; r < rows; r++) {
                    for (int c = 0; c < columns; c++) {
                        markedForRemoval[r][c] = false;
                    }
                }
            }

            System.out.println("CASE #" + (t + 1) + ": " + totalValue);
        }
    }

    private static int[][] readGrid(Scanner scanner, int rows, int columns) {
        int[][] grid = new int[rows][columns];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                grid[r][c] = scanner.nextInt();
            }
        }
        return grid;
    }
}