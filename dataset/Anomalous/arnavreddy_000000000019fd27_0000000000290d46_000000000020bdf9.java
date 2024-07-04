import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCases = scanner.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            Interval[] intervals = new Interval[n];
            for (int i = 0; i < n; i++) {
                intervals[i] = new Interval(scanner.nextInt(), scanner.nextInt(), i);
            }
            Arrays.sort(intervals);

            Interval cameron = null, jamie = null;
            String[] result = new String[n];
            boolean impossible = false;

            for (Interval interval : intervals) {
                if (cameron == null || cameron.end <= interval.start) {
                    cameron = interval;
                    result[interval.originalIndex] = "C";
                } else if (jamie == null || jamie.end <= interval.start) {
                    jamie = interval;
                    result[interval.originalIndex] = "J";
                } else {
                    System.out.println("Case #" + testCase + ": IMPOSSIBLE");
                    impossible = true;
                    break;
                }
            }

            if (!impossible) {
                System.out.print("Case #" + testCase + ": ");
                for (String res : result) {
                    System.out.print(res);
                }
                System.out.println();
            }
        }
    }
}

class Interval implements Comparable<Interval> {
    int originalIndex;
    int start;
    int end;

    public Interval(int start, int end, int originalIndex) {
        this.originalIndex = originalIndex;
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