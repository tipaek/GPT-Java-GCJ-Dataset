import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

    static boolean done;
    static BufferedReader in;
    static PrintWriter out;
    static StringTokenizer tok;
    static int test;

    public static void main(String[] args) {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            int tests = scanInt();
            scanInt(); // Read but ignore these values
            scanInt(); // Read but ignore these values
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

    static boolean query(int x, int y) throws IOException {
        if (done) {
            return true;
        }
        out.println(x + " " + y);
        out.flush();
        switch (scanString()) {
            case "CENTER":
                done = true;
                return true;
            case "HIT":
                return true;
            case "MISS":
                return false;
            default:
                System.exit(0);
                return false;
        }
    }

    static void solve() throws Exception {
        done = false;
        int x = -500000000, y = -500000000;
        outerLoop: while (true) {
            for (y = -500000000; y <= 500000000; y += 500000000) {
                if (query(x, y)) {
                    break outerLoop;
                }
            }
            x += 500000000;
            if (x > 500000000) {
                throw new AssertionError();
            }
        }

        int x1 = binarySearch(x, 1000000000, y, true);
        int x2 = binarySearch(-1000000000, x, y, false);
        int y1 = binarySearch(y, 1000000000, x, true, true);
        int y2 = binarySearch(-1000000000, y, x, false, true);

        query((x1 + x2) / 2, (y1 + y2) / 2);
        if (!done) {
            throw new AssertionError();
        }
    }

    static int binarySearch(int l, int r, int fixed, boolean findMax) throws IOException {
        return binarySearch(l, r, fixed, findMax, false);
    }

    static int binarySearch(int l, int r, int fixed, boolean findMax, boolean isYFixed) throws IOException {
        while (l < r) {
            int m = (l + r + (findMax ? 1 : 0)) / 2;
            if (query(isYFixed ? fixed : m, isYFixed ? m : fixed) == findMax) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        return findMax ? l : r;
    }

    static int scanInt() throws IOException {
        return Integer.parseInt(scanString());
    }

    static String scanString() throws IOException {
        while (tok == null || !tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }
}