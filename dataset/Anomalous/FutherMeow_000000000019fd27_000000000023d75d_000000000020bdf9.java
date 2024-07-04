import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

    static final int TIME_SLOT = 1441;
    static final String FAIL = "IMPOSSIBLE";

    static void solve() throws Exception {
        ArrayList<short[]> cTime = new ArrayList<>(TIME_SLOT);
        ArrayList<short[]> jTime = new ArrayList<>(TIME_SLOT);

        int n = scanInt();
        StringBuilder result = new StringBuilder();
        boolean resultCheck = false;
        for (int i = 0; i < n; i++) {
            short start = scanInt();
            short end = scanInt();

            // Uncomment and modify the logic below as needed
            // if (jTime.size() > cTime.size()) {
            //     if (add(start, end, cTime)) {
            //         result.append("C");
            //     } else if (add(start, end, jTime)) {
            //         result.append("J");
            //     } else {
            //         resultCheck = true;
            //         break;
            //     }
            // } else {
            //     if (add(start, end, jTime)) {
            //         result.append("J");
            //     } else if (add(start, end, cTime)) {
            //         result.append("C");
            //     } else {
            //         resultCheck = true;
            //         break;
            //     }
            // }
        }

        if (resultCheck) {
            printCase(FAIL);
        } else {
            printCase(result.toString());
        }
    }

    static boolean add(short start, short end, ArrayList<short[]> timeSlot) {
        for (short[] time : timeSlot) {
            if (checkContain(time, start) || checkContain(time, end)) {
                return false;
            }
        }
        timeSlot.add(new short[]{start, end});
        return true;
    }

    static boolean checkContain(short[] time, short value) {
        return time[0] < value && time[1] > value;
    }

    static short scanInt() throws IOException {
        return Short.parseShort(scanString());
    }

    static String scanString() throws IOException {
        while (tok == null || !tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }

    static void printCase(String result) {
        out.println("Case #" + test + ": " + result);
    }

    static BufferedReader in;
    static PrintWriter out;
    static StringTokenizer tok;
    static int test;

    public static void main(String[] args) {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            int tests = scanInt();
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
}