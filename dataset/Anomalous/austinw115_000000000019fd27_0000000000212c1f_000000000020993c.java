import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 32768);
        PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        
        int testCases = Integer.parseInt(reader.readLine().trim());
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int matrixSize = Integer.parseInt(reader.readLine().trim());
            int[][] matrix = new int[matrixSize][matrixSize];
            
            for (int row = 0; row < matrixSize; row++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = Integer.parseInt(tokenizer.nextToken());
                }
            }
            
            int trace = calculateTrace(matrix, matrixSize);
            int duplicateRows = countDuplicateRows(matrix, matrixSize);
            int duplicateColumns = countDuplicateColumns(matrix, matrixSize);
            
            writer.printf("Case #%d: %d %d %d%n", caseNum, trace, duplicateRows, duplicateColumns);
        }
        
        writer.close();
    }
    
    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }
    
    private static int countDuplicateRows(int[][] matrix, int size) {
        int duplicateRowCount = 0;
        
        for (int row = 0; row < size; row++) {
            Set<Integer> seen = new HashSet<>();
            for (int col = 0; col < size; col++) {
                if (!seen.add(matrix[row][col])) {
                    duplicateRowCount++;
                    break;
                }
            }
        }
        
        return duplicateRowCount;
    }
    
    private static int countDuplicateColumns(int[][] matrix, int size) {
        int duplicateColumnCount = 0;
        
        for (int col = 0; col < size; col++) {
            Set<Integer> seen = new HashSet<>();
            for (int row = 0; row < size; row++) {
                if (!seen.add(matrix[row][col])) {
                    duplicateColumnCount++;
                    break;
                }
            }
        }
        
        return duplicateColumnCount;
    }
}