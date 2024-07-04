
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

class Solution {

  private static final String CASES = "Case #";
  private static final String COLON = ": ";
  private static final String NEWLINE = "\n";

  public static void solve(final Input input, final PrintWriter output) throws IOException {
    final int numberOfTestCases = input.nextInt();
    final StringBuilder stringBuilder = new StringBuilder(2000 * numberOfTestCases);
    for (int z = 1; z <= numberOfTestCases; z++) {
      stringBuilder.append(CASES);
      stringBuilder.append(z);
      stringBuilder.append(COLON);
      int n = input.nextInt();
      int sum = 0;
      int[][] rows = new int[n][n];
      int[][] cols = new int[n][n];
      for (int r = 0; r < n; r++) {
        for (int c = 0; c < n; c++) {
          int num = input.nextInt();
          rows[r][num - 1]++;
          cols[c][num - 1]++;
          if (r == c)
            sum += num;
        }
      }

      int dr = 0, dc = 0;
      boolean isRowDone = false, isColDone = false;
      for (int r = 0; r < n; r++) {
        isRowDone = false;
        isColDone = false;
        for (int c = 0; c < n; c++) {
          if (rows[r][c] > 1 && !isRowDone) {
            dr++;
            isRowDone = true;
          }
          if (cols[r][c] > 1 && !isColDone) {
            dc++;
            isColDone = true;
          }
        }
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
