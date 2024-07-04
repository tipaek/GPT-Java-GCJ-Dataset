import java.awt.*;
import java.io.*;
import java.util.*;

public class Solution {
    static int n, k;
    static int[][] arr;
    static boolean[][] visR, visC;

    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        for (int tst = 1; tst <= t; tst++) {
            StringBuilder sb = new StringBuilder();
            sb.append("Case #").append(tst).append(": ");
            n = sc.nextInt();
            k = sc.nextInt();
            arr = new int[n][n];
            visR = new boolean[n + 1][n + 1];
            visC = new boolean[n + 1][n + 1];
            if (dfs(0, 0)) {
                sb.append("POSSIBLE\n");
                for (int[] row : arr) {
                    for (int val : row) {
                        sb.append(val).append(" ");
                    }
                    sb.append("\n");
                }
            } else {
                sb.append("IMPOSSIBLE\n");
            }
            System.out.print(sb);
        }
    }

    static boolean isSolutionValid() {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            boolean[] doneRow = new boolean[n + 1];
            for (int j = 0; j < n; j++) {
                if (i == j) sum += arr[i][j];
                if (doneRow[arr[i][j]]) return false;
                doneRow[arr[i][j]] = true;
            }
        }
        for (int j = 0; j < n; j++) {
            boolean[] doneCol = new boolean[n + 1];
            for (int i = 0; i < n; i++) {
                if (doneCol[arr[i][j]]) return false;
                doneCol[arr[i][j]] = true;
            }
        }
        return sum == k;
    }

    static boolean dfs(int i, int j) {
        if (i == n - 1 && j == n - 1) {
            for (int l = 1; l <= n; l++) {
                arr[i][j] = l;
                if (isSolutionValid()) return true;
            }
            return false;
        }
        for (int a = 1; a <= n; a++) {
            if (visR[i][a] || visC[j][a]) continue;
            arr[i][j] = a;
            visR[i][a] = true;
            visC[j][a] = true;
            if (j == n - 1) {
                if (dfs(i + 1, 0)) return true;
            } else {
                if (dfs(i, j + 1)) return true;
            }
            visR[i][a] = false;
            visC[j][a] = false;
        }
        return false;
    }

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
}