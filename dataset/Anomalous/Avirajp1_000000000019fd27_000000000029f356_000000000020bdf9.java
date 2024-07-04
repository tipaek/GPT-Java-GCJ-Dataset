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

            int[] c = new int[99999];
            int[] j = new int[99999];
            Arrays.fill(c, -1);
            Arrays.fill(j, -1);

            StringBuilder result = new StringBuilder("C");
            int x = 0, y = 0;
            boolean impossible = false;

            for (int k = intervals[0][0]; k < intervals[0][1]; k++) {
                c[x++] = k;
            }

            for (int m = 1; m < n; m++) {
                int overlapC = 0, overlapJ = 0;

                for (int k = 0; k < c.length; k++) {
                    for (int u = intervals[m][0]; u < intervals[m][1]; u++) {
                        if (u == c[k]) overlapC++;
                        if (u == j[k]) overlapJ++;
                    }
                }

                if (overlapC > 0 && overlapJ == 0) {
                    result.append('J');
                    for (int l = intervals[m][0]; l < intervals[m][1]; l++) {
                        j[y++] = l;
                    }
                } else if (overlapC == 0 && overlapJ > 0) {
                    result.append('C');
                    for (int l = intervals[m][0]; l < intervals[m][1]; l++) {
                        c[x++] = l;
                    }
                } else if (overlapC == 0 && overlapJ == 0) {
                    result.append('J');
                    for (int l = intervals[m][0]; l < intervals[m][1]; l++) {
                        c[x++] = l;
                    }
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.printf("Case #%d: IMPOSSIBLE%n", ts);
            } else {
                System.out.printf("Case #%d: %s%n", ts, result.toString());
            }
            ts++;
        }
    }
}