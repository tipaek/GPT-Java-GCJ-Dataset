import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

    static final int TIME_SLOTS = 1440;
    static final String IMPOSSIBLE = "IMPOSSIBLE";

    public static class Time {
        int start;
        int end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static void solve() throws Exception {
        boolean[] cTimeSlots = new boolean[TIME_SLOTS];
        boolean[] jTimeSlots = new boolean[TIME_SLOTS];

        int n = scanInt();
        StringBuilder result = new StringBuilder();
        boolean isPossible = true;

        for (int i = 0; i < n; i++) {
            int start = scanInt();
            int end = scanInt();
            Time time = new Time(start, end);

            if (isBusy(time, cTimeSlots)) {
                if (isBusy(time, jTimeSlots)) {
                    isPossible = false;
                    break;
                } else {
                    markBusy(time, jTimeSlots);
                    result.append("J");
                }
            } else {
                markBusy(time, cTimeSlots);
                result.append("C");
            }
        }

        if (!isPossible) {
            printResult(IMPOSSIBLE);
        } else {
            printResult(result.toString());
        }
    }

    static boolean isBusy(Time time, boolean[] timeSlots) {
        for (int i = time.start; i < time.end; i++) {
            if (timeSlots[i]) {
                return true;
            }
        }
        return false;
    }

    static void markBusy(Time time, boolean[] timeSlots) {
        for (int i = time.start; i < time.end; i++) {
            timeSlots[i] = true;
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
            int totalTests = scanInt();
            for (testCase = 1; testCase <= totalTests; testCase++) {
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