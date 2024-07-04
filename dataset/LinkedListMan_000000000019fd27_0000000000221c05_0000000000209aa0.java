import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        FastReader scan = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        Task solver = new Task();
        int t = scan.nextInt();
        for(int tt = 1; tt <= t; tt++) solver.solve(tt, scan, out);
        out.close();
    }

    static class Task {
        int n, k;
        int[][] a;

        public void solve(int testNumber, FastReader scan, PrintWriter out) {
            out.printf("Case #%d: ", testNumber);
            n = scan.nextInt();
            k = scan.nextInt();
            a = new int[n][n];
            for(int i = 1; i <= n; i++) {
                a[0][0] = i;
                if(go(0, 0)) {
                    out.println("POSSIBLE");
                    for(int j = 0; j < n; j++) {
                        for(int k = 0; k < n; k++) {
                            out.printf("%d ", a[j][k]);
                        }
                        out.println();
                    }
                    return;
                }
            }
            out.println("IMPOSSIBLE");
        }

        boolean go(int row, int col) {
            if(!check(row, col)) return false;
            if(row == n - 1 && col == n - 1) {
                return sum() == k;
            }
            int nrow = col == n - 1 ? row + 1 : row;
            int ncol = col == n - 1 ? 0 : col + 1;
            for(int i = 1; i <= n; i++) {
                a[nrow][ncol] = i;
                if(go(nrow, ncol)) return true;
            }
            a[nrow][ncol] = 0;
            return false;
        }

        boolean check(int r, int c) {
            for(int i = 0; i < n; i++) {
                if(a[r][i] == a[r][c] && i != c) return false;
                if(a[i][c] == a[r][c] && i != r) return false;
            }
            return true;
        }

        int sum() {
            int ret = 0;
            for(int i = 0; i < n; i++) ret += a[i][i];
            return ret;
        }

    }

    static void shuffle(int[] a) {
        Random get = new Random();
        for (int i = 0; i < a.length; i++) {
            int r = get.nextInt(a.length);
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    static void shuffle(long[] a) {
        Random get = new Random();
        for (int i = 0; i < a.length; i++) {
            int r = get.nextInt(a.length);
            long temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
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