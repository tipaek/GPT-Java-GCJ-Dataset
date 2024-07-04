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
        ArrayList<int[]> cTimeSlots = new ArrayList<>(TIME_SLOT);
        ArrayList<int[]> jTimeSlots = new ArrayList<>(TIME_SLOT);

        int n = scanInt();
        StringBuilder result = new StringBuilder();
        boolean isImpossible = false;

        for (int i = 0; i < n; i++) {
            int[] input = scanArray();
            int start = input[0];
            int end = input[1];

            if (addTimeSlot(start, end, cTimeSlots)) {
                result.append("C");
            } else if (addTimeSlot(start, end, jTimeSlots)) {
                result.append("J");
            } else {
                isImpossible = true;
                break;
            }
        }

        if (isImpossible) {
            printCase(IMPOSSIBLE);
        } else {
            printCase(result.toString());
        }
    }

    private static boolean addTimeSlot(int start, int end, ArrayList<int[]> timeSlots) {
        for (int[] time : timeSlots) {
            if (isOverlapping(time, start, end)) {
                return false;
            }
        }
        timeSlots.add(new int[]{start, end});
        return true;
    }

    private static boolean isOverlapping(int[] time, int start, int end) {
        return !(time[1] <= start || time[0] >= end);
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

    private static int[] scanArray() throws IOException {
        tokenizer = new StringTokenizer(reader.readLine());
        int start = Integer.parseInt(tokenizer.nextToken());
        int end = Integer.parseInt(tokenizer.nextToken());
        return new int[]{start, end};
    }

    private static void printCase(String result) {
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