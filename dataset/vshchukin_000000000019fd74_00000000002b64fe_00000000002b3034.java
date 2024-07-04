import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        PatternMatching solver = new PatternMatching();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class PatternMatching {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int numPatt = in.nextInt();
            String[] arr = new String[numPatt];
            Arrays.setAll(arr, i -> in.next());
            String[] pref = new String[numPatt];
            String[] suff = new String[numPatt];
            int[] st = new int[numPatt];
            int[] en = new int[numPatt];
            for (int i = 0; i < numPatt; i++) {
                st[i] = arr[i].indexOf('*');
                en[i] = arr[i].lastIndexOf('*') + 1;
                pref[i] = arr[i].substring(0, st[i]);
                suff[i] = arr[i].substring(en[i]);
            }
            Arrays.sort(pref, Comparator.comparingInt(String::length));
            Arrays.sort(suff, Comparator.comparingInt(String::length));
            boolean ok = true;
            for (int i = 1; i < numPatt; i++) {
                if (!pref[i].startsWith(pref[i - 1])) {
                    ok = false;
                    break;
                }
                if (!suff[i].endsWith(suff[i - 1])) {
                    ok = false;
                    break;
                }
            }
            if (!ok) {
                out.printf("Case #%d: *\n", testNumber);
            } else {
                String lp = pref[numPatt - 1];
                String ls = suff[numPatt - 1];
                StringBuilder res = new StringBuilder();
                res.append(lp);

                for (int i = 0; i < numPatt; i++) {
                    for (int j = st[i]; j < en[i]; j++) {
                        if (arr[i].charAt(j) != '*') {
                            res.append(arr[i].charAt(j));
                        }
                    }
                }
                res.append(ls);
                out.printf("Case #%d: %s\n", testNumber, res.toString());
            }

        }

    }
}

