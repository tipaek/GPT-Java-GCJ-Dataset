import java.util.*;
import java.io.*;

public class Solution {
    static class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            Interval[] intervals = new Interval[n];

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals[i] = new Interval(start, end);
            }

            int status = 0;
            StringBuilder schedule = new StringBuilder();
            schedule.append("C");

            int cameronEnd = intervals[0].end;
            int jamieEnd = -1;
            int cameronStart = intervals[0].start;
            int jamieStart = -1;

            for (int i = 0; i < n - 1; i++) {
                if ((cameronStart > intervals[i + 1].start && cameronStart >= intervals[i + 1].end) || (cameronEnd <= intervals[i + 1].start)) {
                    schedule.append("C");
                    cameronStart = intervals[i + 1].start;
                    cameronEnd = intervals[i + 1].end;
                } else if ((jamieStart > intervals[i + 1].start && jamieStart >= intervals[i + 1].end) || (jamieEnd <= intervals[i + 1].start)) {
                    schedule.append("J");
                    jamieStart = intervals[i + 1].start;
                    jamieEnd = intervals[i + 1].end;
                } else {
                    status = 1;
                    break;
                }
            }

            if (status == 1) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + t + ": " + schedule);
            }
        }
    }
}