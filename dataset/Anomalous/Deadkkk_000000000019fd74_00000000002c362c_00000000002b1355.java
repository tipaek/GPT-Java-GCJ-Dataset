import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        int[][] matrix;
        int[] results = new int[testCases];

        for (int t = 0; t < testCases; t++) {
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            matrix = new int[rows][cols];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            results[t] = processMatrix(rows, cols, 0, matrix);
        }

        for (int t = 0; t < testCases; t++) {
            System.out.println("Case #" + (t + 1) + ": " + results[t]);
        }
    }

    private static int processMatrix(int rows, int cols, int sum, int[][] matrix) {
        int[][] newMatrix = new int[rows][cols];
        boolean isLastRound = true;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] > 0) {
                    List<Integer> neighbors = new ArrayList<>();
                    sum += matrix[i][j];

                    addNeighbor(neighbors, getUp(i, j, matrix));
                    addNeighbor(neighbors, getLeft(i, j, matrix));
                    addNeighbor(neighbors, getDown(i, j, rows, matrix));
                    addNeighbor(neighbors, getRight(i, j, cols, matrix));

                    if (calculateAverage(neighbors) > matrix[i][j]) {
                        isLastRound = false;
                        newMatrix[i][j] = 0;
                    } else {
                        newMatrix[i][j] = matrix[i][j];
                    }
                }
            }
        }

        if (isLastRound) {
            return sum;
        }

        return processMatrix(rows, cols, sum, newMatrix);
    }

    private static void addNeighbor(List<Integer> neighbors, int value) {
        if (value > 0) {
            neighbors.add(value);
        }
    }

    private static float calculateAverage(List<Integer> values) {
        float sum = 0;
        int count = 0;

        for (int value : values) {
            sum += value;
            if (value > 0) {
                count++;
            }
        }

        return count == 0 ? 0 : sum / count;
    }

    private static int getUp(int row, int col, int[][] matrix) {
        for (int i = row - 1; i >= 0; i--) {
            if (matrix[i][col] > 0) {
                return matrix[i][col];
            }
        }
        return 0;
    }

    private static int getDown(int row, int col, int rows, int[][] matrix) {
        for (int i = row + 1; i < rows; i++) {
            if (matrix[i][col] > 0) {
                return matrix[i][col];
            }
        }
        return 0;
    }

    private static int getLeft(int row, int col, int[][] matrix) {
        for (int i = col - 1; i >= 0; i--) {
            if (matrix[row][i] > 0) {
                return matrix[row][i];
            }
        }
        return 0;
    }

    private static int getRight(int row, int col, int cols, int[][] matrix) {
        for (int i = col + 1; i < cols; i++) {
            if (matrix[row][i] > 0) {
                return matrix[row][i];
            }
        }
        return 0;
    }
}