import java.io.IOException;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }
            
            System.out.println(computeVestigium(caseNumber, matrix, matrixSize));
        }
        
        scanner.close();
    }

    private static String computeVestigium(int caseNumber, int[][] matrix, int size) {
        int diagonalSum = 0;
        int rowDuplicates = 0;
        int colDuplicates = 0;
        
        for (int i = 0; i < size; i++) {
            boolean[] rowCheck = new boolean[size + 1];
            boolean[] colCheck = new boolean[size + 1];
            boolean rowFlag = false;
            boolean colFlag = false;
            
            diagonalSum += matrix[i][i];
            
            for (int j = 0; j < size; j++) {
                if (rowCheck[matrix[i][j]]) {
                    rowFlag = true;
                } else {
                    rowCheck[matrix[i][j]] = true;
                }
                
                if (colCheck[matrix[j][i]]) {
                    colFlag = true;
                } else {
                    colCheck[matrix[j][i]] = true;
                }
            }
            
            if (rowFlag) rowDuplicates++;
            if (colFlag) colDuplicates++;
        }
        
        return String.format("Case #%d: %d %d %d", caseNumber, diagonalSum, rowDuplicates, colDuplicates);
    }
}