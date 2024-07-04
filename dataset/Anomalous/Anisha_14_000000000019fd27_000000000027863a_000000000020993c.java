import java.util.Scanner;

class Ques {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        int caseNumber = 1;

        while (testCaseCount > 0) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            // Read the matrix
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            // Calculate the sum of the main diagonal
            int diagonalSum = 0;
            for (int i = 0; i < matrixSize; i++) {
                diagonalSum += matrix[i][i];
            }

            System.out.print("Case #" + caseNumber + ": " + diagonalSum + " ");

            // Track the maximum row and column duplicates
            int maxRowDuplicates = -999999;
            int maxColDuplicates = -999999;

            for (int i = 0; i < matrixSize; i++) {
                int[] rowCounts = new int[matrixSize + 1];
                int[] colCounts = new int[matrixSize + 1];

                for (int j = 0; j < matrixSize; j++) {
                    rowCounts[matrix[i][j]]++;
                    colCounts[matrix[j][i]]++;
                }

                for (int k = 0; k <= matrixSize; k++) {
                    if (rowCounts[k] > maxRowDuplicates) {
                        maxRowDuplicates = rowCounts[k];
                    }
                    if (colCounts[k] > maxColDuplicates) {
                        maxColDuplicates = colCounts[k];
                    }
                }
            }

            // Adjust the counts as per the original logic
            maxRowDuplicates -= 1;
            maxColDuplicates -= 1;

            System.out.print(maxRowDuplicates + " ");
            System.out.print(maxColDuplicates + " ");
            System.out.println();

            testCaseCount--;
            caseNumber++;
        }

        scanner.close();
    }
}