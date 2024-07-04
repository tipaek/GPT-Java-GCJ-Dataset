import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }
            
            int trace = 0;
            for (int i = 0; i < size; i++) {
                trace += matrix[i][i];
            }
            
            int duplicateRows = 0;
            int duplicateCols = 0;
            
            for (int i = 0; i < size; i++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();
                boolean rowDuplicate = false;
                boolean colDuplicate = false;
                
                for (int j = 0; j < size; j++) {
                    if (!rowDuplicate && !rowSet.add(matrix[i][j])) {
                        duplicateRows++;
                        rowDuplicate = true;
                    }
                    
                    if (!colDuplicate && !colSet.add(matrix[j][i])) {
                        duplicateCols++;
                        colDuplicate = true;
                    }
                }
            }
            
            System.out.println("Case #" + testCase + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
    }
}