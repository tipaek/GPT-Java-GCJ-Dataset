import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int diagonalSum = 0, repeatedRows = 0, repeatedColumns = 0;
            boolean[] columnDuplicates = new boolean[matrixSize];
            Set<String> columnValues = new HashSet<>();
            
            for (int row = 0; row < matrixSize; row++) {
                Set<Integer> rowValues = new HashSet<>();
                boolean hasRowDuplicates = false;
                
                for (int col = 0; col < matrixSize; col++) {
                    int value = scanner.nextInt();
                    matrix[row][col] = value;
                    
                    if (!rowValues.add(value)) {
                        hasRowDuplicates = true;
                    }
                    
                    String columnKey = (char)(col + 'a') + String.valueOf(value);
                    if (!columnValues.add(columnKey)) {
                        columnDuplicates[col] = true;
                    }
                    
                    if (row == col) {
                        diagonalSum += value;
                    }
                }
                
                if (hasRowDuplicates) {
                    repeatedRows++;
                }
            }
            
            for (boolean hasColumnDuplicates : columnDuplicates) {
                if (hasColumnDuplicates) {
                    repeatedColumns++;
                }
            }
            
            System.out.println("Case #" + testCase + ": " + diagonalSum + " " + repeatedRows + " " + repeatedColumns);
        }
    }
}