import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

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

        // Initialize character count array
        Arrays.fill(charCount, 0);

        // Count occurrences of the first character in each query response
        for (int i = 0; i < 10000; i++) {
            char c = queries[i].r.charAt(0);
            charCount[c - 'A']++;
        }

        // Determine the characters for positions 1 to 9
        for (int k = 1; k <= 9; k++) {
            int maxIndex = -1;
            int maxValue = -1;
            for (int j = 0; j < 26; j++) {
                if (charCount[j] > maxValue) {
                    maxValue = charCount[j];
                    maxIndex = j;
                }
            }
            D[k] = (char) ('A' + maxIndex);
            charCount[maxIndex] = 0;
        }

        String res = new String(D);
        boolean[] usedChars = new boolean[256];

        for (char c : res.toCharArray()) {
            usedChars[c] = true;
        }

        // Determine the character for position 0
        for (int i = 0; i < 10000; i++) {
            char c = queries[i].r.charAt(queries[i].r.length() - 1);
            if (!usedChars[c]) {
                D[0] = c;
                return new String(D);
            }
        }

        return new String(D);
    }

    public static final int DEBUG_TEST_CASE = 0;
    public static final boolean SIMULATE_TEST_CASES = false;

    public static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        int tmax;

        if (!SIMULATE_TEST_CASES) {
            tmax = in.nextInt();
            for (int t = 1; t <= tmax; ++t) {
                U = in.nextInt();
                queries = new Query[10000];
                for (int i = 0; i < 10000; i++) {
                    queries[i] = new Query();
                    queries[i].m = in.nextInt();
                    queries[i].r = in.next();
                }

                Arrays.sort(queries, Comparator.comparing(Query::getM));

                if (DEBUG_TEST_CASE <= 0 || t == DEBUG_TEST_CASE) {
                    String res = solve();
                    System.out.println("Case #" + t + ": " + res);
                }
            }
        } else {
            simulateTestCases();
        }
    }

    private static void simulateTestCases() {
        U = 1000;
        queries = new Query[10000];
        String d = "ABCDEFGHIJ";

        for (int t = 1; t <= 1000; ++t) {
            for (int i = 0; i < 10000; i++) {
                int m = (int) Math.ceil(100.0 * Math.random());
                String r = "" + (int) Math.ceil(m * Math.random());

                for (int k = 0; k <= 9; k++) {
                    r = r.replace((char) ('0' + k), d.charAt(k));
                }

                queries[i] = new Query();
                queries[i].m = m;
                queries[i].r = r;
            }

            Arrays.sort(queries, Comparator.comparing(Query::getM));

            String res = solve();
            assert res.equals(d);
        }
    }
}