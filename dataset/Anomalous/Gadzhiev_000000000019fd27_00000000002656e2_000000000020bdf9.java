import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCaseCount = scanner.nextInt();
            scanner.nextLine();
            for (int i = 1; i <= testCaseCount; i++) {
                processTestCase(scanner, i);
            }
        }
    }

    private static void processTestCase(Scanner scanner, int testCaseNumber) {
        int intervalCount = scanner.nextInt();
        StringBuilder result = new StringBuilder();
        Map<Interval, Integer> assignmentMap = new HashMap<>();
        List<Interval> intervals = new ArrayList<>();

        for (int i = 0; i < intervalCount; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            intervals.add(new Interval(start, end));
        }

        List<Interval> sortedIntervals = new ArrayList<>(intervals);
        sortedIntervals.sort(Comparator.comparingInt(Interval::getEnd));

        int lastEnd = sortedIntervals.get(0).getEnd();
        int previousEnd = -1;
        int currentColor = 1;
        assignmentMap.put(sortedIntervals.get(0), currentColor);

        for (int i = 1; i < sortedIntervals.size(); i++) {
            Interval currentInterval = sortedIntervals.get(i);
            if (currentInterval.getStart() < lastEnd) {
                if (currentInterval.getStart() < previousEnd) {
                    System.out.println("Case #" + testCaseNumber + ": IMPOSSIBLE");
                    return;
                }
                currentColor *= -1;
                previousEnd = lastEnd;
                lastEnd = currentInterval.getEnd();
            }
            assignmentMap.put(currentInterval, currentColor);
        }

        for (Interval interval : intervals) {
            int color = assignmentMap.get(interval);
            result.append(color == 1 ? "C" : "J");
        }

        System.out.println("Case #" + testCaseNumber + ": " + result);
    }

    static class Interval {
        private final int start;
        private final int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        int getStart() {
            return start;
        }

        int getEnd() {
            return end;
        }
    }
}