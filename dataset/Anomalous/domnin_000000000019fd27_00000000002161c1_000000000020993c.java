import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;
        
        while (testCases-- > 0) {
            int matrixSize = scanner.nextInt();
            int rowDuplicates = 0, colDuplicates = 0, trace = 0;

            int[][] matrix = new int[matrixSize][matrixSize];
            
            // Reading the matrix and calculating the trace
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                }
            }
            
            // Checking for duplicate values in rows
            for (int row = 0; row < matrixSize; row++) {
                Set<Integer> uniqueValues = new HashSet<>();
                for (int col = 0; col < matrixSize; col++) {
                    uniqueValues.add(matrix[row][col]);
                }
                if (uniqueValues.size() < matrixSize) {
                    rowDuplicates++;
                }
            }
            
            // Checking for duplicate values in columns
            for (int col = 0; col < matrixSize; col++) {
                Set<Integer> uniqueValues = new HashSet<>();
                for (int row = 0; row < matrixSize; row++) {
                    uniqueValues.add(matrix[row][col]);
                }
                if (uniqueValues.size() < matrixSize) {
                    colDuplicates++;
                }
            }

            System.out.println("Case #" + caseNumber++ + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
        
        scanner.close();
    }
}