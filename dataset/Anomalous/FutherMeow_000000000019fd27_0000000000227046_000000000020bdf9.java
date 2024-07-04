import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

    static final int MAX_TIME_SLOT = 1441;
    static final String IMPOSSIBLE = "IMPOSSIBLE";

    public static class TimeSlot {
        int start;
        int end;

        public TimeSlot(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static void solve() throws Exception {
        boolean[] cTimeSlots = new boolean[MAX_TIME_SLOT];
        boolean[] jTimeSlots = new boolean[MAX_TIME_SLOT];

        int n = scanInt();
        StringBuilder result = new StringBuilder();
        boolean isPossible = true;

        for (int i = 0; i < n; i++) {
            int start = scanInt();
            int end = scanInt();
            TimeSlot timeSlot = new TimeSlot(start, end);

            if (isTimeSlotBusy(timeSlot, cTimeSlots)) {
                if (isTimeSlotBusy(timeSlot, jTimeSlots)) {
                    isPossible = false;
                    break;
                } else {
                    markTimeSlotBusy(timeSlot, jTimeSlots);
                    result.append("J");
                }
            } else {
                markTimeSlotBusy(timeSlot, cTimeSlots);
                result.append("C");
            }
        }

        if (!isPossible) {
            printResult(IMPOSSIBLE);
        } else {
            printResult(result.toString());
        }
    }

    static boolean isTimeSlotBusy(TimeSlot timeSlot, boolean[] timeSlots) {
        for (int i = timeSlot.start; i < timeSlot.end; i++) {
            if (timeSlots[i]) {
                return true;
            }
        }
        return false;
    }

    static void markTimeSlotBusy(TimeSlot timeSlot, boolean[] timeSlots) {
        for (int i = timeSlot.start; i < timeSlot.end; i++) {
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
        out.println("Case #" + testCaseNumber + ": " + result);
    }

    static BufferedReader reader;
    static PrintWriter out;
    static StringTokenizer tokenizer;
    static int testCaseNumber;

    public static void main(String[] args) {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            int testCases = scanInt();
            for (testCaseNumber = 1; testCaseNumber <= testCases; testCaseNumber++) {
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