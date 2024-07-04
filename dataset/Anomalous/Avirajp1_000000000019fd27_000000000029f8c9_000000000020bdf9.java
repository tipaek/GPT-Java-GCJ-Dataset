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

            int[] c = new int[100000];
            int[] j = new int[100000];
            Arrays.fill(c, -1);
            Arrays.fill(j, -1);

            StringBuilder result = new StringBuilder("C");
            boolean impossible = false;

            for (int k = intervals[0][0] + 1; k < intervals[0][1]; k++) {
                c[k] = 1;
            }

            for (int m = 1; m < n; m++) {
                boolean cConflict = false;
                boolean jConflict = false;

                for (int k = intervals[m][0]; k < intervals[m][1]; k++) {
                    if (c[k] == 1) {
                        cConflict = true;
                    }
                    if (j[k] == 1) {
                        jConflict = true;
                    }
                }

                if (cConflict && jConflict) {
                    impossible = true;
                    break;
                } else if (cConflict) {
                    result.append('J');
                    for (int k = intervals[m][0]; k < intervals[m][1]; k++) {
                        j[k] = 1;
                    }
                } else {
                    result.append('C');
                    for (int k = intervals[m][0]; k < intervals[m][1]; k++) {
                        c[k] = 1;
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