import java.util.Scanner;

public class MatrixAnalysis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            // Reading matrix elements
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            int trace = 0;
            int duplicateRows = 0;
            int duplicateCols = 0;

            // Calculating trace
            for (int i = 0; i < matrixSize; i++) {
                trace += matrix[i][i];
            }

            boolean[] rowChecked = new boolean[matrixSize];
            boolean[] colChecked = new boolean[matrixSize];

            // Checking for duplicate elements in rows and columns
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    // Check for duplicate in current row
                    if (!rowChecked[row]) {
                        for (int nextCol = col + 1; nextCol < matrixSize; nextCol++) {
                            if (matrix[row][col] == matrix[row][nextCol]) {
                                duplicateRows++;
                                rowChecked[row] = true;
                                break;
                            }
                        }
                    }

                    // Check for duplicate in current column
                    if (!colChecked[col]) {
                        for (int nextRow = row + 1; nextRow < matrixSize; nextRow++) {
                            if (matrix[row][col] == matrix[nextRow][col]) {
                                duplicateCols++;
                                colChecked[col] = true;
                                break;
                            }
                        }
                    }
                }
            }

            // Output the results
            System.out.println("Case #" + testCase + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }

        scanner.close();
    }
}