import java.io.*;
import java.util.*;

// Solution class
public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
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
            
            // Counting rows with duplicates
            int duplicateRows = 0;
            for (int row = 0; row < matrixSize; row++) {
                boolean[] seen = new boolean[matrixSize + 1];
                for (int col = 0; col < matrixSize; col++) {
                    if (seen[matrix[row][col]]) {
                        duplicateRows++;
                        break;
                    }
                    seen[matrix[row][col]] = true;
                }
            }
            
            // Counting columns with duplicates
            int duplicateColumns = 0;
            for (int col = 0; col < matrixSize; col++) {
                boolean[] seen = new boolean[matrixSize + 1];
                for (int row = 0; row < matrixSize; row++) {
                    if (seen[matrix[row][col]]) {
                        duplicateColumns++;
                        break;
                    }
                    seen[matrix[row][col]] = true;
                }
            }
            
            // Printing the result for the current test case
            System.out.println("Case #" + testCase + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
    }
}