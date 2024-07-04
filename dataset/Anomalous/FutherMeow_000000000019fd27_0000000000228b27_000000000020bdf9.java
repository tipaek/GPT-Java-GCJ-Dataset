import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
            System.exit(1);
        }
    }

    private static void solve() throws Exception {
        boolean[] cSchedule = new boolean[TIME_SLOTS];
        boolean[] jSchedule = new boolean[TIME_SLOTS];
        int n = nextInt();
        StringBuilder result = new StringBuilder();
        boolean isPossible = true;

        for (int i = 0; i < n; i++) {
            int start = nextInt();
            int end = nextInt();
            if (isBusy(start, end, cSchedule)) {
                if (isBusy(start, end, jSchedule)) {
                    isPossible = false;
                    break;
                } else {
                    markBusy(start, end, jSchedule);
                    result.append("J");
                }
            } else {
                markBusy(start, end, cSchedule);
                result.append("C");
            }
        }

        if (isPossible) {
            printResult(result.toString());
        } else {
            printResult(IMPOSSIBLE);
        }
    }

    private static boolean isBusy(int start, int end, boolean[] schedule) {
        for (int i = start; i < end; i++) {
            if (schedule[i]) {
                return true;
            }
        }
        return false;
    }

    private static void markBusy(int start, int end, boolean[] schedule) {
        for (int i = start; i < end; i++) {
            schedule[i] = true;
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
        writer.println("Case #" + testCaseNumber + ": " + result);
    }
}