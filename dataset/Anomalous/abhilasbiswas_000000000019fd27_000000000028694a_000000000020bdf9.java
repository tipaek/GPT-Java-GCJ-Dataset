import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = input.nextInt();
        for (int i = 1; i <= T; i++) {
            String result = processTestCase(input);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    public static String processTestCase(Scanner input) {
        boolean[] c = new boolean[1441];
        boolean[] j = new boolean[1441];
        char[] result;
        int x = 0;

        int n = input.nextInt();
        int[][] intervals = new int[n][2];
        result = new char[n];

        for (int i = 0; i < n; i++) {
            intervals[i][0] = input.nextInt();
            intervals[i][1] = input.nextInt();
        }

        intervals = sortIntervals(intervals);

        if (intervals == null) {
            return "IMPOSSIBLE";
        }

        for (int i = 0; i < n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (!c[start]) {
                markOccupied(c, start, end);
                result[x++] = 'C';
            } else if (!j[start]) {
                markOccupied(j, start, end);
                result[x++] = 'J';
            } else {
                return "IMPOSSIBLE";
            }
        }

        return rearrangeResult(result);
    }

    static boolean[] flag;
    static boolean[] shadow;
    static boolean[] ss;
    static int[] n;
    static int[] ns;
    static int[] nss;
    static int[][] h;

    public static String rearrangeResult(char[] t) {
        char[] reordered = new char[t.length];
        for (int[] p : h) {
            reordered[p[0]] = t[p[1]];
        }
        return new String(reordered);
    }

    public static int[][] sortIntervals(int[][] intervals) {
        flag = new boolean[1441];
        shadow = new boolean[1441];
        ss = new boolean[1441];
        n = new int[1441];
        ns = new int[1441];
        nss = new int[1441];

        int length = intervals.length;
        int[][] sortedIntervals = new int[length][2];
        h = new int[length][2];

        for (int i = 0; i < length; i++) {
            int start = intervals[i][0];
            if (!flag[start]) {
                n[start] = i;
                flag[start] = true;
            } else if (!shadow[start]) {
                ns[start] = i;
                shadow[start] = true;
            } else if (!ss[start]) {
                nss[start] = i;
                ss[start] = true;
            } else {
                return null;
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
                    if (ss[i]) {
                        index = nss[i];
                        sortedIntervals[p] = intervals[index];
                        h[p][0] = p;
                        h[p][1] = index;
                        p++;
                    }
                }
            }
        }

        return sortedIntervals;
    }

    public static void markOccupied(boolean[] schedule, int start, int end) {
        Arrays.fill(schedule, start, end, true);
    }
}