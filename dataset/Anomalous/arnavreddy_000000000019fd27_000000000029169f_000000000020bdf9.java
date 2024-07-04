import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = in.nextInt();
        for (int count = 1; count <= t; count++) {
            int n = in.nextInt();
            Interval[] intervals = new Interval[n];

            for (int i = 0; i < n; i++) {
                intervals[i] = new Interval(in.nextInt(), in.nextInt(), i);
            }

            Arrays.sort(intervals);

            Interval cam = null, jam = null;
            String[] ans = new String[n];
            boolean impossible = false;

            for (Interval interval : intervals) {
                if (cam == null || cam.end <= interval.start) {
                    cam = interval;
                    ans[interval.ogIndex] = "C";
                } else if (jam == null || jam.end <= interval.start) {
                    jam = interval;
                    ans[interval.ogIndex] = "J";
                } else {
                    System.out.println("Case #" + count + ": IMPOSSIBLE");
                    impossible = true;
                    break;
                }
            }

            if (!impossible) {
                System.out.print("Case #" + count + ": ");
                for (String str : ans) {
                    System.out.print(str);
                }
                System.out.println();
            }
        }
    }
}

class Interval implements Comparable<Interval> {
    int ogIndex;
    int start;
    int end;

    public Interval(int start, int end, int index) {
        this.ogIndex = index;
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Interval other) {
        if (this.start == other.start) {
            return Integer.compare(this.end, other.end);
        }
        return Integer.compare(this.start, other.start);
    }
}