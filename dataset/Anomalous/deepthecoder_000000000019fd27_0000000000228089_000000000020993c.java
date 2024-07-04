import java.util.*;

class Solution {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int z = 1; z <= t; z++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            int trace = 0, crow = 0, ccol = 0;
            
            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            
            // Calculating the trace
            for (int i = 0; i < n; i++) {
                trace += arr[i][i];
            }
            
            // Check for duplicate values in rows and columns
            for (int i = 0; i < n; i++) {
                if (hasDuplicates(arr[i])) {
                    crow++;
                }
                
                int[] col = new int[n];
                for (int j = 0; j < n; j++) {
                    col[j] = arr[j][i];
                }
                
                if (hasDuplicates(col)) {
                    ccol++;
                }
            }
            
            System.out.println("Case #" + z + ": " + trace + " " + crow + " " + ccol);
        }
    }
    
    private static boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int num : array) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}