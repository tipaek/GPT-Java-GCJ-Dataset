import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {

    private static final int TIME_SLOT = 1441;
    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    private static String createTimeSlot(int start, int end) {
        return start + ":" + end;
    }

    private static void solve() throws IOException {
        HashSet<String> cTimeSlots = new HashSet<>();
        HashSet<String> jTimeSlots = new HashSet<>();
        cTimeSlots.add(createTimeSlot(0, TIME_SLOT));
        jTimeSlots.add(createTimeSlot(0, TIME_SLOT));

        int n = scanInt();
        StringBuilder result = new StringBuilder();
        boolean isPossible = true;

        for (int i = 0; i < n; i++) {
            int start = scanInt();
            int end = scanInt();

            if (isFree(start, end, cTimeSlots)) {
                result.append("C");
            } else if (isFree(start, end, jTimeSlots)) {
                result.append("J");
            } else {
                isPossible = false;
                break;
            }
        }

        if (!isPossible) {
            printResult(IMPOSSIBLE);
        } else {
            printResult(result.toString());
        }
    }

    private static boolean isFree(int start, int end, HashSet<String> timeSlots) {
        for (String freeTime : timeSlots) {
            String[] free = freeTime.split(":");
            int freeStart = Integer.parseInt(free[0]);
            int freeEnd = Integer.parseInt(free[1]);

            if (freeStart <= start && freeEnd >= end) {
                timeSlots.remove(freeTime);
                markBusy(start, end, timeSlots, freeStart, freeEnd);
                return true;
            }
        }
        return false;
    }

    private static void markBusy(int start, int end, HashSet<String> timeSlots, int freeStart, int freeEnd) {
        if (freeStart < start) {
            timeSlots.add(createTimeSlot(freeStart, start));
        }
        if (freeEnd > end) {
            timeSlots.add(createTimeSlot(end, freeEnd));
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
        writer.println("Case #" + testCaseNumber + ": " + result);
    }

    private static BufferedReader reader;
    private static PrintWriter writer;
    private static StringTokenizer tokenizer;
    private static int testCaseNumber;

    public static void main(String[] args) {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            writer = new PrintWriter(System.out);
            int testCases = scanInt();
            for (testCaseNumber = 1; testCaseNumber <= testCases; testCaseNumber++) {
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