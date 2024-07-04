import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int N = in.nextInt();
            int[] S = new int[N];
            int[] E = new int[N];

            for (int j = 0 ; j < N; j++) {
                S[j] = in.nextInt();
                E[j] = in.nextInt();
            }
            System.out.println("Case #" + i + ": " + solve(S, E, N));
        }
    }

    private static String solve(int[] S, int[] E, int N) {
        Interval[] intervals = new Interval[N];

        for (int i = 0; i < N ; i++) {
            intervals[i] = new Interval(S[i], E[i]);
        }

        List<Interval> intervalList = Stream.of(intervals).sorted((i1, i2) -> (i1.start.compareTo(i2.start))).collect(Collectors.toList());

        Interval cInterval = null, jInterval = null;

        for (Interval interval : intervalList) {
            if (cInterval != null) {
                if (cInterval.end <= interval.start) {
                    cInterval = null;
                }
            }

            if (jInterval != null) {
                if (jInterval.end <= interval.start) {
                    jInterval = null;
                }
            }

            if (cInterval == null) {
                cInterval = interval;
                cInterval.parent = 'C';
            } else if (jInterval == null) {
                jInterval = interval;
                jInterval.parent = 'J';
            } else {
                return "IMPOSSIBLE";
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Interval interval : intervals) {
            sb.append(interval.parent);
        }
        return sb.toString();
    }

    public static class Interval {
        private Integer start;
        private Integer end;
        private char parent;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}