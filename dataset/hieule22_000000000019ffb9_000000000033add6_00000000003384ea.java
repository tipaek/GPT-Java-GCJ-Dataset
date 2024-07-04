import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in Actual solution is at the top
 *
 * @author Hieu Le
 */
public class Solution {
  public static void main(String[] args) {
    InputStream inputStream = System.in;
    OutputStream outputStream = System.out;
    InputReader in = new InputReader(inputStream);
    PrintWriter out = new PrintWriter(outputStream);
    HouseOfPancakes solver = new HouseOfPancakes();
    int testCount = Integer.parseInt(in.next());
    for (int i = 1; i <= testCount; i++) solver.solve(i, in, out);
    out.close();
  }

  static class HouseOfPancakes {
    boolean DEBUG = false;

    public void solve(int testNumber, InputReader in, PrintWriter out) {
      long l = in.nextLong();
      long r = in.nextLong();

      long L = l, R = r;
      int n = 1;
      if (DEBUG) {
        while (Math.max(L, R) >= n) {
          if (L >= R) {
            L -= n;
          } else {
            R -= n;
          }
          ++n;
        }
      }

      long delta = Math.abs(l - r);

      // Find max n such as n * (n + 1) / 2 <= delta
      long initial;
      {
        long low = 0;
        long high = (long) Math.sqrt(2 * delta);
        while (low < high) {
          long mid = low + (high - low + 1) / 2;
          if (mid * (mid + 1) > 2 * delta) {
            high = mid - 1;
          } else {
            low = mid;
          }
        }
        initial = low;
      }

      long offset = initial * (initial + 1) / 2;
      if (l > r) {
        l -= offset;
      } else if (l < r) {
        r -= offset;
      }

      long low = initial;
      long high = 2 * (long) 1e9;

      while (low < high) {
        long mid = low + (high - low + 1) / 2;
        if (check(l, r, initial + 1, mid)) {
          low = mid;
        } else {
          high = mid - 1;
        }
      }

      if (l >= r) {
        l -= calculate(initial + 1, low);
        r -= calculate(initial + 2, low);
      } else {
        l -= calculate(initial + 2, low);
        r -= calculate(initial + 1, low);
      }

      if (DEBUG) {
        if (low != n - 1 || l != L || r != R) {
          throw new RuntimeException();
        }
      }

      out.printf("Case #%d: %d %d %d\n", testNumber, low, l, r);
    }

    private boolean check(long l, long r, long first, long last) {
      long small = Math.min(l, r);
      long big = Math.max(l, r);

      return big >= calculate(first, last) && small >= calculate(first + 1, last);
    }

    private long calculate(long start, long end) {
      if (start % 2 != end % 2) {
        --end;
      }
      if (start > end) {
        return 0;
      }
      long count = (end - start) / 2 + 1;
      return (start + end) * count / 2;
    }
  }

  static class InputReader {
    private BufferedReader reader;
    private StringTokenizer tokenizer;
    private static final int BUFFER_SIZE = 32768;

    public InputReader(InputStream stream) {
      reader = new BufferedReader(new InputStreamReader(stream), BUFFER_SIZE);
      tokenizer = null;
    }

    public String next() {
      while (tokenizer == null || !tokenizer.hasMoreTokens()) {
        try {
          tokenizer = new StringTokenizer(reader.readLine());
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
      return tokenizer.nextToken();
    }

    public long nextLong() {
      return Long.parseLong(next());
    }
  }
}
