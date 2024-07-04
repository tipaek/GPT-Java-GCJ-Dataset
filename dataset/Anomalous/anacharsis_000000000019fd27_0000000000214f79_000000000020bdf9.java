import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Solution {
    private StringBuilder outputBuffer = new StringBuilder(16384);

    void solve() throws IOException {
        InputReader reader = new InputReader(System.in);
        int testCases = reader.nextInt();

        for (int t = 0; t < testCases; ++t) {
            List<Event> events = new ArrayList<>();
            int eventCount = reader.nextInt();

            for (int e = 0; e < eventCount; ++e) {
                events.add(new Event(e, reader.nextInt(), reader.nextInt()));
            }

            Collections.sort(events);
            char[] assignments = new char[eventCount];
            Event jEvent = null;
            Event cEvent = null;

            for (Event event : events) {
                int currentStart = event.start;

                if (jEvent == null || jEvent.end <= currentStart) {
                    assignments[event.idx] = 'J';
                    jEvent = event;
                } else if (cEvent == null || cEvent.end <= currentStart) {
                    assignments[event.idx] = 'C';
                    cEvent = event;
                } else {
                    assignments = null;
                    break;
                }
            }

            outputBuffer.append(String.format("Case #%d: %s\n", t + 1, assignments == null ? "IMPOSSIBLE" : new String(assignments)));
        }

        System.out.print(outputBuffer);
    }

    private static class Event implements Comparable<Event> {
        private int idx;
        private int start;
        private int end;

        public Event(int idx, int start, int end) {
            this.idx = idx;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Event other) {
            return Integer.compare(this.start, other.start);
        }
    }

    public static void main(String[] args) throws IOException {
        new Solution().solve();
    }

    class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
            tokenizer = null;
        }

        public String readLine() throws IOException {
            return reader.readLine();
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    return null;
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}