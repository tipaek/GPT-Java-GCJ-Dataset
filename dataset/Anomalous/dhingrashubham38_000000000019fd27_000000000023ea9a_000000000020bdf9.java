import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Solution {
    static final int MAX = 1005;

    static class Pair {
        int start, end, index;

        public Pair(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }

    static class PairComparator implements Comparator<Pair> {
        @Override
        public int compare(Pair p1, Pair p2) {
            if (p1.start == p2.start) {
                return p1.end - p2.end;
            }
            return p1.start - p2.start;
        }
    }

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int testCases = reader.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = reader.nextInt();
            Pair[] intervals = new Pair[n];
            char[] assignments = new char[n];

            for (int i = 0; i < n; i++) {
                int start = reader.nextInt();
                int end = reader.nextInt();
                intervals[i] = new Pair(start, end, i);
            }

            Arrays.sort(intervals, new PairComparator());

            Pair cameron = null;
            Pair jamie = null;
            boolean impossible = false;

            for (Pair interval : intervals) {
                if (cameron == null || cameron.end <= interval.start) {
                    cameron = interval;
                    assignments[interval.index] = 'C';
                } else if (jamie == null || jamie.end <= interval.start) {
                    jamie = interval;
                    assignments[interval.index] = 'J';
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + testCase + ": " + new String(assignments));
            }
        }
    }

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
}