import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int numCases = scanner.nextInt();
        int[] sums = new int[numCases];
        int[] rowsWithDuplicates = new int[numCases];
        int[] colsWithDuplicates = new int[numCases];
        
        for (int caseIndex = 0; caseIndex < numCases; caseIndex++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int[][] transposedMatrix = new int[matrixSize][matrixSize];
            
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                    transposedMatrix[col][row] = matrix[row][col];
                    if (row == col) {
                        sums[caseIndex] += matrix[row][col];
                    }
                }
            }
            
            for (int row = 0; row < matrixSize; row++) {
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
    
    public static boolean hasDuplicates(int[] array) {
        HashMap<Integer, Boolean> elementSeen = new HashMap<>();
        for (int value : array) {
            if (elementSeen.containsKey(value)) {
                return true;
            }
            elementSeen.put(value, true);
        }
        return false;
    }
}