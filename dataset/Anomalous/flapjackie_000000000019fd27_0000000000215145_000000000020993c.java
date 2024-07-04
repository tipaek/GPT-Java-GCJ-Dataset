import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FastScanner sc = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int T = sc.nextInt();

        for (int ca = 1; ca <= T; ca++) {
            int n = sc.nextInt();
            int[][] board = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    board[i][j] = sc.nextInt();
                }
            }

            int trace = calculateTrace(board, n);
            int r = countDuplicateRows(board, n);
            int c = countDuplicateColumns(board, n);

            out.printf("Case #%d: %d %d %d\n", ca, trace, r, c);
        }
        out.close();
    }

    private static int calculateTrace(int[][] board, int n) {
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += board[i][i];
        }
        return trace;
    }

    private static int countDuplicateRows(int[][] board, int n) {
        int r = 0;
        for (int i = 0; i < n; i++) {
            if (hasDuplicates(board[i])) {
                r++;
            }
        }
        return r;
    }

    private static int countDuplicateColumns(int[][] board, int n) {
        int c = 0;
        for (int i = 0; i < n; i++) {
            int[] column = new int[n];
            for (int j = 0; j < n; j++) {
                column[j] = board[j][i];
            }
            if (hasDuplicates(column)) {
                c++;
            }
        }
        return c;
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> seen = new HashSet<>();
        for (int num : array) {
            if (!seen.add(num)) {
                return true;
            }
        }
        return false;
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(InputStream i) {
            br = new BufferedReader(new InputStreamReader(i));
            st = new StringTokenizer("");
        }

        public String next() throws IOException {
            while (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
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
    }
}