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
        return Integer.compare(this.start, other.start);
    }
}

public class Solution {

    public static String solve(Interval[] intervals) {
        Arrays.sort(intervals);
        StringBuilder result = new StringBuilder();

        Interval cameron = null, jamie = null;

        for (Interval interval : intervals) {
            if (cameron == null) {
                cameron = interval;
                result.append("C");
            } else if (jamie == null) {
                jamie = interval;
                result.append("J");
            } else {
                if (interval.start >= cameron.end) {
                    cameron = interval;
                    result.append("C");
                } else if (interval.start >= jamie.end) {
                    jamie = interval;
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
    }
}