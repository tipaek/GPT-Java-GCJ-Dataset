import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    private static final int TIME_SLOT = 1441;
    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    private static void solve() throws IOException {
        ArrayList<short[]> cTime = new ArrayList<>(TIME_SLOT);
        ArrayList<short[]> jTime = new ArrayList<>(TIME_SLOT);

        int n = scanInt();
        StringBuilder result = new StringBuilder();
        boolean isImpossible = false;

        for (int i = 0; i < n; i++) {
            short start = scanInt();
            short end = scanInt();

            if (jTime.size() > cTime.size()) {
                if (addTimeSlot(start, end, cTime)) {
                    result.append("C");
                } else if (addTimeSlot(start, end, jTime)) {
                    result.append("J");
                } else {
                    isImpossible = true;
                    break;
                }
            } else {
                if (addTimeSlot(start, end, jTime)) {
                    result.append("J");
                } else if (addTimeSlot(start, end, cTime)) {
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
        for (short[] time : timeSlots) {
            if (isTimeOverlapping(time, start) || isTimeOverlapping(time, end)) {
                return false;
            }
        }

        timeSlots.add(new short[]{start, end});
        return true;
    }

    private static boolean isTimeOverlapping(short[] time, short value) {
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

    private static void printResult(String result) {
        writer.println("Case #" + testCase + ": " + result);
    }

    private static BufferedReader reader;
    private static PrintWriter writer;
    private static StringTokenizer tokenizer;
    private static int testCase;

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