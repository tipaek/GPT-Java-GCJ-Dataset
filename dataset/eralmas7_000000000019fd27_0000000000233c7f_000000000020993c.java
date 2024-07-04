
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

class A {

  private static final String CASES = "Case #";
  private static final String COLON = ": ";
  private static final String NEWLINE = "\n";

  public static void solve(final Input input, final PrintWriter output) throws IOException {
    final int numberOfTestCases = input.nextInt();
    final StringBuilder stringBuilder = new StringBuilder(2500 * numberOfTestCases);
    for (int z = 1; z <= numberOfTestCases; z++) {
      stringBuilder.append(CASES);
      stringBuilder.append(z);
      stringBuilder.append(COLON);
      int n = input.nextInt();
      int sum = 0, mod = 0;
      for (int i = 1; i <= n; i++) {
        mod ^= i;
      }
      int[] rows = new int[n];
      int[] cols = new int[n];
      Arrays.fill(rows, mod);
      Arrays.fill(cols, mod);
      for (int r = 0; r < n; r++) {
        for (int c = 0; c < n; c++) {
          int num = input.nextInt();
          rows[r] ^= num;
          cols[c] ^= num;
          if (r == c)
            sum += num;
        }
      }

      int dr = 0, dc = 0;
      for (int r = 0; r < n; r++) {
        if (rows[r] != 0)
          dr++;
        if (cols[r] != 0)
          dc++;
      }
      stringBuilder.append(sum);
      stringBuilder.append(' ');
      stringBuilder.append(dr);
      stringBuilder.append(' ');
      stringBuilder.append(dc);
      stringBuilder.append(NEWLINE);
    }
    output.println(stringBuilder);
  }

  public static void main(final String[] args) throws IOException {
    try (final PrintWriter output = new PrintWriter(System.out);
            final Input input = new Input(new BufferedReader(new InputStreamReader(System.in)))) {
      solve(input, output);
    }
  }

  private static class Input implements Closeable {

    private final BufferedReader in;
    private final StringBuilder sb = new StringBuilder();

    public Input(final BufferedReader in) {
      this.in = in;
    }

    public String next() throws IOException {
      sb.setLength(0);
      while (true) {
        int c = in.read();
        if (c == -1) {
          return null;
        }
        if (c != ' ' && c != '\n' && c != '\r' && c != '\t') {
          sb.append((char) c);
          break;
        }
      }
      while (true) {
        int c = in.read();
        if (c == -1 || c == ' ' || c == '\n' || c == '\r' || c == '\t') {
          break;
        }
        sb.append((char) c);
      }
      return sb.toString();
    }

    public int nextInt() throws IOException {
      return Integer.parseInt(next(), 10);
    }

    @Override
    public void close() throws IOException {
      in.close();
    }
  }
}
