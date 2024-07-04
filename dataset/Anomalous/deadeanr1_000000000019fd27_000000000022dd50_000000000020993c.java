import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; ++testCase) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            boolean[] visited = new boolean[matrixSize];
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            // Read matrix and calculate trace
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
                trace += matrix[i][i];
            }

            // Check for repeated elements in columns
            for (int col = 0; col < matrixSize; col++) {
                Arrays.fill(visited, false);
                for (int row = 0; row < matrixSize; row++) {
                    int value = matrix[row][col] - 1;
                    if (visited[value]) {
                        colRepeats++;
                        break;
                    }
                    visited[value] = true;
                }
            }

            // Check for repeated elements in rows
            for (int row = 0; row < matrixSize; row++) {
                Arrays.fill(visited, false);
                for (int col = 0; col < matrixSize; col++) {
                    int value = matrix[row][col] - 1;
                    if (visited[value]) {
                        rowRepeats++;
                        break;
                    }
                    visited[value] = true;
                }
            }

            // Print result for the current test case
            System.out.println("Case #" + testCase + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }
}