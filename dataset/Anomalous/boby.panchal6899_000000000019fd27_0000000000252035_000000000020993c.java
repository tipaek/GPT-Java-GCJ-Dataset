import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            int trace = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;
            
            for (int i = 0; i < matrixSize; i++) {
                trace += matrix[i][i];
                
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();
                
                for (int j = 0; j < matrixSize; j++) {
                    rowSet.add(matrix[i][j]);
                    colSet.add(matrix[j][i]);
                }
                
                if (rowSet.size() < matrixSize) {
                    rowDuplicates++;
                }
                
                if (colSet.size() < matrixSize) {
                    colDuplicates++;
                }
            }
            
            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}