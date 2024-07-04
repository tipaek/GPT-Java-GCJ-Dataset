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
        char[] digits = new char[10];
        int[] charCount = new int[26];

        // Determine the character for 0
        Arrays.fill(charCount, 0);
        for (int i = 0; i < 10000; i++) {
            Query query = queries[i];
            if (query.r.length() > 1) {
                char c = query.r.charAt(query.r.length() - 1);
                charCount[c - 'A']++;
            }
        }

        int maxIndex = -1;
        int maxValue = -1;
        for (int j = 0; j < 26; j++) {
            if (charCount[j] > maxValue) {
                maxValue = charCount[j];
                maxIndex = j;
            }
        }
        digits[0] = (char) ('A' + maxIndex);

        Arrays.fill(charCount, 0);
        for (int i = 0; i < 10000; i++) {
            Query query = queries[i];
            for (int j = 0; j < query.r.length(); j++) {
                char c = query.r.charAt(j);
                charCount[c - 'A']++;
            }
        }

        for (int k = 1; k <= 9; k++) {
            maxIndex = -1;
            maxValue = -1;
            for (int j = 0; j < 26; j++) {
                if (charCount[j] > maxValue) {
                    maxValue = charCount[j];
                    maxIndex = j;
                }
            }
            digits[k] = (char) ('A' + maxIndex);
            charCount[maxIndex] = 0;
        }

        return new String(digits);
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
                    Query query = new Query();
                    query.m = in.nextInt();
                    query.r = in.next();
                    queries[i] = query;
                }

                Arrays.sort(queries, Comparator.comparing(Query::getM));

                if ((DEBUG_TEST_CASE <= 0) || (t == DEBUG_TEST_CASE)) {
                    String result = solve();
                    System.out.println("Case #" + t + ": " + result);
                }
            }
        } else {
            // Simulating test cases
            /*
            tmax = 10000000;
            for (int t = 1; t <= tmax; ++t) {
                N = "" + (long) Math.ceil(Math.random() * 100000 + 1);
                State result = solve();
                System.out.println("Case #" + t + ": " + N + " " + result.a + " " + result.b);
                assert !result.a.startsWith("0");
                assert !result.b.startsWith("0");
                assert !result.a.contains("4");
                assert !result.b.contains("4");
                assert Long.parseLong(result.a) + Long.parseLong(result.b) == Long.parseLong(N);
            }
            */
        }
    }
}