import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    private final Scanner in = new Scanner(System.in);

    private void solve(int testCaseNumber) {
        int rows = in.nextInt(), cols = in.nextInt();
        int[][] grid = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = in.nextInt();
            }
        }

        long totalSum = 0;

        while (true) {
            boolean hasElimination = false;
            int[][] tempGrid = new int[rows][cols];

            for (int i = 0; i < rows; i++) {
                totalSum += Arrays.stream(grid[i]).sum();
                tempGrid[i] = Arrays.copyOf(grid[i], cols);
            }

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (tempGrid[i][j] == 0) continue;

                    int sum = 0;
                    int neighbors = 0;

                    // Check upward
                    for (int k = i - 1; k >= 0 && tempGrid[k][j] == 0; k--);
                    if (k >= 0) {
                        sum += tempGrid[k][j];
                        neighbors++;
                    }

                    // Check downward
                    for (int k = i + 1; k < rows && tempGrid[k][j] == 0; k++);
                    if (k < rows) {
                        sum += tempGrid[k][j];
                        neighbors++;
                    }

                    // Check left
                    for (int k = j - 1; k >= 0 && tempGrid[i][k] == 0; k--);
                    if (k >= 0) {
                        sum += tempGrid[i][k];
                        neighbors++;
                    }

                    // Check right
                    for (int k = j + 1; k < cols && tempGrid[i][k] == 0; k++);
                    if (k < cols) {
                        sum += tempGrid[i][k];
                        neighbors++;
                    }

                    if (neighbors > 0 && sum > neighbors * tempGrid[i][j]) {
                        hasElimination = true;
                        grid[i][j] = 0;
                    }
                }
            }

            if (!hasElimination) break;
        }

        System.out.printf("Case #%d: %d%n", testCaseNumber, totalSum);
    }

    private void run() {
        int testCases = in.nextInt();
        for (int t = 1; t <= testCases; t++) {
            solve(t);
        }
    }

    public static void main(String[] args) {
        new Solution().run();
    }
}