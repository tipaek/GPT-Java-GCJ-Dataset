import java.util.*;

public class Solution {
    
    public static void main(String[] args) {
        
       Scanner s = new Scanner(System.in);

       int T = s.nextInt();

       for(int i = 0; i < T; i++) {
           solve(i+1, s);
       }

        
    }

    private static void solve(int cid, Scanner s) {

        int N = s.nextInt();

        int[][] M = new int[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                M[i][j] = s.nextInt();
            }
        }

        int trace = 0;
        for(int i = 0; i < N; i++) {
            trace += M[i][i];
        }

        int row_dups = 0;
        for(int i = 0; i < N; i++) {
            boolean[] used = new boolean[N];
            for(int j = 0; j < N; j++) {
                if(used[M[i][j]-1]) {
                    row_dups++;
                    break;
                }
                used[M[i][j]-1] = true;
            }
        }

        int col_dups = 0;
        for(int j = 0; j < N; j++) {
            boolean[] used = new boolean[N];
            for(int i = 0; i < N; i++) {
                if(used[M[i][j]-1]) {
                    col_dups++;
                    break;
                }
                used[M[i][j]-1] = true;
            }
        }

        System.out.println("Case #" + cid + ": " + trace + " " + row_dups + " " + col_dups);

    }
    
}