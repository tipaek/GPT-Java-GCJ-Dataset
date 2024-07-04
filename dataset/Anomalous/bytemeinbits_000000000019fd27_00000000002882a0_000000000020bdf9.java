import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

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
            return this.startTime != other.startTime ? this.startTime - other.startTime : this.endTime - other.endTime;
        }
    }

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int testCases = reader.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = reader.nextInt();
            TimeInterval[] intervals = new TimeInterval[n];
            
            for (int i = 0; i < n; i++) {
                intervals[i] = new TimeInterval(reader.nextInt(), reader.nextInt());
            }
            
            Arrays.sort(intervals);
            
            int jEnd = -1;
            int cEnd = -1;
            StringBuilder result = new StringBuilder();
            
            for (TimeInterval interval : intervals) {
                if (jEnd <= interval.startTime) {
                    jEnd = interval.endTime;
                    result.append("J");
                } else if (cEnd <= interval.startTime) {
                    cEnd = interval.endTime;
                    result.append("C");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            
            System.out.println("Case #" + testCase + ": " + result);
        }
    }
}