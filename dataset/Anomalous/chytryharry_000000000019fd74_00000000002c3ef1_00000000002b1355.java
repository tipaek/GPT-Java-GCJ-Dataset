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
            for (int j = 0; j < rows; j++) {
                for (int k = 0; k < columns; k++) {
                    matrix[j][k] = scanner.nextInt();
                }
            }
            System.out.println("Case #" + i + ": " + calculateInterest(matrix, rows, columns));
        }
    }

    private static int calculateInterest(int[][] matrix, int rows, int columns) {
        int[][] tempMatrix = new int[rows][columns];
        for (int j = 0; j < rows; j++) {
            System.arraycopy(matrix[j], 0, tempMatrix[j], 0, columns);
        }

        boolean gameEnded = false;
        int interestLevel = 0;

        while (!gameEnded) {
            boolean unchanged = true;
            boolean[] cellStatus = new boolean[rows * columns];
            for (int i = 0; i < rows * columns; i++) {
                cellStatus[i] = true;
            }

            for (int j = 0; j < rows; j++) {
                for (int k = 0; k < columns; k++) {
                    if (matrix[j][k] == -1) {
                        continue;
                    }
                    int neighbors = 0;
                    int sum = 0;

                    // Check right neighbor
                    for (int tempIdx = k + 1; tempIdx < columns; tempIdx++) {
                        if (matrix[j][tempIdx] != -1) {
                            sum += matrix[j][tempIdx];
                            neighbors++;
                            break;
                        }
                    }

                    // Check left neighbor
                    for (int tempIdx = k - 1; tempIdx >= 0; tempIdx--) {
                        if (matrix[j][tempIdx] != -1) {
                            sum += matrix[j][tempIdx];
                            neighbors++;
                            break;
                        }
                    }

                    // Check upper neighbor
                    for (int tempIdx = j - 1; tempIdx >= 0; tempIdx--) {
                        if (matrix[tempIdx][k] != -1) {
                            sum += matrix[tempIdx][k];
                            neighbors++;
                            break;
                        }
                    }

                    // Check lower neighbor
                    for (int tempIdx = j + 1; tempIdx < rows; tempIdx++) {
                        if (matrix[tempIdx][k] != -1) {
                            sum += matrix[tempIdx][k];
                            neighbors++;
                            break;
                        }
                    }

                    double average = (neighbors != 0) ? (double) sum / neighbors : 0;
                    interestLevel += matrix[j][k];
                    if (matrix[j][k] < average) {
                        tempMatrix[j][k] = -1;
                        cellStatus[j * columns + k] = false;
                    }
                }
            }

            for (boolean status : cellStatus) {
                if (!status) {
                    unchanged = false;
                    break;
                }
            }

            matrix = tempMatrix;
            gameEnded = unchanged;
        }

        return interestLevel;
    }
}