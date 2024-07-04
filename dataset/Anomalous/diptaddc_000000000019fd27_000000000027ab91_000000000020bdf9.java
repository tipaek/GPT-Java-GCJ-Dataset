import java.util.*;
import java.io.*;

class Interval implements Comparable<Interval> {
    int start;
    int end;
    int index;

    Interval(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }

    @Override
    public int compareTo(Interval other) {
        return Integer.compare(this.start, other.start);
    }
}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            int n = Integer.parseInt(br.readLine());
            char[] result = new char[n];
            boolean possible = true;
            int cEnd = 0;
            int jEnd = 0;

            List<Interval> intervals = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String[] line = br.readLine().split(" ");
                int start = Integer.parseInt(line[0]);
                int end = Integer.parseInt(line[1]);
                intervals.add(new Interval(start, end, i));
            }

            Collections.sort(intervals);

            for (Interval interval : intervals) {
                if (cEnd <= interval.start) {
                    cEnd = interval.end;
                    result[interval.index] = 'C';
                } else if (jEnd <= interval.start) {
                    jEnd = interval.end;
                    result[interval.index] = 'J';
                } else {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                System.out.println("Case #" + testCase + ": " + new String(result));
            } else {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            }
        }
    }
}