import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int count = reader.nextInt();
        for (int test = 1; test <= count; test++) {
            int N = reader.nextInt();
            Interval[] intervals = new Interval[N];
            for (int i = 0; i < N; i++) {
                int start = reader.nextInt();
                int end = reader.nextInt();
                intervals[i] = new Interval(start, end);
            }
            Arrays.sort(intervals);
            Interval c = intervals[0];
            Interval j = intervals[1];
            StringBuilder sb = new StringBuilder();
            sb.append('C');
            sb.append('J');
            for (int i = 2; i < intervals.length; i++) {
                Interval current = intervals[i];
                if (c.end > current.start && j.end > current.start) {
                    sb = new StringBuilder("IMPOSSIBLE");
                    break;
                }
                if (c.end > j.end) {
                    sb.append("J");
                    j = current;
                } else {
                    sb.append("C");
                    c = current;
                }
            }
            System.out.println("Case #" + test + ": " + sb.toString());
        }
    }

    static class Interval implements Comparable<Interval> {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Interval o) {
            return Integer.compare(this.start, o.start);
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
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
}

