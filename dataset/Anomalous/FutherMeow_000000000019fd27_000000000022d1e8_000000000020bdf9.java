import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.exit;

public class Solution {

    static final int TIME_SLOT = 1440;
    static final String IMPOSSIBLE = "IMPOSSIBLE";

    public static class TimeInterval {
        int start;
        int end;

        public TimeInterval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static void solve() throws Exception {
        boolean[] cBusy = new boolean[TIME_SLOT];
        boolean[] jBusy = new boolean[TIME_SLOT];

        int n = scanInt();
        StringBuilder result = new StringBuilder();
        boolean isPossible = true;

        for (int i = 0; i < n; i++) {
            int start = scanInt();
            int end = scanInt();
            TimeInterval interval = new TimeInterval(start, end);

            if (isBusy(interval, cBusy)) {
                if (isBusy(interval, jBusy)) {
                    isPossible = false;
                    break;
                } else {
                    markBusy(interval, jBusy);
                    result.append("J");
                }
            } else {
                markBusy(interval, cBusy);
                result.append("C");
            }
        }

        if (!isPossible) {
            printCase(IMPOSSIBLE);
        } else {
            printCase(result.toString());
        }
    }

    static boolean isBusy(TimeInterval interval, boolean[] busySlots) {
        for (int i = interval.start; i < interval.end; i++) {
            if (busySlots[i]) {
                return true;
            }
        }
        return false;
    }

    static void markBusy(TimeInterval interval, boolean[] busySlots) {
        for (int i = interval.start; i < interval.end; i++) {
            busySlots[i] = true;
        }
    }

    static int scanInt() throws IOException {
        return parseInt(scanString());
    }

    static String scanString() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    static void printCase(String result) {
        writer.println("Case #" + testNumber + ": " + result);
    }

    static BufferedReader reader;
    static PrintWriter writer;
    static StringTokenizer tokenizer;
    static int testNumber;

    public static void main(String[] args) {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            writer = new PrintWriter(System.out);
            int testCases = scanInt();
            for (testNumber = 1; testNumber <= testCases; testNumber++) {
                solve();
            }
            reader.close();
            writer.close();
        } catch (Throwable e) {
            e.printStackTrace();
            exit(1);
        }
    }
}