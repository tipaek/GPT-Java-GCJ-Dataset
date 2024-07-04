import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = input.nextInt();
        for (int i = 1; i <= T; i++) {
            String result = solveCase(input);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String solveCase(Scanner input) {
        boolean[] c = new boolean[1441];
        boolean[] j = new boolean[1441];
        char[] result;
        int x = 0;
        boolean r;

        int n = input.nextInt();
        int[][] intervals = new int[n][2];
        result = new char[n];

        for (int i = 0; i < n; i++) {
            intervals[i][0] = input.nextInt();
            intervals[i][1] = input.nextInt();
        }

        intervals = sortIntervals(intervals);
        if (intervals == null) return "IMPOSSIBLE";

        for (int i = 0; i < n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (!c[start]) {
                r = fillSchedule(c, start, end);
                if (r) {
                    result[x++] = 'C';
                    continue;
                }
            }

            if (!j[start]) {
                r = fillSchedule(j, start, end);
                if (r) {
                    result[x++] = 'J';
                    continue;
                }
            }
            return "IMPOSSIBLE";
        }

        return rearrangeResult(result);
    }

    private static boolean[] flag = new boolean[1441];
    private static boolean[] shadow = new boolean[1441];
    private static int[] n = new int[1441];
    private static int[] ns = new int[1441];
    private static int[][] h = null;

    private static String rearrangeResult(char[] t) {
        char[] r = new char[t.length];
        for (int[] p : h) {
            r[p[0]] = t[p[1]];
        }
        return new String(r);
    }

    private static int[][] sortIntervals(int[][] intervals) {
        Arrays.fill(flag, false);
        Arrays.fill(shadow, false);
        Arrays.fill(n, 0);
        Arrays.fill(ns, 0);

        int length = intervals.length;
        int[][] sortedIntervals = new int[length][2];
        h = new int[length][2];

        for (int i = 0; i < length; i++) {
            int index = intervals[i][0];
            if (!flag[index]) {
                n[index] = i;
                flag[index] = true;
            } else {
                if (!shadow[index]) {
                    ns[index] = i;
                    shadow[index] = true;
                } else {
                    return null;
                }
            }
        }

        int p = 0;
        for (int i = 0; i < 1441; i++) {
            if (flag[i]) {
                int index = n[i];
                sortedIntervals[p] = intervals[index];
                h[p][0] = p;
                h[p][1] = index;
                p++;
                if (shadow[i]) {
                    index = ns[i];
                    sortedIntervals[p] = intervals[index];
                    h[p][0] = p;
                    h[p][1] = index;
                    p++;
                }
            }
        }

        return sortedIntervals;
    }

    private static boolean fillSchedule(boolean[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (!schedule[i]) {
                schedule[i] = true;
            } else {
                for (int j = start; j < i; j++) {
                    schedule[j] = false;
                }
                return false;
            }
        }
        return true;
    }
}