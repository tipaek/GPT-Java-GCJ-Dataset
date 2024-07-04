import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Vestigium {
    public static void main(String[] args) throws IOException {
        File inputFile = new File(args[0]);
        Scanner scanner = new Scanner(inputFile);

        int numberOfTestCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
            int matrixSize = scanner.nextInt();
            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;
            int[][] matrix = new int[matrixSize][matrixSize];

            // Read the matrix and calculate the trace
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            // Calculate the number of rows with repeated elements
            for (int i = 0; i < matrixSize; i++) {
                boolean[] seen = new boolean[matrixSize + 1];
                for (int j = 0; j < matrixSize; j++) {
                    if (seen[matrix[i][j]]) {
                        rowRepeats++;
                        break;
                    }
                    seen[matrix[i][j]] = true;
                }
            }

            // Calculate the number of columns with repeated elements
            for (int j = 0; j < matrixSize; j++) {
                boolean[] seen = new boolean[matrixSize + 1];
                for (int i = 0; i < matrixSize; i++) {
                    if (seen[matrix[i][j]]) {
                        colRepeats++;
                        break;
                    }
                    seen[matrix[i][j]] = true;
                }
            }

            System.out.printf("Case #%d: %d %d %d\n", testCase, trace, rowRepeats, colRepeats);
        }

        scanner.close();
    }
}