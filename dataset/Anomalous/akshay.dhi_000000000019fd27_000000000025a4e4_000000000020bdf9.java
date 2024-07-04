import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        int caseNumber = 1;

        while (testCases-- > 0) {
            int numIntervals = Integer.parseInt(br.readLine());
            List<Interval> intervals = new ArrayList<>();

            for (int i = 0; i < numIntervals; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                intervals.add(new Interval(start, end));
            }

            intervals.sort(Comparator.comparingInt(interval -> interval.start));

            int cEnd = -1;
            int jEnd = -1;
            StringBuilder schedule = new StringBuilder();
            boolean impossible = false;

            for (Interval interval : intervals) {
                if (interval.start >= cEnd) {
                    cEnd = interval.end;
                    schedule.append("C");
                } else if (interval.start >= jEnd) {
                    jEnd = interval.end;
                    schedule.append("J");
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseNumber + ": " + schedule.toString());
            }

            caseNumber++;
        }
    }
}

class Interval {
    int start, end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}