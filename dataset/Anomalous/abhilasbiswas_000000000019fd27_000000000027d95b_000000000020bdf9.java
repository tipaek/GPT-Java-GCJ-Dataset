import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = input.nextInt();
        for (int i = 1; i <= T; i++) {
            String result = test(input);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    public static String test(Scanner input) {
        boolean[] c = new boolean[1441];
        boolean[] j = new boolean[1441];
        char[] result = new char[input.nextInt()];
        int[][] intervals = new int[result.length][2];

        for (int i = 0; i < intervals.length; i++) {
            intervals[i][0] = input.nextInt();
            intervals[i][1] = input.nextInt();
        }

        intervals = sort(intervals);
        if (intervals == null) return "IMPOSSIBLE";

        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (!c[start]) {
                fill(c, start, end);
                result[i] = 'C';
            } else if (!j[start]) {
                fill(j, start, end);
                result[i] = 'J';
            } else {
                return "IMPOSSIBLE";
            }
        }

        return rearrange(result);
    }

    static boolean[] flag;
    static boolean[] shadow;
    static boolean[] ss;
    static int[] n;
    static int[] ns;
    static int[] nss;
    static int[][] h;

    public static String rearrange(char[] t) {
        char[] r = new char[t.length];
        for (int[] p : h) {
            r[p[0]] = t[p[1]];
        }
        return new String(r);
    }

    public static int[][] sort(int[][] intervals) {
        flag = new boolean[1441];
        shadow = new boolean[1441];
        ss = new boolean[1441];
        n = new int[1441];
        ns = new int[1441];
        nss = new int[1441];
        int l = intervals.length;
        int[][] sortedIntervals = new int[l][2];
        h = new int[l][2];

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
                sortedIntervals[p] = intervals[n[i]];
                h[p][0] = p;
                h[p][1] = n[i];
                p++;
                if (shadow[i]) {
                    sortedIntervals[p] = intervals[ns[i]];
                    h[p][0] = p;
                    h[p][1] = ns[i];
                    p++;
                    if (ss[i]) {
                        sortedIntervals[p] = intervals[nss[i]];
                        h[p][0] = p;
                        h[p][1] = nss[i];
                        p++;
                    }
                }
            }
        }

        return sortedIntervals;
    }

    public static boolean fill(boolean[] p, int a, int b) {
        Arrays.fill(p, a, b, true);
        return true;
    }
}