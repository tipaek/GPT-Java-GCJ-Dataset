import java.io.*;
import java.util.*;

class Interval implements Comparable<Interval> {
    int index;
    int start;
    int end;

    Interval(int index, int start, int end) {
        this.index = index;
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Interval other) {
        if (this.start != other.start) {
            return Integer.compare(this.start, other.start);
        }
        return Integer.compare(this.end, other.end);
    }
}

public class Solution {

    private static String assignTasks(List<Interval> intervals) {
        Collections.sort(intervals);
        char[] result = new char[intervals.size()];

        Interval cInterval = null;
        Interval jInterval = null;

        for (Interval interval : intervals) {
            if (cInterval == null || cInterval.end <= interval.start) {
                result[interval.index] = 'C';
                cInterval = interval;
            } else if (jInterval == null || jInterval.end <= interval.start) {
                result[interval.index] = 'J';
                jInterval = interval;
            } else {
                return "IMPOSSIBLE";
            }
        }

        return new String(result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int intervalCount = scanner.nextInt();
            List<Interval> intervals = new ArrayList<>();

            for (int i = 0; i < intervalCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals.add(new Interval(i, start, end));
            }

            String result = assignTasks(intervals);
            System.out.println("Case #" + t + ": " + result);
        }

        scanner.close();
    }
}