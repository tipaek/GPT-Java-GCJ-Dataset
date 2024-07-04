import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalCases = scanner.nextInt();
        
        for (int caseIndex = 1; caseIndex <= totalCases; caseIndex++) {
            System.out.print("Case #" + caseIndex + ": ");
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            
            // Read the matrix
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }
            
            int diagonalSum = 0;
            int repeatedRows = 0;
            int repeatedCols = 0;
            
            // Calculate the sum of the diagonal
            for (int i = 0; i < matrixSize; i++) {
                diagonalSum += matrix[i][i];
            }
            
            // Check for repeated elements in rows
            for (int row = 0; row < matrixSize; row++) {
                Set<Integer> uniqueElements = new HashSet<>();
                boolean hasRepetition = false;
                
                for (int col = 0; col < matrixSize; col++) {
                    if (!uniqueElements.add(matrix[row][col])) {
                        hasRepetition = true;
                    }
                }
                
                if (hasRepetition) {
                    repeatedRows++;
                }
            }
            
            // Check for repeated elements in columns
            for (int col = 0; col < matrixSize; col++) {
                Set<Integer> uniqueElements = new HashSet<>();
                boolean hasRepetition = false;
                
                for (int row = 0; row < matrixSize; row++) {
                    if (!uniqueElements.add(matrix[row][col])) {
                        hasRepetition = true;
                    }
                }
                
                if (hasRepetition) {
                    repeatedCols++;
                }
            }
            
            System.out.println(diagonalSum + " " + repeatedRows + " " + repeatedCols);
        }
        
        scanner.close();
    }
}