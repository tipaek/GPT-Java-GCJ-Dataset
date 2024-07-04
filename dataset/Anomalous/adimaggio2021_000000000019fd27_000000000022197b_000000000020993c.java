import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();
        
        for (int caseNumber = 0; caseNumber < numberOfCases; caseNumber++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            
            // Reading the matrix
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            // Calculating the trace
            int trace = 0;
            for (int i = 0; i < matrixSize; i++) {
                trace += matrix[i][i];
            }
            
            // Counting rows with duplicate elements
            int rowCountWithDuplicates = 0;
            for (int i = 0; i < matrixSize; i++) {
                if (hasDuplicates(matrix[i])) {
                    rowCountWithDuplicates++;
                }
            }
            
            // Counting columns with duplicate elements
            int colCountWithDuplicates = 0;
            for (int j = 0; j < matrixSize; j++) {
                if (hasDuplicates(getColumn(matrix, j))) {
                    colCountWithDuplicates++;
                }
            }
            
            // Printing the result
            System.out.println("Case #" + (caseNumber + 1) + ": " + trace + " " + rowCountWithDuplicates + " " + colCountWithDuplicates);
        }
        
        scanner.close();
    }

    // Helper method to check for duplicates in an array
    private static boolean hasDuplicates(int[] array) {
        Set<Integer> seen = new HashSet<>();
        for (int value : array) {
            if (!seen.add(value)) {
                return true;
            }
        }
        return false;
    }

    // Helper method to extract a column from a matrix
    private static int[] getColumn(int[][] matrix, int columnIndex) {
        int[] column = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][columnIndex];
        }
        return column;
    }
}