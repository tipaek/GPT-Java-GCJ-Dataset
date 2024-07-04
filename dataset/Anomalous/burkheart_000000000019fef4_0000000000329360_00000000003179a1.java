import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

    public Solution() {}

    public static int U;
    public static Q[] queries;

    public static class Q {
        public long m;
        public String r;

        public long getM() {
            return m;
        }
    }

    public static String solve() {
        char[] D = new char[10];
        int[] charCount = new int[26];
        Arrays.fill(charCount, 0);

        for (int i = 0; i < 10000; i++) {
            char c = queries[i].r.charAt(0);
            charCount[c - 'A']++;
        }

        for (int k = 1; k <= 9; k++) {
            int maxJ = -1;
            int maxVal = -1;
            for (int j = 0; j < 26; j++) {
                if (charCount[j] > maxVal) {
                    maxVal = charCount[j];
                    maxJ = j;
                }
            }
            D[k] = (char) ('A' + maxJ);
            charCount[maxJ] = 0;
        }

        String res = new String(D);
        char[] x = new char[256];
        for (int j = 0; j < res.length(); j++) {
            x[res.charAt(j)] = 1;
        }

        for (int i = 0; i < 10000; i++) {
            for (int j = 1; j < queries[i].r.length(); j++) {
                char c = queries[i].r.charAt(j);
                if (x[c] == 0) {
                    D[0] = c;
                    return new String(D);
                }
            }
        }

        return new String(D);
    }

    public static final int DEBUG_TEST_CASE = 0;
    public static final boolean SIMULATE_TEST_CASES = false;

    public static final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        int tmax;

        if (!SIMULATE_TEST_CASES) {
            tmax = in.nextInt(); 
            for (int t = 1; t <= tmax; ++t) {
                U = in.nextInt();
                queries = new Q[10000];
                for (int i = 0; i < 10000; i++) {
                    Q q = new Q();
                    q.m = in.nextInt();
                    q.r = in.next();
                    queries[i] = q;
                }

                Arrays.sort(queries, Comparator.comparing(Q::getM));

                if ((DEBUG_TEST_CASE <= 0) || (t == DEBUG_TEST_CASE)) {
                    String res = solve();
                    System.out.println("Case #" + t + ": " + res);
                }
            }
        } else {
            simulateTestCases();
        }
    }

    private static void simulateTestCases() {
        U = 100;
        queries = new Q[10000];
        String d = "ABCDEFGHIJ";

        for (int t = 1; t <= 1000; ++t) {
            for (int i = 0; i < 10000; i++) {
                int m = (int) Math.ceil(100.0 * Math.random());
                String r = "" + (int) Math.ceil(m * Math.random());

                for (int k = 0; k <= 9; k++) {
                    r = r.replace((char) ('0' + k), d.charAt(k));
                }

                Q q = new Q();
                q.m = m;
                q.r = r;
                queries[i] = q;
            }

            Arrays.sort(queries, Comparator.comparing(Q::getM));
            String res = solve();
            assert res.equals(d);
        }
    }
}