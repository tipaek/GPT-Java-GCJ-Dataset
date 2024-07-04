import java.util.Scanner;
import java.io.IOException;

public class HelloWorld {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseIndex = 1; caseIndex <= testCases; caseIndex++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            // Fill the matrix
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            // Calculate the trace of the matrix
            int trace = 0;
            for (int i = 0; i < matrixSize; i++) {
                trace += matrix[i][i];
            }

            // Calculate the number of rows with duplicate elements
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

            // Calculate the number of columns with duplicate elements
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

            System.out.println("Case #" + caseIndex + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }

        scanner.close();
    }
}