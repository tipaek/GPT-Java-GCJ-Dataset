import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int testCases = scanner.nextInt();
        
        for (int caseIndex = 0; caseIndex < testCases; caseIndex++) {
            int matrixSize = scanner.nextInt();
            int trace = 0;
            int duplicateRows = 0;
            int duplicateColumns = 0;
            
            int[][] matrix = new int[matrixSize][matrixSize];
            
            for (int row = 0; row < matrixSize; row++) {
                int[] rowCheck = new int[101];
                boolean hasDuplicateRow = false;
                
                for (int col = 0; col < matrixSize; col++) {
                    int value = scanner.nextInt();
                    matrix[row][col] = value;
                    rowCheck[value]++;
                    
                    if (row == col) {
                        trace += value;
                    }
                    
                    if (rowCheck[value] > 1) {
                        hasDuplicateRow = true;
                    }
                }
                
                if (hasDuplicateRow) {
                    duplicateRows++;
                }
            }
            
            for (int col = 0; col < matrixSize; col++) {
                int[] colCheck = new int[101];
                boolean hasDuplicateCol = false;
                
                for (int row = 0; row < matrixSize; row++) {
                    int value = matrix[row][col];
                    colCheck[value]++;
                    
                    if (colCheck[value] > 1) {
                        hasDuplicateCol = true;
                    }
                }
                
                if (hasDuplicateCol) {
                    duplicateColumns++;
                }
            }
            
            System.out.println("Case #" + (caseIndex + 1) + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
    }
}