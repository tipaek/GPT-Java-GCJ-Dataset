import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; ++i) {
            int n = scanner.nextInt();
            List<Interval> intervals = new ArrayList<>();
            
            for (int j = 0; j < n; j++) {
                intervals.add(new Interval(scanner.nextInt(), scanner.nextInt(), j));
            }
            
            scheduleIntervals(intervals, i);
        }
    }

    private static void scheduleIntervals(List<Interval> intervals, int caseNumber) {
        String impossible = "IMPOSSIBLE";
        StringBuilder result = new StringBuilder();
        result.setLength(intervals.size());

        Collections.sort(intervals);

        int cEnd = -1;
        int jEnd = -1;

        for (Interval interval : intervals) {
            if (cEnd <= interval.start) {
                result.setCharAt(interval.index, 'C');
                cEnd = interval.end;
            } else if (jEnd <= interval.start) {
                result.setCharAt(interval.index, 'J');
                jEnd = interval.end;
            } else {
                result = new StringBuilder(impossible);
                break;
            }
        }

        System.out.println("Case #" + caseNumber + ": " + result.toString());
    }

    private static class Interval implements Comparable<Interval> {
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
            if (this.start != other.start) {
                return Integer.compare(this.start, other.start);
            }
            return Integer.compare(this.end, other.end);
        }
    }
}