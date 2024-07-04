import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int caseCount = input.nextInt();
        int[][] results = new int[caseCount][4];

        for (int caseIndex = 0; caseIndex < caseCount; caseIndex++) {
            int matrixSize = input.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int trace = 0;

            // Read matrix values
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = input.nextInt();
                }
            }

            // Calculate trace
            for (int i = 0; i < matrixSize; i++) {
                trace += matrix[i][i];
            }

            int rowDuplicates = 0;
            int colDuplicates = 0;

            // Calculate row and column duplicates
            for (int i = 0; i < matrixSize; i++) {
                rowDuplicates += countRowDuplicates(matrix, matrixSize, i);
                colDuplicates += countColumnDuplicates(matrix, matrixSize, i);
            }

            results[caseIndex][0] = caseIndex + 1;
            results[caseIndex][1] = trace;
            results[caseIndex][2] = rowDuplicates;
            results[caseIndex][3] = colDuplicates;
        }

        // Print results
        for (int[] result : results) {
            System.out.println("Case #" + result[0] + ": " + result[1] + " " + result[2] + " " + result[3]);
        }
    }

    private static int countRowDuplicates(int[][] matrix, int size, int row) {
        int duplicates = 0;
        for (int j = 0; j < size; j++) {
            for (int k = j + 1; k < size; k++) {
                if (matrix[row][j] == matrix[row][k]) {
                    duplicates++;
                    return duplicates;
                }
            }
        }
        return duplicates;
    }

    private static int countColumnDuplicates(int[][] matrix, int size, int col) {
        int duplicates = 0;
        for (int j = 0; j < size; j++) {
            for (int k = j + 1; k < size; k++) {
                if (matrix[j][col] == matrix[k][col]) {
                    duplicates++;
                    return duplicates;
                }
            }
        }
        return duplicates;
    }
}