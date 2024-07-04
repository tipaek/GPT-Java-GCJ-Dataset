import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int testCases = Integer.parseInt(scanner.nextLine());
        
        for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
            int matrixSize = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[matrixSize][matrixSize];
            
            int diagonalSum = 0;
            int rowDuplicateCount = 0;
            int colDuplicateCount = 0;
            
            // Reading matrix and calculating row duplicates and diagonal sum
            for (int row = 0; row < matrixSize; row++) {
                Set<Integer> rowSet = new HashSet<>();
                String[] rowValues = scanner.nextLine().split(" ");
                
                for (int col = 0; col < matrixSize; col++) {
                    int value = Integer.parseInt(rowValues[col]);
                    matrix[row][col] = value;
                    
                    if (rowSet.contains(value)) {
                        rowDuplicateCount++;
                        break;
                    }
                    rowSet.add(value);
                }
                
                diagonalSum += matrix[row][row];
            }
            
            // Calculating column duplicates
            for (int col = 0; col < matrixSize; col++) {
                Set<Integer> colSet = new HashSet<>();
                
                for (int row = 0; row < matrixSize; row++) {
                    int value = matrix[row][col];
                    
                    if (colSet.contains(value)) {
                        colDuplicateCount++;
                        break;
                    }
                    colSet.add(value);
                }
            }
            
            System.out.println("Case #" + caseNumber + ": " + diagonalSum + " " + rowDuplicateCount + " " + colDuplicateCount);
        }
        
        scanner.close();
    }
}