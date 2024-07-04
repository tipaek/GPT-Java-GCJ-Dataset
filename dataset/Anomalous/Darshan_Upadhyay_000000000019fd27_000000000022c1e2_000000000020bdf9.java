import java.util.*;

public class Solution {
    private static final String OUTPUT_FORMAT = "Case #%d: %s";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCaseCount = scanner.nextInt();
            for (int caseNum = 1; caseNum <= testCaseCount; caseNum++) {
                new Solution().processCase(caseNum, scanner);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void processCase(int caseNum, Scanner scanner) {
        int n = scanner.nextInt();
        List<Interval> intervals = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            intervals.add(new Interval(start, end, i));
        }

        intervals.sort(Comparator.comparingInt(interval -> interval.start));

        int cEnd = 0;
        int jEnd = 0;
        char[] schedule = new char[n];
        boolean isImpossible = false;

        for (Interval interval : intervals) {
            if (interval.start >= cEnd) {
                cEnd = interval.end;
                schedule[interval.index] = 'C';
            } else if (interval.start >= jEnd) {
                jEnd = interval.end;
                schedule[interval.index] = 'J';
            } else {
                isImpossible = true;
                break;
            }
        }

        String result = isImpossible ? "IMPOSSIBLE" : new String(schedule);
        System.out.printf(OUTPUT_FORMAT, caseNum, result);
        System.out.println();
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
}