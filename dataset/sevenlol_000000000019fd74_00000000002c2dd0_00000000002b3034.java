import java.io.*;
import java.util.*;

/**
 * Solution
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        try {
            solve(sc);
        } finally {
            sc.close();
        }
    }

    private static void solve(Scanner sc) {
        int T = Integer.parseInt(sc.nextLine());

        // System.out.println(T);

        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(sc.nextLine().trim());
            String[] ptns = new String[N];
            for (int j = 0; j < N; j++) {
                ptns[j] = sc.nextLine().trim();
            }
            // System.out.println(N + "," + Arrays.toString(ptns));
            solve(i, N, ptns);
        }
    }

    private static void solve(int T, int N, String[] ptns) {
        System.out.printf("Case #%d: ", T);

        String[] l = new String[N];
        String[] r = new String[N];
        int lmax = 0, rmax = 0, lmin = 1000000, rmin = 1000000;
        for (int i = 0; i < N; i++) {
            int idx = ptns[i].indexOf('*');
            l[i] = ptns[i].substring(0, idx);
            r[i] = ptns[i].substring(idx + 1);
            lmax = Math.max(lmax, l[i].length());
            rmax = Math.max(rmax, r[i].length());
            lmin = Math.min(lmin, l[i].length());
            rmin = Math.min(rmin, r[i].length());
        }

        String prefix = "";
        for (int i = 0; i < lmax; i++) {
            Character c = null;
            for (String ls : l) {
                if (i >= ls.length()) {
                    continue;
                }

                if (c == null) {
                    c = ls.charAt(i);
                } else if (!c.equals(ls.charAt(i))) {
                    System.out.println("*");
                    return;
                }
            }
            for (String ss : l) {
                if (ss.length() == lmax) {
                    prefix = ss;
                }
            }
        }

        String suffix = "";
        for (int i = 0; i < rmax; i++) {
            Character c = null;
            for (String rs : r) {
                if (i >= rs.length()) {
                    continue;
                }

                if (c == null) {
                    c = rs.charAt(rs.length() - i - 1);
                } else if (!c.equals(rs.charAt(rs.length() - i - 1))) {
                    System.out.println("*");
                    return;
                }
            }
            for (String ss : r) {
                if (ss.length() == rmax) {
                    suffix = ss;
                }
            }
        }

        // int i = Math.min(lmax - lmin, rmax - rmin);
        // while (i > 0) {
        //     if (prefix.substring(lmax - i).equals(suffix.substring(0, i))) {
        //         break;
        //     } else {
        //         i--;
        //     }
        // }

        // System.out.println(Arrays.toString(l));
        // System.out.format("lmax=%d,lmin=%d,rmax=%d,rmin=%d\n", lmax, lmin, rmax, rmin);
        // System.out.println(i);
        // System.out.println(prefix + "," + suffix);
        String res = prefix + suffix;
        System.out.println(res);
    }
}