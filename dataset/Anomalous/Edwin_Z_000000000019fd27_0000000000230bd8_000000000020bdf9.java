import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        int testCases = in.nextInt();
        for (int i = 0; i < testCases; i++) {
            solver.solve(i + 1, in, out);
        }
        out.close();
    }

    static class Task {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            PriorityQueue<int[]> events = new PriorityQueue<>((a, b) -> {
                if (a[1] == b[1]) return Integer.compare(a[0], b[0]);
                return Integer.compare(a[1], b[1]);
            });

            for (int i = 0; i < n; i++) {
                int start = in.nextInt();
                int end = in.nextInt();
                events.offer(new int[]{start, end});
            }

            StringBuilder result = new StringBuilder();
            int[] endTimes = new int[2];
            Arrays.fill(endTimes, -1);

            while (!events.isEmpty()) {
                int[] currentEvent = events.poll();
                boolean assigned = false;

                for (int i = 0; i < 2; i++) {
                    if (endTimes[i] <= currentEvent[0]) {
                        endTimes[i] = currentEvent[1];
                        result.append(i == 0 ? 'C' : 'J');
                        assigned = true;
                        break;
                    }
                }

                if (!assigned) {
                    out.println("Case #" + testNumber + ": IMPOSSIBLE");
                    return;
                }
            }

            out.println("Case #" + testNumber + ": " + result.toString());
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