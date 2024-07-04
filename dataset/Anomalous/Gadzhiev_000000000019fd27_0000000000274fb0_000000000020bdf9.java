import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            scanner.nextLine();
            for (int i = 1; i <= testCases; i++) {
                processTestCase(scanner, i);
            }
        }
    }

    private static void processTestCase(Scanner scanner, int testCaseNumber) {
        int numIntervals = scanner.nextInt();
        List<Interval> intervals = new ArrayList<>();
        for (int i = 0; i < numIntervals; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            intervals.add(new Interval(start, end));
        }

        List<Interval> sortedIntervals = new ArrayList<>(intervals);
        sortedIntervals.sort(Comparator.comparingInt(Interval::getTo).thenComparingInt(Interval::getFrom));

        Map<Interval, Character> assignmentMap = new HashMap<>();
        int cEnd = -1;
        int jEnd = -1;

        for (Interval interval : sortedIntervals) {
            if (interval.getFrom() >= cEnd) {
                assignmentMap.put(interval, 'C');
                cEnd = interval.getTo();
            } else if (interval.getFrom() >= jEnd) {
                assignmentMap.put(interval, 'J');
                jEnd = interval.getTo();
            } else {
                System.out.println("Case #" + testCaseNumber + ": IMPOSSIBLE");
                return;
            }
        }

        StringBuilder result = new StringBuilder();
        for (Interval interval : intervals) {
            result.append(assignmentMap.get(interval));
        }

        System.out.println("Case #" + testCaseNumber + ": " + result);
    }

    static class Interval {
        private final int from;
        private final int to;

        Interval(int from, int to) {
            this.from = from;
            this.to = to;
        }

        int getFrom() {
            return from;
        }

        int getTo() {
            return to;
        }
    }
}