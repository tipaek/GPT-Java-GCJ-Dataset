import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine().trim());

        for (int i = 1; i <= t; i++) {
            int n = Integer.parseInt(br.readLine().trim());
            Interval[] intervals = new Interval[n];
            for (int j = 0; j < n; j++) {
                String[] input = br.readLine().trim().split("\\s+");
                intervals[j] = new Interval(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
            }

            Interval[] sortedIntervals = intervals.clone();
            Arrays.sort(sortedIntervals);

            boolean isJamieFree = true, isCameronFree = true;
            int jamieEnd = 0, cameronEnd = 0;
            StringBuilder result = new StringBuilder();

            for (Interval interval : sortedIntervals) {
                if (interval.start >= jamieEnd) {
                    isJamieFree = true;
                    jamieEnd = 0;
                }
                if (interval.start >= cameronEnd) {
                    isCameronFree = true;
                    cameronEnd = 0;
                }

                if (isJamieFree) {
                    interval.person = 'J';
                    jamieEnd = interval.end;
                    isJamieFree = false;
                } else if (isCameronFree) {
                    interval.person = 'C';
                    cameronEnd = interval.end;
                    isCameronFree = false;
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            if (!result.toString().equals("IMPOSSIBLE")) {
                for (Interval interval : intervals) {
                    result.append(interval.person);
                }
            }

            bw.write("Case #" + i + ": " + result.toString() + "\n");
        }

        br.close();
        bw.close();
    }
}

class Interval implements Comparable<Interval> {
    int start, end;
    char person;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
        this.person = ' ';
    }

    @Override
    public int compareTo(Interval other) {
        return Integer.compare(this.start, other.start);
    }
}