import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

    private static final int TIME_SLOT = 1441;
    private static final String FAIL = "IMPOSSIBLE";

    private static BufferedReader in;
    private static PrintWriter out;
    private static StringTokenizer tok;
    private static int test;

    public static void main(String[] args) {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            int tests = Integer.parseInt(in.readLine());
            for (test = 1; test <= tests; test++) {
                solve();
            }
            in.close();
            out.close();
        } catch (Throwable e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    private static void solve() throws Exception {
        ArrayList<int[]> cTime = new ArrayList<>(TIME_SLOT);
        ArrayList<int[]> jTime = new ArrayList<>(TIME_SLOT);

        int n = Integer.parseInt(in.readLine());
        StringBuilder result = new StringBuilder();
        boolean resultCheck = false;

        for (int i = 0; i < n; i++) {
            int[] input = scanArray();
            int start = input[0];
            int end = input[1];

            if (jTime.size() > cTime.size()) {
                if (add(start, end, cTime)) {
                    result.append("C");
                } else if (add(start, end, jTime)) {
                    result.append("J");
                } else {
                    resultCheck = true;
                    break;
                }
            } else {
                if (add(start, end, jTime)) {
                    result.append("J");
                } else if (add(start, end, cTime)) {
                    result.append("C");
                } else {
                    resultCheck = true;
                    break;
                }
            }
        }

        if (resultCheck) {
            printCase(FAIL);
        } else {
            printCase(result.toString());
        }
    }

    private static boolean add(int start, int end, ArrayList<int[]> timeSlot) {
        for (int[] time : timeSlot) {
            if (checkContain(time, start, end)) {
                return false;
            }
        }
        timeSlot.add(new int[]{start, end});
        return true;
    }

    private static boolean checkContain(int[] time, int start, int end) {
        return !(time[0] >= end || time[1] <= start || 
                 (time[0] == start || time[1] == end) || 
                 (time[0] < start && time[1] > start) || 
                 (time[0] < end && time[1] > end) || 
                 (time[0] > start && time[1] < end));
    }

    private static int[] scanArray() throws IOException {
        tok = new StringTokenizer(in.readLine());
        int start = Integer.parseInt(tok.nextToken());
        int end = Integer.parseInt(tok.nextToken());
        return new int[]{start, end};
    }

    private static void printCase(String result) {
        out.println("Case #" + test + ": " + result);
    }
}