import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution3 {

    static void solve() throws Exception {
        int n = scanInt(), d = scanInt();
        double[] slices = new double[n];
        for (int i = 0; i < n; i++) {
            slices[i] = scanInt();
        }
        Arrays.sort(slices);
        printCase();
        boolean found = false;
        double even;
        int soFar;
        for (int k = 0; k < d && !found; k++) {
            for (int i = 0; i < n && !found; i++) {
                even = 1;
                soFar = 0;
                for (int j = 0; j < n && !found; j++) {
                    if (slices[i] % slices[j] == 0) {
                        if (even + (slices[i] % slices[j]) <= d) {
                            soFar++;
                            even += (slices[i] % slices[j]);
                        }
                    }
                    if (even >= d) {
                        found = true;
                        out.println(soFar);
                        return;
                    }
                }
            }
            slices[0] /= d;
        }
    }

    static int scanInt() throws IOException {
        return Integer.parseInt(scanString());
    }

    static long scanLong() throws IOException {
        return Long.parseLong(scanString());
    }

    static String scanString() throws IOException {
        while (tok == null || !tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }

    static void printCase() {
        out.print("Case #" + test + ": ");
    }

    static void printlnCase() {
        out.println("Case #" + test + ":");
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
            System.exit(1);
        }
    }
}