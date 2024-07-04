import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Random;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    private BufferedReader br;
    private StringTokenizer st;
    private PrintWriter out;
    private boolean eof = false;

    private void run() {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        int testn = nextInt();
        long lower = nextInt();
        long higher = nextInt();
        for (int test = 1; test <= testn; test++) {
            solve(lower, higher);
        }
        out.close();
    }

    private String nextToken() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (Exception e) {
                eof = true;
                return "0";
            }
        }
        return st.nextToken();
    }

    private int nextInt() {
        return Integer.parseInt(nextToken());
    }

    private long nextLong() {
        return Long.parseLong(nextToken());
    }

    private double nextDouble() {
        return Double.parseDouble(nextToken());
    }

    private static final int SIZE = (int) 1e9;
    private static final String CENTER = "CENTER";
    private static final String HIT = "HIT";
    private static final String MISS = "MISS";

    private void solve(long lower, long higher) {
        Random rand = new Random(12345);
        long x1 = -SIZE + lower;
        long y1 = -SIZE + lower;
        long x2 = SIZE - lower;
        long y2 = SIZE - lower;
        for (int i = 0; i < 200; i++) {
            long y = (y1 + y2) / 2;
            long xRight = Math.round((x1 + x2) / 2 + Math.sqrt(lower * lower - (y1 - y2) * (y1 - y2) / 4.0));
            if (i % 2 == 0) {
                out.println(xRight + " " + y);
            } else {
                out.println(y + " " + xRight);
            }
            out.flush();
            String resp = nextToken();
            if (resp.equals(CENTER)) {
                return;
            }
            if (resp.equals(MISS)) {
                x2 = (x1 + x2) / 2 + 1;
            } else {
                x1 = xRight - lower;
            }
            long t = x1;
            x1 = y1;
            y1 = t;
            t = x2;
            x2 = y2;
            y2 = t;
        }
        System.err.println(x1 + " " + y1 + " " + x2 + " " + y2);
        for (long i = x1; i <= x2; i++) {
            for (long j = y1; j <= y2; j++) {
                out.println(i + " " + j);
                out.flush();
                String resp = nextToken();
                if (resp.equals(CENTER)) {
                    return;
                }
            }
        }
    }
}