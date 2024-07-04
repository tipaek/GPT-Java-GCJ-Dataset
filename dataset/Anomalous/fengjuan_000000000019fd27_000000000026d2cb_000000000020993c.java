import java.util.Scanner;
import java.util.HashSet;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            
            // Reading the matrix
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }
            
            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;
            
            // Calculating trace and checking for repeated elements in rows and columns
            for (int i = 0; i < matrixSize; i++) {
                trace += matrix[i][i];
                
                HashSet<Integer> rowSet = new HashSet<>();
                HashSet<Integer> colSet = new HashSet<>();
                
                for (int j = 0; j < matrixSize; j++) {
                    rowSet.add(matrix[i][j]);
                    colSet.add(matrix[j][i]);
                }
                
                if (rowSet.size() != matrixSize) {
                    rowRepeats++;
                }
                if (colSet.size() != matrixSize) {
                    colRepeats++;
                }
            }
            
            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
        
        scanner.close();
    }
}