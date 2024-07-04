import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
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
            int[][] transposeMatrix = new int[matrixSize][matrixSize];
            
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    int value = scanner.nextInt();
                    matrix[row][col] = value;
                    transposeMatrix[col][row] = value;
                    if (row == col) {
                        traceSums[caseIndex] += value;
                    }
                }
            }
            
            for (int row = 0; row < matrixSize; row++) {
                if (containsDuplicates(matrix[row])) {
                    duplicateRows[caseIndex]++;
                }
                if (containsDuplicates(transposeMatrix[row])) {
                    duplicateCols[caseIndex]++;
                }
            }
        }
        
        for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {
            System.out.println("Case #" + (caseIndex + 1) + ": " + traceSums[caseIndex] + " " + duplicateRows[caseIndex] + " " + duplicateCols[caseIndex]);
        }
        
        scanner.close();
    }
    
    public static boolean containsDuplicates(int[] array) {
        HashSet<Integer> seenNumbers = new HashSet<>();
        for (int number : array) {
            if (!seenNumbers.add(number)) {
                return true;
            }
        }
        return false;
    }
}