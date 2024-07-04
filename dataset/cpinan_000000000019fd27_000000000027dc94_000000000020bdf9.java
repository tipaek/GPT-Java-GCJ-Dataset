import java.io.*;
import java.util.*;

public class Solution {

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

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

        Schedule(final int start, final int end, final int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        public boolean isFree(Schedule schedule) {
            return start == -1 && end == -1 ||
                    schedule.start >= end;
        }

        public void updateSchedule(Schedule schedule) {
            this.start = schedule.start;
            this.end = schedule.end;
        }

        @Override
        public String toString() {
            return "Schedule{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }

        @Override
        public int compareTo(Schedule other) {
            return start > other.start ? 1 : -1;
        }
    }

    private void resolve() {
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

            // Can be moved into a class to manage more than two cases.
            Schedule cameronSchedule = new Schedule(-1, -1, -1);
            Schedule jamesSchedule = new Schedule(-1, -1, -1);

            boolean isPossible = true;
            char[] result = new char[N];
            for (Schedule schedule : schedules) {
                if (cameronSchedule.isFree(schedule)) {
                    result[schedule.index] = 'C';
                    cameronSchedule.updateSchedule(schedule);
                } else if (jamesSchedule.isFree(schedule)) {
                    result[schedule.index] = 'J';
                    jamesSchedule.updateSchedule(schedule);
                } else {
                    isPossible = false;
                    break;
                }
            }

            out.print("Case #" + t + ": ");
            if (!isPossible) {
                out.print("IMPOSSIBLE");
            } else {
                out.print(new String(result));
            }
            out.println();
        }
        out.close();
    }

    public static void main(String[] args) {
        Solution p = new Solution();
        p.resolve();
    }
}
