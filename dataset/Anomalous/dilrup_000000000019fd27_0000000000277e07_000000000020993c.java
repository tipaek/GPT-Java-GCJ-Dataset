import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int diagonalSum = 0;
            int repeatedRows = 0;
            int repeatedColumns = 0;
            
            boolean[] columnHasDuplicates = new boolean[n];
            Set<String> columnSet = new HashSet<>();
            
            for (int row = 0; row < n; row++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean rowHasDuplicates = false;
                
                for (int col = 0; col < n; col++) {
                    int value = scanner.nextInt();
                    matrix[row][col] = value;
                    
                    if (rowSet.contains(value)) {
                        rowHasDuplicates = true;
                    } else {
                        rowSet.add(value);
                    }
                    
                    String columnKey = col + ":" + value;
                    if (columnSet.contains(columnKey)) {
                        columnHasDuplicates[col] = true;
                    } else {
                        columnSet.add(columnKey);
                    }
                    
                    if (row == col) {
                        diagonalSum += value;
                    }
                }
                
                if (rowHasDuplicates) {
                    repeatedRows++;
                }
            }
            
            for (boolean hasDuplicates : columnHasDuplicates) {
                if (hasDuplicates) {
                    repeatedColumns++;
                }
            }
            
            System.out.println("Case #" + caseNumber + ": " + diagonalSum + " " + repeatedRows + " " + repeatedColumns);
        }
    }
}