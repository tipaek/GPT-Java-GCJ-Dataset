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

        String next() {
            while (st == null || !st.hasMoreElements()) {
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

        public TimeInterval(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(TimeInterval other) {
            if (this.endTime == other.endTime) {
                return this.startTime - other.startTime;
            }
            return this.endTime - other.endTime;
        }
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int t = fr.nextInt();
        
        for (int test = 1; test <= t; test++) {
            int n = fr.nextInt();
            TimeInterval[] intervals = new TimeInterval[n];
            
            for (int i = 0; i < n; i++) {
                intervals[i] = new TimeInterval(fr.nextInt(), fr.nextInt());
            }

            Arrays.sort(intervals);
            
            int jTime = -1;
            int cTime = -1;
            StringBuilder res = new StringBuilder();

            for (TimeInterval interval : intervals) {
                if (jTime <= interval.startTime) {
                    jTime = interval.endTime;
                    res.append("J");
                } else if (cTime <= interval.startTime) {
                    cTime = interval.endTime;
                    res.append("C");
                } else {
                    res = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + test + ": " + res);
        }
    }
}