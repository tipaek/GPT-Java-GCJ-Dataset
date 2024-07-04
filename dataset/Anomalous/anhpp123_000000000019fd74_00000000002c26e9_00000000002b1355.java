import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        final long MOD = 1000000007;
        int t = sc.nextInt();
        int caseNumber = 0;

        while (caseNumber++ < t) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] s = new int[n + 2][m + 2];

            for (int i = 0; i < n + 2; i++) {
                s[i][0] = s[i][m + 1] = -1;
            }
            for (int j = 0; j < m + 2; j++) {
                s[0][j] = s[n + 1][j] = -1;
            }
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    s[i][j] = sc.nextInt();
                }
            }

            TreeSet<Integer> rowSet = new TreeSet<>();
            for (int i = 0; i < m + 2; i++) {
                rowSet.add(i);
            }
            TreeSet<Integer> colSet = new TreeSet<>();
            for (int i = 0; i < n + 2; i++) {
                colSet.add(i);
            }

            TreeSet<Integer>[] rows = new TreeSet[n + 2];
            for (int i = 0; i < n + 2; i++) {
                rows[i] = new TreeSet<>(rowSet);
            }
            TreeSet<Integer>[] cols = new TreeSet[m + 2];
            for (int j = 0; j < m + 2; j++) {
                cols[j] = new TreeSet<>(colSet);
            }

            long cnt = 1L, ans = 0L;
            while (cnt > 0) {
                cnt = 0L;
                boolean[][] del = new boolean[n + 1][m + 1];
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= m; j++) {
                        if (s[i][j] == -1) continue;
                        ans += s[i][j];
                        int neighbors = 0, sum = 0;
                        int[][] neighborsCoords = {
                            {i, rows[i].higher(j)}, 
                            {i, rows[i].lower(j)}, 
                            {cols[j].higher(i), j}, 
                            {cols[j].lower(i), j}
                        };
                        for (int[] coord : neighborsCoords) {
                            if (s[coord[0]][coord[1]] != -1) {
                                neighbors++;
                                sum += s[coord[0]][coord[1]];
                            }
                        }
                        if (sum > s[i][j] * neighbors) {
                            del[i][j] = true;
                            cnt++;
                        }
                    }
                }
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= m; j++) {
                        if (del[i][j]) {
                            s[i][j] = -1;
                            rows[i].remove(j);
                            cols[j].remove(i);
                        }
                    }
                }
            }
            out.println("Case #" + caseNumber + ": " + ans);
        }
        out.close();
    }

    public static class MyScanner {
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