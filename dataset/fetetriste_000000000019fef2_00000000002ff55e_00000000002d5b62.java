import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.PrintStream;
import java.util.HashMap;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Map;
import java.io.BufferedReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastScanner in = new FastScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        A_Expogo solver = new A_Expogo();
        solver.solve(1, in, out);
        out.close();
    }

    static class A_Expogo {
        Map<String, String> cache = new HashMap<>();

        public void solve(int testNumber, FastScanner in, PrintWriter out) {
            if (false) {
//        if (true) {
                dummyPrecalc();
                final int R = 100;
                for (int x = -R; x < R; x++) {
                    for (int y = -R; y < R; y++) {
                        if (x == 0 && y == 0) {
                            continue;
                        }
                        String str = solve(x, y);
                        String dstr = dummy(x, y);
                        if (str.startsWith("I") != dstr.startsWith("I")) {
                            System.out.println(x + " " + y);
                            System.out.println(str);
                            System.out.println(dstr);
                            throw new AssertionError();
                        }
                        if (!str.startsWith("I")) {
                            if (str.length() != dstr.length()) {
                                System.out.println(str);
                                System.out.println(dstr);
                                throw new AssertionError(x + " " + y);
                            }
                            int[] cs = trace(str);
                            if (x != cs[0] || y != cs[1]) {
                                throw new AssertionError(x + " " + y);
                            }
                        }
                    }
                }
            }

            int numTests = in.nextInt();
            for (int test = 1; test <= numTests; test++) {
                int x = in.nextInt();
                int y = in.nextInt();
                out.printf("Case #%d: %s\n", test, solve(x, y));
            }
        }

        private String solve(int x, int y) {
            StringBuilder res = new StringBuilder();
            while (x != 0 || y != 0) {
                if (x == 0 && Math.abs(y) == 1) {
                    res.append(y < 0 ? "S" : "N");
                    y -= Math.signum(y);
                } else if (y == 0 && Math.abs(x) == 1) {
                    res.append(x < 0 ? "W" : "E");
                    x -= Math.signum(x);
                } else if (e(x)) {
                    if (e(y)) {
                        return "IMPOSSIBLE";
                    }
                    if (e((y + 1) / 2) != e(x / 2)) {
                        ++y;
                        res.append("S");
                    } else {
                        --y;
                        res.append("N");
                    }
                } else {
                    if (!e(y)) {
                        return "IMPOSSIBLE";
                    }
                    if (e((x + 1) / 2) != e(y / 2)) {
                        ++x;
                        res.append("W");
                    } else {
                        --x;
                        res.append("E");
                    }
                }
                if (!e(x) || !e(y)) {
                    throw new AssertionError(x + " " + y);
                }
                x /= 2;
                y /= 2;
            }
            return res.toString();
        }

        private boolean e(int x) {
            return x % 2 == 0;
        }

        private void dummyPrecalc() {
            char[] dirs = "NESW".toCharArray();
            for (int len = 1; len <= 10; len++) {
                char[] buf = new char[len];
                for (int mask = 0; mask < 1 << (2 * len); mask++) {
                    for (int i = 0; i < len; i++) {
                        buf[i] = dirs[(mask >> (2 * i)) & 3];
                    }
                    int[] cs = trace(new String(buf));
                    String key = cs[0] + " " + cs[1];
                    if (!cache.containsKey(key)) {
                        cache.put(key, new String(buf));
                    }
                }
            }
        }

        private String dummy(int x, int y) {
            String ret = cache.get(x + " " + y);
            if (ret == null) {
                return "IMPOSSIBLE";
            }
            return ret;
        }

        private int[] trace(String str) {
            int x = 0;
            int y = 0;
            for (int i = 0; i < str.length(); i++) {
                int dx = 0;
                int dy = 0;
                switch (str.charAt(i)) {
                    case 'N':
                        dy = 1;
                        break;
                    case 'S':
                        dy = -1;
                        break;
                    case 'E':
                        dx = 1;
                        break;
                    case 'W':
                        dx = -1;
                        break;
                }
                x += dx * (1 << i);
                y += dy * (1 << i);
            }
            return new int[]{x, y};
        }

    }

    static class FastScanner {
        private BufferedReader in;
        private StringTokenizer st;

        public FastScanner(InputStream stream) {
            in = new BufferedReader(new InputStreamReader(stream));
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(in.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

