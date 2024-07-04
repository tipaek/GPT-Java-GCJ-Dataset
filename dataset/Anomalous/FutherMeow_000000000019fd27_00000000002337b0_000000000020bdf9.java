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
        ArrayList<int[]> cSchedule = new ArrayList<>();
        ArrayList<int[]> jSchedule = new ArrayList<>();

        int n = readInt();
        StringBuilder result = new StringBuilder();
        boolean isPossible = true;

        for (int i = 0; i < n; i++) {
            int start = readInt();
            int end = readInt();

            if (addSchedule(start, end, cSchedule)) {
                result.append("C");
            } else if (addSchedule(start, end, jSchedule)) {
                result.append("J");
            } else {
                isPossible = false;
                break;
            }
        }

        if (isPossible) {
            printResult(result.toString());
        } else {
            printResult(IMPOSSIBLE);
        }
    }

    private static boolean addSchedule(int start, int end, ArrayList<int[]> schedule) {
        for (int[] time : schedule) {
            if (isOverlapping(time, start) || isOverlapping(time, end)) {
                return false;
            }
        }

        schedule.add(new int[]{start, end});
        return true;
    }

    private static boolean isOverlapping(int[] time, int point) {
        return time[0] < point && time[1] > point;
    }

    private static int readInt() throws IOException {
        return Integer.parseInt(readString());
    }

    private static String readString() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    private static void printResult(String result) {
        writer.println("Case #" + testCase + ": " + result);
    }

    private static BufferedReader reader;
    private static PrintWriter writer;
    private static StringTokenizer tokenizer;
    private static int testCase;

    public static void main(String[] args) {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            writer = new PrintWriter(System.out);
            int testCases = readInt();
            for (testCase = 1; testCase <= testCases; testCase++) {
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