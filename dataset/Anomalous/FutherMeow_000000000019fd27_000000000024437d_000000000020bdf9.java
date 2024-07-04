import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

    private static final int TIME_SLOT = 1441;
    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    private static BufferedReader in;
    private static PrintWriter out;
    private static StringTokenizer tokenizer;
    private static int testCaseNumber;

    public static void main(String[] args) {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            int testCases = Integer.parseInt(in.readLine());
            for (testCaseNumber = 1; testCaseNumber <= testCases; testCaseNumber++) {
                solve();
            }
            in.close();
            out.close();
        } catch (Throwable e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    private static void solve() throws IOException {
        ArrayList<int[]> cTime = new ArrayList<>(TIME_SLOT);
        ArrayList<int[]> jTime = new ArrayList<>(TIME_SLOT);

        int n = Integer.parseInt(in.readLine());
        StringBuilder result = new StringBuilder();
        boolean isImpossible = false;

        for (int i = 0; i < n; i++) {
            int[] interval = scanArray();
            int start = interval[0];
            int end = interval[1];

            if (jTime.size() > cTime.size()) {
                if (addInterval(start, end, cTime)) {
                    result.append("C");
                } else if (addInterval(start, end, jTime)) {
                    result.append("J");
                } else {
                    isImpossible = true;
                    break;
                }
            } else {
                if (addInterval(start, end, jTime)) {
                    result.append("J");
                } else if (addInterval(start, end, cTime)) {
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

    private static boolean addInterval(int start, int end, ArrayList<int[]> timeSlots) {
        for (int[] time : timeSlots) {
            if (isOverlapping(time, start, end)) {
                return false;
            }
        }
        timeSlots.add(new int[]{start, end});
        return true;
    }

    private static boolean isOverlapping(int[] time, int start, int end) {
        return !(time[1] <= start || time[0] >= end);
    }

    private static int[] scanArray() throws IOException {
        tokenizer = new StringTokenizer(in.readLine());
        int start = Integer.parseInt(tokenizer.nextToken());
        int end = Integer.parseInt(tokenizer.nextToken());
        return new int[]{start, end};
    }

    private static void printResult(String result) {
        out.println("Case #" + testCaseNumber + ": " + result);
    }
}