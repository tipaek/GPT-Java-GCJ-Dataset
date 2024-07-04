import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int ts = 1;

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[][] intervals = new int[n][2];

            for (int j = 0; j < n; j++) {
                intervals[j][0] = sc.nextInt();
                intervals[j][1] = sc.nextInt();
            }

            int[] cSchedule = new int[1500];
            int[] jSchedule = new int[1500];
            int cIndex = 0, jIndex = 0;
            boolean impossible = false;
            StringBuilder result = new StringBuilder("C");

            for (int k = intervals[0][0]; k < intervals[0][1]; k++) {
                cSchedule[cIndex++] = k;
            }

            for (int j = 1; j < n; j++) {
                boolean cConflict = false, jConflict = false;

                for (int k = 0; k < cSchedule.length; k++) {
                    if (intervals[j][0] == cSchedule[k] || intervals[j][1] - 1 == cSchedule[k]) {
                        cConflict = true;
                    }
                    if (intervals[j][0] == jSchedule[k] || intervals[j][1] - 1 == jSchedule[k]) {
                        jConflict = true;
                    }
                }

                if (cConflict && jConflict) {
                    impossible = true;
                    break;
                } else if (cConflict) {
                    result.append('J');
                    for (int l = intervals[j][0]; l < intervals[j][1]; l++) {
                        jSchedule[jIndex++] = l;
                    }
                } else {
                    result.append('C');
                    for (int l = intervals[j][0]; l < intervals[j][1]; l++) {
                        cSchedule[cIndex++] = l;
                    }
                }
            }

            if (impossible) {
                System.out.printf("Case #%d: IMPOSSIBLE\n", ts);
            } else {
                System.out.printf("Case #%d: %s\n", ts, result.toString());
            }
            ts++;
        }
    }
}