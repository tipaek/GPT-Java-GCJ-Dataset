import java.io.*;
import java.util.*;

public class Solution {
    FastScanner in;
    PrintWriter out;

    String solve(long x, long y, int d) {
        if (d == 33) {
            return null;
        }
        if (x == 0 && y == 0) {
            return "";
        }
        long step = 1L << d;
        boolean needX = Math.abs(x) % (2 * step) != 0;
        boolean needY = Math.abs(y) % (2 * step) != 0;
        if (needX && needY) {
            return null;
        }
        if (!needX && !needY) {
            return null;
        }
        if (needX) {
            String left = solve(x + step, y, 1 + d);
            String right = solve(x - step, y, 1 + d);
            if (left == null && right == null) {
                return null;
            }
            if (left == null) {
                return "E" + right;
            }
            if (right == null) {
                return "W" + left;
            }
            if (left.length() < right.length()) {
                return "W" + left;
            }
            return "E" + right;
        }
        String up = solve(x, y - step, 1 + d);
        String down = solve(x, y + step, 1 + d);
        if (up == null && down == null) {
            return null;
        }
        if (up == null) {
            return "S" + down;
        }
        if (down == null) {
            return "N" + up;
        }
        if (up.length() < down.length()) {
            return "N" + up;
        }
        return "S" + down;
    }

    void solve() {
        int tc = in.nextInt();
        for (int t = 0; t < tc; t++) {
            int x = in.nextInt();
            int y = in.nextInt();
            String ans = solve(x, y, 0);
            out.println("Case #" + (t + 1) + ": " + (ans == null ? "IMPOSSIBLE" : ans));
        }
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