import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    static class Interval {
        int start, end;
        char work;

        public Interval(int start, int end, char work) {
            this.start = start;
            this.end = end;
            this.work = work;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        List<String> results = new ArrayList<>();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            List<Interval> intervals = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals.add(new Interval(start, end, '\0'));
            }

            String result = assignTasks(intervals, n);
            results.add("Case #" + testCase + ": " + result);
        }

        results.forEach(System.out::println);
        scanner.close();
    }

    private static String assignTasks(List<Interval> intervals, int n) {
        intervals.sort(Comparator.comparingInt(interval -> interval.end));

        int lastC = 0;
        intervals.get(lastC).work = 'C';
        for (int i = 1; i < n; i++) {
            if (intervals.get(i).start >= intervals.get(lastC).end) {
                intervals.get(i).work = 'C';
                lastC = i;
            }
        }

        int lastJ = -1;
        for (int i = 0; i < n; i++) {
            if (intervals.get(i).work == '\0') {
                lastJ = i;
                break;
            }
        }

        if (lastJ != -1) {
            intervals.get(lastJ).work = 'J';
            for (int i = lastJ + 1; i < n; i++) {
                if (intervals.get(i).start >= intervals.get(lastJ).end && intervals.get(i).work == '\0') {
                    intervals.get(i).work = 'J';
                    lastJ = i;
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (Interval interval : intervals) {
            if (interval.work != '\0') {
                result.append(interval.work);
            }
        }

        return result.length() == n ? result.toString() : "IMPOSSIBLE";
    }
}