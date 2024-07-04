import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int numIntervals = scanner.nextInt();
            List<Interval> intervals = new ArrayList<>();
            for (int i = 0; i < numIntervals; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals.add(new Interval(start, end, i));
            }

            intervals.sort(Comparator.comparingInt(interval -> interval.start));

            String result = assignWorkers(intervals);
            System.out.printf("Case #%d: %s%n", testCase, result);
        }
        scanner.close();
    }

    static class Interval {
        int start;
        int end;
        int index;
        char worker;

        Interval(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }

    static String assignWorkers(List<Interval> intervals) {
        Deque<Character> availableWorkers = new ArrayDeque<>(Arrays.asList('C', 'J'));
        List<Interval> activeIntervals = new ArrayList<>();

        for (Interval interval : intervals) {
            activeIntervals.removeIf(active -> active.end <= interval.start);
            if (activeIntervals.size() == 2) {
                return "IMPOSSIBLE";
            }

            interval.worker = availableWorkers.pop();
            activeIntervals.add(interval);
            availableWorkers.push(interval.worker);
        }

        intervals.sort(Comparator.comparingInt(interval -> interval.index));
        StringBuilder result = new StringBuilder();
        for (Interval interval : intervals) {
            result.append(interval.worker);
        }
        return result.toString();
    }
}