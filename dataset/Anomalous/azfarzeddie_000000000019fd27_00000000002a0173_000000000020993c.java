import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            System.out.println(calculateVestigium(t, matrix));
        }
        
        scanner.close();
    }

    public static String calculateVestigium(int testCaseNumber, int[][] matrix) {
        int size = matrix.length;
        int diagonalSum = 0;
        int rowDuplicates = 0;
        int columnDuplicates = 0;
        
        for (int i = 0; i < size; i++) {
            diagonalSum += matrix[i][i];
            
            if (hasDuplicates(matrix[i])) {
                rowDuplicates++;
            }
            
            if (hasDuplicates(getColumn(matrix, i))) {
                columnDuplicates++;
            }
        }
        
        return "Case #" + testCaseNumber + ": " + diagonalSum + " " + rowDuplicates + " " + columnDuplicates;
    }

    private static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[array.length + 1];
        
        for (int num : array) {
            if (seen[num]) {
                return true;
            }
            seen[num] = true;
        }
        
        return false;
    }

    private static int[] getColumn(int[][] matrix, int columnIndex) {
        int[] column = new int[matrix.length];
        
        for (int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][columnIndex];
        }
        
        return column;
    }
}