import java.io.*;
import java.util.*;

class Pair implements Comparable<Pair> {
    int u, v, index;

    public Pair(int u, int v, int index) {
        this.u = u;
        this.v = v;
        this.index = index;
    }

    @Override
    public int compareTo(Pair p) {
        return Integer.compare(this.u, p.u);
    }
}

public class Solution {
    public static void main(String[] args) {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    solve();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }, "Anshum Gupta", 1 << 26).start();
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static boolean isPossible(int[][] arr, int i, int j, int value) {
        int n = arr.length;
        for (int x = 0; x < i; x++) {
            if (arr[x][j] == value) return false;
        }
        for (int x = 0; x < j; x++) {
            if (arr[i][x] == value) return false;
        }
        return true;
    }

    static boolean fill(int[][] arr, int i, int j, int k) {
        int n = arr.length;
        if (j == n) {
            j = 0;
            i++;
        }
        if (i == n) {
            return true;
        }

        if (i == j) {
            for (int x = Math.max(1, k - (n - i - 1) * n); x <= Math.min(k - (n - i - 1), n); x++) {
                if (isPossible(arr, i, j, x)) {
                    arr[i][j] = x;
                    if (fill(arr, i, j + 1, k - x)) {
                        return true;
                    } else {
                        arr[i][j] = 0;
                    }
                }
            }
            return false;
        } else {
            for (int x = 1; x <= n; x++) {
                if (isPossible(arr, i, j, x)) {
                    arr[i][j] = x;
                    if (fill(arr, i, j + 1, k)) {
                        return true;
                    } else {
                        arr[i][j] = 0;
                    }
                }
            }
            return false;
        }
    }

    public static void solve() throws Exception {
        MyScanner s = new MyScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int t = s.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            int n = s.nextInt();
            int k = s.nextInt();
            int[][] arr = new int[n][n];

            if (fill(arr, 0, 0, k)) {
                out.println("Case #" + tc + ": POSSIBLE");
                for (int[] row : arr) {
                    for (int val : row) {
                        out.print(val + " ");
                    }
                    out.println();
                }
            } else {
                out.println("Case #" + tc + ": IMPOSSIBLE");
            }
        }
        out.close();
    }

    static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
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

        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }

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