import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }
            
            System.out.println(calculateVestigium(testCase, matrix, matrixSize));
        }
        
        scanner.close();
    }
    
    private static String calculateVestigium(int testCase, int[][] matrix, int size) {
        int diagonalSum = 0;
        int duplicateRows = 0;
        int duplicateCols = 0;
        
        for (int i = 0; i < size; i++) {
            boolean[] rowSeen = new boolean[size + 1];
            boolean[] colSeen = new boolean[size + 1];
            boolean rowHasDuplicate = false;
            boolean colHasDuplicate = false;
            
            diagonalSum += matrix[i][i];
            
            for (int j = 0; j < size; j++) {
                if (rowSeen[matrix[i][j]]) {
                    rowHasDuplicate = true;
                } else {
                    rowSeen[matrix[i][j]] = true;
                }
                
                if (colSeen[matrix[j][i]]) {
                    colHasDuplicate = true;
                } else {
                    colSeen[matrix[j][i]] = true;
                }
            }
            
            if (rowHasDuplicate) {
                duplicateRows++;
            }
            
            if (colHasDuplicate) {
                duplicateCols++;
            }
        }
        
        return "Case #" + testCase + ": " + diagonalSum + " " + duplicateRows + " " + duplicateCols;
    }
}