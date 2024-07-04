import java.util.*;
import java.io.*;

public class Solution {
    private static final long REM = 1000000000L;
    private InputReader sc;
    private boolean singleTest = false;

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
        sc = new InputReader();
        int tests = singleTest ? 1 : sc.nextInt();
        for (int t = 1; t <= tests; t++) {
            solve(t);
        }
    }

    private void solve(int test) {
        int x = sc.nextInt();
        int y = sc.nextInt();
        if ((x % 2) == (y % 2)) {
            println("Case #" + test + ": IMPOSSIBLE");
            return;
        }

        int x1 = x;
        int y1 = y;
        x = Math.abs(x);
        y = Math.abs(y);
        int sum = x + y;
        int maxI = Integer.SIZE - Integer.numberOfLeadingZeros(sum) - 1;
        boolean[] pos = new boolean[maxI + 1];

        for (int i = maxI; i >= 0; i--) {
            if (sum > 0) {
                pos[i] = true;
                sum -= (1 << i);
            } else if (sum < 0) {
                pos[i] = false;
                sum += (1 << i);
            } else {
                println("Case #" + test + ": IMPOSSIBLE");
                return;
            }
        }

        boolean[] horPart = new boolean[maxI + 1];
        boolean toggle = false;

        while (x > 0) {
            int msb = Integer.SIZE - Integer.numberOfLeadingZeros(x) - 1;
            if (check(x, toggle, pos)) {
                for (int i = 0; i <= msb; i++) {
                    if ((x & (1 << i)) > 0) {
                        horPart[i] = true;
                    }
                }
                x = 0;
            } else if (!toggle) {
                while (msb <= maxI && !pos[msb]) {
                    msb++;
                }
                if (msb > maxI) {
                    println("Case #" + test + ": IMPOSSIBLE");
                    return;
                }
                horPart[msb] = true;
                x = (1 << msb) - x;
                toggle = true;
            } else {
                while (msb <= maxI && pos[msb]) {
                    msb++;
                }
                if (msb > maxI) {
                    println("Case #" + test + ": IMPOSSIBLE");
                    return;
                }
                horPart[msb] = true;
                x = (1 << msb) - x;
                toggle = false;
            }
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i <= maxI; i++) {
            if (horPart[i]) {
                res.append(pos[i] ? (x1 < 0 ? "W" : "E") : (x1 < 0 ? "E" : "W"));
            } else {
                res.append(pos[i] ? (y1 < 0 ? "S" : "N") : (y1 < 0 ? "N" : "S"));
            }
        }

        println("Case #" + test + ": " + res);
    }

    private boolean check(int x, boolean toggle, boolean[] pos) {
        for (int i = 0; i < pos.length; i++) {
            if (((x >> i) & 1) > 0 && pos[i] != toggle) {
                return false;
            }
        }
        return true;
    }

    private void println(String str) {
        System.out.println(str);
    }

    private static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader() {
            this(System.in);
        }

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}