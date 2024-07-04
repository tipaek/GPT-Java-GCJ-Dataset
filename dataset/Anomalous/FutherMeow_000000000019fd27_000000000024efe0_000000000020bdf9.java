import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    private static final int TIME_SLOTS = 1441;
    private static final String IMPOSSIBLE = "IMPOSSIBLE";
    private static BufferedReader reader;
    private static PrintWriter writer;
    private static StringTokenizer tokenizer;
    private static int testCaseNumber;

    public static void main(String[] args) {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            writer = new PrintWriter(System.out);
            int testCases = nextInt();
            for (testCaseNumber = 1; testCaseNumber <= testCases; testCaseNumber++) {
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
        ArrayList<int[]> cTimes = new ArrayList<>(TIME_SLOTS);
        ArrayList<int[]> jTimes = new ArrayList<>(TIME_SLOTS);
        int n = nextInt();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int[] interval = nextIntArray();
            int start = interval[0];
            int end = interval[1];

            if (jTimes.size() > cTimes.size()) {
                if (addInterval(start, end, cTimes)) {
                    result.append("C");
                } else if (addInterval(start, end, jTimes)) {
                    result.append("J");
                }
            } else {
                if (addInterval(start, end, jTimes)) {
                    result.append("J");
                } else if (addInterval(start, end, cTimes)) {
                    result.append("C");
                }
            }
        }

        if (result.length() < n) {
            printResult(IMPOSSIBLE);
        } else {
            printResult(result.toString());
        }
    }

    private static boolean addInterval(int start, int end, ArrayList<int[]> timeSlots) {
        for (int[] time : timeSlots) {
            if (isOverlap(time, start, end)) {
                return false;
            }
        }
        timeSlots.add(new int[]{start, end});
        return true;
    }

    private static boolean isOverlap(int[] time, int start, int end) {
        return !(time[1] <= start || time[0] >= end);
    }

    private static int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    private static String nextToken() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    private static int[] nextIntArray() throws IOException {
        int start = nextInt();
        int end = nextInt();
        return new int[]{start, end};
    }

    private static void printResult(String result) {
        writer.println("Case #" + testCaseNumber + ": " + result);
    }
}