package p3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

    private static final int TIME_SLOTS = 1441;
    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    public static class TimeInterval {
        int start;
        int end;

        public TimeInterval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private static void solve() throws Exception {
        boolean[] cSchedule = new boolean[TIME_SLOTS];
        boolean[] jSchedule = new boolean[TIME_SLOTS];

        int n = nextInt();
        StringBuilder result = new StringBuilder();
        boolean isPossible = true;

        for (int i = 0; i < n; i++) {
            int start = nextInt();
            int end = nextInt();
            TimeInterval interval = new TimeInterval(start, end);

            if (isBusy(interval, cSchedule)) {
                if (isBusy(interval, jSchedule)) {
                    isPossible = false;
                    break;
                } else {
                    markBusy(interval, jSchedule);
                    result.append("J");
                }
            } else {
                markBusy(interval, cSchedule);
                result.append("C");
            }
        }

        if (!isPossible) {
            printResult(IMPOSSIBLE);
        } else {
            printResult(result.toString());
        }
    }

    private static boolean isBusy(TimeInterval interval, boolean[] schedule) {
        for (int i = interval.start; i < interval.end; i++) {
            if (schedule[i]) {
                return true;
            }
        }
        return false;
    }

    private static void markBusy(TimeInterval interval, boolean[] schedule) {
        for (int i = interval.start; i < interval.end; i++) {
            schedule[i] = true;
        }
    }

    private static int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    private static String nextToken() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    private static void printResult(String result) {
        out.println("Case #" + testCase + ": " + result);
    }

    private static BufferedReader reader;
    private static PrintWriter out;
    private static StringTokenizer tokenizer;
    private static int testCase;

    public static void main(String[] args) {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            int testCases = nextInt();
            for (testCase = 1; testCase <= testCases; testCase++) {
                solve();
            }
            reader.close();
            out.close();
        } catch (Throwable e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}