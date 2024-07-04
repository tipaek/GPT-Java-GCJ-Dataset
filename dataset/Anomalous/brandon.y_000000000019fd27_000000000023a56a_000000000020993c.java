import java.util.*;
import java.io.*;

public class Solution {
    // Check if there are duplicates within K distance in the array
    static boolean checkDuplicatesWithinK(int[] arr, int k) {
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i])) {
                return true;
            }
            set.add(arr[i]);
            if (i >= k) {
                set.remove(arr[i - k]);
            }
        }
        return false;
    }

    // Swap rows and columns of a 2D array
    private static int[][] swapMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int[][] swappedMatrix = new int[cols][rows];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                swappedMatrix[j][i] = matrix[i][j];
            }
        }
        return swappedMatrix;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int trace = 0;
            int rowRepeatCount = 0;
            int colRepeatCount = 0;
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            
            // Read the matrix and calculate trace
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
                // Check for row duplicates
                if (checkDuplicatesWithinK(matrix[i], n)) {
                    rowRepeatCount++;
                }
            }
            
            // Swap rows and columns to check for column duplicates
            int[][] transposedMatrix = swapMatrix(matrix);
            for (int i = 0; i < n; i++) {
                if (checkDuplicatesWithinK(transposedMatrix[i], n)) {
                    colRepeatCount++;
                }
            }
            
            System.out.println("Case #" + caseNum + ": " + trace + " " + rowRepeatCount + " " + colRepeatCount);
        }
    }
}