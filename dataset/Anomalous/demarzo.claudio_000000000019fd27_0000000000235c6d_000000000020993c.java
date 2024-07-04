import java.util.*;
import java.io.*;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; ++caseNum) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            
            // Read the matrix
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }
            
            // Calculate the trace
            int trace = 0;
            for (int i = 0; i < size; i++) {
                trace += matrix[i][i];
            }
            
            // Count rows with repeated elements
            int repeatedRows = 0;
            for (int row = 0; row < size; row++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean hasDuplicate = false;
                for (int col = 0; col < size; col++) {
                    if (!rowSet.add(matrix[row][col])) {
                        hasDuplicate = true;
                        break;
                    }
                }
                if (hasDuplicate) {
                    repeatedRows++;
                }
            }
            
            // Count columns with repeated elements
            int repeatedCols = 0;
            for (int col = 0; col < size; col++) {
                Set<Integer> colSet = new HashSet<>();
                boolean hasDuplicate = false;
                for (int row = 0; row < size; row++) {
                    if (!colSet.add(matrix[row][col])) {
                        hasDuplicate = true;
                        break;
                    }
                }
                if (hasDuplicate) {
                    repeatedCols++;
                }
            }
            
            // Print the result for this test case
            System.out.println("Case #" + caseNum + ": " + trace + " " + repeatedRows + " " + repeatedCols);
        }
    }
}