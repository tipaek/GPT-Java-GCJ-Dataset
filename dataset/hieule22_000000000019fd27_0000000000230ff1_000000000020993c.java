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
    Vestigium solver = new Vestigium();
    int testCount = Integer.parseInt(in.next());
    for (int i = 1; i <= testCount; i++) solver.solve(i, in, out);
    out.close();
  }

  static class Vestigium {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
      int n = in.nextInt();
      int[][] mat = new int[n][];
      for (int r = 0; r < n; ++r) mat[r] = in.nextIntArray(n);

      int trace = 0;
      for (int r = 0; r < n; ++r) trace += mat[r][r];

      int R = 0;
      for (int r = 0; r < n; ++r) {
        boolean[] seen = new boolean[n + 1];
        for (int c = 0; c < n; ++c) {
          if (seen[mat[r][c]]) {
            ++R;
            break;
          }
          seen[mat[r][c]] = true;
        }
      }

      int C = 0;
      for (int c = 0; c < n; ++c) {
        boolean[] seen = new boolean[n + 1];
        for (int r = 0; r < n; ++r) {
          if (seen[mat[r][c]]) {
            ++C;
            break;
          }
          seen[mat[r][c]] = true;
        }
      }

      out.printf("Case #%d: %d %d %d\n", testNumber, trace, R, C);
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

    public int[] nextIntArray(int length) {
      int[] result = new int[length];
      for (int i = 0; i < length; ++i) result[i] = nextInt();
      return result;
    }
  }
}
