import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    private final InputReader reader = new InputReader();

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        solution.solve();
    }

    void solve() throws Exception {
        int t = reader.readInt();
        for (int caseId = 1; caseId <= t; caseId++) {
            int n = reader.readInt();
            Interval[] intervals = new Interval[n];
            for (int i = 0; i < n; i++) {
                int start = reader.readInt();
                int end = reader.readInt();
                intervals[i] = new Interval(start, end, i);
            }
            Arrays.sort(intervals, Comparator.comparingInt(interval -> interval.start));
            PriorityQueue<Integer> jamie = new PriorityQueue<>(Comparator.reverseOrder());
            PriorityQueue<Integer> cameron = new PriorityQueue<>(Comparator.reverseOrder());
            char[] result = new char[n];
            boolean impossible = false;

            for (Interval interval : intervals) {
                if (jamie.isEmpty() || jamie.peek() <= interval.start) {
                    jamie.offer(interval.end);
                    result[interval.index] = 'J';
                } else if (cameron.isEmpty() || cameron.peek() <= interval.start) {
                    cameron.offer(interval.end);
                    result[interval.index] = 'C';
                } else {
                    impossible = true;
                    System.out.printf("Case #%d: IMPOSSIBLE\n", caseId);
                    break;
                }
            }
            if (!impossible) {
                System.out.printf("Case #%d: %s\n", caseId, new String(result));
            }
        }
    }

    private static class Interval {
        int start;
        int end;
        int index;

        Interval(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }

    private static class InputReader {
        private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int readInt() throws Exception {
            return Integer.parseInt(br.readLine().trim());
        }
    }
}