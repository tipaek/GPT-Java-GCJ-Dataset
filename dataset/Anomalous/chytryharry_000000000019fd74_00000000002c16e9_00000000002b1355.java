import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; ++i) {
            int rows = scanner.nextInt();
            int columns = scanner.nextInt();
            int[][] matrix = new int[rows][columns];
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < columns; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }
            System.out.println("Case #" + i + ": " + calculateInterest(matrix, rows, columns));
        }
    }

    private static int calculateInterest(int[][] matrix, int rows, int columns) {
        int[][] tempMatrix = new int[rows][columns];
        copyMatrix(matrix, tempMatrix, rows, columns);

        boolean gameEnded = false;
        int interestLevel = 0;

        while (!gameEnded) {
            gameEnded = true;
            boolean[] cellChecks = new boolean[rows * columns];
            for (int i = 0; i < rows * columns; i++) {
                cellChecks[i] = true;
            }

            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < columns; col++) {
                    if (matrix[row][col] == -1) {
                        continue;
                    }

                    int sum = 0;
                    int neighbors = 0;

                    // Check right
                    for (int tempCol = col + 1; tempCol < columns; tempCol++) {
                        if (matrix[row][tempCol] != -1) {
                            sum += matrix[row][tempCol];
                            neighbors++;
                            break;
                        }
                    }

                    // Check left
                    for (int tempCol = col - 1; tempCol >= 0; tempCol--) {
                        if (matrix[row][tempCol] != -1) {
                            sum += matrix[row][tempCol];
                            neighbors++;
                            break;
                        }
                    }

                    // Check up
                    for (int tempRow = row - 1; tempRow >= 0; tempRow--) {
                        if (matrix[tempRow][col] != -1) {
                            sum += matrix[tempRow][col];
                            neighbors++;
                            break;
                        }
                    }

                    // Check down
                    for (int tempRow = row + 1; tempRow < rows; tempRow++) {
                        if (matrix[tempRow][col] != -1) {
                            sum += matrix[tempRow][col];
                            neighbors++;
                            break;
                        }
                    }

                    double average = neighbors > 0 ? (double) sum / neighbors : 0;
                    interestLevel += matrix[row][col];

                    if (matrix[row][col] < average) {
                        tempMatrix[row][col] = -1;
                        cellChecks[row * columns + col] = false;
                    }
                }
            }

            for (boolean check : cellChecks) {
                if (!check) {
                    gameEnded = false;
                    break;
                }
            }

            copyMatrix(tempMatrix, matrix, rows, columns);
        }

        return interestLevel;
    }

    private static void copyMatrix(int[][] source, int[][] destination, int rows, int columns) {
        for (int row = 0; row < rows; row++) {
            System.arraycopy(source[row], 0, destination[row], 0, columns);
        }
    }
}