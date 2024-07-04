import java.io.*;
import java.util.*;

public class Solution {
    FastScanner in;
    PrintWriter out;

    boolean movesLeft(long l, long r) {
        return l >= r;
    }

    long sum(long startFrom, long mid) {
        return (startFrom + startFrom + (mid - 1) * 2) / 2 * mid;
    }

    long canSubCnt(long curValue, long startFrom) {
        long l = 0, r = (long) 2e9;
        while (r - l > 1) {
            long mid = (l + r) >> 1;
            long sum = sum(startFrom, mid);
            if (sum <= curValue) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return l * 2 + startFrom - 1;
    }

    void solve() {
        int tc = in.nextInt();
        for (int t = 0; t < tc; t++) {
            long l = in.nextLong();
            long r = in.nextLong();
            boolean startMoveLeft = movesLeft(l, r);
            long from = 0, to = (long) 3e9;
            while (to - from > 1) {
                long mid = (from + to) >>> 1;
                long sum = (1 + mid) * mid / 2;
                long nl = l - (startMoveLeft ? sum : 0);
                long nr = r - (startMoveLeft ? 0 : sum);
                boolean nextMoveLeft = movesLeft(nl, nr);
                if (nextMoveLeft != startMoveLeft) {
                    to = mid;
                } else {
                    from = mid;
                }
            }
            to -= 1;
            // after [1 .. to] -> changed
            long sum = (1 + to) * to / 2;
            if (startMoveLeft) {
                l -= sum;
            } else {
                r -= sum;
            }
            long leftRes, rightRes;
            if (startMoveLeft) {
                leftRes = canSubCnt(l, to + 1);
                rightRes = canSubCnt(r, to + 2);
            } else {
                leftRes = canSubCnt(l, to + 2);
                rightRes = canSubCnt(r, to + 1);
            }
            long lastValue = Math.min(leftRes, rightRes);
            if (startMoveLeft) {
                l -= sum(to + 1, segCnt(to + 1, lastValue));
                r -= sum(to + 2, segCnt(to + 2, lastValue));
            } else {
                r -= sum(to + 1, segCnt(to + 1, lastValue));
                l -= sum(to + 2, segCnt(to + 2, lastValue));
            }
            out.println("Case #" + (t + 1) + ": " + lastValue + " " + l + " " + r);
        }
    }

    long segCnt(long from, long to) {
        if (to < from) {
            return 0;
        }
        return 1 + (to - from) / 2;
    }

    void run() {
        try {
            in = new FastScanner(new File("Solution.in"));
            out = new PrintWriter(new File("Solution.out"));

            solve();

            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    void runIO() {

        in = new FastScanner(System.in);
        out = new PrintWriter(System.out);

        solve();

        out.close();
    }

    class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(File f) {
            try {
                br = new BufferedReader(new FileReader(f));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public FastScanner(InputStream f) {
            br = new BufferedReader(new InputStreamReader(f));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                String s = null;
                try {
                    s = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (s == null)
                    return null;
                st = new StringTokenizer(s);
            }
            return st.nextToken();
        }

        boolean hasMoreTokens() {
            while (st == null || !st.hasMoreTokens()) {
                String s = null;
                try {
                    s = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (s == null)
                    return false;
                st = new StringTokenizer(s);
            }
            return true;
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
    }

    public static void main(String[] args) {
        new Solution().runIO();
    }
}