import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int numCases = scanner.nextInt();
        int[] sums = new int[numCases];
        int[] rows = new int[numCases];
        int[] cols = new int[numCases];
        
        for (int i = 0; i < numCases; i++) {
            int numRows = scanner.nextInt();
            int[][] matrix = new int[numRows][numRows];
            int[][] transposedMatrix = new int[numRows][numRows];
            
            for (int j = 0; j < numRows; j++) {
                for (int k = 0; k < numRows; k++) {
                    matrix[j][k] = scanner.nextInt();
                    transposedMatrix[k][j] = matrix[j][k];
                    if (j == k) {
                        sums[i] += matrix[j][k];
                    }
                }
            }
            
            for (int j = 0; j < numRows; j++) {
                if (hasDuplicates(matrix[j])) {
                    rows[i]++;
                }
                if (hasDuplicates(transposedMatrix[j])) {
                    cols[i]++;
                }
            }
        }
        
        scanner.close();
        
        for (int i = 0; i < numCases; i++) {
            System.out.println(sums[i] + " " + rows[i] + " " + cols[i]);
        }
    }
    
    public static boolean hasDuplicates(int[] array) {
        HashSet<Integer> seen = new HashSet<>();
        for (int value : array) {
            if (!seen.add(value)) {
                return true;
            }
        }
        return false;
    }
}