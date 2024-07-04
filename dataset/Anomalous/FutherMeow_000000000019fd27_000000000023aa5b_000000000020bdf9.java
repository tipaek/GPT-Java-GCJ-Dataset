import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

    private static final int TIME_SLOT = 1441;
    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    private static void solve() throws Exception {
        ArrayList<short[]> cTimes = new ArrayList<>(TIME_SLOT);
        ArrayList<short[]> jTimes = new ArrayList<>(TIME_SLOT);

        int n = scanInt();
        StringBuilder result = new StringBuilder();
        boolean isImpossible = false;

        for (int i = 0; i < n; i++) {
            short start = scanInt();
            short end = scanInt();

            if (jTimes.size() > cTimes.size()) {
                if (addTimeSlot(start, end, cTimes)) {
                    result.append("C");
                } else if (addTimeSlot(start, end, jTimes)) {
                    result.append("J");
                } else {
                    isImpossible = true;
                    break;
                }
            } else {
                if (addTimeSlot(start, end, jTimes)) {
                    result.append("J");
                } else if (addTimeSlot(start, end, cTimes)) {
                    result.append("C");
                } else {
                    isImpossible = true;
                    break;
                }
            }
        }

        if (isImpossible) {
            printCase(IMPOSSIBLE);
        } else {
            printCase(result.toString());
        }
    }

    private static boolean addTimeSlot(short start, short end, ArrayList<short[]> timeSlots) {
        for (short[] time : timeSlots) {
            if (isContained(time, start) || isContained(time, end)) {
                return false;
            }
        }
        timeSlots.add(new short[]{start, end});
        return true;
    }

    private static boolean isContained(short[] time, short value) {
        return time[0] < value && time[1] > value;
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

    private static void printCase(String result) {
        output.println("Case #" + testCase + ": " + result);
    }

    private static BufferedReader reader;
    private static PrintWriter output;
    private static StringTokenizer tokenizer;
    private static int testCase;

    public static void main(String[] args) {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            output = new PrintWriter(System.out);
            int numberOfTests = scanInt();
            for (testCase = 1; testCase <= numberOfTests; testCase++) {
                solve();
            }
            reader.close();
            output.close();
        } catch (Throwable e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}