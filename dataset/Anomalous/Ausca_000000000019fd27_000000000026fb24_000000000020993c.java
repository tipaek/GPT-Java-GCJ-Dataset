import java.util.Scanner;
import java.io.PrintWriter;

public class Vestigium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter writer = new PrintWriter(System.out);
        int testCases = scanner.nextInt();
        int[] seen = new int[101];
        int currentTestCase = testCases;

        while (currentTestCase-- > 0) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            // Read the matrix
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;

            // Calculate the trace
            for (int i = 0; i < matrixSize; i++) {
                trace += matrix[i][i];
            }

            // Check for repeated numbers in rows
            for (int row = 0; row < matrixSize; row++) {
                boolean hasRepetition = false;
                for (int col = 0; col < matrixSize; col++) {
                    if (seen[matrix[row][col]] == sentinel) {
                        hasRepetition = true;
                        break;
                    }
                    seen[matrix[row][col]] = sentinel;
                }
                if (hasRepetition) {
                    rowRepeats++;
                }
                sentinel++;
            }

            // Check for repeated numbers in columns
            for (int col = 0; col < matrixSize; col++) {
                boolean hasRepetition = false;
                for (int row = 0; row < matrixSize; row++) {
                    if (seen[matrix[row][col]] == sentinel) {
                        hasRepetition = true;
                        break;
                    }
                    seen[matrix[row][col]] = sentinel;
                }
                if (hasRepetition) {
                    colRepeats++;
                }
                sentinel++;
            }

            // Output the result
            writer.printf("Case #%d: %d %d %d%n", testCases - currentTestCase, trace, rowRepeats, colRepeats);
        }

        writer.flush();
    }

    static int sentinel = 1;
}