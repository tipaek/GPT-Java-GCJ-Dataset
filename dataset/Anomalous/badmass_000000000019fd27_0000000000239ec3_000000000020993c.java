import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            int diagonalSum = 0;
            int duplicateRows = 0;
            int duplicateColumns = 0;
            
            // Calculate the sum of the main diagonal
            for (int i = 0; i < matrixSize; i++) {
                diagonalSum += matrix[i][i];
            }
            
            // Check for duplicate values in rows
            for (int i = 0; i < matrixSize; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < matrixSize; j++) {
                    rowSet.add(matrix[i][j]);
                }
                if (rowSet.size() < matrixSize) {
                    duplicateRows++;
                }
            }
            
            // Check for duplicate values in columns
            for (int i = 0; i < matrixSize; i++) {
                Set<Integer> columnSet = new HashSet<>();
                for (int j = 0; j < matrixSize; j++) {
                    columnSet.add(matrix[j][i]);
                }
                if (columnSet.size() < matrixSize) {
                    duplicateColumns++;
                }
            }
            
            System.out.println("Case #" + caseNum + ": " + diagonalSum + " " + duplicateRows + " " + duplicateColumns);
        }
        
        scanner.close();
    }
}