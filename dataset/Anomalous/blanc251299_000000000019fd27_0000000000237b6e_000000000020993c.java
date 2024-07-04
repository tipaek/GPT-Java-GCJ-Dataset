import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int t = 1; t <= T; t++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            
            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            
            int trace = 0, rowRepeats = 0, colRepeats = 0;
            
            // Calculating the trace
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }
            
            // Checking for row repeats
            for (int i = 0; i < n; i++) {
                if (hasDuplicates(matrix[i])) {
                    rowRepeats++;
                }
            }
            
            // Checking for column repeats
            for (int i = 0; i < n; i++) {
                int[] column = new int[n];
                for (int j = 0; j < n; j++) {
                    column[j] = matrix[j][i];
                }
                if (hasDuplicates(column)) {
                    colRepeats++;
                }
            }
            
            System.out.println("#" + t + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }
    
    private static boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int num : array) {
            if (num > array.length || !set.add(num)) {
                return true;
            }
        }
        return false;
    }
}