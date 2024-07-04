package p3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

    private static final int TIME_SLOT = 1441;
    private static final String IMPOSSIBLE = "IMPOSSIBLE";
    private static BufferedReader reader;
    private static PrintWriter writer;
    private static StringTokenizer tokenizer;
    private static int testCase;

    public static void main(String[] args) {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            writer = new PrintWriter(System.out);
            int numberOfTests = Integer.parseInt(reader.readLine());
            for (testCase = 1; testCase <= numberOfTests; testCase++) {
                solve();
            }
            reader.close();
            writer.close();
        } catch (Throwable e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    private static void solve() throws IOException {
        int n = Integer.parseInt(reader.readLine());
        ArrayList<int[]> cTimeSlots = new ArrayList<>(TIME_SLOT);
        ArrayList<int[]> jTimeSlots = new ArrayList<>(TIME_SLOT);
        StringBuilder result = new StringBuilder();
        boolean isImpossible = false;

        for (int i = 0; i < n; i++) {
            int[] interval = parseInterval();
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

    private static int[] parseInterval() throws IOException {
        tokenizer = new StringTokenizer(reader.readLine());
        int start = Integer.parseInt(tokenizer.nextToken());
        int end = Integer.parseInt(tokenizer.nextToken());
        return new int[]{start, end};
    }

    private static void printResult(String result) {
        writer.println("Case #" + testCase + ": " + result);
    }
}