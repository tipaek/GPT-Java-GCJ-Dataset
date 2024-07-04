import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int k = 1; k <= T; k++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            int trace = 0, rowRepeats = 0, colRepeats = 0;
            
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
            
            // Checking for row duplicates
            for (int i = 0; i < n; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    rowSet.add(arr[i][j]);
                }
                if (rowSet.size() < n) {
                    rowRepeats++;
                }
            }
            
            // Checking for column duplicates
            for (int i = 0; i < n; i++) {
                HashSet<Integer> colSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    colSet.add(arr[j][i]);
                }
                if (colSet.size() < n) {
                    colRepeats++;
                }
            }
            
            System.out.println("Case #" + k + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
        
        sc.close();
    }
}