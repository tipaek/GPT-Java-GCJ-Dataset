import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseIndex = 0; caseIndex < testCases; caseIndex++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }
            
            int[] result = analyzeMatrix(matrix);
            System.out.println("Case #" + (caseIndex + 1) + ": " + result[0] + " " + result[1] + " " + result[2]);
        }
    }

    private static int[] analyzeMatrix(int[][] matrix) {
        int[] result = new int[3];
        int matrixSize = matrix.length;
        
        // Calculate the trace of the matrix
        for (int i = 0; i < matrixSize; i++) {
            result[0] += matrix[i][i];
        }

        // Check for duplicate values in rows
        for (int row = 0; row < matrixSize; row++) {
            boolean[] seen = new boolean[matrixSize];
            for (int col = 0; col < matrixSize; col++) {
                int value = matrix[row][col] - 1;
                if (seen[value]) {
                    result[1]++;
                    break;
                }
                seen[value] = true;
            }
        }

        // Check for duplicate values in columns
        for (int col = 0; col < matrixSize; col++) {
            boolean[] seen = new boolean[matrixSize];
            for (int row = 0; row < matrixSize; row++) {
                int value = matrix[row][col] - 1;
                if (seen[value]) {
                    result[2]++;
                    break;
                }
                seen[value] = true;
            }
        }

        return result;
    }
}