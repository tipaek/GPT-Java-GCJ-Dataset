import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int testCases = scanner.nextInt();
        int[] traceSums = new int[testCases];
        int[] duplicateRows = new int[testCases];
        int[] duplicateCols = new int[testCases];
        
        for (int t = 0; t < testCases; t++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int[][] transposedMatrix = new int[matrixSize][matrixSize];
            
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                    transposedMatrix[j][i] = matrix[i][j];
                    if (i == j) {
                        traceSums[t] += matrix[i][j];
                    }
                }
            }
            
            for (int i = 0; i < matrixSize; i++) {
                if (containsDuplicates(matrix[i])) {
                    duplicateRows[t]++;
                }
                if (containsDuplicates(transposedMatrix[i])) {
                    duplicateCols[t]++;
                }
            }
        }
        
        for (int t = 0; t < testCases; t++) {
            System.out.println("Case #" + (t + 1) + ": " + traceSums[t] + " " + duplicateRows[t] + " " + duplicateCols[t]);
        }
        
        scanner.close();
    }
    
    private static boolean containsDuplicates(int[] array) {
        HashMap<Integer, Boolean> seen = new HashMap<>();
        for (int value : array) {
            if (seen.containsKey(value)) {
                return true;
            }
            seen.put(value, true);
        }
        return false;
    }
}