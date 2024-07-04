import java.util.*;
import java.io.*;

class Interval {
    int start;
    int end;

    Interval(int s, int e) {
        this.start = s;
        this.end = e;
    }
}

public class Solution {

    static boolean isValid(Interval[] intervals) {
        for (int i = 1; i < intervals.length; ++i) {
            int curStart = intervals[i].start;
            int curEnd = intervals[i].end;
            int overlap = 0;

            for (int j = i - 1; j >= 0; --j) {
                int start = intervals[j].start;
                int end = intervals[j].end;

                if (curStart == start) {
                    overlap++;
                }
                if (end == curStart || curEnd == start) {
                    continue;
                }
                if ((curStart > start && curStart < end) || (curEnd < end && curEnd > start)) {
                    overlap++;
                }
            }
            if (overlap >= 2) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseCount = Integer.parseInt(sc.nextLine());

        for (int t = 1; t <= testCaseCount; ++t) {
            int N = Integer.parseInt(sc.nextLine());
            Interval[] intervals = new Interval[N];

            for (int i = 0; i < N; ++i) {
                int start = Integer.parseInt(sc.next());
                int end = Integer.parseInt(sc.next());
                intervals[i] = new Interval(start, end);
            }
            sc.nextLine();

            if (!isValid(intervals)) {
                System.out.printf("Case #%d: IMPOSSIBLE\n", t);
            } else {
                StringBuilder schedule = new StringBuilder();
                schedule.append("J");
                char currentChar = 'J';
                int previousEnd = intervals[0].end;

                for (int i = 1; i < intervals.length; ++i) {
                    int curStart = intervals[i].start;
                    if (curStart < previousEnd) {
                        currentChar = currentChar == 'C' ? 'J' : 'C';
                    }
                    schedule.append(currentChar);
                    previousEnd = intervals[i].end;
                }
                System.out.printf("Case #%d: %s\n", t, schedule.toString());
            }
        }
        sc.close();
    }
}