import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }
            
            System.out.println(vestigium(t, matrix, n));
        }
    }

    public static String vestigium(int testCaseNumber, int[][] matrix, int size) {
        int diagonalSum = 0;
        int rowCount = 0;
        int colCount = 0;
        
        for (int i = 0; i < size; i++) {
            diagonalSum += matrix[i][i];
            boolean[] rowSeen = new boolean[size + 1];
            boolean[] colSeen = new boolean[size + 1];
            boolean rowDuplicate = false;
            boolean colDuplicate = false;
            
            for (int j = 0; j < size; j++) {
                if (rowSeen[matrix[i][j]]) {
                    rowDuplicate = true;
                }
                if (colSeen[matrix[j][i]]) {
                    colDuplicate = true;
                }
                rowSeen[matrix[i][j]] = true;
                colSeen[matrix[j][i]] = true;
            }
            
            if (rowDuplicate) {
                rowCount++;
            }
            if (colDuplicate) {
                colCount++;
            }
        }
        
        return "Case #" + (testCaseNumber + 1) + ": " + diagonalSum + " " + rowCount + " " + colCount;
    }
}