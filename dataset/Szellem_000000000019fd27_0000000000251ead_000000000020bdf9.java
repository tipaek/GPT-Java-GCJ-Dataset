import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static class Interval implements Comparable<Interval> {

        final int start;
        final int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }


        @Override
        public int compareTo(Interval o) {
            return Integer.compare(start, o.start);
        }
    }

    static class TestCase {
        final int index;
        final List<Interval> intervals = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        Interval jCurrent = null;
        Interval cCurrent = null;

        TestCase(int index) {
            this.index = index;
        }

        void solve() {
            Collections.sort(intervals);
            for (Interval interval : intervals) {
                if (jCurrent == null || jCurrent.end <= interval.start) {
                    jCurrent = interval;
                    sb.append('J');
                } else if (cCurrent == null || cCurrent.end <= interval.start) {
                    cCurrent = interval;
                    sb.append('C');
                } else {
                    System.out.println("Case #" + index + ": IMPOSSIBLE");
                    return;
                }
            }


            System.out.println("Case #" + index + ": " + sb.toString());
        }
    }

    Solution.TestCase readTestCase(Scanner in, int index) {
        Solution.TestCase tc = new Solution.TestCase(index);

        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            tc.intervals.add(new Interval(in.nextInt(), in.nextInt()));
        }

        return tc;
    }

    void run() {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            readTestCase(in, i).solve();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.run();
    }
}
