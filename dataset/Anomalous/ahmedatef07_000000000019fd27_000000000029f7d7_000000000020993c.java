import java.util.BitSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfTestCases = scanner.nextInt();

        for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            // Read matrix
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            // Calculate trace
            int trace = 0;
            for (int i = 0; i < matrixSize; i++) {
                trace += matrix[i][i];
            }

            // Calculate rows with repeated numbers
            int rowsWithRepeats = 0;
            for (int[] row : matrix) {
                BitSet seenNumbers = new BitSet();
                for (int number : row) {
                    if (seenNumbers.get(number)) {
                        rowsWithRepeats++;
                        break;
                    }
                    seenNumbers.set(number);
                }
            }

            // Calculate columns with repeated numbers
            int colsWithRepeats = 0;
            for (int col = 0; col < matrixSize; col++) {
                BitSet seenNumbers = new BitSet();
                for (int row = 0; row < matrixSize; row++) {
                    int number = matrix[row][col];
                    if (seenNumbers.get(number)) {
                        colsWithRepeats++;
                        break;
                    }
                    seenNumbers.set(number);
                }
            }

            // Print result
            System.out.printf("Case #%d: %d %d %d\n", testCase, trace, rowsWithRepeats, colsWithRepeats);
        }
        scanner.close();
    }
}