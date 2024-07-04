import java.util.Scanner;

public class Vestigium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int trace = 0, rowCount = 0, colCount = 0;
            
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }
            
            for (int i = 0; i < matrixSize; i++) {
                if (hasDuplicate(matrix[i])) {
                    rowCount++;
                }
                
                int[] column = new int[matrixSize];
                for (int j = 0; j < matrixSize; j++) {
                    column[j] = matrix[j][i];
                }
                
                if (hasDuplicate(column)) {
                    colCount++;
                }
            }
            
            System.out.printf("Case #%d: %d %d %d%n", caseNumber, trace, rowCount, colCount);
        }
        
        scanner.close();
    }
    
    private static boolean hasDuplicate(int[] array) {
        boolean[] seen = new boolean[array.length];
        for (int value : array) {
            if (seen[value - 1]) {
                return true;
            }
            seen[value - 1] = true;
        }
        return false;
    }
}