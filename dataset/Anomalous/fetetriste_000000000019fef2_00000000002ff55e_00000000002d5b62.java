import java.io.*;
import java.util.*;

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
        ExpogoSolver solver = new ExpogoSolver();
        solver.solve(1, in, out);
        out.close();
    }

    static class ExpogoSolver {
        private final Map<String, String> cache = new HashMap<>();

        public void solve(int testNumber, FastScanner in, PrintWriter out) {
            int numTests = in.nextInt();
            for (int test = 1; test <= numTests; test++) {
                int x = in.nextInt();
                int y = in.nextInt();
                out.printf("Case #%d: %s\n", test, findPath(x, y));
            }
        }

        private String findPath(int x, int y) {
            StringBuilder result = new StringBuilder();
            while (x != 0 || y != 0) {
                if (x == 0 && Math.abs(y) == 1) {
                    result.append(y < 0 ? "S" : "N");
                    y -= Math.signum(y);
                } else if (y == 0 && Math.abs(x) == 1) {
                    result.append(x < 0 ? "W" : "E");
                    x -= Math.signum(x);
                } else if (isEven(x)) {
                    if (isEven(y)) {
                        return "IMPOSSIBLE";
                    }
                    if (isEven((y + 1) / 2) != isEven(x / 2)) {
                        y++;
                        result.append("S");
                    } else {
                        y--;
                        result.append("N");
                    }
                } else {
                    if (!isEven(y)) {
                        return "IMPOSSIBLE";
                    }
                    if (isEven((x + 1) / 2) != isEven(y / 2)) {
                        x++;
                        result.append("W");
                    } else {
                        x--;
                        result.append("E");
                    }
                }
                if (!isEven(x) || !isEven(y)) {
                    throw new AssertionError(x + " " + y);
                }
                x /= 2;
                y /= 2;
            }
            return result.toString();
        }

        private boolean isEven(int number) {
            return number % 2 == 0;
        }

        private void dummyPrecalc() {
            char[] directions = "NESW".toCharArray();
            for (int length = 1; length <= 10; length++) {
                char[] buffer = new char[length];
                for (int mask = 0; mask < 1 << (2 * length); mask++) {
                    for (int i = 0; i < length; i++) {
                        buffer[i] = directions[(mask >> (2 * i)) & 3];
                    }
                    int[] coordinates = tracePath(new String(buffer));
                    String key = coordinates[0] + " " + coordinates[1];
                    cache.putIfAbsent(key, new String(buffer));
                }
            }
        }

        private String dummy(int x, int y) {
            return cache.getOrDefault(x + " " + y, "IMPOSSIBLE");
        }

        private int[] tracePath(String path) {
            int x = 0, y = 0;
            for (int i = 0; i < path.length(); i++) {
                int dx = 0, dy = 0;
                switch (path.charAt(i)) {
                    case 'N': dy = 1; break;
                    case 'S': dy = -1; break;
                    case 'E': dx = 1; break;
                    case 'W': dx = -1; break;
                }
                x += dx * (1 << i);
                y += dy * (1 << i);
            }
            return new int[]{x, y};
        }
    }

    static class FastScanner {
        private final BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
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
    }
}