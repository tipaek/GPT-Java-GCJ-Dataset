import java.io.*;
import java.util.*;

public class Solution {
    private static final long MOD = 1000000007;
    private static PrintWriter out;
    private static final int OFFSET = -1000000000;

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int t = sc.nextInt();
        for (int tt = 1; tt <= t; tt++) {
            processTestCase(sc, tt);
        }
        out.close();
    }

    private static void processTestCase(MyScanner sc, int testCaseNumber) {
        long l = sc.nextLong();
        long r = sc.nextLong();
        int LR = l >= r ? 0 : 1;
        long diff = Math.abs(l - r);
        long n = (long) (Math.sqrt(2 * diff + 0.25) - 0.5);
        
        if (LR == 0) {
            l -= (n * n + n) / 2;
        } else {
            r -= (n * n + n) / 2;
        }
        
        LR = l >= r ? 0 : 1;
        if (l >= r) {
            adjustValuesForLGreater(l, r, n, testCaseNumber);
        } else {
            adjustValuesForRGreater(l, r, n, testCaseNumber);
        }
    }

    private static void adjustValuesForLGreater(long l, long r, long n, int testCaseNumber) {
        long L = Math.max(0, (long) (Math.ceil(Math.sqrt(l + n * n / 4.0) - n / 2.0) - 5));
        long R = Math.max(0, L - 10);

        while (L < R + 10 && L * n + L * L <= l) {
            L++;
        }
        while (R <= L + 10 && R * n + R * R + R <= r) {
            R++;
        }
        L--;
        R--;

        l -= L * n + L * L;
        r -= R * n + R * R + R;
        n += L + R;

        out.println("Case #" + testCaseNumber + ": " + n + " " + l + " " + r);
    }

    private static void adjustValuesForRGreater(long l, long r, long n, int testCaseNumber) {
        long R = Math.max(0, (long) (Math.ceil(Math.sqrt(l + n * n / 4.0) - n / 2.0) - 5));
        long L = Math.max(0, R - 10);

        while (L < R + 10 && L * n + L * L + L <= l) {
            L++;
        }
        while (R <= L + 10 && R * n + R * R <= r) {
            R++;
        }
        L--;
        R--;

        l -= L * n + L * L + L;
        r -= R * n + R * R;
        n += L + R;

        out.println("Case #" + testCaseNumber + ": " + n + " " + l + " " + r);
    }

    //-----------MyScanner class for faster input----------
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}