import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        
        for (int i = 1; i <= testcase; i++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            int rsum = 0;
            
            // Reading the matrix and calculating the trace
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    arr[j][k] = sc.nextInt();
                    if (j == k) {
                        rsum += arr[j][k];
                    }
                }
            }
            
            System.out.print("Case #" + i + ": " + rsum);
            int r = 0, c = 0;
            
            // Checking for duplicate values in rows
            for (int j = 0; j < n; j++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int k = 0; k < n; k++) {
                    if (!rowSet.add(arr[j][k])) {
                        r++;
                        break;
                    }
                }
            }
            
            // Checking for duplicate values in columns
            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int k = 0; k < n; k++) {
                    if (!colSet.add(arr[k][j])) {
                        c++;
                        break;
                    }
                }
            }
            
            System.out.println(" " + r + " " + c);
        }
        
        sc.close();
    }
}