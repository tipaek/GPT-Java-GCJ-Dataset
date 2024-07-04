import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new Solution().run();
    }

    private void run() {
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            solve(t);
        }
    }

    private void solve(int testCaseNumber) {
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int[][] grid = new int[rows][cols];

        // Read grid input
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }

        int totalSum = 0;
        boolean hasElimination;

        do {
            hasElimination = false;
            int[][] tempGrid = new int[rows][cols];

            // Calculate the sum of all elements in the grid
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    totalSum += grid[i][j];
                }
            }

            // Copy the grid to a temporary grid
            for (int i = 0; i < rows; i++) {
                tempGrid[i] = Arrays.copyOf(grid[i], cols);
            }

            // Eliminate elements based on the neighbor conditions
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (tempGrid[i][j] == 0) continue;

                    int sumNeighbors = 0;
                    int neighborCount = 0;

                    // Check upward
                    int k = i - 1;
                    while (k >= 0 && tempGrid[k][j] == 0) k--;
                    if (k >= 0) {
                        sumNeighbors += tempGrid[k][j];
                        neighborCount++;
                    }

                    // Check downward
                    k = i + 1;
                    while (k < rows && tempGrid[k][j] == 0) k++;
                    if (k < rows) {
                        sumNeighbors += tempGrid[k][j];
                        neighborCount++;
                    }

                    // Check left
                    k = j - 1;
                    while (k >= 0 && tempGrid[i][k] == 0) k--;
                    if (k >= 0) {
                        sumNeighbors += tempGrid[i][k];
                        neighborCount++;
                    }

                    // Check right
                    k = j + 1;
                    while (k < cols && tempGrid[i][k] == 0) k++;
                    if (k < cols) {
                        sumNeighbors += tempGrid[i][k];
                        neighborCount++;
                    }

                    // Eliminate the element if it satisfies the condition
                    if (neighborCount > 0 && sumNeighbors > neighborCount * tempGrid[i][j]) {
                        hasElimination = true;
                        grid[i][j] = 0;
                    }
                }
            }
        } while (hasElimination);

        System.out.printf("Case #%d: %d%n", testCaseNumber, totalSum);
    }
}