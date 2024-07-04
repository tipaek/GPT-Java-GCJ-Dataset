import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int diagonalSum = 0;
            int repeatedRows = 0;
            int repeatedCols = 0;
            
            HashSet<String> columnCheckSet = new HashSet<>();
            boolean[] columnHasDuplicates = new boolean[matrixSize];
            
            for (int row = 0; row < matrixSize; row++) {
                HashSet<Integer> rowCheckSet = new HashSet<>();
                boolean rowHasDuplicates = false;
                
                for (int col = 0; col < matrixSize; col++) {
                    int value = scanner.nextInt();
                    matrix[row][col] = value;
                    
                    if (!rowCheckSet.add(value)) {
                        rowHasDuplicates = true;
                    }
                    
                    String colCheckKey = (char) (col + 97) + "" + value;
                    if (!columnCheckSet.add(colCheckKey)) {
                        columnHasDuplicates[col] = true;
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
                    repeatedCols++;
                }
            }
            
            System.out.println("Case #" + caseNum + ": " + diagonalSum + " " + repeatedRows + " " + repeatedCols);
        }
        
        scanner.close();
    }
}