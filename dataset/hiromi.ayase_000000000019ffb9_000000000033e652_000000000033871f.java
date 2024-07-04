
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution {

  private static final String debug = "";

  private static void solve() {
    int t = ni();
    for (int i = 1; i <= t; i++) {
      int c = ni();
      int d = ni();
      int[] x = new int[c];
      for (int j = 1; j < c; j++) {
        x[j] = ni();
      }
      int[] from = new int[d];
      int[] to = new int[d];
      int[] w = new int[d];
      for (int j = 0; j < d; j++) {
        from[j] = ni() - 1;
        to[j] = ni() - 1;
        w[j] = j;
      }
      int[] ret = solve(c, d, x, packWU(c, from, to, w));
      StringBuilder sb = new StringBuilder();
      for (int v : ret) {
        sb.append(v + " ");
      }
      out.printf("Case #%d: %s\n", i, sb.substring(0, sb.length() - 1));
    }
  }


  private static int[] solve(int c, int d, int[] x, int[][][] g) {
    int[] y = new int[d];
    Arrays.fill(y, -1);

    TreeSet<int[]> q = new TreeSet<>((o1, o2) -> {
      int a = o1[0];
      int b = o2[0];
      if (x[a] - x[b] != 0)
        return -(x[a] - x[b]);
      return a - b;
    });

    q.add(new int[] {0, -1, 0});
    Map<Integer, Integer> map = new HashMap<>();
    int nowLen = 0;

    boolean[] ved = new boolean[c];
    while (q.size() > 0) {
      int[] v = q.pollFirst();
      int cur = v[0];
      int edge = v[1];
      int lastLen = v[2];

      if (cur > 0) {
        if (!map.containsKey(x[cur])) {
          nowLen++;
          map.put(x[cur], nowLen);
        }
        y[edge] = map.get(x[cur]) - lastLen;
      }
      ved[cur] = true;


      int len = cur == 0 ? 0 : map.get(x[cur]);
      for (int i = 0; i < g[cur].length; i++) {
        int nex = g[cur][i][0];
        int nexEdg = g[cur][i][1];
        if (ved[nex])
          continue;
        q.add(new int[] {nex, nexEdg, len});
      }
    }

    for (int i = 0; i < d; i++) {
      if (y[i] < 0) {
        y[i] = 1000000;
      }
    }

    return y;
  }


  private static void test() {

  }

  public static int[][][] packWU(int n, int[] from, int[] to, int[] w) {
    int[][][] g = new int[n][][];
    int[] p = new int[n];
    for (int f : from)
      p[f]++;
    for (int t : to)
      p[t]++;
    for (int i = 0; i < n; i++)
      g[i] = new int[p[i]][2];
    for (int i = 0; i < from.length; i++) {
      --p[from[i]];
      g[from[i]][p[from[i]]][0] = to[i];
      g[from[i]][p[from[i]]][1] = w[i];
      --p[to[i]];
      g[to[i]][p[to[i]]][0] = from[i];
      g[to[i]][p[to[i]]][1] = w[i];
    }
    return g;
  }


  public static void main(String[] args) {
    new Thread(null, new Runnable() {
      @Override
      public void run() {
        if (debug.equals("test")) {
          test();
        } else if (!debug.equals("")) {
          long start = System.currentTimeMillis();
          InputStream is = new ByteArrayInputStream(debug.getBytes(StandardCharsets.UTF_8));
          OutputStream os = new ByteArrayOutputStream();
          reader = new BufferedReader(new InputStreamReader(is), 32768);
          out = new PrintWriter(os);
          solve();
          out.flush();
          System.err.println(((ByteArrayOutputStream) os).toString());
          System.err.printf("[%d ms]%n%n", System.currentTimeMillis() - start);
        } else {
          reader = new BufferedReader(new InputStreamReader(System.in));
          out = new PrintWriter(System.out);
          solve();
          out.flush();
        }
      }
    }, "", 64000000).start();
  }


  private static PrintWriter out;
  private static StringTokenizer tokenizer = null;
  private static BufferedReader reader;

  public static String next() {
    while (tokenizer == null || !tokenizer.hasMoreTokens()) {
      try {
        tokenizer = new java.util.StringTokenizer(reader.readLine());
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    }
    return tokenizer.nextToken();
  }

  private static double nd() {
    return Double.parseDouble(next());
  }

  private static long nl() {
    return Long.parseLong(next());
  }

  private static int[] na(int n) {
    int[] a = new int[n];
    for (int i = 0; i < n; i++)
      a[i] = ni();
    return a;
  }

  private static char[] ns() {
    return next().toCharArray();
  }

  private static long[] nal(int n) {
    long[] a = new long[n];
    for (int i = 0; i < n; i++)
      a[i] = nl();
    return a;
  }

  private static int[][] ntable(int n, int m) {
    int[][] table = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        table[i][j] = ni();
      }
    }
    return table;
  }

  private static int[][] nlist(int n, int m) {
    int[][] table = new int[m][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        table[j][i] = ni();
      }
    }
    return table;
  }

  private static int ni() {
    return Integer.parseInt(next());
  }
}
