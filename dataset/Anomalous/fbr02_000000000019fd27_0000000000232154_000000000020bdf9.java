import java.util.*;

public class Solution {

    private Scanner scanner;
    private TreeMap<Integer, List<Interval>> intervals;

    private static class Interval {
        int start;
        int end;
        int value;

        public Interval(int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }
    }

    private void solve() {
        scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            intervals = new TreeMap<>();
            StringBuilder result = new StringBuilder();
            int n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                addInterval(start, end);
            }
            if (!assignIntervals(result)) {
                result = new StringBuilder("IMPOSSIBLE");
            }
            System.out.println("Case #" + t + ": " + result.toString());
        }
    }

    private void addInterval(int start, int end) {
        intervals.computeIfAbsent(start, k -> new ArrayList<>()).add(new Interval(start, end, 1));
        intervals.computeIfAbsent(end, k -> new ArrayList<>()).add(new Interval(start, end, -1));
    }

    private boolean assignIntervals(StringBuilder result) {
        int activeIntervals = 0;
        int cEnd = -1;
        int jEnd = -1;
        for (Map.Entry<Integer, List<Interval>> entry : intervals.entrySet()) {
            int time = entry.getKey();
            List<Interval> intervalList = entry.getValue();
            int change = 0;
            for (Interval interval : intervalList) {
                change += interval.value;
                if (interval.value == -1) {
                    if (cEnd == interval.end) cEnd = -1;
                    if (jEnd == interval.end) jEnd = -1;
                }
            }
            activeIntervals += change;
            if (activeIntervals >= 3) {
                return false;
            } else {
                for (Interval interval : intervalList) {
                    if (interval.value == 1) {
                        if (jEnd == -1) {
                            result.append('J');
                            jEnd = interval.end;
                        } else {
                            result.append('C');
                            cEnd = interval.end;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }
}