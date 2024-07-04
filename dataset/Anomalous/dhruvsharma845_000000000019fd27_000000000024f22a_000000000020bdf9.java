import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int testCases = reader.nextInt();

        for (int t = 0; t < testCases; t++) {
            int numIntervals = reader.nextInt();
            Interval[] intervals = new Interval[numIntervals];

            for (int i = 0; i < numIntervals; i++) {
                int start = reader.nextInt();
                int end = reader.nextInt();
                intervals[i] = new Interval(start, end, i);
            }

            Arrays.sort(intervals, Comparator.comparingInt(interval -> interval.end));

            Interval cameron = null;
            Interval jamie = null;
            StringBuilder result = new StringBuilder(" ".repeat(numIntervals));

            cameron = intervals[0];
            result.setCharAt(cameron.index, 'C');

            for (int i = 1; i < numIntervals; i++) {
                Interval current = intervals[i];

                if (current.start < cameron.end) {
                    if (jamie != null && current.start < jamie.end) {
                        result = new StringBuilder("IMPOSSIBLE");
                        break;
                    }
                    jamie = current;
                    result.setCharAt(jamie.index, 'J');
                } else {
                    cameron = current;
                    result.setCharAt(cameron.index, 'C');
                }
            }

            System.out.println("Case #" + (t + 1) + ": " + result);
        }
    }

    static class Interval {
        int start;
        int end;
        int index;

        Interval(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
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
}