import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        // Read number of test cases
        int testCases = Integer.parseInt(reader.readLine());
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            // Read the size of the matrix
            int matrixSize = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[matrixSize][matrixSize];
            
            // Read the matrix values
            for (int i = 0; i < matrixSize; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = Integer.parseInt(tokenizer.nextToken());
                }
            }
            
            // Print the matrix (for debugging purposes)
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    System.out.println(matrix[i][j]);
                }
            }
            
            // Calculate the trace (sum of diagonal elements)
            int trace = 0;
            for (int i = 0; i < matrixSize; i++) {
                trace += matrix[i][i];
            }
            
            // Calculate the number of rows with duplicate elements
            int duplicateRows = 0;
            for (int i = 0; i < matrixSize; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < matrixSize; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        duplicateRows++;
                        break;
                    }
                }
            }
            
            // Calculate the number of columns with duplicate elements
            int duplicateColumns = 0;
            for (int j = 0; j < matrixSize; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int i = 0; i < matrixSize; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        duplicateColumns++;
                        break;
                    }
                }
            }
            
            // Print the result for the current test case
            System.out.printf("Case #%d: %d %d %d%n", caseNumber, trace, duplicateRows, duplicateColumns);
        }
    }
}