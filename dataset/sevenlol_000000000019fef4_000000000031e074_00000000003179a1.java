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
        int T = sc.nextInt();

        int n = 10000;
        for (int i = 1; i <= T; i++) {
            int q = sc.nextInt();

            String[] vs = new String[n];
            String[] rs = new String[n];
            for (int j = 0; j < n; j++) {
                vs[j] = sc.next();
                rs[j] = sc.next();
                // System.out.println(vs[j] + "," + rs[j]);
            }
            solve(i, q, vs, rs);
        }
    }

    private static void solve(int T, int q, String[] vs, String[] rs) {
        System.out.format("Case #%d: ", T);
        int n = vs.length;

        Set<Character> cs = new HashSet<>();
        Set<Character> nz = new HashSet<>();
        @SuppressWarnings("unchecked")
        Set<Character>[] pcs = (Set<Character>[]) new Set[10];
        for (int i = 0; i < 10; i++) {
            pcs[i] = new HashSet<>();
        }
        for (int i = 0; i < n; i++) {
            String v = vs[i];
            String r = rs[i];
            for (int j = 0; j < r.length(); j++) {
                if (j == 0) {
                    nz.add(r.charAt(j));
                }
                cs.add(r.charAt(j));
            }
            if (v.length() == r.length()) {
                // System.out.println("XXX: " + v + "," + r + " === " + (v.charAt(0) - '0') + ", r=" + r.charAt(0));
                for (int j = v.charAt(0) - '0'; j <= 9; j++) {
                    pcs[j].add(r.charAt(0));
                }
            }
        }

        // System.out.println("cs: " + cs);
        // System.out.println("nz: " + nz);
        // for (int i = 1; i <= 9; i++) {
        //     System.out.println(pcs[i]);
        // }
        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 1; i--) {
            char r = '#';
            for (char c : pcs[i]) {
                boolean found = true;
                for (int j = i - 1; j >= 1; j--) {
                    if (pcs[j].contains(c)) {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    r = c;
                    for (int j = i - 1; j >= 1; j--) pcs[j].remove(r);
                    break;
                }
            }
            sb.append(r);
        }

        // 0
        for (char c : cs) {
            if (!nz.contains(c)) {
                sb.append(c);
                break;
            }
        }
        System.out.println(sb.reverse().toString());
    }
}