import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

    public Solution() {}

    public static int U;
    public static Query[] queries;

    public static class Query {
        public long m;
        public String r;

        public long getM() {
            return m;
        }
    }

    public static String solve() {
        char[] D = new char[10];
        int[] charCount = new int[26];

        // Determine 0
        Arrays.fill(charCount, 0);

        for (int i = 0; i < 10000; i++) {
            Query q = queries[i];
            if (q.r.length() > 1) {
                char c = q.r.charAt(q.r.length() - 1);
                charCount[c - 'A']++;
            }
        }

        int maxJ = -1;
        int maxVal = -1;
        for (int j = 0; j < 26; j++) {
            if (charCount[j] > maxVal) {
                maxVal = charCount[j];
                maxJ = j;
            }
        }
        D[0] = (char) ('A' + maxJ);

        Arrays.fill(charCount, 0);

        for (int i = 0; i < 10000; i++) {
            Query q = queries[i];
            char c = q.r.charAt(0);
            charCount[c - 'A']++;
        }

        for (int k = 1; k <= 9; k++) {
            maxJ = -1;
            maxVal = -1;
            for (int j = 0; j < 26; j++) {
                if (charCount[j] > maxVal) {
                    maxVal = charCount[j];
                    maxJ = j;
                }
            }
            D[k] = (char) ('A' + maxJ);
            charCount[maxJ] = 0;
        }

        return new String(D);
    }

    public static int DEBUG_TEST_CASE = 0;
    public static boolean SIMULATE_TEST_CASES = false;

    public static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        int tmax;

        if (!SIMULATE_TEST_CASES) {
            tmax = in.nextInt();
            for (int t = 1; t <= tmax; ++t) {
                U = in.nextInt();
                queries = new Query[10000];
                for (int i = 0; i < 10000; i++) {
                    Query q = new Query();
                    q.m = in.nextInt();
                    q.r = in.next();
                    queries[i] = q;
                }

                Arrays.sort(queries, Comparator.comparing(Query::getM));

                if ((DEBUG_TEST_CASE <= 0) || (t == DEBUG_TEST_CASE)) {
                    String res = solve();
                    System.out.println("Case #" + t + ": " + res);
                }
            }
        } else {
            // Simulating test cases
            /*
            tmax = 10000000;
            for (int t = 1; t <= tmax; ++t) {
                N = ""+(long)Math.ceil(Math.random() * 100000 + 1);

                State res = solve();

                System.out.println("Case #"+t+": "+N+" "+res.a+" "+res.b);

                assert !res.a.startsWith("0");
                assert !res.b.startsWith("0");
                assert !res.a.contains("4");
                assert !res.b.contains("4");
                assert Long.parseLong(res.a) + Long.parseLong(res.b) == Long.parseLong(N);
            }
            */
        }
    }
}