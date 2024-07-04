import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int matrixSize = scanner.nextInt();
            int trace = 0;
            int rowDuplicates = 0;
            int columnDuplicates = 0;
            
            int[][] matrix = new int[matrixSize][matrixSize];
            boolean[] columnChecks = new boolean[matrixSize];
            
            for (int row = 0; row < matrixSize; row++) {
                boolean[] rowChecks = new boolean[matrixSize];
                for (int col = 0; col < matrixSize; col++) {
                    int value = scanner.nextInt();
                    matrix[row][col] = value;
                    
                    // Calculate trace
                    if (row == col) {
                        trace += value;
                    }
                    
                    // Check for row duplicates
                    if (rowChecks[value - 1]) {
                        rowDuplicates++;
                        rowChecks[value - 1] = false; // Avoid counting duplicates more than once
                    } else {
                        rowChecks[value - 1] = true;
                    }
                }
            }
            
            // Check for column duplicates
            for (int col = 0; col < matrixSize; col++) {
                boolean[] colChecks = new boolean[matrixSize];
                for (int row = 0; row < matrixSize; row++) {
                    int value = matrix[row][col];
                    if (colChecks[value - 1]) {
                        columnDuplicates++;
                        colChecks[value - 1] = false; // Avoid counting duplicates more than once
                    } else {
                        colChecks[value - 1] = true;
                    }
                }
            }
            
            System.out.println("Case #" + testCase + ": " + trace + " " + rowDuplicates + " " + columnDuplicates);
        }
        
        scanner.close();
    }
}