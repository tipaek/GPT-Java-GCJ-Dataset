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

    private static void solve() throws IOException {
        boolean[] cBusy = new boolean[TIME_SLOTS];
        boolean[] jBusy = new boolean[TIME_SLOTS];
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
            printResult(IMPOSSIBLE);
        } else {
            printResult(result.toString());
        }
    }

    private static boolean isBusy(TimeInterval interval, boolean[] busySlots) {
        for (int i = interval.start; i < interval.end; i++) {
            if (busySlots[i]) {
                return true;
            }
        }
        return false;
    }

    private static void markBusy(TimeInterval interval, boolean[] busySlots) {
        for (int i = interval.start; i < interval.end; i++) {
            busySlots[i] = true;
        }
    }

    private static int scanInt() throws IOException {
        return Integer.parseInt(scanString());
    }

    private static String scanString() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    private static void printResult(String result) {
        writer.println("Case #" + currentTest + ": " + result);
    }

    private static BufferedReader reader;
    private static PrintWriter writer;
    private static StringTokenizer tokenizer;
    private static int currentTest;

    public static void main(String[] args) {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            writer = new PrintWriter(System.out);
            int testCases = scanInt();
            for (currentTest = 1; currentTest <= testCases; currentTest++) {
                solve();
            }
            reader.close();
            writer.close();
        } catch (Throwable e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}