import java.util.*;
import java.io.*;

public class Solution {
    public static final boolean DEBUG = false;

    public static void main(String[] args) throws Exception {
        PrintWriter pw = new PrintWriter(System.out);
        FastScan sc = new FastScan();

        int cases = sc.nextInt();

        for (int t = 1; t <= cases; t++) {
            String a = sc.nextToken();
            String b = sc.nextToken();

            int[][] dp = new int[a.length() + 1][b.length() + 1];
            Pair[][] prev = new Pair[a.length() + 1][b.length() + 1];

            for (int i = 0; i <= a.length(); i++) {
                for (int j = 0; j <= b.length(); j++) {
                    if (i == 0 && j == 0) continue;

                    int best = Integer.MAX_VALUE;
                    Pair p = null;

                    if (i > 0) {
                        int cost = dp[i - 1][j] + 1;
                        if (cost < best) {
                            best = cost;
                            p = new Pair(i - 1, j);
                        }
                    }

                    if (j > 0) {
                        int cost = dp[i][j - 1] + 1;
                        if (cost < best) {
                            best = cost;
                            p = new Pair(i, j - 1);
                        }
                    }

                    if (i > 0 && j > 0) {
                        int cost = dp[i - 1][j - 1] + (a.charAt(i - 1) == b.charAt(j - 1) ? 0 : 1);
                        if (cost < best) {
                            best = cost;
                            p = new Pair(i - 1, j - 1);
                        }
                    }

                    dp[i][j] = best;
                    prev[i][j] = p;
                }
            }

            int dist = dp[a.length()][b.length()];

            int i = a.length();
            int j = b.length();

            while (dp[i][j] > dist / 2) {
                Pair p = prev[i][j];
                i = p.i;
                j = p.j;
            }

            pw.printf("Case #%d: %s\n", t, b.substring(0, j) + a.substring(i));
        }

        pw.close();
        sc.close();
    }

    static class Pair {
        int i, j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void debug(Object obj, String end) {
        if (DEBUG) {
            if (obj instanceof boolean[]) {
                System.out.print(Arrays.toString((boolean[]) obj));
            } else if (obj instanceof byte[]) {
                System.out.print(Arrays.toString((byte[]) obj));
            } else if (obj instanceof short[]) {
                System.out.print(Arrays.toString((short[]) obj));
            } else if (obj instanceof char[]) {
                System.out.print(Arrays.toString((char[]) obj));
            } else if (obj instanceof int[]) {
                System.out.print(Arrays.toString((int[]) obj));
            } else if (obj instanceof long[]) {
                System.out.print(Arrays.toString((long[]) obj));
            } else if (obj instanceof float[]) {
                System.out.print(Arrays.toString((float[]) obj));
            } else if (obj instanceof double[]) {
                System.out.print(Arrays.toString((double[]) obj));
            } else if (obj instanceof Object[]) {
                debug((Object[]) obj);
            } else {
                System.out.print(obj);
            }
            System.out.print(end);
        }
    }

    public static void debug(Object... args) {
        if (DEBUG) {
            System.out.print("#");
            for (Object arg : args) {
                debug(arg, " ");
            }
            System.out.println();
        }
    }

    public static void debugGrid(int[][] grid) {
        if (DEBUG) {
            for (int[] row : grid) {
                System.out.print("#");
                for (int cell : row) {
                    System.out.printf("%3d ", cell);
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

        public String nextToken() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(nextLine());
            }
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(nextToken());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(nextToken());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(nextToken());
        }

        public void close() throws IOException {
            br.close();
        }
    }
}