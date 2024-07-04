import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        int testCaseNumber = 0;

        while (t-- > 0) {
            testCaseNumber++;
            int n = sc.nextInt();
            Interval[] intervals = new Interval[n];
            Interval[] originalIntervals = new Interval[n];

            for (int i = 0; i < n; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                intervals[i] = new Interval(start, end);
                originalIntervals[i] = new Interval(start, end);
            }

            Arrays.sort(intervals, Comparator.comparingInt(interval -> interval.end));

            boolean impossible = false;
            Map<Interval, Character> assignmentMap = new HashMap<>();
            int maxEndC = intervals[0].end;
            int maxEndJ = 0;
            assignmentMap.put(new Interval(intervals[0].start, intervals[0].end), 'C');

            for (int i = 1; i < n; i++) {
                int start = intervals[i].start;
                int end = intervals[i].end;

                if (maxEndC <= start) {
                    assignmentMap.put(new Interval(start, end), 'C');
                    maxEndC = end;
                } else if (maxEndJ <= start) {
                    assignmentMap.put(new Interval(start, end), 'J');
                    maxEndJ = end;
                } else {
                    impossible = true;
                    break;
                }
            }

            StringBuilder result = new StringBuilder();
            if (impossible) {
                result.append("IMPOSSIBLE");
            } else {
                for (Interval interval : originalIntervals) {
                    result.append(assignmentMap.get(new Interval(interval.start, interval.end)));
                }
            }

            System.out.println("Case #" + testCaseNumber + ": " + result);
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