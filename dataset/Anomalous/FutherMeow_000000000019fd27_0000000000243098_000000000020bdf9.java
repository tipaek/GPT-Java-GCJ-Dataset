import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.exit;

public class Solution {

    private static final int TIME_SLOT = 1441;
    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    private static void solve() throws IOException {
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

    private static boolean addTimeSlot(int start, int end, ArrayList<int[]> timeSlots) {
        for (int[] slot : timeSlots) {
            if (isOverlapping(slot, start, end)) {
                return false;
            }
        }
        timeSlots.add(new int[]{start, end});
        return true;
    }

    private static boolean isOverlapping(int[] slot, int start, int end) {
        return !(slot[1] <= start || slot[0] >= end);
    }

    private static int scanInt() throws IOException {
        return parseInt(scanString());
    }

    private static String scanString() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    private static int[] scanArray() throws IOException {
        tokenizer = new StringTokenizer(reader.readLine());
        int start = scanInt();
        int end = scanInt();
        return new int[]{start, end};
    }

    private static void printResult(String result) {
        out.println("Case #" + testCaseNumber + ": " + result);
    }

    private static BufferedReader reader;
    private static PrintWriter out;
    private static StringTokenizer tokenizer;
    private static int testCaseNumber;

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
            exit(0);
        }
    }
}