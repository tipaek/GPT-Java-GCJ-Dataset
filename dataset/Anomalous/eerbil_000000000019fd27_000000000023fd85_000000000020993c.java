import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int numCases = scanner.nextInt();
        int[] sums = new int[numCases];
        int[] rowsWithDuplicates = new int[numCases];
        int[] colsWithDuplicates = new int[numCases];
        
        for (int caseIndex = 0; caseIndex < numCases; caseIndex++) {
            int numRows = scanner.nextInt();
            int[][] matrix = new int[numRows][numRows];
            int[][] transposedMatrix = new int[numRows][numRows];
            
            for (int row = 0; row < numRows; row++) {
                for (int col = 0; col < numRows; col++) {
                    int value = scanner.nextInt();
                    matrix[row][col] = value;
                    transposedMatrix[col][row] = value;
                    if (row == col) {
                        sums[caseIndex] += value;
                    }
                }
            }
            
            for (int row = 0; row < numRows; row++) {
                if (hasDuplicates(matrix[row])) {
                    rowsWithDuplicates[caseIndex]++;
                }
                if (hasDuplicates(transposedMatrix[row])) {
                    colsWithDuplicates[caseIndex]++;
                }
            }
        }
        
        for (int caseIndex = 0; caseIndex < numCases; caseIndex++) {
            System.out.println("Case #" + (caseIndex + 1) + ": " + sums[caseIndex] + " " + rowsWithDuplicates[caseIndex] + " " + colsWithDuplicates[caseIndex]);
        }
        
        scanner.close();
    }
    
    private static boolean hasDuplicates(int[] array) {
        HashSet<Integer> seen = new HashSet<>();
        for (int value : array) {
            if (!seen.add(value)) {
                return true;
            }
        }
        return false;
    }
}