import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

    private static final int TOTAL_TIME_SLOTS = 1441;
    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    private static void solve() throws IOException {
        ArrayList<int[]> cSchedule = new ArrayList<>();
        ArrayList<int[]> jSchedule = new ArrayList<>();

        int n = nextInt();
        StringBuilder result = new StringBuilder();
        boolean isPossible = true;

        for (int i = 0; i < n; i++) {
            int start = nextInt();
            int end = nextInt();

            if (addSchedule(start, end, cSchedule)) {
                result.append("C");
            } else if (addSchedule(start, end, jSchedule)) {
                result.append("J");
            } else {
                isPossible = false;
                break;
            }
        }

        if (!isPossible) {
            printResult(IMPOSSIBLE);
        } else {
            printResult(result.toString());
        }
    }

    private static boolean addSchedule(int start, int end, ArrayList<int[]> schedule) {
        for (int[] timeSlot : schedule) {
            if (isOverlapping(timeSlot, start) || isOverlapping(timeSlot, end)) {
                return false;
            }
        }
        schedule.add(new int[]{start, end});
        return true;
    }

    private static boolean isOverlapping(int[] timeSlot, int time) {
        return timeSlot[0] < time && timeSlot[1] > time;
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

    private static void printResult(String result) {
        out.println("Case #" + testCaseNumber + ": " + result);
    }

    private static BufferedReader reader;
    private static PrintWriter out;
    private static StringTokenizer tokenizer;
    private static int testCaseNumber;

    public static void main(String[] args) {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            int testCases = nextInt();
            for (testCaseNumber = 1; testCaseNumber <= testCases; testCaseNumber++) {
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