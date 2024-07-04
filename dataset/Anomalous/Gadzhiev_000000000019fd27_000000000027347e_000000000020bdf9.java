import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i <= testCases; ++i) {
            processTestCase(scanner, i);
        }
    }

    private static void processTestCase(Scanner scanner, int testCaseNumber) {
        int numberOfIntervals = scanner.nextInt();
        StringBuilder result = new StringBuilder();
        Map<Interval, Character> assignmentMap = new HashMap<>();
        List<Interval> intervals = new ArrayList<>();

        for (int i = 0; i < numberOfIntervals; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            intervals.add(new Interval(start, end));
        }

        List<Interval> sortedIntervals = new ArrayList<>(intervals);
        sortedIntervals.sort((interval1, interval2) -> {
            if (interval1.getEnd() != interval2.getEnd()) {
                return Integer.compare(interval1.getEnd(), interval2.getEnd());
            } else {
                return Integer.compare(interval1.getStart(), interval2.getStart());
            }
        });

        int endTimeC = sortedIntervals.get(0).getEnd();
        assignmentMap.put(sortedIntervals.get(0), 'C');
        int endTimeJ = -1;

        for (int i = 1; i < sortedIntervals.size(); i++) {
            Interval currentInterval = sortedIntervals.get(i);
            if (currentInterval.getStart() >= endTimeC) {
                assignmentMap.put(currentInterval, 'C');
                endTimeC = currentInterval.getEnd();
            } else if (currentInterval.getStart() >= endTimeJ) {
                assignmentMap.put(currentInterval, 'J');
                endTimeJ = currentInterval.getEnd();
            } else {
                System.out.println("Case #" + testCaseNumber + ": IMPOSSIBLE");
                return;
            }
        }

        intervals.forEach(interval -> result.append(assignmentMap.get(interval)));
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