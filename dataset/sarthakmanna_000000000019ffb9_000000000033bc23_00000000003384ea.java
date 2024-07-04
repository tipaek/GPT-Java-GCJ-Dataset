import java.io.*;
import java.util.*;
import java.math.*;

public class Solution implements Runnable {
    @Override
    public void run() {
        try {
            new Solver().solve();
            System.exit(0);
        } catch (Exception | Error e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        //new Thread(null, new Solution(), "Solver", 1l << 25).start();
        new Solution().run();
    }
}

class Solver {
    final FastIO hp = new FastIO();
    final int MAXN = 1000_006;
    final long MAX = (long) 2e9 + 7;

    void solve() throws Exception {
        int tc = TESTCASES ? hp.nextInt() : 1;
        for (int tce = 1; tce <= tc; ++tce) solve(tce);
        hp.flush();
    }

    boolean TESTCASES = true;

    void solve(int tc) throws Exception {
        hp.print("Case #" + tc + ": ");

        int i, j, k;
        long L = hp.nextLong(), R = hp.nextLong();

        long cust = 0;
        if (L > R) {
            cust += calc(L - R);
            long take = cust * (cust + 1) >> 1;
            while (L - take >= R) {
                ++cust;
                take = cust * (cust + 1) >> 1;
            }

            L -= take;
            if (L < 0) {
                L += cust--;
                hp.println(cust + " " + L + " " + R);
                return;
            }

            long upto = bs(cust + 1, R, L, cust, MAX);
            R -= sum(cust + 1, upto);
            L -= sum(cust + 2, upto);
            hp.println(upto + " " + L + " " + R);
        } else if (R > L) {
            cust += calc(R - L);
            long take = cust * (cust + 1) >> 1;
            while (R - take > L) {
                ++cust;
                take = cust * (cust + 1) >> 1;
            }
            R -= take;

            if (R < 0) {
                R += cust--;
                hp.println(cust + " " + L + " " + R);
                return;
            }

            long upto = bs(cust + 1, L, R, cust, MAX);
            L -= sum(cust + 1, upto);
            R -= sum(cust + 2, upto);
            hp.println(upto + " " + L + " " + R);
        } else {
            long upto = bs(cust + 1, L, R, cust, MAX);
            L -= sum(cust + 1, upto);
            R -= sum(cust + 2, upto);
            hp.println(upto + " " + L + " " + R);
        }
    }

    long calc(long num) {
        return -1 + (long) Math.sqrt(1 + 8 * num) >> 1;
    }

    long bs(final long start, long A, long B, long l, long r) {
        while (true) {
            long mid = l + r >> 1;

            if (l == mid) {
                if (sum(start, r) <= A && sum(start + 1, r) <= B) return r;
                else return l;
            } else if (sum(start, mid) <= A && sum(start + 1, mid) <= B) {
                l = mid;
            } else {
                r = mid;
            }
        }
    }

    long sum(long start, long end) {
        long k = end - start >> 1;
        return (k + 1) * start + k * (k + 1);
    }
}

class FastIO {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer("");
    StringBuilder sb = new StringBuilder();

    public String next() throws Exception {
        while (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }

    public int nextInt() throws Exception {
        return Integer.parseInt(next());
    }

    public long nextLong() throws Exception {
        return Long.parseLong(next());
    }

    public String nextLine() throws Exception {
        return br.readLine();
    }

    public void print(Object o) {
        sb.append(o);
    }

    public void println() {
        print("\n");
    }

    public void println(Object o) {
        print(o);
        println();
    }

    public void flush() {
        System.out.print(sb);
        sb = new StringBuilder();
    }

    int[] getIntArray(int size) throws Exception {
        int[] ret = new int[size];
        for (int i = 0; i < size; ++i) ret[i] = nextInt();
        return ret;
    }

    long[] getLongArray(int size) throws Exception {
        long[] ret = new long[size];
        for (int i = 0; i < size; ++i) ret[i] = nextLong();
        return ret;
    }
}