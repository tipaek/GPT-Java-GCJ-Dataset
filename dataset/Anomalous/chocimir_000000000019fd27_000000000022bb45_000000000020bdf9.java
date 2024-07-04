import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    private static class Interval implements Comparable<Interval> {
        int start, end, index;

        Interval(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        @Override
        public int compareTo(Interval other) {
            if (this.start != other.start) {
                return Integer.compare(this.start, other.start);
            }
            return Integer.compare(this.end, other.end);
        }
    }

    public String solve(Scanner scanner) {
        int n = scanner.nextInt();
        List<Interval> intervals = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            intervals.add(new Interval(scanner.nextInt(), scanner.nextInt(), i));
        }
        Collections.sort(intervals);

        Interval c = null, j = null;
        String[] result = new String[n];

        for (Interval interval : intervals) {
            if (c == null || c.end <= interval.start) {
                c = interval;
                result[interval.index] = "C";
            } else if (j == null || j.end <= interval.start) {
                j = interval;
                result[interval.index] = "J";
            } else {
                return "IMPOSSIBLE";
            }
        }
        return String.join("", result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        Solution solution = new Solution();
        for (int i = 1; i <= t; i++) {
            System.out.println("Case #" + i + ": " + solution.solve(scanner));
        }
    }
}