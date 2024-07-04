import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        for (int k = 1; k <= t; k++) {
            int n = sc.nextInt();
            int[][] mat = new int[n][n];
            int trace = 0, cntr = 0, cntc = 0;
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = sc.nextInt();
                    if (i == j) {
                        trace += mat[i][j];
                    }
                }
            }
            
            for (int i = 0; i < n; i++) {
                boolean[] rowCheck = new boolean[n + 1];
                boolean[] colCheck = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    if (rowCheck[mat[i][j]]) {
                        cntr++;
                        break;
                    }
                    rowCheck[mat[i][j]] = true;
                }
                
                for (int j = 0; j < n; j++) {
                    if (colCheck[mat[j][i]]) {
                        cntc++;
                        break;
                    }
                    colCheck[mat[j][i]] = true;
                }
            }
            
            System.out.println("Case #" + k + ": " + trace + " " + cntr + " " + cntc);
        }
        
        sc.close();
    }
}