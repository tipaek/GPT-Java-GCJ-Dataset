import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        final long MOD = 1000000007;
        int t = sc.nextInt();
        int caseNumber = 0;
        Solution sol = new Solution();

        while (caseNumber++ < t) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            String result = sol.solve(n, matrix);
            out.println("Case #" + caseNumber + ": " + result);
        }
        out.close();
    }

    public String solve(int n, int[][] matrix) {
        int trace = 0, rowRepeats = 0, colRepeats = 0;

        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }

        for (int i = 0; i < n; i++) {
            boolean[] rowSet = new boolean[n + 1];
            for (int j = 0; j < n; j++) {
                if (rowSet[matrix[i][j]]) {
                    rowRepeats++;
                    break;
                }
                rowSet[matrix[i][j]] = true;
            }
        }

        for (int i = 0; i < n; i++) {
            boolean[] colSet = new boolean[n + 1];
            for (int j = 0; j < n; j++) {
                if (colSet[matrix[j][i]]) {
                    colRepeats++;
                    break;
                }
                colSet[matrix[j][i]] = true;
            }
        }

        return trace + " " + rowRepeats + " " + colRepeats;
    }

    public long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    // FastScanner for faster input
    public static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
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
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}