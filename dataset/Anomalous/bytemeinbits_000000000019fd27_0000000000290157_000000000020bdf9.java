import java.io.*;
import java.util.*;

public class Solution {
    static class FastReader {
        private BufferedReader br;
        private StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static class TimeInterval implements Comparable<TimeInterval> {
        int startTime;
        int endTime;
        int index;

        public TimeInterval(int startTime, int endTime, int index) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.index = index;
        }

        @Override
        public int compareTo(TimeInterval other) {
            if (this.endTime != other.endTime) {
                return this.endTime - other.endTime;
            }
            return this.startTime - other.startTime;
        }
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int t = fr.nextInt();

        for (int test = 1; test <= t; test++) {
            int n = fr.nextInt();
            TimeInterval[] intervals = new TimeInterval[n];

            for (int i = 0; i < n; i++) {
                intervals[i] = new TimeInterval(fr.nextInt(), fr.nextInt(), i);
            }

            Arrays.sort(intervals);
            String[] result = new String[n];
            int jEnd = -1, cEnd = -1;
            boolean impossible = false;

            for (TimeInterval interval : intervals) {
                if (jEnd <= interval.startTime) {
                    jEnd = interval.endTime;
                    result[interval.index] = "J";
                } else if (cEnd <= interval.startTime) {
                    cEnd = interval.endTime;
                    result[interval.index] = "C";
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.println("Case #" + test + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + test + ": " + String.join("", result));
            }
        }
    }
}