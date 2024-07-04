import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int numberOfCases = scanner.nextInt();
        int[] traceSums = new int[numberOfCases];
        int[] duplicateRows = new int[numberOfCases];
        int[] duplicateCols = new int[numberOfCases];
        
        for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int[][] transposedMatrix = new int[matrixSize][matrixSize];
            
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                    transposedMatrix[col][row] = matrix[row][col];
                    if (row == col) {
                        traceSums[caseIndex] += matrix[row][col];
                    }
                }
            }
            
            for (int row = 0; row < matrixSize; row++) {
                if (containsDuplicates(matrix[row])) {
                    duplicateRows[caseIndex]++;
                }
                if (containsDuplicates(transposedMatrix[row])) {
                    duplicateCols[caseIndex]++;
                }
            }
        }
        
        for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {
            System.out.println(traceSums[caseIndex] + " " + duplicateRows[caseIndex] + " " + duplicateCols[caseIndex]);
        }
        
        scanner.close();
    }
    
    public static boolean containsDuplicates(int[] array) {
        HashMap<Integer, Integer> elementCounts = new HashMap<>();
        for (int value : array) {
            if (elementCounts.containsKey(value)) {
                return true;
            }
            elementCounts.put(value, 1);
        }
        return false;
    }
}