import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Interval implements Comparable<Interval> {
    int start;
    int end;
    int index;

    public Interval(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }

    @Override
    public int compareTo(Interval other) {
        return Integer.compare(this.start, other.start);
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            ArrayList<Interval> intervals = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals.add(new Interval(start, end, i));
            }

            Collections.sort(intervals);
            assignSchedules(intervals, n, testCase);
        }
    }

    private static void assignSchedules(ArrayList<Interval> intervals, int n, int testCase) {
        char[] schedule = new char[n];
        int cEnd = -1;
        int jEnd = -1;

        boolean possible = true;

        for (Interval interval : intervals) {
            if (interval.start >= cEnd) {
                schedule[interval.index] = 'C';
                cEnd = interval.end;
            } else if (interval.start >= jEnd) {
                schedule[interval.index] = 'J';
                jEnd = interval.end;
            } else {
                possible = false;
                break;
            }
        }

        if (possible) {
            System.out.println("Case #" + testCase + ": " + new String(schedule));
        } else {
            System.out.println("Case #" + testCase + ": IMPOSSIBLE");
        }
    }
}