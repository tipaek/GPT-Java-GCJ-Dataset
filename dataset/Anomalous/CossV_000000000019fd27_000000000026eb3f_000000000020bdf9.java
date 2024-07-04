import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int numIntervals = Integer.parseInt(scanner.nextLine());
            StringBuilder result = new StringBuilder(" ".repeat(numIntervals));
            List<Interval> allIntervals = new ArrayList<>();
            List<Interval> cIntervals = new ArrayList<>();
            List<Interval> jIntervals = new ArrayList<>();

            for (int i = 0; i < numIntervals; i++) {
                String[] times = scanner.nextLine().split(" ");
                int start = Integer.parseInt(times[0]);
                int end = Integer.parseInt(times[1]);
                allIntervals.add(new Interval(start, end));
            }

            List<Interval> sortedIntervals = new ArrayList<>(allIntervals);
            sortedIntervals.sort(Comparator.comparingInt(interval -> interval.start));

            for (Interval interval : sortedIntervals) {
                if (!hasOverlap(cIntervals, interval)) {
                    cIntervals.add(interval);
                    result.setCharAt(allIntervals.indexOf(interval), 'C');
                } else if (!hasOverlap(jIntervals, interval)) {
                    jIntervals.add(interval);
                    result.setCharAt(allIntervals.indexOf(interval), 'J');
                } else {
                    result.setLength(0);
                    result.append("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + caseNum + ": " + result);
        }
    }

    private static boolean hasOverlap(List<Interval> intervals, Interval newInterval) {
        for (Interval interval : intervals) {
            if (!noOverlap(interval.start, interval.end, newInterval.start, newInterval.end)) {
                return true;
            }
        }
        return false;
    }

    private static boolean noOverlap(int start1, int end1, int start2, int end2) {
        return end1 <= start2 || end2 <= start1;
    }

    static class Interval {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Interval interval = (Interval) obj;
            return start == interval.start && end == interval.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }
    }
}