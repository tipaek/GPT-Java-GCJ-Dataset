import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          int N = in.nextInt();
          int K = in.nextInt();
          int[][] input = new int[N][N];
          boolean pos = helper(input, 0, K, new boolean[N][N], new boolean[N][N]);
          if(pos){
              System.out.println("Case #" + i + ": POSSIBLE");
          }else{
              System.out.println("Case #" + i + ": IMPOSSIBLE");
          }
        }
    }
    
    public static int Trace(int[][] M){
        int trace = 0;
        int N = M.length;
        for(int i = 0; i < N; ++i) trace += M[i][i];
        return trace;
    }
    
    public static boolean helper(int[][] M, int p, int K, 
                                boolean[][] usedR, boolean[][] usedC){
        int N = M.length;
        
        if(p == (N * N - 1)){
            return Trace(M) == K;
        }
        
        int r = p / N;
        int c = p % N;
        
        for(int i = 1; i <= N; ++i){
            if(!usedR[r][i - 1] && !usedC[c][i - 1]){
                usedR[r][i - 1] = true;
                usedC[c][i - 1] = true;
                M[r][c] = i;
                if(helper(M, p + 1, K, usedR, usedC)) return true;
                usedR[r][i - 1] = false;
                usedC[c][i - 1] = false;
                M[r][c] = 0;
            }
        }
        
        return false;
    }
}
