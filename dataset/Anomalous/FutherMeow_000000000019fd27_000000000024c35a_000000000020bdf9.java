import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

    private static final int TIME_SLOT = 1441;
    private static final String IMPOSSIBLE = "IMPOSSIBLE";
    private static BufferedReader in;
    private static PrintWriter out;
    private static StringTokenizer tokenizer;
    private static int testCase;

    public static void main(String[] args) {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            int testCount = scanInt();
            for (testCase = 1; testCase <= testCount; testCase++) {
                solve();
            }
            in.close();
            out.close();
        } catch (Throwable e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    private static void solve() throws Exception {
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
                if (addInterval(cTimeSlots, start, end)) {
                    result.append("C");
                } else if (addInterval(jTimeSlots, start, end)) {
                    result.append("J");
                } else {
                    isImpossible = true;
                    break;
                }
            } else {
                if (addInterval(jTimeSlots, start, end)) {
                    result.append("J");
                } else if (addInterval(cTimeSlots, start, end)) {
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

    private static boolean addInterval(ArrayList<int[]> timeSlots, int start, int end) {
        for (int[] interval : timeSlots) {
            if (isOverlapping(interval, start, end)) {
                return false;
            }
        }
        timeSlots.add(new int[]{start, end});
        return true;
    }

    private static boolean isOverlapping(int[] interval, int start, int end) {
        return !(interval[1] <= start || interval[0] >= end);
    }

    private static int scanInt() throws IOException {
        return Integer.parseInt(scanString());
    }

    private static String scanString() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(in.readLine());
        }
        return tokenizer.nextToken();
    }

    private static int[] scanArray() throws IOException {
        int start = scanInt();
        int end = scanInt();
        return new int[]{start, end};
    }

    private static void printResult(String result) {
        out.println("Case #" + testCase + ": " + result);
    }
}