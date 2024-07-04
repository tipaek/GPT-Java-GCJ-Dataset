import java.io.*;
import java.util.*;

public class Solution implements Runnable {
    private boolean judge = true;
    private FastReader scn;
    private PrintWriter out;
    private String INPUT = "";

    public static void main(String[] args) {
        new Thread(null, new Solution(), "Main", 1 << 28).start();
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        boolean oj = System.getProperty("ONLINE_JUDGE") != null || judge;
        out = new PrintWriter(System.out);
        scn = new FastReader(oj);
        solve();
        out.flush();
        if (!oj) {
            System.out.println(Arrays.deepToString(new Object[]{System.currentTimeMillis() - startTime + " ms"}));
        }
    }

    private void solve() {
        int T = scn.nextInt();
        for (int tt = 1; tt <= T; tt++) {
            out.print("Case #" + tt + ": ");
            int n = scn.nextInt();
            int m = scn.nextInt();
            int[][] arr = scn.next2DInt(n, m);
            boolean[][] rem = new boolean[n][m];
            long ans = 0, prev = 0;

            while (true) {
                long add = 0;
                for (int[] row : arr) {
                    for (int val : row) {
                        add += val;
                    }
                }
                if (add == prev) break;
                ans += add;
                prev = add;

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (rem[i][j]) continue;
                        int tot = 0, cnt = 0;
                        cnt = updateCountAndTotal(arr, i, j, n, m, tot, cnt);
                        if (arr[i][j] * cnt < tot) {
                            rem[i][j] = true;
                        }
                    }
                }

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (rem[i][j]) {
                            arr[i][j] = 0;
                        }
                    }
                }
            }
            out.println(ans);
        }
    }

    private int updateCountAndTotal(int[][] arr, int i, int j, int n, int m, int tot, int cnt) {
        for (int k = i - 1; k >= 0; k--) {
            if (arr[k][j] != 0) {
                cnt++;
                tot += arr[k][j];
                break;
            }
        }
        for (int k = i + 1; k < n; k++) {
            if (arr[k][j] != 0) {
                cnt++;
                tot += arr[k][j];
                break;
            }
        }
        for (int k = j - 1; k >= 0; k--) {
            if (arr[i][k] != 0) {
                cnt++;
                tot += arr[i][k];
                break;
            }
        }
        for (int k = j + 1; k < m; k++) {
            if (arr[i][k] != 0) {
                cnt++;
                tot += arr[i][k];
                break;
            }
        }
        return cnt;
    }

    class FastReader {
        private InputStream is;
        private byte[] inbuf = new byte[1024];
        private int lenbuf = 0, ptrbuf = 0;

        public FastReader(boolean onlineJudge) {
            is = onlineJudge ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        }

        private int readByte() {
            if (lenbuf == -1) throw new InputMismatchException();
            if (ptrbuf >= lenbuf) {
                ptrbuf = 0;
                try {
                    lenbuf = is.read(inbuf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (lenbuf <= 0) return -1;
            }
            return inbuf[ptrbuf++];
        }

        private boolean isSpaceChar(int c) {
            return !(c >= 33 && c <= 126);
        }

        private int skip() {
            int b;
            while ((b = readByte()) != -1 && isSpaceChar(b)) ;
            return b;
        }

        public String next() {
            int b = skip();
            StringBuilder sb = new StringBuilder();
            while (!isSpaceChar(b)) {
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }

        public int nextInt() {
            int num = 0, b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
            if (b == '-') {
                minus = true;
                b = readByte();
            }
            while (true) {
                if (b >= '0' && b <= '9') {
                    num = num * 10 + (b - '0');
                } else {
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }

        public int[][] next2DInt(int n, int m) {
            int[][] arr = new int[n][];
            for (int i = 0; i < n; i++) {
                arr[i] = new int[m];
                for (int j = 0; j < m; j++) {
                    arr[i][j] = nextInt();
                }
            }
            return arr;
        }
    }
}