import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Solution {

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

    private static final String CASE_PREFIX = "Case #";
    private static final String COLON_SPACE = ": ";
    private static final String NEW_LINE = "\n";

    public static void solve(final Input input, final PrintWriter output) throws IOException {
        final int numberOfTestCases = input.nextInt();
        final StringBuilder resultBuilder = new StringBuilder(2500 * numberOfTestCases);
        for (int caseNum = 1; caseNum <= numberOfTestCases; caseNum++) {
            resultBuilder.append(CASE_PREFIX).append(caseNum).append(COLON_SPACE);
            int n = input.nextInt();
            Interval[] intervals = new Interval[n];
            for (int i = 0; i < n; i++) {
                intervals[i] = new Interval(input.nextInt(), input.nextInt(), i);
            }
            Arrays.sort(intervals);
            char[] result = new char[n];
            result[intervals[0].index] = 'C';
            Interval cameron = intervals[0], jamie = new Interval(0, 0, -1);
            boolean possible = true;
            for (int i = 1; i < n; i++) {
                if (!cameron.doesOverlap(intervals[i])) {
                    result[intervals[i].index] = 'C';
                    cameron = intervals[i];
                } else if (!jamie.doesOverlap(intervals[i])) {
                    result[intervals[i].index] = 'J';
                    jamie = intervals[i];
                } else {
                    resultBuilder.append("IMPOSSIBLE").append(NEW_LINE);
                    possible = false;
                    break;
                }
            }
            if (possible) {
                resultBuilder.append(new String(result)).append(NEW_LINE);
            }
        }
        output.print(resultBuilder);
    }

    public static void main(final String[] args) throws IOException {
        try (final PrintWriter output = new PrintWriter(System.out);
             final Input input = new Input(new BufferedReader(new InputStreamReader(System.in)))) {
            solve(input, output);
        }
    }

    private static class Input implements Closeable {

        private final BufferedReader reader;
        private final StringBuilder sb = new StringBuilder();

        public Input(final BufferedReader reader) {
            this.reader = reader;
        }

        public String next() throws IOException {
            sb.setLength(0);
            int c;
            while ((c = reader.read()) != -1 && Character.isWhitespace(c)) {
                // Skip whitespace
            }
            if (c == -1) {
                return null;
            }
            sb.append((char) c);
            while ((c = reader.read()) != -1 && !Character.isWhitespace(c)) {
                sb.append((char) c);
            }
            return sb.toString();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        @Override
        public void close() throws IOException {
            reader.close();
        }
    }
}