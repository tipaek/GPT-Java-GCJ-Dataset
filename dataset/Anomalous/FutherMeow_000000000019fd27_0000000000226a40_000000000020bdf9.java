import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

    private static final int TIME_SLOT = 1441;
    private static final String IMPOSSIBLE = "IMPOSSIBLE";
    
    private static class TimeInterval {
        int start;
        int end;

        TimeInterval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private static void solve() throws IOException {
        boolean[] cTime = new boolean[TIME_SLOT];
        boolean[] jTime = new boolean[TIME_SLOT];

        int n = nextInt();
        StringBuilder result = new StringBuilder();
        boolean isPossible = true;

        for (int i = 0; i < n; i++) {
            int start = nextInt();
            int end = nextInt();
            TimeInterval interval = new TimeInterval(start, end);

            if (isBusy(interval, cTime)) {
                if (isBusy(interval, jTime)) {
                    isPossible = false;
                    break;
                } else {
                    markBusy(interval, jTime);
                    result.append("J");
                }
            } else {
                markBusy(interval, cTime);
                result.append("C");
            }
        }

        printResult(isPossible ? result.toString() : IMPOSSIBLE);
    }

    private static boolean isBusy(TimeInterval interval, boolean[] timeSlots) {
        for (int i = interval.start; i < interval.end; i++) {
            if (timeSlots[i]) {
                return true;
            }
        }
        return false;
    }

    private static void markBusy(TimeInterval interval, boolean[] timeSlots) {
        for (int i = interval.start; i < interval.end; i++) {
            timeSlots[i] = true;
        }
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
        out.println("Case #" + testCase + ": " + result);
    }

    private static BufferedReader reader;
    private static PrintWriter out;
    private static StringTokenizer tokenizer;
    private static int testCase;

    public static void main(String[] args) {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            int testCases = nextInt();
            
            for (testCase = 1; testCase <= testCases; testCase++) {
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