import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

    private static final int TIME_SLOT_COUNT = 1441;
    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    private static void solve() throws Exception {
        ArrayList<short[]> cTimeSlots = new ArrayList<>(TIME_SLOT_COUNT);
        ArrayList<short[]> jTimeSlots = new ArrayList<>(TIME_SLOT_COUNT);

        int n = scanInt();
        StringBuilder result = new StringBuilder();
        boolean isImpossible = false;

        for (int i = 0; i < n; i++) {
            short start = scanInt();
            short end = scanInt();

            if (jTimeSlots.size() > cTimeSlots.size()) {
                if (addTimeSlot(start, end, cTimeSlots)) {
                    result.append("C");
                } else if (addTimeSlot(start, end, jTimeSlots)) {
                    result.append("J");
                } else {
                    isImpossible = true;
                    break;
                }
            } else {
                if (addTimeSlot(start, end, jTimeSlots)) {
                    result.append("J");
                } else if (addTimeSlot(start, end, cTimeSlots)) {
                    result.append("C");
                } else {
                    isImpossible = true;
                    break;
                }
            }
        }

        if (isImpossible) {
            printResult(IMPOSSIBLE);
        } else {
            printResult(result.toString());
        }
    }

    private static boolean addTimeSlot(short start, short end, ArrayList<short[]> timeSlots) {
        for (short[] timeSlot : timeSlots) {
            if (isTimeContained(timeSlot, start) || isTimeContained(timeSlot, end)) {
                return false;
            }
        }

        timeSlots.add(new short[]{start, end});
        return true;
    }

    private static boolean isTimeContained(short[] timeSlot, short time) {
        return timeSlot[0] < time && timeSlot[1] > time;
    }

    private static short scanInt() throws IOException {
        return Short.parseShort(scanString());
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