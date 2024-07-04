import java.util.Scanner;
import java.io.IOException;

public class HelloWorld {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();

        for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            // Reading the matrix
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            // Calculating the trace of the matrix
            int trace = 0;
            for (int i = 0; i < matrixSize; i++) {
                trace += matrix[i][i];
            }

            // Counting rows with duplicate elements
            int duplicateRows = 0;
            for (int row = 0; row < matrixSize; row++) {
                boolean hasDuplicate = false;
                outerLoop:
                for (int col1 = 0; col1 < matrixSize; col1++) {
                    for (int col2 = col1 + 1; col2 < matrixSize; col2++) {
                        if (matrix[row][col1] == matrix[row][col2]) {
                            hasDuplicate = true;
                            break outerLoop;
                        }
                    }
                }
                if (hasDuplicate) {
                    duplicateRows++;
                }
            }

            // Counting columns with duplicate elements
            int duplicateColumns = 0;
            for (int col = 0; col < matrixSize; col++) {
                boolean hasDuplicate = false;
                outerLoop:
                for (int row1 = 0; row1 < matrixSize; row1++) {
                    for (int row2 = row1 + 1; row2 < matrixSize; row2++) {
                        if (matrix[row1][col] == matrix[row2][col]) {
                            hasDuplicate = true;
                            break outerLoop;
                        }
                    }
                }
                if (hasDuplicate) {
                    duplicateColumns++;
                }
            }

            // Printing the result for the current case
            System.out.println("Case #" + (caseIndex + 1) + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }

        scanner.close();
    }
}