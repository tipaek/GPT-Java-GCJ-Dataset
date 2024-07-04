import java.util.*;
import java.io.*;
public class Solution {
  public static boolean check(int[] d, int[] dd) {
    return (long)d[0] * dd[0] + (long)d[1] * dd[1] > 0 &&
        (long)d[1] * dd[0] == (long)d[0] * dd[1];
  }
  
  public static int count(int[] conf, int i, int[] d, int[][] c, int N) {
    boolean[] v = new boolean[N];
    boolean[] e = new boolean[N];
    int n = i;
    while(!e[n]) {
      e[n] = true;
      v[n] = true;
      if(n == conf[n]) break;
      n = conf[n];
      v[n] = true;
      long m = Long.MAX_VALUE;
      int pp = -1;
      for(int p = 0; p < N; ++p) {
        int[] dd = new int[2];
        dd[0] = c[p][0] - c[n][0];
        dd[1] = c[p][1] - c[n][1];
        if(check(d, dd)) {
          long mm = (long)d[0] * dd[0] + (long)d[1] * dd[1];
          if(mm < m) {
            pp = p;
            m = mm;
          }
        }
      }
      if(pp == -1) break;
      n = pp;
    }
    int ans = 0;
    for(int k = 0; k < N; ++k) {
      if(v[k]) ans++;
    }
    return ans;
  }
  
  public static void dfs(int[] conf, int dep, int bool, int N, int[] ans, int[][] c) {
    if(dep == N) {
      boolean ok = true;
      for(int i = 0; i < N; i++) {
        if(conf[conf[i]] != i) {
          ok = false;
        }
      }
      if(!ok) return;
      for(int i = 0; i < N; ++i) {
        for(int j = 0; j < N; ++j) {
          if(i == j) continue;
          for(int k = 0; k < N; ++k) {
            int[] d = new int[2];
            d[0] = c[j][0] - c[i][0];
            d[1] = c[j][1] - c[i][1];
            ans[0] = Math.max(ans[0], count(conf, k, d, c, N));
          }
        }
      }
      return;
    }
    for(int i = 0; i < N; i++) {
      if((bool & (1 << i)) == 0) {
        conf[dep] = i;
        dfs(conf, dep + 1, bool & (1 << i), N, ans, c);
      }
    }
  }
  
  public static void solve(Scanner in) {
    int N = in.nextInt();
    int[][] c = new int[N][2];
    for(int i = 0; i < N; i++) {
      c[i][0] = in.nextInt();
      c[i][1] = in.nextInt();
    }
    int[] conf = new int[N];
    int[] ans = new int[1];
    ans[0] = 1;
    dfs(conf, 0, 0, N, ans, c);
    System.out.println(ans[0]);
  }
    
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int i = 1; i <= t; ++i) {
      System.out.print("Case #" + i + ": ");
      solve(in);
    }
  }
}