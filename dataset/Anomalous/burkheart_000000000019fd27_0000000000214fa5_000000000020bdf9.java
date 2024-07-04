import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

    public static class Interval {
        public int start, end;
        public int getStart() { return start; }
    }

    public static int N;
    public static Interval[] intervals;

    public static String solve() {
        StringBuilder result = new StringBuilder();
        Arrays.sort(intervals, Comparator.comparing(Interval::getStart));

        int endJ = 0, endC = 0;
        for (Interval interval : intervals) {
            if (interval.start >= endJ) {
                result.append("J");
                endJ = interval.end;
            } else if (interval.start >= endC) {
                result.append("C");
                endC = interval.end;
            } else {
                return "IMPOSSIBLE";
            }
        }

        return result.toString();
    }

    public static Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; ++t) {
            N = scanner.nextInt();
            intervals = new Interval[N];
            for (int i = 0; i < N; i++) {
                intervals[i] = new Interval();
                intervals[i].start = scanner.nextInt();
                intervals[i].end = scanner.nextInt();
            }

            String result = solve();
            System.out.println("Case #" + t + ": " + result);
        }
    }
}