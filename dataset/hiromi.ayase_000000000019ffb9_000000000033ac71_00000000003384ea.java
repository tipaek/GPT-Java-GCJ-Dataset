
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.StringTokenizer;

public class Solution {

  private static final String debug = "";

  private static void solve() {
    int t = ni();
    for (int i = 1; i <= t; i++) {

      long l = nl();
      long r = nl();
      String ret = solve(l, r);
      out.printf("Case #%d: %s\n", i, ret);
    }
  }


  private static String solve(long l, long r) {

    boolean rev = r < l;
    if (rev) {
      long tmp = l;
      l = r;
      r = tmp;
    }

    // l <= r
    long d = r - l;

    long x = bisect(d);
    long served = x;
    r -= x * (x + 1) / 2;


    // l <= r
    long[] ret1;
    long[] ret2;
    if (!rev && l == r) {
      ret1 = bisect(l, served + 1);
      ret2 = bisect(r, served + 2);
      l = ret1[1];
      r = ret2[1];
    } else {
      // rev && l == r || l < r
      ret1 = bisect(r, served + 1);
      ret2 = bisect(l, served + 2);
      r = ret1[1];
      l = ret2[1];
    }

    served += ret1[0] + ret2[0];

    if (rev) {
      long tmp = l;
      l = r;
      r = tmp;
    }

    return "" + served + " " + l + " " + r;
  }

  private static long[] bisect(long n, long s) {
    long ok = 0;
    long ng = (long) 1e9;

    while (ng - ok > 1) {
      long k = (ok + ng) / 2;
      // s + (s + 2) + (s + 4) + ... + (s + 2(k-1))
      long x = k * 2 * (s + k - 1) / 2;

      if (x <= n) {
        ok = k;
      } else {
        ng = k;
      }
    }
    long last = n - ok * 2 * (s + ok - 1) / 2;
    return new long[] {ok, last};
  }


  private static long bisect(long n) {
    long ok = 0;
    long ng = (long) 1e9;

    while (ng - ok > 1) {
      long k = (ok + ng) / 2;
      long x = k * (k + 1) / 2;

      if (x <= n) {
        ok = k;
      } else {
        ng = k;
      }
    }
    return ok;
  }


  private static String solve2(long l, long r) {
    long k = 0;
    while (Math.max(l, r) >= k + 1) {
      k++;
      if (l >= r) {
        l -= k;
      } else {
        r -= k;
      }
    }
    return "" + k + " " + l + " " + r;
  }

  private static void test() {
    Random gen = new Random();

    for (int i = 0; i < 1000; i++) {
      long l = gen.nextInt(10000) + 1;
      long r = gen.nextInt(10000) + 1;
      // l = 69;
      // r = 99;

      String ret1 = solve(l, r);
      String ret2 = solve2(l, r);

      if (!ret1.equals(ret2)) {
        System.err.println(l + " " + r + " : " + ret1 + " : " + ret2);
        break;
      }
    }
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
