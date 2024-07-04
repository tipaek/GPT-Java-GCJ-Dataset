import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        new Thread(null, new Runnable() {
            public void run() {
                solve();
            }
        }, "1", 1 << 26).start();
    }

    static void solve() {
        FastReader fr = new FastReader();
        PrintWriter op = new PrintWriter(System.out);

        int T = fr.nextInt();
        for (int t = 1; t <= T; ++t) {
            int x = fr.nextInt();
            int y = fr.nextInt();

            boolean[] pos = new boolean[2];
            pos[0] = x >= 0;
            pos[1] = y >= 0;

            x = Math.abs(x);
            y = Math.abs(y);

            if (x % 2 == y % 2) {
                op.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                int[][] a = new int[2][32];
                int[][] rs = new int[32][2];
                boolean[][] bit = new boolean[32][2];
                boolean flg = true;

                int i = -1, j = -1, k = 1, l = 1;
                while (x >= k) {
                    a[0][++i] = (x & (1 << i)) == 0 ? 0 : 1;
                    k <<= 1;
                }
                while (y >= l) {
                    a[1][++j] = (y & (1 << j)) == 0 ? 0 : 1;
                    l <<= 1;
                }

                int n = Math.max(i, j);

                for (i = 0; i <= n; ++i) {
                    if (a[0][i] == a[1][i] && a[0][i] == 0) {
                        flg = false;
                        break;
                    }
                    if (a[0][i] == a[1][i] && a[0][i] == 1) {
                        if (a[0][i - 1] == 1) j = 0;
                        else j = 1;
                        rs[i - 1][j] = -1;

                        while (j != -1) {
                            while (i <= n && a[0][i] == a[1][i] && a[0][i] == 1) {
                                bit[i][j] = true;
                                rs[i][j ^ 1] = 1;
                                ++i;
                            }
                            rs[i][j] = 1;
                            bit[i][j] = true;
                            if (a[j][i] == 1) {
                                flg = false;
                                break;
                            } else if (a[j ^ 1][i] == 1) {
                                j ^= 1;
                                if (bit[i - 1][j]) {
                                    flg = false;
                                    break;
                                }
                                rs[i - 1][j] = -1;
                                ++i;
                            } else {
                                j = -1;
                            }
                        }
                    } else {
                        if (a[0][i] == 1) rs[i][0] = 1;
                        else rs[i][1] = 1;
                    }
                    if (!flg) break;
                }

                if (!flg) {
                    op.println("Case #" + t + ": IMPOSSIBLE");
                } else {
                    op.print("Case #" + t + ": ");
                    for (i = 0; i <= (n + 1); ++i) {
                        if (rs[i][1] == 1) {
                            op.print(pos[1] ? 'N' : 'S');
                        }
                        if (rs[i][1] == -1) {
                            op.print(!pos[1] ? 'N' : 'S');
                        }
                        if (rs[i][0] == 1) {
                            op.print(pos[0] ? 'E' : 'W');
                        }
                        if (rs[i][0] == -1) {
                            op.print(!pos[0] ? 'E' : 'W');
                        }
                    }
                    op.println();
                }
            }
        }
        op.flush();
        op.close();
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

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}