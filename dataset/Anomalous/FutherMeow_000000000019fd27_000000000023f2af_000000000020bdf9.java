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
    private static StringTokenizer tok;
    private static int test;

    private static void solve() throws IOException {
        ArrayList<int[]> cTimes = new ArrayList<>(TIME_SLOT);
        ArrayList<int[]> jTimes = new ArrayList<>(TIME_SLOT);

        int n = scanInt();
        StringBuilder result = new StringBuilder();
        boolean isImpossible = false;

        for (int i = 0; i < n; i++) {
            int[] input = scanArray();
            int start = input[0];
            int end = input[1];

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
            printResult(IMPOSSIBLE);
        } else {
            printResult(result.toString());
        }
    }

    private static boolean addTimeSlot(int start, int end, ArrayList<int[]> timeSlots) {
        for (int[] time : timeSlots) {
            if (isOverlapping(time, start) || isOverlapping(time, end)) {
                return false;
            }
        }
        timeSlots.add(new int[]{start, end});
        return true;
    }

    private static boolean isOverlapping(int[] time, int value) {
        return time[0] < value && time[1] > value;
    }

    private static int scanInt() throws IOException {
        return Integer.parseInt(in.readLine());
    }

    private static int[] scanArray() throws IOException {
        tok = new StringTokenizer(in.readLine());
        int start = Integer.parseInt(tok.nextToken());
        int end = Integer.parseInt(tok.nextToken());
        return new int[]{start, end};
    }

    private static void printResult(String result) {
        out.println("Case #" + test + ": " + result);
    }

    public static void main(String[] args) {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            int tests = scanInt();
            for (test = 1; test <= tests; test++) {
                solve();
            }
            in.close();
            out.close();
        } catch (Throwable e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
}