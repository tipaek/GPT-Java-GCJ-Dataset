import java.io.*;
import java.util.*;

public class Solution {

    static final boolean USE_STDIN = true;
    static final String FILENAME = "";
    static FastScanner scanner;
    static PrintWriter writer;

    public static void main(String[] args) throws IOException {
        if (USE_STDIN) {
            scanner = new FastScanner();
            writer = new PrintWriter(new OutputStreamWriter(System.out));
        } else {
            scanner = new FastScanner(FILENAME + ".in");
            writer = new PrintWriter(new FileWriter(FILENAME + ".out"));
        }

        Solver solver = new Solver();
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            System.out.print("Case #" + i + ": ");
            solver.solve(scanner, writer);
        }
        writer.close();
    }

    static class Solver {
        static final long MOD = (long) 1e20 + 7;

        public void solve(FastScanner scanner, PrintWriter writer) throws IOException {
            long x = scanner.nextLong();
            long y = scanner.nextLong();
            int[] result = null;

            if (Math.abs(x) != Math.abs(y)) {
                for (int i = 0; i < 8; i++) {
                    result = findPath(x, y, true, i);
                    if (result != null) break;
                    result = findPath(x, y, false, i);
                    if (result != null) break;
                }
            }

            if (result == null) {
                System.out.println("IMPOSSIBLE");
            } else {
                for (int dir : result) {
                    if (dir == 1) System.out.print("S");
                    else if (dir == 2) System.out.print("N");
                    else if (dir == 3) System.out.print("W");
                    else if (dir == 4) System.out.print("E");
                }
                System.out.println();
            }
        }

        static int[] findPath(long x, long y, boolean vertical, int jump) {
            int[] path = new int[jump + 1];
            if (vertical) {
                if (y < 0) {
                    y += 1L << jump;
                    path[jump] = 1;
                } else if (y > 0) {
                    y -= 1L << jump;
                    path[jump] = 2;
                } else {
                    return null;
                }
            } else {
                if (x < 0) {
                    x += 1L << jump;
                    path[jump] = 3;
                } else if (x > 0) {
                    x -= 1L << jump;
                    path[jump] = 4;
                } else {
                    return null;
                }
            }

            if (jump == 0) {
                return (x == 0 && y == 0) ? path : null;
            } else {
                jump--;
                int[] subPath = findPath(x, y, true, jump);
                if (subPath != null) {
                    System.arraycopy(subPath, 0, path, 0, jump + 1);
                } else {
                    subPath = findPath(x, y, false, jump);
                    if (subPath != null) {
                        System.arraycopy(subPath, 0, path, 0, jump + 1);
                    } else {
                        return null;
                    }
                }
                return path;
            }
        }

        static long gcd(long a, long b) {
            return (b == 0) ? a : gcd(b, a % b);
        }

        static long lcm(long a, long b) {
            return a * (b / gcd(a, b));
        }

        static long pow(long base, long exp) {
            if (exp == 0) return 1;
            long half = pow(base, exp / 2);
            long result = (half * half) % MOD;
            return (exp % 2 == 0) ? result : (result * base) % MOD;
        }
    }

    static class Point implements Comparable<Point> {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point other) {
            return (x == other.x) ? y - other.y : x - other.x;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj instanceof Point) {
                Point other = (Point) obj;
                return x == other.x && y == other.y;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return 31 * x + y;
        }
    }

    public static class FastScanner {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public FastScanner(String fileName) {
            try {
                reader = new BufferedReader(new FileReader(fileName));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
        }

        private String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
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

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                return "";
            }
        }

        public int[] nextIntArray(int n) {
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = nextInt();
            }
            return array;
        }

        public long[] nextLongArray(int n) {
            long[] array = new long[n];
            for (int i = 0; i < n; i++) {
                array[i] = nextLong();
            }
            return array;
        }

        public String[] nextStringArray(int n) {
            String[] array = new String[n];
            for (int i = 0; i < n; i++) {
                array[i] = next();
            }
            return array;
        }
    }
}