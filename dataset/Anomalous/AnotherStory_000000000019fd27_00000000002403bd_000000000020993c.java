import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int duplicateRows = 0, duplicateColumns = 0, trace = 0;
            
            // Read the matrix
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            // Calculate trace
            for (int i = 0; i < matrixSize; i++) {
                trace += matrix[i][i];
            }
            
            // Check for duplicate rows
            for (int i = 0; i < matrixSize; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < matrixSize; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        duplicateRows++;
                        break;
                    }
                }
            }
            
            // Check for duplicate columns
            for (int i = 0; i < matrixSize; i++) {
                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < matrixSize; j++) {
                    if (!colSet.add(matrix[j][i])) {
                        duplicateColumns++;
                        break;
                    }
                }
            }
            
            // Print the result
            System.out.println("Case #" + testCase + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
    }
}