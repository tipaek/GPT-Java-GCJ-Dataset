
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

  private static final String debug = "test";

  private static void solve() {
    int t = ni();
    for (int i = 1; i <= t; i++) {
      int n = ni();
      String ret = solve(n);
      out.printf("Case #%d:\n%s", i, ret);
    }
  }


  private static String solve(long n) {
    StringBuilder sb = new StringBuilder();

    int m = 50;
    if (n < m) {
      sb.append("1 1\n");
      n--;
      for (int i = 0; i < n; i++) {
        sb.append((i + 2) + " 1\n");
      }
    } else {
      long x = n - 33;
      boolean[] rb = new boolean[m + 2];
      for (int i = 30; i >= 1; i--) {
        if (((x >> i) & 1) == 1) {
          rb[i + 1] = true;
        }
      }

      boolean rev = false;
      int k = 1;
      for (int r = 1; r <= 30; r++) {
        if (rb[r]) {
          if (!rev) {
            for (; k <= r; k++) {
              n -= C(r - 1, k - 1, mod, fif);
              sb.append(r + " " + k + "\n");
            }
          } else {
            for (; k >= 1; k--) {
              n -= C(r - 1, k - 1, mod, fif);
              sb.append(r + " " + k + "\n");
            }
            k = 1;
          }
          rev = !rev;
        } else {
          k = (rev ? r : 1);
          n -= C(r - 1, k - 1, mod, fif);
          sb.append(r + " " + k + "\n");
        }
      }
      if (n < 0) {
        n += mod;
      }
      for (int i = 0; i < n; i++) {
        int r = 30 + 1 + i;
        sb.append(r + " " + (rev ? r : 1) + "\n");
      }
    }

    return sb.toString();
  }

  static int mod = (int) 1e9 + 7;
  static int[][] fif = enumFIF(100000, mod);

  private static void test() {

    for (int t = 1; t <= 100000; t++) {
      String[] ret = solve(t).split("\n");
      int n = ret.length;
      if (n > 500) {
        throw new RuntimeException();
      }
      int[][] a = new int[n][2];

      int v = 0;
      Set<String> set = new HashSet<>();
      for (int i = 0; i < n; i++) {
        String[] e = ret[i].split(" ");
        if (set.contains(ret[i])) {
          throw new RuntimeException();
        }
        set.add(ret[i]);
        a[i][0] = Integer.parseInt(e[0]);
        a[i][1] = Integer.parseInt(e[1]);

        if (i == 0) {
          if (a[i][0] != 1 || a[i][1] != 1) {
            throw new RuntimeException();
          }
        } else if (i > 0) {
          if (Math.abs(a[i][0] - a[i - 1][0]) > 1 || Math.abs(a[i][1] - a[i - 1][1]) > 1) {
            throw new RuntimeException();
          }
        }
        v += C(a[i][0] - 1, a[i][1] - 1, mod, fif);
      }
      if (t != v) {
        System.out.println(t + " " + v);
      }
    }
  }

  public static int[][] enumFIF(int n, int mod) {
    int[] f = new int[n + 1];
    int[] invf = new int[n + 1];
    f[0] = 1;
    for (int i = 1; i <= n; i++) {
      f[i] = (int) ((long) f[i - 1] * i % mod);
    }
    long a = f[n];
    long b = mod;
    long p = 1, q = 0;
    while (b > 0) {
      long c = a / b;
      long d;
      d = a;
      a = b;
      b = d % b;
      d = p;
      p = q;
      q = d - c * q;
    }
    invf[n] = (int) (p < 0 ? p + mod : p);
    for (int i = n - 1; i >= 0; i--) {
      invf[i] = (int) ((long) invf[i + 1] * (i + 1) % mod);
    }
    return new int[][] {f, invf};
  }

  public static long C(int n, int r, int mod, int[][] fif) {
    if (n < 0 || r < 0 || r > n)
      return 0;
    return (long) fif[0][n] * fif[1][r] % mod * fif[1][n - r] % mod;
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
