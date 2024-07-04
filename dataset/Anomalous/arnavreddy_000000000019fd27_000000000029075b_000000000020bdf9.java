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
            for (int index = 0; index < intervals.length; index++) {
                if (cam == null || cam.end <= intervals[index].start) {
                    cam = intervals[index];
                    ans[intervals[index].ogIndex] = "C";
                } else if (jam == null || jam.end <= intervals[index].start) {
                    jam = intervals[index];
                    ans[intervals[index].ogIndex] = "J";
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
    int start, end, ogIndex;

    Interval(int start, int end, int ogIndex) {
        this.start = start;
        this.end = end;
        this.ogIndex = ogIndex;
    }

    @Override
    public int compareTo(Interval other) {
        return this.start - other.start;
    }
}