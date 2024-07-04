import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        int testCase = 1;

        while (t-- > 0) {
            int n = sc.nextInt();
            Interval[] intervals = new Interval[n];
            Interval[] originalIntervals = new Interval[n];

            for (int i = 0; i < n; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                intervals[i] = new Interval(start, end);
                originalIntervals[i] = new Interval(start, end);
            }

            Arrays.sort(intervals, Comparator.comparingInt((Interval p) -> p.start).thenComparingInt(p -> p.end));

            boolean isPossible = true;
            Map<Interval, Character> schedule = new HashMap<>();
            int lastCameronEnd = 0;
            int lastJamieEnd = 0;

            schedule.put(intervals[0], 'C');
            lastCameronEnd = intervals[0].end;

            for (int i = 1; i < n; i++) {
                int start = intervals[i].start;
                int end = intervals[i].end;

                if (lastCameronEnd <= start) {
                    schedule.put(intervals[i], 'C');
                    lastCameronEnd = end;
                } else if (lastJamieEnd <= start) {
                    schedule.put(intervals[i], 'J');
                    lastJamieEnd = end;
                } else {
                    isPossible = false;
                    break;
                }
            }

            StringBuilder result = new StringBuilder();
            if (!isPossible || schedule.size() != n) {
                result.append("IMPOSSIBLE");
            } else {
                for (Interval interval : originalIntervals) {
                    result.append(schedule.get(interval));
                }
            }

            System.out.println("Case #" + testCase + ": " + result);
            testCase++;
        }
    }
}

class Interval {
    int start;
    int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Interval)) return false;
        Interval other = (Interval) obj;
        return start == other.start && end == other.end;
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }
}

class FastReader {
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