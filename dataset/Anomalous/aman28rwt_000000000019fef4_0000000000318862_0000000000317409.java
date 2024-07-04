import java.io.*;
import java.util.*;

public class Solution implements Runnable {
    private boolean judge = true;
    private FastReader scn;
    private PrintWriter out;
    private String INPUT = "";

    private void solve() {
        int T = scn.nextInt();
        for (int tt = 1; tt <= T; tt++) {
            out.print("Case #" + tt + ": ");

            int x = scn.nextInt(), y = scn.nextInt();
            char[] seq = scn.next().toCharArray();

            String directions = "NSEW";
            int[] dx = { 0, 0, 1, -1 };
            int[] dy = { 1, -1, 0, 0 };

            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < seq.length; i++) {
                int dirIndex = directions.indexOf(seq[i]);
                x += dx[dirIndex];
                y += dy[dirIndex];

                int distance = Math.abs(x) + Math.abs(y);
                if (distance <= i + 1) {
                    ans = Math.min(ans, i + 1);
                }
            }

            if (ans == Integer.MAX_VALUE) {
                out.println("IMPOSSIBLE");
            } else {
                out.println(ans);
            }
        }
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        boolean onlineJudge = System.getProperty("ONLINE_JUDGE") != null || judge;
        out = new PrintWriter(System.out);
        scn = new FastReader(onlineJudge);
        solve();
        out.flush();
        if (!onlineJudge) {
            System.out.println(Arrays.deepToString(new Object[] { System.currentTimeMillis() - startTime + " ms" }));
        }
    }

    public static void main(String[] args) {
        new Thread(null, new Solution(), "Main", 1 << 28).start();
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
            while ((b = readByte()) != -1 && isSpaceChar(b));
            return b;
        }

        public String next() {
            int b = skip();
            StringBuilder sb = new StringBuilder();
            while (!(isSpaceChar(b))) {
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }

        public int nextInt() {
            int num = 0, b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
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
    }
}