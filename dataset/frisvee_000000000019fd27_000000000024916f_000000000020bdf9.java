import java.io.*;
import java.util.*;

class Interval implements Comparable<Interval> {
    int index;
    int start;
    int end;

    public Interval(int index, int start, int end) {
        this.index = index;
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Interval o) {
        if (this.start == o.start) {
            return this.end - o.end;
        } else {
            return this.start - o.start;
        }
    }
}

public class Solution {
    private static String solve(ArrayList<Interval> intervals) {
        Collections.sort(intervals);
        byte[] result = new byte[intervals.size()];

        Interval pC = null;
        Interval pJ = null;

        for (Interval current : intervals) {
            if (pC == null || pC.end <= current.start) {
                result[current.index] = 'C';
                pC = current;
                continue;
            }

            if (pJ == null || pJ.end <= current.start) {
                result[current.index] = 'J';
                pJ = current;
                continue;
            }

            return "IMPOSSIBLE";
        }

        return new String(result);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = in.nextInt();

            ArrayList<Interval> intervals = new ArrayList<>();
            for (int n = 0; n < N; n++) {
                Interval interval = new Interval(n, in.nextInt(), in.nextInt());
                intervals.add(interval);
            }

            System.out.println("Case #" + t + ": " + solve(intervals));
        }

        in.close();
    }
}