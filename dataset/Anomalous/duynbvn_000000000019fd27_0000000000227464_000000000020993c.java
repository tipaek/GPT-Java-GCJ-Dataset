import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int rowRepeats = 0;
            int columnRepeats = 0;
            int trace = 0;
            
            for (int i = 0; i < matrixSize; i++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean hasRowRepeat = false;
                
                for (int j = 0; j < matrixSize; j++) {
                    int value = scanner.nextInt();
                    matrix[i][j] = value;
                    
                    if (i == j) {
                        trace += value;
                    }
                    
                    if (!rowSet.add(value)) {
                        hasRowRepeat = true;
                    }
                }
                
                if (hasRowRepeat) {
                    rowRepeats++;
                }
            }
            
            for (int j = 0; j < matrixSize; j++) {
                Set<Integer> columnSet = new HashSet<>();
                boolean hasColumnRepeat = false;
                
                for (int i = 0; i < matrixSize; i++) {
                    if (!columnSet.add(matrix[i][j])) {
                        hasColumnRepeat = true;
                    }
                }
                
                if (hasColumnRepeat) {
                    columnRepeats++;
                }
            }
            
            System.out.println("Case #" + testCase + ": " + trace + " " + rowRepeats + " " + columnRepeats);
        }
        
        scanner.close();
    }
}