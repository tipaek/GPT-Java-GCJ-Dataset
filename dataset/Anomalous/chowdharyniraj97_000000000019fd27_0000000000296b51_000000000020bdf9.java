import java.util.*;

class Interval {
    int start;
    int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
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
    private static boolean isJAvailable;
    private static boolean isCAvailable;
    private static int jEndTime = -1;
    private static int cEndTime = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 0;

        while (testCases-- > 0) {
            caseNumber++;
            isJAvailable = true;
            isCAvailable = true;
            jEndTime = -1;
            cEndTime = -1;
            int n = scanner.nextInt();
            List<Interval> intervals = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals.add(new Interval(start, end));
            }

            String result = computeSchedule(intervals);
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }

    private static String computeSchedule(List<Interval> intervals) {
        PriorityQueue<Interval> queue = new PriorityQueue<>(new IntervalComparator());
        StringBuilder schedule = new StringBuilder();

        for (Interval interval : intervals) {
            queue.add(interval);
        }

        while (!queue.isEmpty()) {
            Interval current = queue.poll();
            int start = current.start;
            int end = current.end;

            if (start >= jEndTime) {
                jEndTime = end;
                schedule.append("J");
            } else if (start >= cEndTime) {
                cEndTime = end;
                schedule.append("C");
            } else {
                return "IMPOSSIBLE";
            }
        }

        return schedule.toString();
    }
}