import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseIndex = 0; caseIndex < testCases; caseIndex++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = readMatrix(matrixSize, scanner);
            int trace = calculateTrace(matrix);
            int duplicateRows = countDuplicateRows(matrix);
            int duplicateColumns = countDuplicateColumns(matrix);
            
            System.out.printf("Case #%d: %d %d %d%n", caseIndex + 1, trace, duplicateRows, duplicateColumns);
        }
    }
    
    private static int[][] readMatrix(int size, Scanner scanner) {
        int[][] matrix = new int[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
        return matrix;
    }
    
    private static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }
    
    private static int countDuplicateRows(int[][] matrix) {
        int duplicateCount = 0;
        for (int[] row : matrix) {
            if (hasDuplicates(row)) {
                duplicateCount++;
            }
        }
        return duplicateCount;
    }
    
    private static int countDuplicateColumns(int[][] matrix) {
        int duplicateCount = 0;
        int size = matrix.length;
        
        for (int col = 0; col < size; col++) {
            int[] column = new int[size];
            for (int row = 0; row < size; row++) {
                column[row] = matrix[row][col];
            }
            if (hasDuplicates(column)) {
                duplicateCount++;
            }
        }
        return duplicateCount;
    }
    
    private static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[array.length + 1];
        for (int value : array) {
            if (seen[value]) {
                return true;
            }
            seen[value] = true;
        }
        return false;
    }
}