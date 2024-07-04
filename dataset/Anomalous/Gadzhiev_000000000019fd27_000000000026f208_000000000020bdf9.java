import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            processCase(scanner, caseNum);
        }
    }

    private static void processCase(Scanner scanner, int caseNum) {
        int numIntervals = scanner.nextInt();
        List<Interval> intervals = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        Map<Interval, Character> assignment = new HashMap<>();

        for (int i = 0; i < numIntervals; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            intervals.add(new Interval(start, end));
        }

        intervals.sort(Comparator.comparingInt(Interval::getEnd));

        int cEnd = 0, jEnd = 0;

        for (Interval interval : intervals) {
            if (interval.getStart() >= cEnd) {
                assignment.put(interval, 'C');
                cEnd = interval.getEnd();
            } else if (interval.getStart() >= jEnd) {
                assignment.put(interval, 'J');
                jEnd = interval.getEnd();
            } else {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
                return;
            }
        }

        for (Interval interval : intervals) {
            result.append(assignment.get(interval));
        }

        System.out.println("Case #" + caseNum + ": " + result);
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