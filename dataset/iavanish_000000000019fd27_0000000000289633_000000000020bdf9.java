import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String... args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();

        for (int testCase = 1; testCase <= t; testCase++) {
            int n = scanner.nextInt();
            Interval[] intervals = new Interval[n];
            for (int i = 0; i < n; i++) {
                intervals[i] = new Interval(i, scanner.nextInt(), scanner.nextInt());
            }

            Arrays.sort(intervals, (i1, i2) -> {
                if (i1.s != i2.s) {
                    return i1.s - i2.s;
                }
                return i1.e - i2.e;
            });

            int lastC = -1;
            int lastJ = -1;
            boolean impossible = false;
            boolean[] assignment = new boolean[n];
            for (int i = 0; i < n; i++) {
                if (lastC <= intervals[i].s) {
                    lastC = intervals[i].e;
                }
                else if (lastJ <= intervals[i].s) {
                    assignment[intervals[i].index] = true;
                    lastJ = intervals[i].e;
                }
                else {
                    impossible = true;
                    break;
                }
            }
            
            StringBuilder result = new StringBuilder();
            if (impossible) {
                result = new StringBuilder("IMPOSSIBLE");
            }
            else {
                for (int i = 0; i < n; i++) {
                    result.append(!assignment[i] ? 'C' : 'J');
                }
            }

            System.out.printf("Case #%d: %s\n", testCase, result.toString());
        }
    }

    private static class Interval {
        public int index;
        public int s;
        public int e;
        Interval(int index, int s, int e) {
            this.index = index;
            this.s = s;
            this.e = e;
        }
    }

}
