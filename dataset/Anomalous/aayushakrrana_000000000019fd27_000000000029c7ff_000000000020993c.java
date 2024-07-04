import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int trace = 0, rowRepeats = 0, columnRepeats = 0;
            int[][] matrix = new int[n][n];
            
            // Reading matrix values
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            // Calculating trace and checking for row and column repeats
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
                
                // Check for row repeats
                if (hasRepeats(matrix[i])) {
                    rowRepeats++;
                }
                
                // Check for column repeats
                int[] column = new int[n];
                for (int j = 0; j < n; j++) {
                    column[j] = matrix[j][i];
                }
                if (hasRepeats(column)) {
                    columnRepeats++;
                }
            }
            
            System.out.println("Case #" + testCase + ": " + trace + " " + rowRepeats + " " + columnRepeats);
        }
    }
    
    private static boolean hasRepeats(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int value : array) {
            if (!set.add(value)) {
                return true;
            }
        }
        return false;
    }
}