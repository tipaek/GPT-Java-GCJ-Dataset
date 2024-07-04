import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

    private static final int TIME_SLOT = 1441;
    private static final String FAIL = "IMPOSSIBLE";

    public static class Time {
        int start;
        int end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }
    }

    private static void solve() throws Exception {
        ArrayList<Time> cTime = new ArrayList<>();
        ArrayList<Time> jTime = new ArrayList<>();
        cTime.add(new Time(0, TIME_SLOT));
        jTime.add(new Time(0, TIME_SLOT));

        int n = scanInt();
        StringBuilder result = new StringBuilder();
        boolean resultCheck = true;

        for (int i = 0; i < n; i++) {
            int start = scanInt();
            int end = scanInt();

            if (addTimeSlot(start, end, cTime)) {
                result.append("C");
            } else if (addTimeSlot(start, end, jTime)) {
                result.append("J");
            } else {
                resultCheck = false;
                break;
            }
        }

        if (!resultCheck) {
            printCase(FAIL);
        } else {
            printCase(result.toString());
        }
    }

    private static boolean addTimeSlot(int start, int end, ArrayList<Time> timeSlots) {
        Time freeTime = findFreeTimeSlot(start, end, timeSlots);
        if (freeTime == null) {
            return false;
        }
        updateBusyTimeSlots(start, end, timeSlots, freeTime);
        return true;
    }

    private static Time findFreeTimeSlot(int start, int end, ArrayList<Time> timeSlots) {
        for (Time freeTime : timeSlots) {
            if (freeTime.getStart() <= start && freeTime.getEnd() >= end) {
                return freeTime;
            }
        }
        return null;
    }

    private static void updateBusyTimeSlots(int start, int end, ArrayList<Time> timeSlots, Time freeTime) {
        timeSlots.remove(freeTime);
        if (freeTime.getStart() < start) {
            timeSlots.add(new Time(freeTime.getStart(), start));
        }
        if (freeTime.getEnd() > end) {
            timeSlots.add(new Time(end, freeTime.getEnd()));
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
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new PrintWriter(System.out);
        try {
            int testCases = Integer.parseInt(reader.readLine());
            for (testCaseNumber = 1; testCaseNumber <= testCases; testCaseNumber++) {
                solve();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
    }
}