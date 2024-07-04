import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

public class Solution {

    public static final long POS_MIN = -1000000000;
    public static final long POS_MAX = 1000000000;

    public static long A, B;
    public static int numInteractions = 0;
    public static boolean SIMULATE_TEST_CASES = false;
    public static boolean USE_LOCAL_JUDGE = true;

    public static Scanner in = null;
    public static PrintStream out = null;
    public static Process judgeProcess = null;

    public static void main(String[] args) throws IOException {
        initializeIO();
        if (!SIMULATE_TEST_CASES) {
            int tmax = in.nextInt();
            A = in.nextInt();
            B = in.nextInt();
            for (int t = 1; t <= tmax; ++t) {
                solve();
            }
        } else {
            simulateTestCases();
        }
    }

    public static void initializeIO() throws IOException {
        if (!USE_LOCAL_JUDGE) {
            in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            out = System.out;
        } else {
            judgeProcess = Runtime.getRuntime().exec("python src/judge.py 0");
            in = new Scanner(new BufferedReader(new InputStreamReader(judgeProcess.getInputStream())));
            out = new PrintStream(judgeProcess.getOutputStream());
        }
    }

    public static void sendToJudge(String val) {
        out.println(val);
        out.flush();
    }

    public static String retrieveFromJudge() {
        return in.next();
    }

    public static String interact(long x, long y) {
        numInteractions++;
        sendToJudge(x + " " + y);
        return retrieveFromJudge();
    }

    public static void solve() {
        numInteractions = 0;
        long r = A;
        for (long x = POS_MIN + r; x <= POS_MAX - r; x++) {
            for (long y = POS_MIN + r; y <= POS_MAX - r; y++) {
                String res = interact(x, y);
                if (res.equals("MISS")) {
                    continue;
                } else if (res.equals("HIT")) {
                    continue;
                } else if (res.equals("CENTER")) {
                    return;
                } else {
                    throw new AssertionError("Unexpected response: " + res);
                }
            }
        }
    }

    public static void simulateTestCases() {
        int tmax = 1;
        for (int t = 1; t <= tmax; ++t) {
            solve();
        }
    }
}