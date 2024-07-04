import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int initialTestCases = testCases;

        while (testCases-- > 0) {
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            int[][] matrix = new int[rows][cols];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int previousIterationSum = -1;
            int currentIterationSum = 0;
            int totalSum = 0;

            while (previousIterationSum != currentIterationSum) {
                previousIterationSum = currentIterationSum;
                currentIterationSum = 0;

                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        if (matrix[i][j] != -1) {
                            currentIterationSum += matrix[i][j];
                        }
                    }
                }

                if (previousIterationSum == currentIterationSum) {
                    break;
                }

                totalSum += currentIterationSum;
                List<int[]> indicesToRemove = new ArrayList<>();

                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        if (matrix[i][j] == -1) continue;

                        int sum = 0;
                        int count = 0;

                        // Right
                        for (int k = j + 1; k < cols; k++) {
                            if (matrix[i][k] != -1) {
                                sum += matrix[i][k];
                                count++;
                                break;
                            }
                        }

                        // Left
                        for (int k = j - 1; k >= 0; k--) {
                            if (matrix[i][k] != -1) {
                                sum += matrix[i][k];
                                count++;
                                break;
                            }
                        }

                        // Down
                        for (int k = i + 1; k < rows; k++) {
                            if (matrix[k][j] != -1) {
                                sum += matrix[k][j];
                                count++;
                                break;
                            }
                        }

                        // Up
                        for (int k = i - 1; k >= 0; k--) {
                            if (matrix[k][j] != -1) {
                                sum += matrix[k][j];
                                count++;
                                break;
                            }
                        }

                        if (count > 0 && matrix[i][j] < (float) sum / count) {
                            indicesToRemove.add(new int[]{i, j});
                        }
                    }
                }

                for (int[] index : indicesToRemove) {
                    matrix[index[0]][index[1]] = -1;
                }
            }

            System.out.println("Case #" + (initialTestCases - testCases) + ": " + totalSum);
        }
    }
}