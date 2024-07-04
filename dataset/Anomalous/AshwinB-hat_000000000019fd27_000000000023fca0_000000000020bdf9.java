import java.util.Arrays;
import java.util.Scanner;

class Interval implements Comparable<Interval> {
    int start, end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Interval other) {
        if (this.start == other.start) {
            return this.end - other.end;
        }
        return this.start - other.start;
    }
}

public class Solution {
    public static String solve(Interval[] intervals) {
        Arrays.sort(intervals);
        StringBuilder result = new StringBuilder();
        
        Interval cInterval = null, jInterval = null;

        for (Interval interval : intervals) {
            if (cInterval == null) {
                cInterval = interval;
                result.append("C");
            } else if (jInterval == null) {
                jInterval = interval;
                result.append("J");
            } else {
                if (interval.start >= cInterval.end) {
                    cInterval = interval;
                    result.append("C");
                } else if (interval.start >= jInterval.end) {
                    jInterval = interval;
                    result.append("J");
                } else {
                    return "IMPOSSIBLE";
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            Interval[] intervals = new Interval[n];
            for (int j = 0; j < n; j++) {
                intervals[j] = new Interval(scanner.nextInt(), scanner.nextInt());
            }
            String answer = solve(intervals);
            System.out.println("Case #" + i + ": " + answer);
        }
        scanner.close();
    }
}