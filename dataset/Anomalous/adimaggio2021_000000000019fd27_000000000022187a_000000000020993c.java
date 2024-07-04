import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int run = in.nextInt();
        
        for (int m = 0; m < run; m++) {
            int n = in.nextInt();
            int[][] sq = new int[n][n];
            
            // Read the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sq[i][j] = in.nextInt();
                }
            }
            
            // Calculate trace
            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace += sq[i][i];
            }
            
            // Count rows with duplicate elements
            int rowcount = 0;
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[n + 1];
                boolean duplicate = false;
                for (int j = 0; j < n; j++) {
                    if (seen[sq[i][j]]) {
                        duplicate = true;
                        break;
                    }
                    seen[sq[i][j]] = true;
                }
                if (duplicate) {
                    rowcount++;
                }
            }
            
            // Count columns with duplicate elements
            int colcount = 0;
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[n + 1];
                boolean duplicate = false;
                for (int j = 0; j < n; j++) {
                    if (seen[sq[j][i]]) {
                        duplicate = true;
                        break;
                    }
                    seen[sq[j][i]] = true;
                }
                if (duplicate) {
                    colcount++;
                }
            }
            
            System.out.println("Case #" + (m + 1) + ": " + trace + " " + colcount + " " + rowcount);
        }
        
        in.close();
    }
}