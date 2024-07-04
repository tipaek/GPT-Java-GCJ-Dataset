import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        int testCase = 0;

        while (t-- > 0) {
            testCase++;
            int n = sc.nextInt();
            Interval[] intervals = new Interval[n];
            Interval[] originalIntervals = new Interval[n];

            for (int i = 0; i < n; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                intervals[i] = new Interval(start, end);
                originalIntervals[i] = new Interval(start, end);
            }

            Arrays.sort(intervals, Comparator.comparingInt((Interval p) -> p.end).thenComparingInt(p -> p.start));

            boolean isImpossible = false;
            Map<Interval, Character> cAssignments = new HashMap<>();
            Map<Interval, Character> jAssignments = new HashMap<>();
            int cEnd = intervals[0].end;
            int jEnd = 0;
            cAssignments.put(new Interval(intervals[0].start, intervals[0].end), 'C');

            for (int i = 1; i < n; i++) {
                int start = intervals[i].start;
                int end = intervals[i].end;

                if (cEnd <= start && !cAssignments.containsKey(new Interval(start, end))) {
                    cAssignments.put(new Interval(start, end), 'C');
                    cEnd = end;
                } else if (jEnd <= start && !jAssignments.containsKey(new Interval(start, end))) {
                    jAssignments.put(new Interval(start, end), 'J');
                    jEnd = end;
                } else {
                    isImpossible = true;
                    break;
                }
            }

            StringBuilder result = new StringBuilder();
            if (isImpossible || (cAssignments.size() + jAssignments.size() != n)) {
                result.append("IMPOSSIBLE");
            } else {
                for (int i = 0; i < n; i++) {
                    Interval interval = originalIntervals[i];
                    if (cAssignments.containsKey(interval)) {
                        result.append(cAssignments.get(new Interval(interval.start, interval.end)));
                        cAssignments.remove(interval);
                    } else {
                        result.append(jAssignments.get(new Interval(interval.start, interval.end)));
                        jAssignments.remove(interval);
                    }
                }
            }

            System.out.println("Case #" + testCase + ": " + result.toString());
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Interval)) return false;
        Interval interval = (Interval) o;
        return start == interval.start && end == interval.end;
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