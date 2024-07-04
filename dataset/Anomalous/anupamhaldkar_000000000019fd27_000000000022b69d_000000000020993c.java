import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        while (testCases-- > 0) {
            int trace = 0;
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            int duplicateRows = 0;
            int duplicateColumns = 0;
            
            for (int i = 0; i < matrixSize; i++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();
                
                for (int j = 0; j < matrixSize; j++) {
                    rowSet.add(matrix[i][j]);
                    colSet.add(matrix[j][i]);
                    
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
                
                if (rowSet.size() < matrixSize) {
                    duplicateRows++;
                }
                
                if (colSet.size() < matrixSize) {
                    duplicateColumns++;
                }
            }
            
            System.out.println(trace + " " + duplicateRows + " " + duplicateColumns);
        }
        
        scanner.close();
    }
}