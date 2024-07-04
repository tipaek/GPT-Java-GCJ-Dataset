
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

  private static final String debug = "";

  private static void solve() {
    int t = ni();
    for (int i = 1; i <= t; i++) {
      int n = ni();
      String ret = solve(ntable(n, n));
      out.printf("Case #%d: %s\n", i, ret);
    }
  }


  private static String solve(int[][] m) {
    int n = m.length;

    int tr = 0;
    int r = 0;
    int c = 0;
    for (int i = 0; i < n; i++) {
      Set<Integer> row = new HashSet<>();
      Set<Integer> col = new HashSet<>();
      for (int j = 0; j < n; j++) {
        row.add(m[i][j]);
        col.add(m[j][i]);
      }
      tr += m[i][i];
      r += row.size() == n ? 0 : 1;
      c += col.size() == n ? 0 : 1;
    }
    return tr + " " + r + " " + c;
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
