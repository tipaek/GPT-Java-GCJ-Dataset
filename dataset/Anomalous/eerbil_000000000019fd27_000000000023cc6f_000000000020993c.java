import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int numCases = scanner.nextInt();
        int[] sums = new int[numCases];
        int[] duplicateRows = new int[numCases];
        int[] duplicateCols = new int[numCases];
        
        for (int caseIndex = 0; caseIndex < numCases; caseIndex++) {
            int numRows = scanner.nextInt();
            int[][] matrix = new int[numRows][numRows];
            
            for (int row = 0; row < numRows; row++) {
                for (int col = 0; col < numRows; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }
            
            int[][] rowCounts = new int[numRows][numRows];
            int[][] colCounts = new int[numRows][numRows];
            HashMap<Integer, Boolean> rowDuplicates = new HashMap<>();
            HashMap<Integer, Boolean> colDuplicates = new HashMap<>();
            int diagonalSum = 0;
            
            for (int row = 0; row < numRows; row++) {
                for (int col = 0; col < numRows; col++) {
                    int value = matrix[row][col];
                    if (row == col) {
                        diagonalSum += value;
                    }
                    rowCounts[row][value - 1]++;
                    colCounts[col][value - 1]++;
                    
                    if (rowCounts[row][value - 1] > 1 && !rowDuplicates.containsKey(row)) {
                        rowDuplicates.put(row, true);
                    }
                    if (colCounts[col][value - 1] > 1 && !colDuplicates.containsKey(col)) {
                        colDuplicates.put(col, true);
                    }
                }
            }
            
            sums[caseIndex] = diagonalSum;
            duplicateRows[caseIndex] = rowDuplicates.size();
            duplicateCols[caseIndex] = colDuplicates.size();
        }
        
        scanner.close();
        
        for (int caseIndex = 0; caseIndex < numCases; caseIndex++) {
            System.out.println(sums[caseIndex] + " " + duplicateRows[caseIndex] + " " + duplicateCols[caseIndex]);
        }
    }
}