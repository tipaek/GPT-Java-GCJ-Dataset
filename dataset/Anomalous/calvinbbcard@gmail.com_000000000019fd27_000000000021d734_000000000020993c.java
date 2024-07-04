import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            
            // Reading the matrix
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            int trace = 0;
            int repeatedRows = 0;
            int repeatedColumns = 0;
            
            // Calculating the trace
            for (int i = 0; i < matrixSize; i++) {
                trace += matrix[i][i];
            }
            
            // Checking for repeated elements in rows and columns
            for (int i = 0; i < matrixSize; i++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> columnSet = new HashSet<>();
                for (int j = 0; j < matrixSize; j++) {
                    rowSet.add(matrix[i][j]);
                    columnSet.add(matrix[j][i]);
                }
                if (rowSet.size() != matrixSize) {
                    repeatedRows++;
                }
                if (columnSet.size() != matrixSize) {
                    repeatedColumns++;
                }
            }
            
            System.out.printf("Case #%d: %d %d %d%n", caseNumber, trace, repeatedRows, repeatedColumns);
        }
        
        scanner.close();
    }
}