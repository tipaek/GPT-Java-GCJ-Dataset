import java.io.*;
import java.util.*;

public class Solution {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

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
        int start;
        int end;

        public TimeInterval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(TimeInterval other) {
            return Integer.compare(this.start, other.start);
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
            int jEnd = 0, cEnd = 0;
            StringBuilder result = new StringBuilder();
            boolean possible = true;

            for (TimeInterval interval : intervals) {
                if (jEnd <= interval.start) {
                    jEnd = interval.end;
                    result.append("J");
                } else if (cEnd <= interval.start) {
                    cEnd = interval.end;
                    result.append("C");
                } else {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                result = new StringBuilder("IMPOSSIBLE");
            }

            System.out.printf("Case #%d: %s%n", testCase, result);
        }
    }
}