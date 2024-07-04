import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

    static final int TIME_SLOT = 1441;
    static final String IMPOSSIBLE = "IMPOSSIBLE";

    static void solve() throws Exception {
        ArrayList<int[]> cTimeSlots = new ArrayList<>(TIME_SLOT);
        ArrayList<int[]> jTimeSlots = new ArrayList<>(TIME_SLOT);

        int n = scanInt();
        StringBuilder result = new StringBuilder();
        boolean isImpossible = false;

        for (int i = 0; i < n; i++) {
            int[] interval = scanArray();
            int start = interval[0];
            int end = interval[1];

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

    static boolean addTimeSlot(int start, int end, ArrayList<int[]> timeSlots) {
        for (int[] timeSlot : timeSlots) {
            if (isOverlapping(timeSlot, start, end)) {
                return false;
            }
        }
        timeSlots.add(new int[]{start, end});
        return true;
    }

    static boolean isOverlapping(int[] timeSlot, int start, int end) {
        return !(timeSlot[1] <= start || timeSlot[0] >= end);
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

    static int[] scanArray() throws IOException {
        int start = scanInt();
        int end = scanInt();
        return new int[]{start, end};
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
            System.exit(0);
        }
    }
}