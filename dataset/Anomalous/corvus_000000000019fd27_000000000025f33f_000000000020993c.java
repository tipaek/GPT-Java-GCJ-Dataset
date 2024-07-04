import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            
            // Reading the matrix
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }
            
            int trace = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;
            
            // Calculate trace and row duplicates
            for (int row = 0; row < matrixSize; row++) {
                boolean[] seenInRow = new boolean[matrixSize + 1];
                for (int col = 0; col < matrixSize; col++) {
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                    if (seenInRow[matrix[row][col]]) {
                        rowDuplicates++;
                        break;
                    }
                    seenInRow[matrix[row][col]] = true;
                }
            }
            
            // Calculate column duplicates
            for (int col = 0; col < matrixSize; col++) {
                boolean[] seenInCol = new boolean[matrixSize + 1];
                for (int row = 0; row < matrixSize; row++) {
                    if (seenInCol[matrix[row][col]]) {
                        colDuplicates++;
                        break;
                    }
                    seenInCol[matrix[row][col]] = true;
                }
            }
            
            System.out.println(String.format("Case #%d: %d %d %d", caseNumber, trace, rowDuplicates, colDuplicates));
        }
    }
}