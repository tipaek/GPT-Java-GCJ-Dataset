import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

    private static final int TOTAL_TIME = 1441;
    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    private static class TimeSlot {
        int start;
        int end;

        TimeSlot(int start, int end) {
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

    private static void solve() throws IOException {
        ArrayList<TimeSlot> cSlots = new ArrayList<>();
        ArrayList<TimeSlot> jSlots = new ArrayList<>();
        cSlots.add(new TimeSlot(0, TOTAL_TIME));
        jSlots.add(new TimeSlot(0, TOTAL_TIME));

        int n = scanInt();
        StringBuilder result = new StringBuilder();
        boolean isPossible = true;

        for (int i = 0; i < n; i++) {
            int start = scanInt();
            int end = scanInt();

            if (allocateTime(start, end, cSlots)) {
                result.append("C");
            } else if (allocateTime(start, end, jSlots)) {
                result.append("J");
            } else {
                isPossible = false;
                break;
            }
        }

        printResult(isPossible ? result.toString() : IMPOSSIBLE);
    }

    private static boolean allocateTime(int start, int end, ArrayList<TimeSlot> slots) {
        TimeSlot availableSlot = findAvailableSlot(start, end, slots);
        if (availableSlot == null) {
            return false;
        }
        updateSlots(start, end, slots, availableSlot);
        return true;
    }

    private static TimeSlot findAvailableSlot(int start, int end, ArrayList<TimeSlot> slots) {
        for (TimeSlot slot : slots) {
            if (slot.getStart() <= start && slot.getEnd() >= end) {
                return slot;
            }
        }
        return null;
    }

    private static void updateSlots(int start, int end, ArrayList<TimeSlot> slots, TimeSlot slot) {
        slots.remove(slot);
        if (slot.getStart() < start) {
            slots.add(new TimeSlot(slot.getStart(), start));
        }
        if (slot.getEnd() > end) {
            slots.add(new TimeSlot(end, slot.getEnd()));
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

    private static void printResult(String result) {
        out.println("Case #" + testNumber + ": " + result);
    }

    private static BufferedReader reader;
    private static PrintWriter out;
    private static StringTokenizer tokenizer;
    private static int testNumber;

    public static void main(String[] args) {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            int testCases = scanInt();
            for (testNumber = 1; testNumber <= testCases; testNumber++) {
                solve();
            }
            reader.close();
            out.close();
        } catch (Throwable e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}