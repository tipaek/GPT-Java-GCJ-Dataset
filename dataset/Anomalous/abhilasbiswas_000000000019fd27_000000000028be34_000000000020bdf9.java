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
        int n = input.nextInt();
        int[][] w = new int[n][2];
        char[] result = new char[n];

        for (int i = 0; i < n; i++) {
            w[i][0] = input.nextInt();
            w[i][1] = input.nextInt();
        }

        w = sort(w);
        if (w == null) return "IMPOSSIBLE";

        int ct = 0, jt = 0;
        for (int i = 0; i < n; i++) {
            int t1 = w[i][0];
            int t2 = w[i][1];
            boolean cb = !c[t1];
            boolean jb = !j[t1];
            int nc = t1 - ct;
            int nj = t1 - jt;

            if ((cb && !jb) || (cb && jb && nc > nj)) {
                ct = t2;
                fill(c, t1, t2);
                result[i] = 'C';
            } else if ((jb && !cb) || (cb && jb && nj > nc)) {
                jt = t2;
                fill(j, t1, t2);
                result[i] = 'J';
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
        int l = w.length;
        int[][] wn = new int[l][2];
        h = new int[l][2];
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < l; i++) {
            map.computeIfAbsent(w[i][0], k -> new ArrayList<>()).add(i);
        }

        int p = 0;
        for (int i = 0; i < 1441; i++) {
            if (map.containsKey(i)) {
                for (int index : map.get(i)) {
                    wn[p] = w[index];
                    h[p][0] = p;
                    h[p][1] = index;
                    p++;
                }
            }
        }

        return p == l ? wn : null;
    }

    public static void fill(boolean[] p, int a, int b) {
        Arrays.fill(p, a, b, true);
    }
}