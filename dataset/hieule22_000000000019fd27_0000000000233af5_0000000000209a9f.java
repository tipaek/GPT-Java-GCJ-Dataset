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
    NestingDepth solver = new NestingDepth();
    int testCount = Integer.parseInt(in.next());
    for (int i = 1; i <= testCount; i++) solver.solve(i, in, out);
    out.close();
  }

  static class NestingDepth {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
      String input = in.next();
      int[] s = new int[input.length()];
      for (int i = 0; i < s.length; ++i) {
        s[i] = Character.getNumericValue(input.charAt(i));
      }

      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < s[0]; ++i) sb.append('(');
      sb.append(s[0]);

      for (int i = 1; i < s.length; ++i) {
        int delta = s[i] - s[i - 1];
        for (int j = 0; j < Math.abs(delta); ++j) {
          sb.append(delta > 0 ? '(' : ')');
        }
        sb.append(s[i]);
      }

      for (int i = 0; i < s[s.length - 1]; ++i) {
        sb.append(')');
      }

      out.printf("Case #%d: %s\n", testNumber, sb.toString());
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
  }
}
