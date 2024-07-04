import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = scanner.nextInt();
        
        int[] traceSums = new int[numCases];
        int[] duplicateRows = new int[numCases];
        int[] duplicateColumns = new int[numCases];

        for (int caseIndex = 0; caseIndex < numCases; caseIndex++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            // Read the matrix
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            // Calculate the trace
            for (int i = 0; i < matrixSize; i++) {
                traceSums[caseIndex] += matrix[i][i];
            }

            // Check for duplicate rows
            for (int i = 0; i < matrixSize; i++) {
                boolean hasDuplicate = false;
                for (int j = 0; j < matrixSize; j++) {
                    for (int k = j + 1; k < matrixSize; k++) {
                        if (matrix[i][j] == matrix[i][k]) {
                            duplicateRows[caseIndex]++;
                            hasDuplicate = true;
                            break;
                        }
                    }
                    if (hasDuplicate) break;
                }
            }

            // Check for duplicate columns
            for (int j = 0; j < matrixSize; j++) {
                boolean hasDuplicate = false;
                for (int i = 0; i < matrixSize; i++) {
                    for (int k = i + 1; k < matrixSize; k++) {
                        if (matrix[i][j] == matrix[k][j]) {
                            duplicateColumns[caseIndex]++;
                            hasDuplicate = true;
                            break;
                        }
                    }
                    if (hasDuplicate) break;
                }
            }
        }

        // Print results
        for (int i = 0; i < numCases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + traceSums[i] + " " + duplicateRows[i] + " " + duplicateColumns[i]);
        }

        scanner.close();
    }
}