import java.util.*;
import java.io.*;

public class Solution {
    public static final boolean DEBUG = false;

    public static void main(String[] args) throws Exception {
        PrintWriter pw = new PrintWriter(System.out);
        FastScan sc = new FastScan();

        int cases = sc.nextInt();

        for (int t = 1; t <= cases; t++) {
            String str = sc.nextLine();
            pw.printf("Case #%d: ", t);

            int level = 0;

            for (int i = 0; i < str.length(); i++) {
                int digit = str.charAt(i) - '0';

                while (level < digit) {
                    pw.print("(");
                    level++;
                }

                while (level > digit) {
                    pw.print(")");
                    level--;
                }

                pw.print(str.charAt(i));
            }

            while (level > 0) {
                pw.print(")");
                level--;
            }

            pw.println();
        }

        pw.close();
        sc.close();
    }

    // Debugging functions
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

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(nextLine(), " ");
            }
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        public void close() throws IOException {
            br.close();
        }
    }
}

interface Suspended {
    Object eval();
}