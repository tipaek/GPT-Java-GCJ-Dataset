import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        for (int k = 1; k <= t; k++) {
            int n = sc.nextInt();
            int[][] mat = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = sc.nextInt();
                }
            }
            
            int trace = 0;
            int cntr = 0;
            int cntc = 0;
            
            for (int i = 0; i < n; i++) {
                boolean[] rowCheck = new boolean[n + 1];
                boolean[] colCheck = new boolean[n + 1];
                boolean rowDuplicate = false;
                boolean colDuplicate = false;
                
                for (int j = 0; j < n; j++) {
                    if (i == j) {
                        trace += mat[i][j];
                    }
                    
                    if (!rowCheck[mat[i][j]]) {
                        rowCheck[mat[i][j]] = true;
                    } else {
                        rowDuplicate = true;
                    }
                    
                    if (!colCheck[mat[j][i]]) {
                        colCheck[mat[j][i]] = true;
                    } else {
                        colDuplicate = true;
                    }
                }
                
                if (rowDuplicate) {
                    cntr++;
                }
                if (colDuplicate) {
                    cntc++;
                }
            }
            
            System.out.println("Case #" + k + ": " + trace + " " + cntr + " " + cntc);
        }
        
        sc.close();
    }
}