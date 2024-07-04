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
                intervals[i] = new Interval(start, end, i);
            }
            Arrays.sort(intervals);
            Interval c = intervals[0];
            Interval j = intervals[1];
            StringBuilder sb = new StringBuilder();
            HashMap<Integer, String> map = new HashMap<>();
            map.put(intervals[0].index, "C");
            map.put(intervals[1].index, "J");
            boolean early = false;
            for (int i = 2; i < intervals.length; i++) {
                Interval current = intervals[i];
                if (c.end > current.start && j.end > current.start) {
                    early = true;
                    break;
                }
                if (c.end > j.end) {
                    map.put(current.index, "J");
                    j = current;
                } else {
                    map.put(current.index, "C");
                    c = current;
                }
            }
            if (early)
                System.out.println("Case #" + test + ": " + "IMPOSSIBLE");
            else {
                for (int i = 0; i < N; i++) {
                    sb.append(map.get(i));
                }
                System.out.println("Case #" + test + ": " + sb.toString());
            }
        }
    }

    static class Interval implements Comparable<Interval> {
        int start;
        int end;
        int index;

        Interval(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
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

