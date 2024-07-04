/**
 * @author Finn Lidbetter
 */
import java.util.*;
import java.io.*;
import java.awt.geom.*;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
  
    int nTests = Integer.parseInt(br.readLine());
    for (int test=0; test<nTests; test++) {
      String[] s = br.readLine().split(" ");
      int n = Integer.parseInt(s[0]);
      int trace = Integer.parseInt(s[1]);
      if (trace==n+1 || trace==n*n-1) {
        sb.append(String.format("Case #%d: IMPOSSIBLE\n", test+1));
        continue;
      }
      Integer[][] grid = new Integer[n][n];
      int a = -1;
      int b = -1;
      int c = -1;
      if (trace%n==0) {
        a = trace/n;
        b = a;
        c = a;
      } else {
        for (int i=1; i<=n; i++) {
          for (int j=1; j<=n; j++) {
            if (i==j)
              continue;
            for (int k=j; k<=n; k++) {
              if (i==k)
                continue;
              if (n==3 && j==k)
                continue;
              if (i*(n-2) + j + k == trace) {
                a = i;
                b = j;
                c = k;
                break;
              }
            }
            if (a>=0)
              break;
          }
          if (a>=0)
            break;
        }
      }
      for (int i=0; i<n-2; i++) {
        grid[i][i] = a;
      }
      grid[n-2][n-2] = b;
      grid[n-1][n-1] = c;
      if (a!=b) {
        grid[n-1][n-2] = a;
        grid[n-2][n-1] = a;
      }
      // All a's have been placed.
      // Next, place b's.
      if (b!=a)
        placeValue(grid, b);
      if (c!=b && c!=a)
        placeValue(grid, c);
      for (int i=1; i<=n; i++) {
        if (i!=a && i!=b && i!=c)
          placeValue(grid, i);
      }

      sb.append(String.format("Case #%d: POSSIBLE\n%s", test+1, gridToString(grid)));
    }
    System.out.print(sb);
  }
  static void placeValue(Integer[][] grid, int val) {
    int n = grid.length;
    List<Edge>[] graph = createGraph(2*n + 2);
    
    boolean[] validRow = new boolean[n];
    boolean[] validCol = new boolean[n];
    for (int i=0; i<n; i++) {
      validRow[i] = !rowHasValue(grid, i, val);
      validCol[i] = !colHasValue(grid, i, val);
    }
    for (int r=0; r<n; r++) {
      if (!validRow[r])
        continue;
      for (int c=0; c<n; c++) {
        if (!validCol[c])
          continue;
        if (grid[r][c]==null) 
          addEdge(graph, r, n+c, 1);
      }
    }
    for (int i=0; i<n; i++) {
      if (validRow[i]) {
        addEdge(graph, 2*n, i, 1);
      }
      if (validCol[i]) {
        addEdge(graph, n+i, 2*n+1, 1);
      }
    }
    int[] cut = maxFlow(graph, 2*n, 2*n+1);
    for (int i=0; i<n; i++) {
      if (!validRow[i]) 
        continue;
      for (Edge e: graph[i]) {
        if (e.f>0) {
          grid[i][e.v-n] = val;
        }
      }
    }
  }
  static String gridToString(Integer[][] grid) {
    int n = grid.length;
    StringBuilder sb = new StringBuilder();
    for (int i=0; i<n; i++) {
      for (int j=0; j<n; j++) {
        if (grid[i][j]==null)
          sb.append(0);
        else
          sb.append(grid[i][j]);
        if (j==n-1)
          sb.append("\n");
        else
          sb.append(" ");
      }
    }
    return sb.toString();
  }

  static boolean rowHasValue(Integer[][] grid, int r, int v) {
    int n = grid.length;
    for (int c=0; c<n; c++) {
      if (grid[r][c]!=null && grid[r][c]==v)
        return true;
    }
    return false;
  }
  static boolean colHasValue(Integer[][] grid, int c, int v) {
    int n = grid.length;
    for (int r=0; r<n; r++) {
      if (grid[r][c]!=null && grid[r][c]==v)
        return true;
    }
    return false;
  }

  static List<Edge>[] createGraph(int nodes) {
    List<Edge>[] graph = new List[nodes];
    for (int i = 0; i < nodes; i++) 
      graph[i] = new ArrayList<>();
    return graph; 
  }
  static void addEdge(List<Edge>[] graph, int u, int v, double cap) {
    graph[u].add(new Edge(v, graph[v].size(), cap));
    graph[v].add(new Edge(u, graph[u].size() - 1, 0)); 
  }
  static int[] maxFlow(List<Edge>[] graph, int src, int dest) {
    double flow = 0;
    int[] dist = new int[graph.length];
    while (dinicBfs(graph, src, dest, dist)) {
      int[] ptr = new int[graph.length];
      while (true) {
        double df = dinicDfs(graph, ptr, dist, dest, src, Double.MAX_VALUE);
        if (df == 0) 
          break;
        flow += df; 
      } 
    }
    return dist; 
  }
  static boolean dinicBfs(List<Edge>[] graph, int src, int dest, int[] dist) {
    Arrays.fill(dist, -1);
    dist[src] = 0;
    int[] q = new int[graph.length];
    int size = 0;
    q[size++] = src;
    for (int i = 0; i < size; i++)
      for (Edge e : graph[q[i]])
        if (dist[e.v] < 0 && e.f < e.cap) {
          dist[e.v] = dist[q[i]] + 1;
          q[size++] = e.v; }
    return dist[dest] >= 0; }
  static double dinicDfs(List<Edge>[] graph, int[] ptr, int[] dist, int dest, int u, double f) {
    if (u == dest) 
      return f;
    for (; ptr[u] < graph[u].size(); ++ptr[u]) {
      Edge e = graph[u].get(ptr[u]);
      if (dist[e.v] == dist[u] + 1 && e.f < e.cap) {
        double df = dinicDfs(graph, ptr, dist, dest, e.v, Math.min(f, e.cap - e.f));
        if (df > 0) {
          e.f += df;
          graph[e.v].get(e.rev).f -= df;
          return df; 
        } 
      } 
    }
    return 0;
  }
  static class Edge {
    int v, rev; double cap, f;
    public Edge(int v, int rev, double cap) {
      this.v = v; this.rev = rev; this.cap = cap; 
    }
  }

}
