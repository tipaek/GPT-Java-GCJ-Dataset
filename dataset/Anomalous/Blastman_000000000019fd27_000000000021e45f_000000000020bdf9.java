import java.util.*;
import java.io.*;

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
        solver.solve(scanner, writer);
        writer.close();
    }

    static class Solver {
        static final long MOD = 1_000_000_000L;

        public void solve(FastScanner scanner, PrintWriter writer) throws IOException {
            int testCaseCount = scanner.nextInt();
            for (int testCase = 1; testCase <= testCaseCount; testCase++) {
                int n = scanner.nextInt();
                Point[] points = new Point[n];
                char[] result = new char[n];

                for (int i = 0; i < n; i++) {
                    points[i] = new Point(scanner.nextInt(), scanner.nextInt(), i);
                }

                Arrays.sort(points);

                int lastC = 0, lastJ = 0;
                boolean isPossible = true;

                for (Point point : points) {
                    if (point.start < lastC) {
                        if (point.start < lastJ) {
                            isPossible = false;
                            break;
                        } else {
                            result[point.index] = 'J';
                            lastJ = point.end;
                        }
                    } else {
                        result[point.index] = 'C';
                        lastC = point.end;
                    }
                }

                if (isPossible) {
                    writer.printf("Case #%d: %s%n", testCase, new String(result));
                } else {
                    writer.printf("Case #%d: IMPOSSIBLE%n", testCase);
                }
            }
        }

        static long gcd(long a, long b) {
            while (b != 0) {
                long temp = b;
                b = a % b;
                a = temp;
            }
            return a;
        }

        static long lcm(long a, long b) {
            return a * (b / gcd(a, b));
        }

        static long pow(long base, long exp) {
            if (exp == 0) return 1;
            long half = pow(base, exp / 2);
            long result = (half * half) % MOD;
            return exp % 2 == 0 ? result : (result * base) % MOD;
        }
    }

    static class Point implements Comparable<Point> {
        int start, end, index;

        Point(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        @Override
        public int compareTo(Point other) {
            if (this.start == other.start) {
                return Integer.compare(this.end, other.end);
            }
            return Integer.compare(this.start, other.start);
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

        String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return tokenizer.nextToken();
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
                str = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}