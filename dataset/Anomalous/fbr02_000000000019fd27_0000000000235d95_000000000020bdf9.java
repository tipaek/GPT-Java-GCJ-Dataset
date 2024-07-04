import java.util.*;

public class Solution {

    private Scanner scanner;
    private TreeMap<Integer, List<Interval>> delta;

    private static class Interval {
        int start;
        int end;
        char person;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private List<Interval> intervals;

    public void solve() {
        scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            delta = new TreeMap<>();
            StringBuilder result = new StringBuilder();
            intervals = new ArrayList<>();
            int n = scanner.nextInt();
            for (int j = 0; j < n; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                book(start, end);
            }
            int active = 0;
            int cEnd = -1;
            int jEnd = -1;
            for (Map.Entry<Integer, List<Interval>> entry : delta.entrySet()) {
                List<Interval> intervalList = entry.getValue();
                int time = entry.getKey();
                int deltaCount = 0;
                for (Interval interval : intervalList) {
                    int value = (time == interval.start) ? 1 : -1;
                    deltaCount += value;
                    if (value == -1) {
                        if (cEnd == interval.end) cEnd = -1;
                        if (jEnd == interval.end) jEnd = -1;
                    }
                }
                active += deltaCount;
                if (active >= 3) {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                } else {
                    for (Interval interval : intervalList) {
                        int value = (time == interval.start) ? 1 : -1;
                        if (value == 1) {
                            if (jEnd == -1) {
                                interval.person = 'J';
                                jEnd = interval.end;
                            } else {
                                interval.person = 'C';
                                cEnd = interval.end;
                            }
                        }
                    }
                }
            }
            if (!result.toString().equals("IMPOSSIBLE")) {
                for (Interval interval : intervals) {
                    result.append(interval.person);
                }
            }
            System.out.println("Case #" + t + ": " + result);
        }
    }

    private void book(int start, int end) {
        Interval interval = new Interval(start, end);
        delta.computeIfAbsent(start, k -> new ArrayList<>()).add(interval);
        delta.computeIfAbsent(end, k -> new ArrayList<>()).add(interval);
        intervals.add(interval);
    }

    public static void main(String[] args) {
        new Solution().solve();
    }
}