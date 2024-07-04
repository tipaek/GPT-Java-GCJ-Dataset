import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = scanner.nextInt();
            boolean[] duplicateRow = new boolean[matrixSize];
            boolean[] duplicateColumn = new boolean[matrixSize];
            boolean[][] rowElements = new boolean[matrixSize][matrixSize];
            boolean[][] columnElements = new boolean[matrixSize][matrixSize];
            int trace = 0;
            
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    int value = scanner.nextInt() - 1;
                    
                    if (rowElements[row][value]) {
                        duplicateRow[row] = true;
                    }
                    rowElements[row][value] = true;
                    
                    if (columnElements[col][value]) {
                        duplicateColumn[col] = true;
                    }
                    columnElements[col][value] = true;
                    
                    if (row == col) {
                        trace += value + 1;
                    }
                }
            }
            
            int duplicateRowsCount = 0;
            int duplicateColumnsCount = 0;
            
            for (int i = 0; i < matrixSize; i++) {
                if (duplicateRow[i]) {
                    duplicateRowsCount++;
                }
                if (duplicateColumn[i]) {
                    duplicateColumnsCount++;
                }
            }
            
            System.out.printf("Case #%d: %d %d %d%n", caseNumber, trace, duplicateRowsCount, duplicateColumnsCount);
        }
        
        scanner.close();
    }
}