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
        int n = input.nextInt();
        int[][] intervals = new int[n][2];
        char[] result = new char[n];
        int x = 0;

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
                fill(c, start, end);
                result[x++] = 'C';
            } else if (!j[start]) {
                fill(j, start, end);
                result[x++] = 'J';
            } else {
                return "IMPOSSIBLE";
            }
        }

        return rearrangeResult(result);
    }

    private static boolean[] flag = new boolean[1441];
    private static boolean[] shadow = new boolean[1441];
    private static boolean[] ss = new boolean[1441];
    private static int[] n = new int[1441];
    private static int[] ns = new int[1441];
    private static int[] nss = new int[1441];
    private static int[][] h;

    private static String rearrangeResult(char[] result) {
        char[] rearranged = new char[result.length];
        for (int[] p : h) {
            rearranged[p[0]] = result[p[1]];
        }
        return new String(rearranged);
    }

    private static int[][] sortIntervals(int[][] intervals) {
        int l = intervals.length;
        int[][] sortedIntervals = new int[l][2];
        h = new int[l][2];
        Arrays.fill(flag, false);
        Arrays.fill(shadow, false);
        Arrays.fill(ss, false);

        for (int i = 0; i < l; i++) {
            int index = intervals[i][0];
            if (!flag[index]) {
                n[index] = i;
                flag[index] = true;
            } else if (!shadow[index]) {
                ns[index] = i;
                shadow[index] = true;
            } else if (!ss[index]) {
                nss[index] = i;
                ss[index] = true;
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

    private static void fill(boolean[] p, int a, int b) {
        Arrays.fill(p, a, b, true);
    }
}