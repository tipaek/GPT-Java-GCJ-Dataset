import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
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
            
            System.out.println(calculateVestigium(t, matrix, matrixSize));
        }
    }

    private static String calculateVestigium(int testCaseNumber, int[][] matrix, int size) {
        int diagonalSum = 0;
        int duplicateRows = 0;
        int duplicateColumns = 0;
        
        for (int i = 0; i < size; i++) {
            diagonalSum += matrix[i][i];
            
            boolean[] rowCheck = new boolean[size + 1];
            boolean[] colCheck = new boolean[size + 1];
            boolean rowHasDuplicates = false;
            boolean colHasDuplicates = false;
            
            for (int j = 0; j < size; j++) {
                if (rowCheck[matrix[i][j]]) {
                    rowHasDuplicates = true;
                } else {
                    rowCheck[matrix[i][j]] = true;
                }
                
                if (colCheck[matrix[j][i]]) {
                    colHasDuplicates = true;
                } else {
                    colCheck[matrix[j][i]] = true;
                }
            }
            
            if (rowHasDuplicates) {
                duplicateRows++;
            }
            
            if (colHasDuplicates) {
                duplicateColumns++;
            }
        }
        
        return String.format("Case #%d: %d %d %d", testCaseNumber + 1, diagonalSum, duplicateRows, duplicateColumns);
    }
}