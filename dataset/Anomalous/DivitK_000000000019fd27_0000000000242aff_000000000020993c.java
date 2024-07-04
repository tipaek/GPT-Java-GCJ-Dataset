import java.util.Scanner;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 0; testCase < testCases; testCase++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            int trace = 0;
            for (int i = 0; i < matrixSize; i++) {
                trace += matrix[i][i];
            }

            int duplicateRows = 0;
            for (int row = 0; row < matrixSize; row++) {
                boolean[] seen = new boolean[matrixSize + 1];
                for (int col = 0; col < matrixSize; col++) {
                    if (seen[matrix[row][col]]) {
                        duplicateRows++;
                        break;
                    }
                    seen[matrix[row][col]] = true;
                }
            }

            int duplicateCols = 0;
            for (int col = 0; col < matrixSize; col++) {
                boolean[] seen = new boolean[matrixSize + 1];
                for (int row = 0; row < matrixSize; row++) {
                    if (seen[matrix[row][col]]) {
                        duplicateCols++;
                        break;
                    }
                    seen[matrix[row][col]] = true;
                }
            }

            System.out.println("Case #" + (testCase + 1) + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }

        scanner.close();
    }
}