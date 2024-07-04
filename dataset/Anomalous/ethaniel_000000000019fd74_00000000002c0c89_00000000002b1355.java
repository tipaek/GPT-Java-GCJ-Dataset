import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SquareDance {
    public static void main(String[] args) throws IOException {
        BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(cin.readLine());

        for (int t = 1; t <= T; t++) {
            String[] dimensions = cin.readLine().split(" ");
            int rows = Integer.parseInt(dimensions[0]);
            int cols = Integer.parseInt(dimensions[1]);
            int[][] grid = new int[rows][cols];

            for (int i = 0; i < rows; i++) {
                String[] nums = cin.readLine().split(" ");
                for (int j = 0; j < cols; j++) {
                    grid[i][j] = Integer.parseInt(nums[j]);
                }
            }

            System.out.println("Case #" + t + ": " + calculateInterest(grid));
        }
    }

    public static int calculateInterest(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int totalInterest = 0;
        int previousTotal = -1;
        int cumulativeInterest = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (previousTotal != totalInterest) {
            ArrayList<int[]> toRemove = new ArrayList<>();
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    int neighborCount = 0;
                    double neighborSum = 0;
                    for (int[] dir : directions) {
                        int newRow = r + dir[0];
                        int newCol = c + dir[1];
                        boolean found = false;
                        while (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                            if (grid[newRow][newCol] != 0) {
                                found = true;
                                break;
                            }
                            newRow += dir[0];
                            newCol += dir[1];
                        }
                        if (found) {
                            neighborCount++;
                            neighborSum += grid[newRow][newCol];
                        }
                    }

                    if (neighborCount > 0 && grid[r][c] < neighborSum / neighborCount) {
                        toRemove.add(new int[]{r, c});
                    }
                }
            }

            int currentSum = 0;
            for (int[] row : grid) {
                for (int value : row) {
                    currentSum += value;
                }
            }
            cumulativeInterest += totalInterest;
            previousTotal = totalInterest;
            totalInterest = currentSum;

            for (int[] cell : toRemove) {
                grid[cell[0]][cell[1]] = 0;
            }
        }

        return cumulativeInterest;
    }
}