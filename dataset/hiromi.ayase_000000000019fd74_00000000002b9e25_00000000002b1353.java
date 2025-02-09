
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
      String ret = solve(n);
      out.printf("Case #%d: %s", i, ret);
    }
  }


  private static String solve(long n) {
    StringBuilder sb = new StringBuilder();
    sb.append("\n");
    sb.append("1 1\n");
    n--;

    if (n < 3) {
      for (int i = 2; i < n; i++) {
        sb.append((i + 1) + " 1\n");
      }
    } else if (n < 1000) {
      sb.append("2 1\n");
      sb.append("3 2\n");
      n -= 3;
      int r = 3;
      int k = 2;
      while (n > 0) {
        if (n >= 3) {
          if (r == 3) {
            r = 4;
            n -= 3;
          } else {
            r = 3;
            n -= 2;
          }
        } else {
          if (k > 1) {
            k--;
            n--;
          } else {
            r++;
            n--;
          }
        }
        sb.append(r + " " + k + "\n");
      }
    } else {
      return "";
    }

    return sb.toString();
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
