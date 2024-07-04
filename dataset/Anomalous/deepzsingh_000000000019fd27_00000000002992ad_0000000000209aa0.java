import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[][] sqr;
    static boolean[][] rowSafe;
    static boolean[][] colSafe;
    static int n;
    static int k;
    static int caseNumber;
    static boolean solved;

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
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

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();

        while (t-- > 0) {
            caseNumber++;
            n = sc.nextInt();
            k = sc.nextInt();
            sqr = new int[n + 1][n + 1];
            rowSafe = new boolean[n + 1][n + 1];
            colSafe = new boolean[n + 1][n + 1];
            solved = false;
            solve(1, 1, 0);
            if (!solved) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }
        }
    }

    public static void solve(int row, int col, int m) {
        if (row == n && col == n + 1 && m == k && !solved) {
            solved = true;
            System.out.println("Case #" + caseNumber + ": POSSIBLE");
            for (int i = 1; i <= n; ++i) {
                for (int j = 1; j <= n; ++j) {
                    System.out.print(sqr[i][j] + " ");
                }
                System.out.println();
            }
            return;
        } else if (row > n) {
            return;
        } else if (col > n) {
            solve(row + 1, 1, m);
            return;
        }

        for (int i = 1; i <= n && !solved; ++i) {
            if (!rowSafe[row][i] && !colSafe[col][i]) {
                rowSafe[row][i] = colSafe[col][i] = true;
                if (row == col) {
                    m += i;
                }
                sqr[row][col] = i;

                solve(row, col + 1, m);

                rowSafe[row][i] = colSafe[col][i] = false;
                if (row == col) {
                    m -= i;
                }
                sqr[row][col] = 0;
            }
        }
    }
}