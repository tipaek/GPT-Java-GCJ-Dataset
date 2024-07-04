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
        int start;
        int end;
        int index;

        Schedule(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        boolean isFree(Schedule schedule) {
            return (start == -1 && end == -1) || (schedule.start >= end);
        }

        void updateSchedule(Schedule schedule) {
            this.start = schedule.start;
            this.end = schedule.end;
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
                schedules[i] = new Schedule(in.nextInt(), in.nextInt(), i);
            }
            Arrays.sort(schedules);

            Schedule cameron = new Schedule(-1, -1, -1);
            Schedule jamie = new Schedule(-1, -1, -1);

            boolean possible = true;
            char[] result = new char[N];
            for (Schedule schedule : schedules) {
                if (cameron.isFree(schedule)) {
                    result[schedule.index] = 'C';
                    cameron.updateSchedule(schedule);
                } else if (jamie.isFree(schedule)) {
                    result[schedule.index] = 'J';
                    jamie.updateSchedule(schedule);
                } else {
                    possible = false;
                    break;
                }
            }

            out.print("Case #" + t + ": ");
            if (possible) {
                out.print(new String(result));
            } else {
                out.print("IMPOSSIBLE");
            }
            out.println();
        }
        out.close();
    }

    public static void main(String[] args) {
        new Solution().solve();
    }
}