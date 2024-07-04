
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
      String[] p = new String[n];
      for (int j = 0; j < n; j++) {
        p[j] = next();
      }
      String ret = solve(p);
      out.printf("Case #%d: %s\n", i, ret);
    }
  }


  private static String solve(String[] p) {
    int n = p.length;
    StringBuilder mid = new StringBuilder();
    StringBuilder pre = new StringBuilder();
    StringBuilder suf = new StringBuilder();
    for (int i = 0; i < n; i++) {
      String s = "#" + p[i] + "$";
      String[] elem = s.split("\\*");
      // mid
      int m = elem.length;
      for (int j = 1; j < m - 1; j++) {
        mid.append(elem[j]);
      }

      // pre suf
      if (!f(pre, elem[0], false) || !f(suf, elem[m - 1], true)) {
        return "*";
      }
    }
    pre.deleteCharAt(0);
    pre.append(mid);
    pre.append(suf.deleteCharAt(0).reverse());
    return pre.toString();
  }

  private static boolean f(StringBuilder sb, String s, boolean rev) {
    int len = Math.min(sb.length(), s.length());
    int n = s.length();
    char[] t = new char[n];
    for (int i = 0; i < n; i++) {
      t[i] = s.charAt(rev ? (n - i - 1) : i);
    }

    for (int i = 0; i < len; i++) {
      if (sb.charAt(i) != t[i]) {
        return false;
      }
    }
    for (int i = len; i < s.length(); i++) {
      sb.append(t[i]);
    }
    return true;
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
