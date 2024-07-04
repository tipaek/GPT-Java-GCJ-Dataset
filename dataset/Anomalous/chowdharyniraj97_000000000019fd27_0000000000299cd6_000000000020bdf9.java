import java.util.*;

class Interval {
    int start;
    int end;
    int position;

    Interval(int start, int end, int position) {
        this.start = start;
        this.end = end;
        this.position = position;
    }
}

class IntervalComparator implements Comparator<Interval> {
    @Override
    public int compare(Interval i1, Interval i2) {
        if (i1.start != i2.start) {
            return Integer.compare(i1.start, i2.start);
        }
        return Integer.compare(i1.end, i2.end);
    }
}

class Solution {
    private static int jEnd = -1;
    private static int cEnd = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            List<Interval> intervals = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals.add(new Interval(start, end, i));
            }
            String result = scheduleIntervals(intervals);
            System.out.println("Case #" + testCase + ": " + result);
        }
        scanner.close();
    }

    private static String scheduleIntervals(List<Interval> intervals) {
        Collections.sort(intervals, new IntervalComparator());
        char[] schedule = new char[intervals.size()];
        jEnd = -1;
        cEnd = -1;

        for (Interval interval : intervals) {
            if (interval.start >= jEnd) {
                jEnd = interval.end;
                schedule[interval.position] = 'J';
            } else if (interval.start >= cEnd) {
                cEnd = interval.end;
                schedule[interval.position] = 'C';
            } else {
                return "IMPOSSIBLE";
            }
        }
        return new String(schedule);
    }
}