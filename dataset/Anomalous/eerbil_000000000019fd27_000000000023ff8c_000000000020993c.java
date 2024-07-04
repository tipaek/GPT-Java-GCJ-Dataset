import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int numCases = scanner.nextInt();
        int[] traceSums = new int[numCases];
        int[] duplicateRows = new int[numCases];
        int[] duplicateCols = new int[numCases];
        
        for(int caseIndex = 0; caseIndex < numCases; caseIndex++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int[][] transposedMatrix = new int[matrixSize][matrixSize];
            
            for(int row = 0; row < matrixSize; row++) {
                for(int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                    transposedMatrix[col][row] = matrix[row][col];
                    if(row == col) {
                        traceSums[caseIndex] += matrix[row][col];
                    }
                }
            }
            
            for(int row = 0; row < matrixSize; row++) {
                if(hasDuplicates(matrix[row])) {
                    duplicateRows[caseIndex]++;
                }
                if(hasDuplicates(transposedMatrix[row])) {
                    duplicateCols[caseIndex]++;
                }
            }
        }
        
        for(int caseIndex = 0; caseIndex < numCases; caseIndex++) {
            System.out.println("Case #" + (caseIndex + 1) + ": " + traceSums[caseIndex] + " " + duplicateRows[caseIndex] + " " + duplicateCols[caseIndex]);
        }
        
        scanner.close();
    }
    
    public static boolean hasDuplicates(int[] array) {
        HashMap<Integer, Integer> elementCounts = new HashMap<>();
        for(int element : array) {
            if(elementCounts.containsKey(element)) {
                return true;
            } else {
                elementCounts.put(element, 1);
            }
        }
        return false;
    }
}