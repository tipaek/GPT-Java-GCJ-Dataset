import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            
            // Initialize matrix
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }
            
            int trace = calculateTrace(matrix, matrixSize);
            int rowDuplicates = countRowDuplicates(matrix, matrixSize);
            int colDuplicates = countColDuplicates(matrix, matrixSize);
            
            System.out.println("Case #" + caseNum + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
    
    public static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }
    
    public static int countRowDuplicates(int[][] matrix, int size) {
        int duplicateCount = 0;
        for (int row = 0; row < size; row++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int col = 0; col < size; col++) {
                if (uniqueElements.contains(matrix[row][col])) {
                    duplicateCount++;
                    break;
                }
                uniqueElements.add(matrix[row][col]);
            }
        }
        return duplicateCount;
    }
    
    public static int countColDuplicates(int[][] matrix, int size) {
        int duplicateCount = 0;
        for (int col = 0; col < size; col++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int row = 0; row < size; row++) {
                if (uniqueElements.contains(matrix[row][col])) {
                    duplicateCount++;
                    break;
                }
                uniqueElements.add(matrix[row][col]);
            }
        }
        return duplicateCount;
    }
}