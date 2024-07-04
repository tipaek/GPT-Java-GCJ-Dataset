
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

class Solution {// Renmae class to Solution before submitting

  private static final String CASES = "Case #";
  private static final String COLON = ": ";
  private static final String NEWLINE = "\n";

  private static void add(int num, StringBuilder sb, char ch) {
    for (int i = 0; i < num; i++) {
      sb.append(ch);
    }
  }

  public static void solve(final Input input, final PrintWriter output) throws IOException {
    final int numberOfTestCases = input.nextInt();
    final StringBuilder stringBuilder = new StringBuilder(2500 * numberOfTestCases);
    for (int z = 1; z <= numberOfTestCases; z++) {
      stringBuilder.append(CASES);
      stringBuilder.append(z);
      stringBuilder.append(COLON);
      String string = input.next();
      StringBuilder result = new StringBuilder();
      char prev = string.charAt(0);
      add(prev - '0', result, '(');
      result.append(prev);
      for (int i = 1; i < string.length(); i++) {
        char ch = string.charAt(i);
        int diff = prev - ch;
        if (diff < 0) {
          add(-diff, result, '(');
        } else {
          add(diff, result, ')');
        }
        result.append(ch);
        prev = ch;
      }
      add(prev - '0', result, ')');
      stringBuilder.append(result);
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
