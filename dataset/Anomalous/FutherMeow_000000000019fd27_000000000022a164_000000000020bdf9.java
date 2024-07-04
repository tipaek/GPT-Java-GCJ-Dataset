import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

    private static final int TIME_SLOT = 1441;
    private static final String FAIL = "IMPOSSIBLE";

    static class Time {
        int start;
        int end;

        Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        int getStart() {
            return start;
        }

        int getEnd() {
            return end;
        }
    }

    private static void solve() throws Exception {
        ArrayList<Time> cTimeSlots = new ArrayList<>();
        ArrayList<Time> jTimeSlots = new ArrayList<>();
        cTimeSlots.add(new Time(0, TIME_SLOT));
        jTimeSlots.add(new Time(0, TIME_SLOT));

        int n = scanInt();
        StringBuilder result = new StringBuilder();
        boolean isPossible = true;

        for (int i = 0; i < n; i++) {
            int start = scanInt();
            int end = scanInt();

            if (addTimeSlot(start, end, cTimeSlots)) {
                result.append("C");
            } else if (addTimeSlot(start, end, jTimeSlots)) {
                result.append("J");
            } else {
                isPossible = false;
                break;
            }
        }

        if (!isPossible) {
            printCase(FAIL);
        } else {
            printCase(result.toString());
        }
    }

    private static boolean addTimeSlot(int start, int end, ArrayList<Time> timeSlots) {
        Time freeSlot = findFreeSlot(start, end, timeSlots);
        if (freeSlot == null) {
            return false;
        }
        updateSlots(start, end, timeSlots, freeSlot);
        return true;
    }

    private static Time findFreeSlot(int start, int end, ArrayList<Time> timeSlots) {
        for (Time slot : timeSlots) {
            if (slot.getStart() <= start && slot.getEnd() >= end) {
                return slot;
            }
        }
        return null;
    }

    private static void updateSlots(int start, int end, ArrayList<Time> timeSlots, Time freeSlot) {
        timeSlots.remove(freeSlot);
        if (freeSlot.getStart() < start) {
            timeSlots.add(new Time(freeSlot.getStart(), start));
        }
        if (freeSlot.getEnd() > end) {
            timeSlots.add(new Time(end, freeSlot.getEnd()));
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
            int numberOfTests = scanInt();
            for (testCaseNumber = 1; testCaseNumber <= numberOfTests; testCaseNumber++) {
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