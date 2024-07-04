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
            StringBuilder result = new StringBuilder();

            for (int j = 0; j < n; j++) {
                intervals[j][0] = sc.nextInt();
                intervals[j][1] = sc.nextInt();
            }

            int[] c = new int[1500];
            int[] j = new int[1500];
            int cIndex = 0;
            int jIndex = 0;
            int conflictC = 0;
            int conflictJ = 0;
            boolean impossible = false;

            for (int k = intervals[0][0]; k < intervals[0][1]; k++) {
                c[cIndex++] = k;
            }
            result.append('C');

            for (int m = 1; m < n; m++) {
                for (int k = 0; k < 1500; k++) {
                    if (intervals[m][0] == c[k] || intervals[m][1] - 1 == c[k]) {
                        conflictC++;
                    }
                    if (intervals[m][0] == j[k] || intervals[m][1] - 1 == j[k]) {
                        conflictJ++;
                    }
                }

                if (conflictC > 0 && conflictJ == 0) {
                    result.append('J');
                    for (int l = intervals[m][0]; l < intervals[m][1]; l++) {
                        j[jIndex++] = l;
                    }
                } else if (conflictC == 0 && conflictJ > 0) {
                    result.append('C');
                    for (int l = intervals[m][0]; l < intervals[m][1]; l++) {
                        c[cIndex++] = l;
                    }
                } else if (conflictC == 0 && conflictJ == 0) {
                    result.append('C');
                    for (int l = intervals[m][0]; l < intervals[m][1]; l++) {
                        c[cIndex++] = l;
                    }
                } else {
                    impossible = true;
                    break;
                }

                conflictC = 0;
                conflictJ = 0;
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