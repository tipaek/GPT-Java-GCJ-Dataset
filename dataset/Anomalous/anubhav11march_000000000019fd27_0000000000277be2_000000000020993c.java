import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            // Read the matrix
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = 0, rowRepeats = 0, colRepeats = 0;

            // Calculate trace, row repeats, and column repeats
            for (int i = 0; i < matrixSize; i++) {
                boolean[] rowSeen = new boolean[matrixSize + 1];
                boolean[] colSeen = new boolean[matrixSize + 1];
                boolean rowDuplicate = false, colDuplicate = false;

                for (int j = 0; j < matrixSize; j++) {
                    // Calculate trace
                    if (i == j) {
                        trace += matrix[i][j];
                    }

                    // Check for row duplicates
                    if (!rowDuplicate) {
                        if (rowSeen[matrix[i][j]]) {
                            rowRepeats++;
                            rowDuplicate = true;
                        } else {
                            rowSeen[matrix[i][j]] = true;
                        }
                    }

                    // Check for column duplicates
                    if (!colDuplicate) {
                        if (colSeen[matrix[j][i]]) {
                            colRepeats++;
                            colDuplicate = true;
                        } else {
                            colSeen[matrix[j][i]] = true;
                        }
                    }
                }
            }

            System.out.println("Case #" + testCase + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }

        scanner.close();
    }
}