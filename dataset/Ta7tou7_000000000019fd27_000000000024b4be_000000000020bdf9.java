import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int t = sc.nextInt();
        for (int x = 1; x <= t; x++) {
            int n = sc.nextInt();
            Interval[] intervals = new Interval[n];
            for (int i = 0; i < n; i++) {
                intervals[i] = new Interval(sc.nextInt(), sc.nextInt(), i);
            }
            String res = solve(n, intervals);
            System.out.println("Case #" + x + ": " + res);
        }
    }

    private static String solve(int n, Interval[] intervals) {
        Arrays.sort(intervals);
        Interval previous = intervals[0];
        char[] content = new char[n];
        Arrays.fill(content, 'J');
        content[previous.index] = 'C';
        int firstJ = 0;
        boolean found = false;
        for (int i = 1; i < n; i++) {
            Interval current = intervals[i];
            if(current.start >= previous.end) {
                content[current.index] = 'C';
                previous = current;
            }
            else if(!found) {
                found = true;
                firstJ = i;
            }
        }
        previous = intervals[firstJ];
        for (int i = firstJ + 1; i < n; i++) {
            Interval current = intervals[i];
            if(content[current.index] == 'C') continue;

            if(current.start < previous.end) {
                return "IMPOSSIBLE";
            }
        }
        return new String(content);
    }

    static class Interval implements Comparable<Interval> {
        int start;
        int end;
        int index;
        public Interval(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        @Override
        public int compareTo(Interval interval) {
            if(this.start == interval.start) {
                return this.end - interval.end;
            }
            else return this.start - interval.start;
        }
    }
}
