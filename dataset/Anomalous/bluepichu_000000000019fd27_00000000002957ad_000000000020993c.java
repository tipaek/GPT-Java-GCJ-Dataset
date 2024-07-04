import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class A {
    public static final boolean DEBUG = false;

    public static void main(String[] args) throws Exception {
        PrintWriter pw = new PrintWriter(System.out);
        FastScan sc = new FastScan();

        int testCases = sc.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            int trace = 0;
            int duplicateRows = 0;
            int duplicateCols = 0;

            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    rowSet.add(matrix[i][j]);
                    colSet.add(matrix[j][i]);
                }
                if (rowSet.size() < n) duplicateRows++;
                if (colSet.size() < n) duplicateCols++;
            }

            pw.printf("Case #%d: %d %d %d%n", t, trace, duplicateRows, duplicateCols);
        }

        pw.close();
        sc.close();
    }

    public static void debug(Object obj, String end) {
        if (DEBUG) {
            if (obj instanceof boolean[]) {
                System.err.print(Arrays.toString((boolean[]) obj));
            } else if (obj instanceof byte[]) {
                System.err.print(Arrays.toString((byte[]) obj));
            } else if (obj instanceof short[]) {
                System.err.print(Arrays.toString((short[]) obj));
            } else if (obj instanceof char[]) {
                System.err.print(Arrays.toString((char[]) obj));
            } else if (obj instanceof int[]) {
                System.err.print(Arrays.toString((int[]) obj));
            } else if (obj instanceof long[]) {
                System.err.print(Arrays.toString((long[]) obj));
            } else if (obj instanceof float[]) {
                System.err.print(Arrays.toString((float[]) obj));
            } else if (obj instanceof double[]) {
                System.err.print(Arrays.toString((double[]) obj));
            } else if (obj instanceof Object[]) {
                debug((Object[]) obj);
            } else {
                System.err.print(obj);
            }
            System.err.print(end);
        }
    }

    public static void debug(Object... args) {
        if (DEBUG) {
            System.err.print("#");
            for (Object arg : args) {
                debug(arg, " ");
            }
            System.err.println();
        }
    }

    public static void debug(Suspended sus) {
        if (DEBUG) {
            debug(sus.eval());
        }
    }

    public static void debugGrid(int[][] grid) {
        if (DEBUG) {
            for (int[] row : grid) {
                System.out.print("#");
                for (int cell : row) {
                    System.out.print(String.format("%3d ", cell));
                }
                System.out.println();
            }
        }
    }

    static class FastScan {
        BufferedReader br;
        StringTokenizer st;

        public FastScan() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String nextLine() throws Exception {
            return br.readLine();
        }

        public String nextToken() throws Exception {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(nextLine(), " ");
            }
            return st.nextToken();
        }

        public int nextInt() throws Exception {
            return Integer.parseInt(nextToken());
        }

        public long nextLong() throws Exception {
            return Long.parseLong(nextToken());
        }

        public double nextDouble() throws Exception {
            return Double.parseDouble(nextToken());
        }

        public void close() throws Exception {
            br.close();
        }
    }
}

interface Suspended {
    Object eval();
}