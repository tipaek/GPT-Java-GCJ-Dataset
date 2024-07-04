import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static class FastReader {
        private BufferedReader br;
        private StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        private String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
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

        public String nextLine() {
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

        public TimeInterval(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(TimeInterval other) {
            if (this.startTime == other.startTime) {
                return Integer.compare(this.endTime, other.endTime);
            }
            return Integer.compare(this.startTime, other.startTime);
        }
    }

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int t = reader.nextInt();

        for (int test = 1; test <= t; test++) {
            int n = reader.nextInt();
            TimeInterval[] intervals = new TimeInterval[n];

            for (int i = 0; i < n; i++) {
                intervals[i] = new TimeInterval(reader.nextInt(), reader.nextInt());
            }

            Arrays.sort(intervals);

            int jTime = -1;
            int cTime = -1;
            StringBuilder result = new StringBuilder();

            for (TimeInterval interval : intervals) {
                if (jTime <= interval.startTime) {
                    jTime = interval.endTime;
                    result.append("J");
                } else if (cTime <= interval.startTime) {
                    cTime = interval.endTime;
                    result.append("C");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + test + ": " + result);
        }
    }
}