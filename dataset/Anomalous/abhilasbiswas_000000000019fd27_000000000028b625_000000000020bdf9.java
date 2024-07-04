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
        char[] result;
        int x = 0;

        int n = input.nextInt();
        int[][] w = new int[n][2];
        result = new char[n];

        for (int i = 0; i < n; i++) {
            w[i][0] = input.nextInt();
            w[i][1] = input.nextInt();
        }

        w = sort(w);

        if (w == null) {
            return "IMPOSSIBLE";
        }

        int ct = 0, jt = 0;

        for (int i = 0; i < n; i++) {
            int t1 = w[i][0];
            int t2 = w[i][1];

            if (!c[t1]) {
                ct = t2;
                fill(c, t1, t2);
                result[x++] = 'C';
            } else if (!j[t1]) {
                jt = t2;
                fill(j, t1, t2);
                result[x++] = 'J';
            } else {
                return "IMPOSSIBLE";
            }
        }

        return rearrange(result);
    }

    static int[][] h;

    public static String rearrange(char[] t) {
        char[] r = new char[t.length];

        for (int[] p : h) {
            r[p[0]] = t[p[1]];
        }

        return new String(r);
    }

    public static int[][] sort(int[][] w) {
        boolean[] flag = new boolean[1441];
        boolean[] shadow = new boolean[1441];
        boolean[] ss = new boolean[1441];
        int[] n = new int[1441];
        int[] ns = new int[1441];
        int[] nss = new int[1441];

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
                    if (ss[i]) {
                        index = nss[i];
                        wn[p] = w[index];
                        h[p][0] = p;
                        h[p][1] = index;
                        p++;
                    }
                }
            }
        }

        return wn;
    }

    public static void fill(boolean[] p, int a, int b) {
        Arrays.fill(p, a, b, true);
    }
}