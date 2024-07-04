import java.io.*;
import java.util.*;

public class Solution {

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

    private static class Schedule implements Comparable<Schedule> {
        private int start;
        private int end;

        public Schedule(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean isAvailable(Schedule other) {
            return (start == -1 && end == -1) || (other.start >= end);
        }

        public void update(Schedule other) {
            this.start = other.start;
            this.end = other.end;
        }

        @Override
        public int compareTo(Schedule other) {
            return Integer.compare(this.end, other.end);
        }
    }

    private void solve() {
        InputStream inputStream = System.in;
        InputReader in = new InputReader(inputStream);
        PrintStream out = System.out;

        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = in.nextInt();
            Schedule[] schedules = new Schedule[N];
            for (int i = 0; i < N; i++) {
                schedules[i] = new Schedule(in.nextInt(), in.nextInt());
            }
            Arrays.sort(schedules);

            Schedule cameron = new Schedule(-1, -1);
            Schedule james = new Schedule(-1, -1);

            StringBuilder result = new StringBuilder();
            boolean possible = true;

            for (Schedule schedule : schedules) {
                if (cameron.isAvailable(schedule)) {
                    cameron.update(schedule);
                    result.append("C");
                } else if (james.isAvailable(schedule)) {
                    james.update(schedule);
                    result.append("J");
                } else {
                    possible = false;
                    break;
                }
            }

            out.print("Case #" + t + ": ");
            if (!possible) {
                out.println("IMPOSSIBLE");
            } else {
                out.println(result.toString());
            }
        }
        out.close();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }
}