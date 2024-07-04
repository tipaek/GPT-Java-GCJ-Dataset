import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader reader = new InputReader(inputStream);
        PrintWriter writer = new PrintWriter(outputStream);
        Task solver = new Task();
        int testCases = reader.nextInt();
        for (int i = 0; i < testCases; i++) {
            solver.solve(i + 1, reader, writer);
        }
        writer.close();
    }

    static class Task {
        public void solve(int testNumber, InputReader reader, PrintWriter writer) {
            int n = reader.nextInt();
            PriorityQueue<int[]> intervals = new PriorityQueue<>((a, b) -> {
                if (a[0] == b[0]) return a[1] - b[1];
                return a[0] - b[0];
            });

            for (int i = 0; i < n; i++) {
                int start = reader.nextInt();
                int end = reader.nextInt();
                intervals.offer(new int[]{start, end, i});
            }

            char[] result = new char[n];
            int[] endTimes = new int[2];
            Arrays.fill(endTimes, -1);

            while (!intervals.isEmpty()) {
                int[] current = intervals.poll();
                int i;
                for (i = 0; i < 2; i++) {
                    if (endTimes[i] <= current[0]) {
                        endTimes[i] = current[1];
                        break;
                    }
                }

                if (i == 2) {
                    writer.println("Case #" + testNumber + ": IMPOSSIBLE");
                    return;
                }

                result[current[2]] = (i == 0) ? 'C' : 'J';
            }

            writer.println("Case #" + testNumber + ": " + new String(result));
        }
    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
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