import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
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
    ParentingPartneringReturns solver = new ParentingPartneringReturns();
    int testCount = Integer.parseInt(in.next());
    for (int i = 1; i <= testCount; i++) solver.solve(i, in, out);
    out.close();
  }

  static class ParentingPartneringReturns {
    private static final char[] PARTNERS = {'C', 'J'};

    public void solve(int testNumber, InputReader in, PrintWriter out) {
      int n = in.nextInt();
      ParentingPartneringReturns.Interval[] intervals = new ParentingPartneringReturns.Interval[n];

      ParentingPartneringReturns.Boundary[] boundaries =
          new ParentingPartneringReturns.Boundary[2 * n];
      for (int i = 0; i < n; ++i) {
        intervals[i] = new ParentingPartneringReturns.Interval(i, in.nextInt(), in.nextInt());

        boundaries[2 * i] = new ParentingPartneringReturns.Boundary(intervals[i].start, true);
        boundaries[2 * i + 1] = new ParentingPartneringReturns.Boundary(intervals[i].end, false);
      }

      Arrays.sort(
          boundaries,
          (lhs, rhs) -> {
            if (lhs.position != rhs.position) {
              return Integer.compare(lhs.position, rhs.position);
            }
            return Boolean.compare(lhs.open, rhs.open);
          });

      int active = 0;
      for (ParentingPartneringReturns.Boundary boundary : boundaries) {
        if (boundary.open) {
          ++active;
          if (active > 2) {
            out.printf("Case #%d: IMPOSSIBLE\n", testNumber);
            return;
          }
        } else {
          --active;
        }
      }

      Arrays.sort(
          intervals,
          (lhs, rhs) -> {
            if (lhs.start != rhs.start) {
              return Integer.compare(lhs.start, rhs.start);
            }
            return Integer.compare(lhs.end, rhs.end);
          });

      char[] schedule = new char[n];
      int[] ends = {-1, -1};
      for (ParentingPartneringReturns.Interval interval : intervals) {
        for (int i = 0; i < PARTNERS.length; ++i) {
          if (ends[i] <= interval.start) {
            schedule[interval.index] = PARTNERS[i];
            ends[i] = interval.end;
            break;
          }
        }
      }

      out.printf("Case #%d: %s\n", testNumber, new String(schedule));
    }

    static class Interval {
      int index;
      int start;
      int end;

      Interval(int index, int start, int end) {
        this.index = index;
        this.start = start;
        this.end = end;
      }
    }

    static class Boundary {
      int position;
      boolean open;

      Boundary(int position, boolean open) {
        this.position = position;
        this.open = open;
      }
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
