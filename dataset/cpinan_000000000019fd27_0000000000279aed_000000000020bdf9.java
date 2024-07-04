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

        Schedule(final int start, final int end) {
            this.start = start;
            this.end = end;
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
            return end > other.end ? 1 : -1;
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
                schedules[i] = new Schedule(in.nextInt(), in.nextInt());
            }
            Arrays.sort(schedules);
            // System.out.println(Arrays.toString(schedules));

            // Can be moved into a class to manage more than two cases.
            Schedule cameronSchedule = new Schedule(-1, -1);
            Schedule jamesSchedule = new Schedule(-1, -1);

            StringBuilder b = new StringBuilder();
            boolean isPossible = true;

            for (Schedule schedule : schedules) {
                if (cameronSchedule.isFree(schedule)) {
                    cameronSchedule.updateSchedule(schedule);
                    b.append("C");
                } else if (jamesSchedule.isFree(schedule)) {
                    jamesSchedule.updateSchedule(schedule);
                    b.append("J");
                } else {
                    isPossible = false;
                    break;
                }
            }

            out.print("Case #" + t + ": ");
            if (!isPossible) {
                out.print("IMPOSSIBLE");
            } else {
                out.print(b.toString());
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
