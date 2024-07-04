import java.util.*;
import java.io.*;
public class Solution {
  
  public static void solve(Scanner in) {
    int C = in.nextInt();
    int D = in.nextInt();
    int[] x = new int[C + 1];
    int[] t = new int[C + 1];
    int[] r = new int[C + 1];
    for(int i = 2; i <= C; ++i) {
      x[i] = in.nextInt();
      if(x[i] < 0) {
        r[i] = -x[i];
        t[i] = -1;
      } else {
        t[i] = x[i];
        r[i] = -1;
      }
    }
    Integer[] idx = new Integer[C - 1];
    for(int i = 0; i < idx.length; ++i) {
      idx[i] = i + 2;
    }
    Arrays.sort(idx, new Comparator<Integer>() {
      public int compare(Integer a, Integer b) {
        return (t[a] < 0 ? 10000 : t[a]) - (t[b] < 0 ? 10000 : t[b]);
      }
    });
    int p = 0;
    for(p = 0; p < idx.length; ++p) {
      if(t[idx[p]] < 0) break;
    }
    boolean[] v = new boolean[C + 1];
    for(; p < idx.length; ++p) {
      int b = r[idx[p]];
      while(v[b]) {
        ++b;
      }
      v[b] = true;
    }
    int c = 1;
    while(v[c]) {
      c++;
    }
    int s = c;
    for(p = 0; p < idx.length && t[idx[p]] > 0; ++p) {
      if(p > 0 && t[idx[p]] > t[idx[p - 1]]) s = c;
      r[idx[p]] = s;
      c++;
    }
    boolean[][] map = new boolean[C + 1][C + 1];
    int[][] edge = new int[D][3];
    for(int i = 0; i < D; ++i) {
      edge[i][0] = in.nextInt();
      edge[i][1] = in.nextInt();
      int a = edge[i][0];
      int b = edge[i][1];
      map[a][b] = map[b][a] = true;
    }
    int[] dist = new int[C + 1];
    for(int i = 0; i < dist.length; ++i) {
      dist[i] = Integer.MAX_VALUE;
    }
    dist[1] = 0;
    Integer[] i = new Integer[C - 1];
    for(int j = 0; j < i.length; ++j) {
      i[j] = j + 2;
    }
    Arrays.sort(i, new Comparator<Integer>() {
      public int compare(Integer a, Integer b) {
        return r[a] - r[b];
      }
    });
    int m = 1;
    for(int j = 0; j < i.length; ++j) {
      if(j > 0 && r[i[j]] > r[i[j - 1]]) {
        ++m;
      }
      m = Math.max(m, t[i[j]]);
      dist[i[j]] = m;
      for(int k = 1; k <= C; ++k) {
        if(!map[k][i[j]] || dist[k] == Integer.MAX_VALUE) continue;
        for(int q = 0; q < edge.length; ++q) {
          if(k == edge[q][0] && i[j] == edge[q][1]) {
            edge[q][2] = Math.max(1, dist[i[j]] - dist[k]);
          }
          if(k == edge[q][1] && i[j] == edge[q][0]) {
            edge[q][2] = Math.max(1, dist[i[j]] - dist[k]);
          }
        }
      }
    }
    for(int q = 0; q < edge.length; ++q) {
      System.out.print(edge[q][2] + " ");
    }
    System.out.println();
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