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
    Indicium solver = new Indicium();
    int testCount = Integer.parseInt(in.next());
    for (int i = 1; i <= testCount; i++) solver.solve(i, in, out);
    out.close();
  }

  static class Indicium {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
      int n = in.nextInt();
      int k = in.nextInt();

      int[][] mat = new int[n][n];
      if (!recurse(mat, 0, k)) {
        out.printf("Case #%d: IMPOSSIBLE\n", testNumber);
        return;
      }

      out.printf("Case #%d: POSSIBLE\n", testNumber);
      for (int r = 0; r < n; ++r) {
        for (int c = 0; c < n; ++c) out.print(mat[r][c] + " ");
        out.println();
      }
    }

    private boolean recurse(int[][] mat, int rank, int k) {
      int n = mat.length;
      if (rank == n * n) {
        int trace = 0;
        for (int i = 0; i < n; ++i) trace += mat[i][i];
        return trace == k;
      }

      int r = rank / n;
      int c = rank % n;
      boolean[] seen = new boolean[n + 1];

      for (int cc = 0; cc < c; ++cc) seen[mat[r][cc]] = true;
      for (int rr = 0; rr < r; ++rr) seen[mat[rr][c]] = true;

      for (int choice = 1; choice <= n; ++choice) {
        if (seen[choice]) continue;
        mat[r][c] = choice;
        if (r == c) {
          int trace = 0;
          for (int i = 0; i <= r; ++i) trace += mat[i][i];
          int remain = n - r - 1;
          if (trace + remain * 1 <= k && trace + remain * n >= trace) {
            if (recurse(mat, rank + 1, k)) {
              return true;
            }
          }
        } else {
          if (recurse(mat, rank + 1, k)) {
            return true;
          }
        }
      }
      return false;
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

    public int nextInt() {
      return Integer.parseInt(next());
    }
  }
}
