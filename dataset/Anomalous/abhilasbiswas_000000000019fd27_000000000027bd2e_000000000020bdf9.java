import java.util.*;
import java.io.*;

public class Solution {
    private static boolean[] c = new boolean[1441];
    private static boolean[] j = new boolean[1441];
    private static boolean[] flag = new boolean[1441];
    private static boolean[] shadow = new boolean[1441];
    private static int[] n = new int[1441];
    private static int[] ns = new int[1441];
    private static int[][] h;

    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = input.nextInt();
        for (int i = 1; i <= T; i++) {
            String result = test(input);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    public static String test(Scanner input) {
        Arrays.fill(c, false);
        Arrays.fill(j, false);

        int n = input.nextInt();
        int[][] intervals = new int[n][2];
        char[] result = new char[n];

        for (int i = 0; i < n; i++) {
            intervals[i][0] = input.nextInt();
            intervals[i][1] = input.nextInt();
        }

        intervals = sort(intervals);
        if (intervals == null) return "IMPOSSIBLE";

        for (int i = 0; i < n; i++) {
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

    public static String rearrange(char[] t) {
        char[] r = new char[t.length];
        for (int[] p : h) {
            r[p[0]] = t[p[1]];
        }
        return new String(r);
    }

    public static int[][] sort(int[][] w) {
        Arrays.fill(flag, false);
        Arrays.fill(shadow, false);

        int l = w.length;
        int[][] wn = new int[l][2];
        h = new int[l][2];

        for (int i = 0; i < l; i++) {
            int index = w[i][0];
            if (!flag[index]) {
                n[index] = i;
                flag[index] = true;
            } else if (!shadow[index]) {
                ns[index] = i;
                shadow[index] = true;
            } else {
                return null;
            }
        }

        int p = 0;
        for (int i = 0; i < 1441; i++) {
            if (flag[i]) {
                int index = n[i];
                wn[p] = w[index];
                h[p][0] = p;
                h[p][1] = index;
                p++;
                if (shadow[i]) {
                    index = ns[i];
                    wn[p] = w[index];
                    h[p][0] = p;
                    h[p][1] = index;
                    p++;
                }
            }
        }

        return wn;
    }

    public static void fill(boolean[] p, int a, int b) {
        Arrays.fill(p, a, b, true);
    }
}