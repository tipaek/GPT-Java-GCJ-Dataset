
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
import java.util.function.Function;

public class Solution {

  private static final String debug = "";

  private static void solve() {
    int t = ni();
    for (int i = 1; i <= t; i++) {
      int b = ni();
      String ret = solve(b, v -> ask(v));
      out.println(ret);
      out.flush();

      if (next().equals("N")) {
        break;
      }
    }
  }

  private static int ask(int output) {
    out.println(output + 1);
    out.flush();

    int ret = ni();

    return ret;
  }


  private static String solve(int b, Function<Integer, Integer> ask) {
    int[] ret = new int[b];
    int[] type = new int[b];


    for (int i = 0, j = b - 1; i < j; i++, j--) {
      ret[i] = ask.apply(i);
      ret[j] = ask.apply(j);
      type[i] = type[j] = ret[i] == ret[j] ? 1 : 2;
    }

    int[][] set = {{0, b / 4, 5}, {b / 4, b / 2, 5}, {0, b / 2, b / 4}};
    if (b == 10) {
      set = new int[][] {{0, b / 2, 5}};
    }
    for (int[] v : set) {
      // 1:same 2:diff
      int count = 0;
      for (int i = v[0]; i < v[1]; i += v[2]) {

        int c1 = 0;
        int c2 = 0;
        for (int j = i; j < i + v[2]; j++) {
          if (c1 == 0 && type[j] == 1) {
            c1 = ask.apply(j) == ret[j] ? 1 : 2;
            count++;
          } else if (c2 == 0 && type[j] == 2) {
            c2 = ask.apply(j) == ret[j] ? 1 : 2;
            count++;
          }

          if (type[j] == 1 && c1 == 2 || type[j] == 2 && c2 == 2) {
            ret[j] ^= 1;
            ret[b - j - 1] ^= 1;
          }
        }
      }

      for (int i = 0; i < 10 - count; i++) {
        ask.apply(0);
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int v : ret) {
      sb.append(v);
    }
    return sb.toString();
  }


  static int count = 0;

  private static void test() {
    int b = 100;
    int[] bit = new int[b];
    Random gen = new Random();

    while (true) {
      for (int i = 0; i < b; i++) {
        bit[i] = gen.nextInt(2);
      }
      count = 0;
      System.err.println("Trying: " + dump(bit));

      String ret = solve(b, v -> {
        count++;
        if (count > 150) {
          return (int) 'N';
        }
        if (count % 10 == 1) {
          int type = 2;// gen.nextInt(4);
          if (type == 0 || type == 2) {
            for (int i = 0; i < b; i++) {
              bit[i] ^= 1;
            }
          }
          if (type == 1 || type == 2) {
            for (int i = 0, j = b - 1; i < j; i++, j--) {
              int tmp = bit[i];
              bit[i] = bit[j];
              bit[j] = tmp;
            }
          }
          System.err.println("Type:" + type + " " + dump(bit));
        }
        return bit[v];
      });

      if (!ret.equals(dump(bit))) {
        throw new RuntimeException("WA:" + dump(bit) + " " + ret);
      }
      System.err.println("AC:" + dump(bit) + " " + ret);
    }
  }

  private static String dump(int[] bit) {
    StringBuilder ans = new StringBuilder();
    for (int v : bit) {
      ans.append(v);
    }
    return ans.toString();
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
