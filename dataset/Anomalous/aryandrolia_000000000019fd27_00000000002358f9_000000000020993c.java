import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }
            
            processMatrix(matrix, t);
        }
        
        scanner.close();
    }

    public static void processMatrix(int[][] matrix, int caseNumber) {
        int diagonalSum = 0;
        int repeatedRows = 0;
        int repeatedCols = 0;
        int size = matrix.length;
        
        for (int row = 0; row < size; row++) {
            HashSet<Integer> rowSet = new HashSet<>();
            for (int col = 0; col < size; col++) {
                int value = matrix[row][col];
                rowSet.add(value);
                if (row == col) {
                    diagonalSum += value;
                }
            }
            if (rowSet.size() < size) {
                repeatedRows++;
            }
        }
        
        for (int col = 0; col < size; col++) {
            HashSet<Integer> colSet = new HashSet<>();
            for (int row = 0; row < size; row++) {
                int value = matrix[row][col];
                colSet.add(value);
            }
            if (colSet.size() < size) {
                repeatedCols++;
            }
        }
        
        System.out.println(String.format("Case #%d: %d %d %d", caseNumber + 1, diagonalSum, repeatedCols, repeatedRows));
    }
}