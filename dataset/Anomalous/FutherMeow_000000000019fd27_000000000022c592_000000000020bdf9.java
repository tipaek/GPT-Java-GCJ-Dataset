import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

    static final int TIME_SLOT = 1441;
    static final String IMPOSSIBLE = "IMPOSSIBLE";

    static class Time {
        int start;
        int end;

        Time(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static void solve() throws IOException {
        boolean[] cTime = new boolean[TIME_SLOT];
        boolean[] jTime = new boolean[TIME_SLOT];

        int n = scanInt();
        StringBuilder result = new StringBuilder();
        boolean isPossible = true;

        for (int i = 0; i < n; i++) {
            int start = scanInt();
            int end = scanInt();
            Time time = new Time(start, end);

            if (isBusy(time, cTime)) {
                if (isBusy(time, jTime)) {
                    isPossible = false;
                    break;
                } else {
                    markBusy(time, jTime);
                    result.append("J");
                }
            } else {
                markBusy(time, cTime);
                result.append("C");
            }
        }

        if (!isPossible) {
            printResult(IMPOSSIBLE);
        } else {
            printResult(result.toString());
        }
    }

    static boolean isBusy(Time time, boolean[] timeSlot) {
        for (int i = time.start; i < time.end; i++) {
            if (timeSlot[i]) {
                return true;
            }
        }
        return false;
    }

    static void markBusy(Time time, boolean[] timeSlot) {
        for (int i = time.start; i < time.end; i++) {
            timeSlot[i] = true;
        }
    }

    static int scanInt() throws IOException {
        return Integer.parseInt(scanString());
    }

    static String scanString() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    static void printResult(String result) {
        writer.println("Case #" + testCase + ": " + result);
    }

    static BufferedReader reader;
    static PrintWriter writer;
    static StringTokenizer tokenizer;
    static int testCase;

    public static void main(String[] args) {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            writer = new PrintWriter(System.out);
            int testCases = scanInt();

            for (testCase = 1; testCase <= testCases; testCase++) {
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