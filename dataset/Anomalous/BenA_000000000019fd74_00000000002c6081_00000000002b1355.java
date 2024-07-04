import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = Integer.parseInt(scanner.nextLine());

        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            String[] dimensions = scanner.nextLine().split(" ");
            int rows = Integer.parseInt(dimensions[0]);
            int cols = Integer.parseInt(dimensions[1]);
            int[][] matrix = new int[rows][cols];

            for (int row = 0; row < rows; row++) {
                String[] values = scanner.nextLine().split(" ");
                for (int col = 0; col < cols; col++) {
                    matrix[row][col] = Integer.parseInt(values[col]);
                }
            }

            int result = performDance(matrix);
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }

    private static int performDance(int[][] matrix) {
        int[][] nextMatrix = new int[matrix.length][matrix[0].length];
        boolean hasChanges = false;
        int totalSum = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] != 0) {
                    nextMatrix[row][col] = matrix[row][col];
                    totalSum += matrix[row][col];
                    int sumOfNeighbors = 0;
                    int countOfNeighbors = 0;

                    // Check above
                    for (int r = row - 1; r >= 0; r--) {
                        if (matrix[r][col] != 0) {
                            countOfNeighbors++;
                            sumOfNeighbors += matrix[r][col];
                            break;
                        }
                    }

                    // Check below
                    for (int r = row + 1; r < matrix.length; r++) {
                        if (matrix[r][col] != 0) {
                            countOfNeighbors++;
                            sumOfNeighbors += matrix[r][col];
                            break;
                        }
                    }

                    // Check left
                    for (int c = col - 1; c >= 0; c--) {
                        if (matrix[row][c] != 0) {
                            countOfNeighbors++;
                            sumOfNeighbors += matrix[row][c];
                            break;
                        }
                    }

                    // Check right
                    for (int c = col + 1; c < matrix[row].length; c++) {
                        if (matrix[row][c] != 0) {
                            countOfNeighbors++;
                            sumOfNeighbors += matrix[row][c];
                            break;
                        }
                    }

                    if (countOfNeighbors != 0 && (double) sumOfNeighbors / countOfNeighbors > matrix[row][col]) {
                        nextMatrix[row][col] = 0;
                        hasChanges = true;
                    }
                }
            }
        }

        if (hasChanges) {
            return totalSum + performDance(nextMatrix);
        } else {
            return totalSum;
        }
    }
}