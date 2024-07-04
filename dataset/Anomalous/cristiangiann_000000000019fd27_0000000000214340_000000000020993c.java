import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            // Read matrix input
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;

            // Process matrix
            for (int i = 0; i < matrixSize; i++) {
                boolean[] rowCheck = new boolean[matrixSize + 1];
                boolean[] colCheck = new boolean[matrixSize + 1];
                boolean rowHasRepeats = false;
                boolean colHasRepeats = false;

                for (int j = 0; j < matrixSize; j++) {
                    // Check row for repetitions
                    if (rowCheck[matrix[i][j]]) {
                        rowHasRepeats = true;
                    } else {
                        rowCheck[matrix[i][j]] = true;
                    }

                    // Check column for repetitions
                    if (colCheck[matrix[j][i]]) {
                        colHasRepeats = true;
                    } else {
                        colCheck[matrix[j][i]] = true;
                    }
                }

                // Add to trace
                trace += matrix[i][i];

                // Count rows and columns with repetitions
                if (rowHasRepeats) rowRepeats++;
                if (colHasRepeats) colRepeats++;
            }

            // Output result for the current test case
            System.out.println("Case #" + caseNum + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }

        scanner.close();
    }
}