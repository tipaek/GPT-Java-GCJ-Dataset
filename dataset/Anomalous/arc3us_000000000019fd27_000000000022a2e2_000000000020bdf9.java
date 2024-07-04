import java.util.*;
import java.io.*;

public class Solution {

    public static void sortIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(final int[] interval1, final int[] interval2) {
                return Integer.compare(interval1[0], interval2[0]);
            }
        });
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases > 0) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];

            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }

            sortIntervals(intervals);

            boolean impossible = false;
            StringBuilder schedule = new StringBuilder("C".repeat(n));
            int cameronEnd = intervals[0][1];
            int jamieEnd = 0;

            for (int i = 1; i < n; i++) {
                if (intervals[i][0] < cameronEnd) {
                    if (intervals[i][0] < jamieEnd) {
                        impossible = true;
                        break;
                    } else {
                        schedule.setCharAt(i, 'J');
                        jamieEnd = intervals[i][1];
                    }
                } else {
                    cameronEnd = intervals[i][1];
                }
            }

            if (impossible) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseNumber + ": " + schedule);
            }

            caseNumber++;
            testCases--;
        }

        scanner.close();
    }
}