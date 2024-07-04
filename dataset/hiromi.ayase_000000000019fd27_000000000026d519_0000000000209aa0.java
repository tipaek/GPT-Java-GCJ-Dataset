
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.StringTokenizer;

public class Solution {

  private static final String debug = "";

  private static void solve() {
    int t = ni();
    for (int i = 1; i <= t; i++) {
      int n = ni();
      int k = ni();
      String ret = solve(n, k);
      out.printf("Case #%d: %s\n", i, ret);
    }
  }


  private static String solve(int n, int k) {
    int[][] ret = dfs(n, k);
    if (ret == null) {
      return "IMPOSSIBLE";
    }
    StringBuilder sb = new StringBuilder();
    sb.append("POSSIBLE\n");
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        sb.append(ret[i][j] + 1 + " ");
      }
      sb.setCharAt(sb.length() - 1, '\n');
    }
    sb.deleteCharAt(sb.length() - 1);
    return sb.toString();
  }

  private static int[][] dfs(int n, int k) {
    if (k < n) {
      return null;
    }
    k -= n;

    int[][] ret;
    int x;
    if (n % 2 == 0) {
      if (k % 2 != 0) {
        return null;
      }
      ret = f(n);
      x = k / n;
      int y = k % n;

      for (int i = 0; i < y; i++) {
        for (int j = 0; j < n; j++) {
          ret[i][j] ^= 1;
        }
      }

    } else {
      if (k % n != 0) {
        return null;
      }
      x = k / n;
      ret = f2(n);
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        ret[i][j] += x;
        ret[i][j] %= n;
      }
    }
    return ret;
  }

  private static int[][] f(int n) {
    int[][] ret = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        ret[i][(j + i / 2 * 2) % n] = j ^ (i % 2);
      }
    }
    return ret;
  }

  private static int[][] f2(int n) {
    int[][] ret = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        ret[i][(j + i) % n] = j;
      }
    }
    return ret;
  }

  private static void test() {

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
