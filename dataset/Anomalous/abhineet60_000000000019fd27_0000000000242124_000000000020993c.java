import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            int diagonalSum = 0;
            int duplicateRows = 0;
            int duplicateColumns = 0;
            
            // Calculate the sum of the main diagonal
            for (int i = 0; i < n; i++) {
                diagonalSum += matrix[i][i];
            }
            
            // Check for duplicate elements in each row
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        duplicateRows++;
                        break;
                    }
                }
            }
            
            // Check for duplicate elements in each column
            for (int j = 0; j < n; j++) {
                Set<Integer> columnSet = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    if (!columnSet.add(matrix[i][j])) {
                        duplicateColumns++;
                        break;
                    }
                }
            }
            
            System.out.println("Case #" + caseNumber + ": " + diagonalSum + " " + duplicateRows + " " + duplicateColumns);
        }
    }
}