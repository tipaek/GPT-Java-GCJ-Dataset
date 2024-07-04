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
    static boolean J_available;
    static boolean C_available;
    static int j_endTime;
    static int c_endTime;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            J_available = true;
            C_available = true;
            j_endTime = -1;
            c_endTime = -1;
            int n = scanner.nextInt();
            List<Interval> intervals = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals.add(new Interval(start, end, i));
            }

            String result = computeSchedule(intervals);
            System.out.println("Case #" + testCase + ": " + result);
        }
    }

    public static String computeSchedule(List<Interval> intervals) {
        PriorityQueue<Interval> intervalQueue = new PriorityQueue<>(new IntervalComparator());
        char[] schedule = new char[intervals.size()];

        for (Interval interval : intervals) {
            intervalQueue.add(interval);
        }

        while (!intervalQueue.isEmpty()) {
            Interval current = intervalQueue.poll();
            int start = current.start;
            int end = current.end;
            int position = current.position;

            if (start >= j_endTime) {
                j_endTime = end;
                schedule[position] = 'J';
            } else if (start >= c_endTime) {
                c_endTime = end;
                schedule[position] = 'C';
            } else {
                return "IMPOSSIBLE";
            }
        }
        return new String(schedule);
    }
}