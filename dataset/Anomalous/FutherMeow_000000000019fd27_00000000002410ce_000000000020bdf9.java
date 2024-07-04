import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

    static final int TIME_SLOTS = 1441;
    static final String IMPOSSIBLE = "IMPOSSIBLE";

    static void solve() throws Exception {
        ArrayList<int[]> cSchedule = new ArrayList<>(TIME_SLOTS);
        ArrayList<int[]> jSchedule = new ArrayList<>(TIME_SLOTS);

        int n = scanInt();
        StringBuilder result = new StringBuilder();
        boolean isImpossible = false;
        
        for (int i = 0; i < n; i++) {
            int[] interval = scanInterval();
            int start = interval[0];
            int end = interval[1];

            if (jSchedule.size() > cSchedule.size()) {
                if (addInterval(start, end, cSchedule)) {
                    result.append('C');
                } else if (addInterval(start, end, jSchedule)) {
                    result.append('J');
                } else {
                    isImpossible = true;
                    break;
                }
            } else {
                if (addInterval(start, end, jSchedule)) {
                    result.append('J');
                } else if (addInterval(start, end, cSchedule)) {
                    result.append('C');
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

    static boolean addInterval(int start, int end, ArrayList<int[]> schedule) {
        for (int[] interval : schedule) {
            if (isOverlapping(interval, start, end)) {
                return false;
            }
        }
        schedule.add(new int[]{start, end});
        return true;
    }

    static boolean isOverlapping(int[] interval, int start, int end) {
        return !(interval[1] <= start || interval[0] >= end);
    }

    static int scanInt() throws IOException {
        return Integer.parseInt(in.readLine());
    }

    static int[] scanInterval() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(in.readLine());
        int start = Integer.parseInt(tokenizer.nextToken());
        int end = Integer.parseInt(tokenizer.nextToken());
        return new int[]{start, end};
    }

    static void printResult(String result) {
        out.println("Case #" + testNumber + ": " + result);
    }

    static BufferedReader in;
    static PrintWriter out;
    static int testNumber;

    public static void main(String[] args) {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            int testCases = scanInt();
            for (testNumber = 1; testNumber <= testCases; testNumber++) {
                solve();
            }
            in.close();
            out.close();
        } catch (Throwable e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}