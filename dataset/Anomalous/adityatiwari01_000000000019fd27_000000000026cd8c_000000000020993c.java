import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (scanner.hasNext()) {
            int testCases = scanner.nextInt();
            
            for (int t = 0; t < testCases; t++) {
                int matrixSize = scanner.nextInt();
                int[][] matrix = new int[matrixSize][matrixSize];
                int diagonalSum = 0;
                
                // Read matrix and calculate diagonal sum
                for (int row = 0; row < matrixSize; row++) {
                    for (int col = 0; col < matrixSize; col++) {
                        matrix[row][col] = scanner.nextInt();
                        if (row == col) {
                            diagonalSum += matrix[row][col];
                        }
                    }
                }
                
                int duplicateRows = 0;
                int duplicateCols = 0;
                
                // Check for duplicate elements in rows and columns
                for (int row = 0; row < matrixSize; row++) {
                    Set<Integer> rowSet = new HashSet<>();
                    Set<Integer> colSet = new HashSet<>();
                    
                    for (int col = 0; col < matrixSize; col++) {
                        rowSet.add(matrix[row][col]);
                        colSet.add(matrix[col][row]);
                    }
                    
                    if (rowSet.size() < matrixSize) {
                        duplicateRows++;
                    }
                    if (colSet.size() < matrixSize) {
                        duplicateCols++;
                    }
                }
                
                // Print result for the current test case
                System.out.println("Case #" + (t + 1) + ": " + diagonalSum + " " + duplicateRows + " " + duplicateCols);
            }
        }
        
        scanner.close();
    }
}