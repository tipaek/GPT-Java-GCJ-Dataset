import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

    static final int TIME_SLOT = 1441;
    static final String FAIL = "IMPOSSIBLE";

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

    static void solve() throws Exception {
        ArrayList<Time> cTimes = new ArrayList<>();
        ArrayList<Time> jTimes = new ArrayList<>();
        cTimes.add(new Time(0, TIME_SLOT));
        jTimes.add(new Time(0, TIME_SLOT));

        int n = scanInt();
        StringBuilder result = new StringBuilder();
        boolean isPossible = true;

        for (int i = 0; i < n; i++) {
            int start = scanInt();
            int end = scanInt();

            if (addTimeSlot(start, end, cTimes)) {
                result.append("C");
            } else if (addTimeSlot(start, end, jTimes)) {
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

    static boolean addTimeSlot(int start, int end, ArrayList<Time> times) {
        Time freeTime = findFreeTimeSlot(start, end, times);
        if (freeTime == null) {
            return false;
        }
        allocateTimeSlot(start, end, times, freeTime);
        return true;
    }

    static Time findFreeTimeSlot(int start, int end, ArrayList<Time> timeSlots) {
        for (Time freeTime : timeSlots) {
            if (freeTime.start <= start && freeTime.end >= end) {
                return freeTime;
            }
        }
        return null;
    }

    static void allocateTimeSlot(int start, int end, ArrayList<Time> timeSlots, Time freeTime) {
        timeSlots.remove(freeTime);
        if (freeTime.start < start) {
            timeSlots.add(new Time(freeTime.start, start));
        }
        if (freeTime.end > end) {
            timeSlots.add(new Time(end, freeTime.end));
        }
    }

    static int scanInt() throws IOException {
        return Integer.parseInt(scanString());
    }

    static String scanString() throws IOException {
        while (tok == null || !tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }

    static void printCase(String result) {
        out.println("Case #" + test + ": " + result);
    }

    static BufferedReader in;
    static PrintWriter out;
    static StringTokenizer tok;
    static int test;

    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        for (test = 1; test <= t; test++) {
            solve();
        }
        out.close();
    }
}