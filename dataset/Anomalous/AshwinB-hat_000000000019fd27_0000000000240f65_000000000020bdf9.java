import java.util.Arrays;
import java.util.Scanner;

class Interval implements Comparable<Interval> {
    int start, end, index;

    public Interval(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }

    @Override
    public int compareTo(Interval interval) {
        if (this.start == interval.start) {
            return this.end - interval.end;
        }
        return this.start - interval.start;
    }
}

public class PartitionProblem {
    public static String solve(Interval[] intervals) {
        Arrays.sort(intervals);
        String[] result = new String[intervals.length];
        
        Interval cameron = null, jamie = null;

        for (Interval interval : intervals) {
            if (cameron == null) {
                cameron = interval;
                result[interval.index] = "C";
            } else if (jamie == null) {
                jamie = interval;
                result[interval.index] = "J";
            } else {
                if (interval.start >= cameron.end) {
                    cameron = interval;
                    result[interval.index] = "C";
                } else if (interval.start >= jamie.end) {
                    jamie = interval;
                    result[interval.index] = "J";
                } else {
                    return "IMPOSSIBLE";
                }
            }
        }
        return String.join("", result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();
            Interval[] intervals = new Interval[n];

            for (int j = 0; j < n; j++) {
                intervals[j] = new Interval(scanner.nextInt(), scanner.nextInt(), j);
            }

            String answer = solve(intervals);
            System.out.println("Case #" + i + ": " + answer);
        }
    }
}