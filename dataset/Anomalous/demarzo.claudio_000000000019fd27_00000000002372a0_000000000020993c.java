import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
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
                if (hasDuplicates(matrix[row])) {
                    repeatedRows++;
                }
            }
            
            // Count columns with repeated elements
            int repeatedCols = 0;
            for (int col = 0; col < size; col++) {
                int[] columnArray = new int[size];
                for (int row = 0; row < size; row++) {
                    columnArray[row] = matrix[row][col];
                }
                if (hasDuplicates(columnArray)) {
                    repeatedCols++;
                }
            }
            
            // Print the result for this test case
            System.out.println("Case #" + caseNumber + ": " + trace + " " + repeatedRows + " " + repeatedCols);
        }
    }
    
    private static boolean hasDuplicates(int[] array) {
        Set<Integer> seen = new HashSet<>();
        for (int value : array) {
            if (!seen.add(value)) {
                return true;
            }
        }
        return false;
    }
}