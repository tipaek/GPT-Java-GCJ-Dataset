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
    final long MOD = (long) 1e9 + 7;

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

        for (i = 1; ; ++i) {
            if (L >= R) {
                if (i > L) break;
                L -= i;
            } else {
                if (i > R) break;
                R -= i;
            }
        }
        hp.println((i - 1) + " " + L + " " + R);
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