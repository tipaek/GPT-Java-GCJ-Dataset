import java.util.Scanner;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int x = 1; x <= t; x++) {
            int n = sc.nextInt();
            Interval[] intervals = new Interval[n];
            for (int i = 0; i < n; i++) {
                intervals[i] = new Interval(sc.nextInt(), sc.nextInt(), i);
            }

            Arrays.sort(intervals, (a, b) -> a.start - b.start);

            int cs = -1, ce = -1, js = -1, je = -1;
            char[] result = new char[n];
            boolean possible = true;

            for (Interval interval : intervals) {
                if (ce <= interval.start) {
                    result[interval.index] = 'C';
                    cs = interval.start;
                    ce = interval.end;
                } else if (je <= interval.start) {
                    result[interval.index] = 'J';
                    js = interval.start;
                    je = interval.end;
                } else {
                    possible = false;
                    break;
                }
            }

            String output = possible ? new String(result) : "IMPOSSIBLE";
            System.out.println("Case #" + x + ": " + output);
        }

        sc.close();
    }

    static class Interval {
        int start, end, index;

        Interval(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
}