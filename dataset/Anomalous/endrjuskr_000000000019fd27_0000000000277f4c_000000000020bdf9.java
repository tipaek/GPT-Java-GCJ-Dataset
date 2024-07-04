import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int numActivities = scanner.nextInt();
            StringBuilder schedule = new StringBuilder(numActivities);
            int[][] intervals = new int[2 * numActivities][3];
            
            for (int i = 0; i < numActivities; i++) {
                schedule.append('C');
                intervals[2 * i][0] = scanner.nextInt();
                intervals[2 * i + 1][0] = scanner.nextInt();
                intervals[2 * i + 1][1] = -1;
                intervals[2 * i][1] = intervals[2 * i + 1][0];
                intervals[2 * i][2] = i;
                intervals[2 * i + 1][2] = i;
            }

            Arrays.sort(intervals, (a, b) -> {
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);
                } else {
                    return Integer.compare(a[1], b[1]);
                }
            });

            int cEnd = -1;
            int jEnd = -1;

            for (int i = 0; i < 2 * numActivities; i++) {
                if (intervals[i][1] >= 0) {
                    if (cEnd < 0) {
                        schedule.setCharAt(intervals[i][2], 'C');
                        cEnd = intervals[i][1];
                    } else if (jEnd < 0) {
                        schedule.setCharAt(intervals[i][2], 'J');
                        jEnd = intervals[i][1];
                    } else {
                        schedule = new StringBuilder("IMPOSSIBLE");
                        break;
                    }
                } else {
                    if (cEnd == intervals[i][0]) {
                        cEnd = -1;
                    } else {
                        jEnd = -1;
                    }
                }
            }

            System.out.printf("Case #%d: %s%n", t, schedule.toString());
        }
    }
}