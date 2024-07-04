import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int temp = testCases;

        while (testCases-- > 0) {
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            int[][] grid = new int[rows][cols];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    grid[i][j] = scanner.nextInt();
                }
            }

            int previousIterationSum = -1;
            int currentIterationSum = 0;
            int totalSum = 0;
            ArrayList<Integer> indicesToRemove = new ArrayList<>();

            while (previousIterationSum != currentIterationSum) {
                indicesToRemove.clear();
                previousIterationSum = currentIterationSum;
                currentIterationSum = 0;

                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        if (grid[i][j] != -1) {
                            currentIterationSum += grid[i][j];
                        }
                    }
                }

                if (previousIterationSum == currentIterationSum) {
                    break;
                }

                totalSum += currentIterationSum;

                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        if (grid[i][j] == -1) {
                            continue;
                        }

                        int sum = 0;
                        int count = 0;

                        // Check right
                        for (int k = j + 1; k < cols; k++) {
                            if (grid[i][k] != -1) {
                                sum += grid[i][k];
                                count++;
                                break;
                            }
                        }

                        // Check left
                        for (int k = j - 1; k >= 0; k--) {
                            if (grid[i][k] != -1) {
                                sum += grid[i][k];
                                count++;
                                break;
                            }
                        }

                        // Check down
                        for (int k = i + 1; k < rows; k++) {
                            if (grid[k][j] != -1) {
                                sum += grid[k][j];
                                count++;
                                break;
                            }
                        }

                        // Check up
                        for (int k = i - 1; k >= 0; k--) {
                            if (grid[k][j] != -1) {
                                sum += grid[k][j];
                                count++;
                                break;
                            }
                        }

                        if (count > 0 && (float) grid[i][j] < (float) sum / count) {
                            indicesToRemove.add(i);
                            indicesToRemove.add(j);
                        }
                    }
                }

                for (int i = 0; i < indicesToRemove.size(); i += 2) {
                    grid[indicesToRemove.get(i)][indicesToRemove.get(i + 1)] = -1;
                }
            }

            System.out.println("Case #" + (temp - testCases) + ": " + totalSum);
        }
    }
}