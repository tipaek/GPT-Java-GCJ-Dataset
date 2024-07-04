import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int cases = Integer.parseInt(scan.nextLine());
        for (int i = 1; i <= cases; i++) {
            solve(i, scan);
        }
    }

    static class Interval implements Comparable<Interval> {
        int start, end;
        int index;

        public Interval(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        @Override
        public int compareTo(Interval o) {
            if (this.start < o.start) {
                return -1;
            } else if (this.start > o.start) {
                return 1;
            } else {
                if (this.end <= o.end) {
                    return -1;
                } else {
                    return 1;
                }
            }
        }
    }

    public static void solve(int caseNum, Scanner scan) {
        int n = Integer.parseInt(scan.nextLine());
        Interval[] intervals = new Interval[n];
        for (int i = 0; i < n; i++) {
            String line = scan.nextLine();
            String[] tokens = line.split(" ");
            intervals[i] = new Interval(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]), i);
        }
        Arrays.sort(intervals);

        char[] result = new char[n];
        int cameron = 0;
        int jamie = 0;
        for (Interval interval : intervals) {
            if (cameron <= jamie) {
                if (interval.start >= cameron) {
                    cameron = interval.end;
                    result[interval.index] = 'C';
                } else {
                    System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
                    return;
                }
            } else {
                if (interval.start >= jamie) {
                    jamie = interval.end;
                    result[interval.index] = 'J';
                } else {
                    System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
                    return;
                }
            }
        }
        System.out.println("Case #" + caseNum + ": " + String.valueOf(result));

    }
}
