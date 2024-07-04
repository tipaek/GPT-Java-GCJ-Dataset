
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

class Solution {// Renmae class to Solution before submitting

  private static final String CASES = "Case #";
  private static final String COLON = ": ";
  private static final String NEWLINE = "\n";

  public static void solve(final Input input, final PrintStream output) throws IOException {
    final String[] tokens = input.nextLine().split("\\s+");
    final int numberOfTestCases = Integer.parseInt(tokens[0], 10);
    final int bitCount = Integer.parseInt(tokens[1], 10);
    final StringBuilder stringBuilder = new StringBuilder(2500 * numberOfTestCases);
    for (int z = 1; z <= numberOfTestCases; z++) {
      stringBuilder.append(CASES);
      stringBuilder.append(z);
      stringBuilder.append(COLON);
      char[] carray = new char[bitCount];
      char[] parray = new char[bitCount];
      for (int i = 0; i < 15; i++) {
        for (int j = 1; j <= 10; j++) {
          output.println(j);
          carray[j - 1] = input.nextLine().charAt(0);
        }
        System.arraycopy(carray, 0, parray, 0, carray.length);
      }
      output.println(new String(carray));
      char ch = input.nextLine().charAt(0);
      if (ch == 'N')
        return;
      stringBuilder.append(NEWLINE);
    }
  }

  public static void main(final String[] args) throws IOException {
    try (final Input input = new Input(new BufferedReader(new InputStreamReader(System.in)))) {
      solve(input, System.out);
    }
  }

  private static class Input implements Closeable {

    private final BufferedReader bufferedReader;
    private final StringBuilder stringBuilder = new StringBuilder();

    public Input(final BufferedReader in) {
      this.bufferedReader = in;
    }

    public String nextLine() throws IOException {
      stringBuilder.setLength(0);
      while (true) {
        final int c = bufferedReader.read();
        if (c == -1) {
          return null;
        }
        final char ch = (char) c;
        if (!(ch == '\n' || ch == '\r')) {
          stringBuilder.append(ch);
          break;
        }
      }
      while (true) {
        int c = bufferedReader.read();
        char ch = (char) c;
        if (c == -1 || ch == '\n' || ch == '\r') {
          break;
        }
        stringBuilder.append(ch);
      }
      return stringBuilder.toString();
    }

    public String next() throws IOException {
      stringBuilder.setLength(0);
      while (true) {
        int c = bufferedReader.read();
        if (c == -1) {
          return null;
        }
        if (c != ' ' && c != '\n' && c != '\r' && c != '\t') {
          stringBuilder.append((char) c);
          break;
        }
      }
      while (true) {
        int c = bufferedReader.read();
        if (c == -1 || c == ' ' || c == '\n' || c == '\r' || c == '\t') {
          break;
        }
        stringBuilder.append((char) c);
      }
      return stringBuilder.toString();
    }

    public int nextInt() throws IOException {
      return Integer.parseInt(next(), 10);
    }

    @Override
    public void close() throws IOException {
      bufferedReader.close();
    }
  }
}
