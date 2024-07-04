import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

    static void solve() throws Exception {
        int k = parseInputInt(), n = parseInputInt();
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = parseInputInt();
        }
        for (int i = 0; i < n; i++) {
            parseInputInt();
        }
        int ans = n;
        long l = x[n - 1] - k, r = x[0];
        for (int i = 0; i < n; i++) {
            if (2L * x[i] - r >= (i == n - 1 ? x[0] + k : x[i + 1])) {
                ++ans;
                l = i == 0 ? x[n - 1] - k : x[i - 1];
                r = x[i];
            }
            long nl = 2L * x[i] - r, nr = 2L * x[i] - l;
            l = Math.max(nl, x[i]);
            r = Math.min(nr, i == n - 1 ? x[0] + k : x[i + 1]);
        }
        if (ans == n) {
            if (n % 2 == 0) {
                long s0 = 0, s1 = 0;
                for (int i = 0; i < n; i += 2) {
                    s0 += x[i];
                    s1 += x[i + 1];
                }
                if (2 * (s1 - s0) != k) {
                    ++ans;
                }
            } else {
                long pp = 0;
                for (int i = 0; i < n - 1; i += 2) {
                    pp += x[i];
                    pp -= x[i + 1];
                }
                pp = 2 * (pp + x[n - 1]) + k;
                if (pp <= 2L * l || pp >= 2L * r) {
                    ++ans;
                }
            }
        }
        printCase();
        out.println(ans);
    }

    static int parseInputInt() throws IOException {
        return Integer.parseInt(parseInputString());
    }

    static long parseInputLong() throws IOException {
        return Long.parseLong(parseInputString());
    }

    static String parseInputString() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    static void printCase() {
        out.print("Case #" + testCaseNumber + ": ");
    }

    static BufferedReader reader;
    static PrintWriter out;
    static StringTokenizer tokenizer;
    static int testCaseNumber;

    public static void main(String[] args) {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            int numberOfTests = parseInputInt();
            for (testCaseNumber = 1; testCaseNumber <= numberOfTests; testCaseNumber++) {
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