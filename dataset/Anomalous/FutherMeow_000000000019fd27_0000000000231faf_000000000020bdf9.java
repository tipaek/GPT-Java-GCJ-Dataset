import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

    static final int TIME_SLOT = 1441;
    static final String IMPOSSIBLE = "IMPOSSIBLE";

    public static class Time {
        int start;
        int end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean contains(int time) {
            return time > this.start && time < this.end;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Time) {
                Time other = (Time) obj;
                return this.start == other.start && this.end == other.end;
            }
            return false;
        }
    }

    static void solve() throws Exception {
        ArrayList<Time> cTimes = new ArrayList<>();
        ArrayList<Time> jTimes = new ArrayList<>();

        int n = scanInt();
        StringBuilder result = new StringBuilder();
        boolean possible = true;

        for (int i = 0; i < n; i++) {
            int start = scanInt();
            int end = scanInt();

            if (addTimeSlot(start, end, cTimes)) {
                result.append("C");
            } else if (addTimeSlot(start, end, jTimes)) {
                result.append("J");
            } else {
                possible = false;
                break;
            }
        }

        if (!possible) {
            printResult(IMPOSSIBLE);
        } else {
            printResult(result.toString());
        }
    }

    static boolean addTimeSlot(int start, int end, ArrayList<Time> timeSlots) {
        for (Time time : timeSlots) {
            if (time.contains(start) || time.contains(end)) {
                return false;
            }
        }
        timeSlots.add(new Time(start, end));
        return true;
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

    static void printResult(String result) {
        output.println("Case #" + testCaseNumber + ": " + result);
    }

    static BufferedReader reader;
    static PrintWriter output;
    static StringTokenizer tokenizer;
    static int testCaseNumber;

    public static void main(String[] args) {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            output = new PrintWriter(System.out);
            int testCases = scanInt();
            for (testCaseNumber = 1; testCaseNumber <= testCases; testCaseNumber++) {
                solve();
            }
            reader.close();
            output.close();
        } catch (Throwable e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}