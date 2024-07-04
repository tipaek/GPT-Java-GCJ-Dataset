import java.util.*;
import java.io.*;

/*
Andres Arrieche
SDE @ AWS
https://www.linkedin.com/in/andresarrieche/
*/

public class Solution {

    static class Interval implements Comparable<Interval> {
        int id, start, end;

        Interval(int i, int s, int e) {
            start = s;
            end = e;
            id = i;
        }

        @Override
        public String toString() {
            return String.format("(%d, %d)", start, end);
        }

        public int compareTo(Interval interval) {
            if (interval.start != start) {
                return start - interval.start;
            }
            return interval.end - end;
        }

        boolean overlaps(Interval interval) {
            int newStart = Math.max(interval.start, start);
            int newEnd = Math.min(interval.end, end);

            return newStart < newEnd;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCount = in.nextInt();
        for (int test = 1; test <= testCount; test++) {
            int n = in.nextInt();
            List<Interval> intervals = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                intervals.add(new Interval(i, in.nextInt(), in.nextInt()));
            }
            
            System.out.printf("Case #%d: %s\n", test, solve(intervals));
        }
    }

    private static String solve(List<Interval> intervals) {
        String []solution = new String[intervals.size()];

        Interval cameron = new Interval(-1, -1, -1);
        Interval jamie = new Interval(-1, -1, -1);

        Collections.sort(intervals);
        for (int i = 0; i < intervals.size(); i++) {
            Interval newInterval = intervals.get(i);

            if (!cameron.overlaps(newInterval)) {
                cameron = newInterval;
                solution[newInterval.id] = "C";
            } else if (!jamie.overlaps(newInterval)) {
                jamie = newInterval;
                solution[newInterval.id] = "J";
            } else {
                return "IMPOSSIBLE";
            }
        }

        return String.join("", solution);
    }

}