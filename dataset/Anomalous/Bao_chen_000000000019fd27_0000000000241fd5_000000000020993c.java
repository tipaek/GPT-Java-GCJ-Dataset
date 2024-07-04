import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }
            
            processTestCase(caseNumber, matrix);
        }
    }
    
    private static int countDuplicateInColumn(int column, int[][] matrix) {
        Set<Integer> uniqueValues = new HashSet<>();
        
        for (int[] row : matrix) {
            uniqueValues.add(row[column]);
        }
        
        return uniqueValues.size() < matrix.length ? 1 : 0;
    }
    
    private static int countDuplicateInRow(int row, int[][] matrix) {
        Set<Integer> uniqueValues = new HashSet<>();
        
        for (int value : matrix[row]) {
            uniqueValues.add(value);
        }
        
        return uniqueValues.size() < matrix.length ? 1 : 0;
    }
    
    private static void processTestCase(int caseNumber, int[][] matrix) {
        int trace = 0;
        int duplicateRows = 0;
        int duplicateColumns = 0;
        int matrixSize = matrix.length;
        
        for (int i = 0; i < matrixSize; i++) {
            trace += matrix[i][i];
            duplicateRows += countDuplicateInRow(i, matrix);
            duplicateColumns += countDuplicateInColumn(i, matrix);
        }
        
        System.out.println("Case #" + caseNumber + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
    }
}