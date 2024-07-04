import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static class Interval implements Comparable<Interval> {

        final int start;
        final int end;
        final int index;

        Interval(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }


        @Override
        public int compareTo(Interval o) {
            return Integer.compare(start, o.start);
        }
    }

    static class TestCase {
        final int index;
        final List<Interval> intervals = new ArrayList<>();
        Interval jCurrent = null;
        Interval cCurrent = null;
        char[] result;

        TestCase(int index) {
            this.index = index;
        }

        void solve() {
            Collections.sort(intervals);
            for (Interval interval : intervals) {
                if (jCurrent == null || jCurrent.end <= interval.start) {
                    jCurrent = interval;
                    result[interval.index] = 'J';
                } else if (cCurrent == null || cCurrent.end <= interval.start) {
                    cCurrent = interval;
                    result[interval.index] = 'C';
                } else {
                    System.out.println("Case #" + index + ": IMPOSSIBLE");
                    return;
                }
            }


            System.out.println("Case #" + index + ": " + String.valueOf(result, 0, result.length));
        }
    }

    Solution.TestCase readTestCase(Scanner in, int index) {
        Solution.TestCase tc = new Solution.TestCase(index);
        int n = in.nextInt();

        tc.result = new char[n];

        for (int i = 0; i < n; i++) {
            tc.intervals.add(new Interval(in.nextInt(), in.nextInt(), i));
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
