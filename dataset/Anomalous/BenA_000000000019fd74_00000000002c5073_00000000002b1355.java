import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = Integer.parseInt(scanner.nextLine());

        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            String[] dimensions = scanner.nextLine().split(" ");
            int rows = Integer.parseInt(dimensions[0]);
            int cols = Integer.parseInt(dimensions[1]);
            int[][] grid = new int[rows][cols];

            for (int i = 0; i < rows; i++) {
                String[] rowValues = scanner.nextLine().split(" ");
                for (int j = 0; j < cols; j++) {
                    grid[i][j] = Integer.parseInt(rowValues[j]);
                }
            }

            int result = calculateDanceScore(grid);
            System.out.println("Case #" + caseNum + ": " + result);
        }
    }

    public static int calculateDanceScore(int[][] grid) {
        int[][] nextGrid = new int[grid.length][grid[0].length];
        boolean hasChanges = false;
        int totalScore = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 0) {
                    nextGrid[i][j] = grid[i][j];
                    totalScore += grid[i][j];
                    int sum = 0;
                    int count = 0;

                    // Check upward
                    for (int k = i - 1; k >= 0; k--) {
                        if (grid[k][j] != 0) {
                            count++;
                            sum += grid[k][j];
                            break;
                        }
                    }

                    // Check downward
                    for (int k = i + 1; k < grid.length; k++) {
                        if (grid[k][j] != 0) {
                            count++;
                            sum += grid[k][j];
                            break;
                        }
                    }

                    // Check left
                    for (int k = j - 1; k >= 0; k--) {
                        if (grid[i][k] != 0) {
                            count++;
                            sum += grid[i][k];
                            break;
                        }
                    }

                    // Check right
                    for (int k = j + 1; k < grid[i].length; k++) {
                        if (grid[i][k] != 0) {
                            count++;
                            sum += grid[i][k];
                            break;
                        }
                    }

                    if (count > 0 && (double) sum / count > grid[i][j]) {
                        nextGrid[i][j] = 0;
                        hasChanges = true;
                    }
                }
            }
        }

        if (hasChanges) {
            return totalScore + calculateDanceScore(nextGrid);
        } else {
            return totalScore;
        }
    }
}