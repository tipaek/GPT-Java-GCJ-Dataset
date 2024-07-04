import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        FastScanner scanner = new FastScanner(System.in);
        PrintWriter writer = new PrintWriter(System.out);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            writer.print("Case #" + testCase + ": ");
            processTestCase(scanner, writer);
            writer.println();
        }
        writer.close();
    }

    private static void processTestCase(FastScanner scanner, PrintWriter writer) throws IOException {
        int n = scanner.nextInt();
        Schedule[] schedules = new Schedule[n];
        char[] result = new char[n];

        for (int i = 0; i < n; i++) {
            schedules[i] = new Schedule(scanner.nextInt(), scanner.nextInt(), i);
        }

        Arrays.sort(schedules);
        Schedule c = schedules[0];
        result[schedules[0].index] = 'C';
        Schedule j = null;

        for (int i = 1; i < n; i++) {
            if (isOverlapping(c, schedules[i])) {
                if (j == null) {
                    j = schedules[i];
                    result[schedules[i].index] = 'J';
                } else if (isOverlapping(j, schedules[i])) {
                    writer.print("IMPOSSIBLE");
                    return;
                } else {
                    j = schedules[i];
                    result[schedules[i].index] = 'J';
                }
            } else {
                c = schedules[i];
                result[c.index] = 'C';
            }
        }
        writer.print(new String(result));
    }

    private static boolean isOverlapping(Schedule a, Schedule b) {
        return a.end > b.start && a.start < b.end;
    }

    private static class Schedule implements Comparable<Schedule> {
        int start, end, index;

        public Schedule(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        @Override
        public int compareTo(Schedule other) {
            if (this.start == other.start) {
                return this.end - other.end;
            }
            return this.start - other.start;
        }
    }

    private static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner(InputStream inputStream) {
            reader = new BufferedReader(new InputStreamReader(inputStream));
        }

        public int nextInt() throws IOException {
            ensureTokenizer();
            return Integer.parseInt(tokenizer.nextToken());
        }

        public long nextLong() throws IOException {
            ensureTokenizer();
            return Long.parseLong(tokenizer.nextToken());
        }

        public String next() throws IOException {
            ensureTokenizer();
            return tokenizer.nextToken();
        }

        private void ensureTokenizer() throws IOException {
            if (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
        }
    }
}