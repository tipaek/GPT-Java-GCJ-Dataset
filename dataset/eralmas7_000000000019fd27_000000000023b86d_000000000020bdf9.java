
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

class Solution {// Renmae class to Solution before submitting

  private static class Interval implements Comparable<Interval> {
    int start, end, index;

    public Interval(int start, int end, int index) {
      this.start = start;
      this.end = end;
      this.index = index;
    }

    public boolean doesOverlap(Interval interval) {
      return this.start < interval.end && interval.start < this.end;
    }

    @Override
    public int compareTo(Interval other) {
      int diff = Integer.compare(this.start, other.start);
      return diff == 0 ? Integer.compare(this.end, other.end) : diff;
    }
  }

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
      Interval[] intervals = new Interval[n];
      for (int i = 0; i < n; i++) {
        intervals[i] = new Interval(input.nextInt(), input.nextInt(), i);
      }
      Arrays.sort(intervals);
      char[] result = new char[n];
      result[intervals[0].index] = 'C';
      Interval cameron = intervals[0], jamie = new Interval(0, 0, -1);
      for (int i = 1; i < n; i++) {
        if (!cameron.doesOverlap(intervals[i])) {
          result[intervals[i].index] = 'C';
          cameron = intervals[i];
        } else if (!jamie.doesOverlap(intervals[i])) {
          result[intervals[i].index] = 'J';
          jamie = intervals[i];
        } else {
          result = "IMPOSSIBLE".toCharArray();
          break;
        }
      }
      stringBuilder.append(new String(result));
      stringBuilder.append(NEWLINE);
    }
    output.print(stringBuilder);
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
