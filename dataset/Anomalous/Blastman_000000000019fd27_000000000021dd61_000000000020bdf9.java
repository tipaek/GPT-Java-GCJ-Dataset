import java.util.*;
import java.io.*;

public class Solution {

    static final boolean USE_STDIN = true;
    static final String FILE_NAME = "";
    static FastScanner scanner;
    static PrintWriter writer;

    public static void main(String[] args) throws IOException {
        if (USE_STDIN) {
            scanner = new FastScanner();
            writer = new PrintWriter(new OutputStreamWriter(System.out));
        } else {
            scanner = new FastScanner(FILE_NAME + ".in");
            writer = new PrintWriter(new FileWriter(FILE_NAME + ".out"));
        }

        Solver solver = new Solver();
        solver.solve(scanner, writer);
        writer.close();
    }

    static class Solver {
        static final long MOD = (long) 1e9;

        public void solve(FastScanner scanner, PrintWriter writer) throws IOException {
            int testCases = scanner.nextInt();
            int remainingCases = testCases;

            while (testCases-- > 0) {
                int n = scanner.nextInt();
                Point[] points = new Point[n];

                for (int i = 0; i < n; i++) {
                    points[i] = new Point(scanner.nextInt(), scanner.nextInt());
                }

                Arrays.parallelSort(points);

                StringBuilder output = new StringBuilder();
                int lastC = 0, lastJ = 0;

                for (Point point : points) {
                    if (point.start < lastC) {
                        if (point.start < lastJ) {
                            output = new StringBuilder("IMPOSSIBLE");
                            break;
                        } else {
                            output.append("J");
                            lastJ = point.end;
                        }
                    } else {
                        output.append("C");
                        lastC = point.end;
                    }
                }

                System.out.println("Case #" + (remainingCases - testCases) + ": " + output);
            }
        }

        static long gcd(long a, long b) {
            return b == 0 ? a : gcd(b, a % b);
        }

        static long lcm(long a, long b) {
            return a * (b / gcd(a, b));
        }

        static long pow(long base, long exp) {
            if (exp == 0) return 1;
            long half = pow(base, exp / 2);
            long result = half * half % MOD;
            return exp % 2 == 0 ? result : result * base % MOD;
        }
    }

    static class Point implements Comparable<Point> {
        int start;
        int end;

        Point(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Point other) {
            if (this.start == other.start) {
                return this.end - other.end;
            }
            return this.start - other.start;
        }
    }

    public static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(String fileName) {
            try {
                br = new BufferedReader(new FileReader(fileName));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        int nextInt() {
            return Integer.parseInt(nextToken());
        }

        long nextLong() {
            return Long.parseLong(nextToken());
        }

        double nextDouble() {
            return Double.parseDouble(nextToken());
        }

        String nextToken() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        ArrayList<Integer>[] readGraph(int n, int edges) {
            ArrayList<Integer>[] graph = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int i = 0; i < edges; i++) {
                int u = nextInt() - 1;
                int v = nextInt() - 1;
                graph[u].add(v);
                graph[v].add(u);
            }
            return graph;
        }

        Integer[] readIntArray(int n) {
            Integer[] array = new Integer[n];
            for (int i = 0; i < n; i++) {
                array[i] = nextInt();
            }
            return array;
        }

        int[] readIntPrimitiveArray(int n) {
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = nextInt();
            }
            return array;
        }

        Long[] readLongArray(int n) {
            Long[] array = new Long[n];
            for (int i = 0; i < n; i++) {
                array[i] = nextLong();
            }
            return array;
        }

        long[] readLongPrimitiveArray(int n) {
            long[] array = new long[n];
            for (int i = 0; i < n; i++) {
                array[i] = nextLong();
            }
            return array;
        }

        String[] readStringArray(int n) {
            String[] array = new String[n];
            for (int i = 0; i < n; i++) {
                array[i] = nextToken();
            }
            return array;
        }
    }
}