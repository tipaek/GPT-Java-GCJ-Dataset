import java.util.Scanner;

public class LatinSquare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            int trace = 0;
            
            // Read the matrix and compute the trace
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    arr[j][k] = sc.nextInt();
                    if (j == k) {
                        trace += arr[j][k];
                    }
                }
            }
            
            int r = 0;
            int c = 0;
            
            // Check for duplicate values in rows and columns
            for (int j = 0; j < n; j++) {
                if (hasDuplicates(arr[j])) {
                    r++;
                }
                
                int[] column = new int[n];
                for (int k = 0; k < n; k++) {
                    column[k] = arr[k][j];
                }
                
                if (hasDuplicates(column)) {
                    c++;
                }
            }
            
            System.out.println(trace + " " + r + " " + c);
        }
        
        sc.close();
    }
    
    // Helper method to check if an array has duplicates
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