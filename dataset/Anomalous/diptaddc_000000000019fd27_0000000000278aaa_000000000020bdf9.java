import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class Interval implements Comparable<Interval> {
    int start;
    int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Interval other) {
        return Integer.compare(this.start, other.start);
    }
}

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            int n = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            boolean isPossible = true;
            int cEnd = 0;
            int jEnd = 0;
            ArrayList<Interval> intervals = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String[] line = br.readLine().split(" ");
                int start = Integer.parseInt(line[0]);
                int end = Integer.parseInt(line[1]);
                intervals.add(new Interval(start, end));
            }

            Collections.sort(intervals);

            for (Interval interval : intervals) {
                if (cEnd <= interval.start) {
                    cEnd = interval.end;
                    sb.append("C");
                } else if (jEnd <= interval.start) {
                    jEnd = interval.end;
                    sb.append("J");
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                System.out.println("Case #" + testCase + ": " + sb.toString());
            } else {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            }
        }
    }
}