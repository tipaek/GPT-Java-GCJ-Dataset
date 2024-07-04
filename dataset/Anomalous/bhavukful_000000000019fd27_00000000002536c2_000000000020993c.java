import java.util.Scanner;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        
        for (int testCase = 1; testCase <= T; testCase++) {
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];
            int trace = 0;
            
            // Reading the matrix and calculating the trace
            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    matrix[row][col] = scanner.nextInt();
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                }
            }
            
            // Checking for duplicate values in rows
            int duplicateRows = 0;
            for (int row = 0; row < N; row++) {
                HashMap<Integer, Boolean> rowMap = new HashMap<>();
                for (int col = 0; col < N; col++) {
                    if (rowMap.containsKey(matrix[row][col])) {
                        duplicateRows++;
                        break;
                    } else {
                        rowMap.put(matrix[row][col], true);
                    }
                }
            }
            
            // Checking for duplicate values in columns
            int duplicateCols = 0;
            for (int col = 0; col < N; col++) {
                HashMap<Integer, Boolean> colMap = new HashMap<>();
                for (int row = 0; row < N; row++) {
                    if (colMap.containsKey(matrix[row][col])) {
                        duplicateCols++;
                        break;
                    } else {
                        colMap.put(matrix[row][col], true);
                    }
                }
            }
            
            // Printing the result for the current test case
            System.out.println("Case #" + testCase + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
        
        scanner.close();
    }
}