import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseIndex = 0; caseIndex < testCases; caseIndex++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }
            
            int duplicateRows = 0;
            int duplicateCols = 0;
            int diagonalSum = 0;
            
            for (int index = 0; index < matrixSize; index++) {
                HashSet<Integer> rowSet = new HashSet<>();
                HashSet<Integer> colSet = new HashSet<>();
                boolean rowHasDuplicate = false;
                boolean colHasDuplicate = false;
                
                for (int innerIndex = 0; innerIndex < matrixSize; innerIndex++) {
                    if (innerIndex == index) {
                        diagonalSum += matrix[index][innerIndex];
                    }
                    
                    if (!colHasDuplicate && colSet.contains(matrix[innerIndex][index])) {
                        duplicateCols++;
                        colHasDuplicate = true;
                    }
                    
                    if (!rowHasDuplicate && rowSet.contains(matrix[index][innerIndex])) {
                        duplicateRows++;
                        rowHasDuplicate = true;
                    }
                    
                    colSet.add(matrix[innerIndex][index]);
                    rowSet.add(matrix[index][innerIndex]);
                }
            }
            
            System.out.printf("Case #%d: %d %d %d%n", caseIndex + 1, diagonalSum, duplicateRows, duplicateCols);
        }
        
        scanner.close();
    }
}