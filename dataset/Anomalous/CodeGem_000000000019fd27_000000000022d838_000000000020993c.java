import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int testCase = 1; testCase <= t; testCase++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            
            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace += arr[i][i];
            }
            
            int duplicateRows = 0;
            for (int row = 0; row < n; row++) {
                Set<Integer> uniqueElements = new HashSet<>();
                boolean hasDuplicate = false;
                
                for (int col = 0; col < n; col++) {
                    if (!uniqueElements.add(arr[row][col])) {
                        hasDuplicate = true;
                    }
                }
                
                if (hasDuplicate) {
                    duplicateRows++;
                }
            }
            
            int duplicateCols = 0;
            for (int col = 0; col < n; col++) {
                Set<Integer> uniqueElements = new HashSet<>();
                boolean hasDuplicate = false;
                
                for (int row = 0; row < n; row++) {
                    if (!uniqueElements.add(arr[row][col])) {
                        hasDuplicate = true;
                    }
                }
                
                if (hasDuplicate) {
                    duplicateCols++;
                }
            }
            
            System.out.println("Case #" + testCase + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
        sc.close();
    }
}