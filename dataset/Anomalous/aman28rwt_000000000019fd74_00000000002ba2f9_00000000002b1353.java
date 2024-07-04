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
        boolean onlineJudge = System.getProperty("ONLINE_JUDGE") != null || judge;
        out = new PrintWriter(System.out);
        scn = new FastReader(onlineJudge);
        solve();
        out.flush();
        if (!onlineJudge) {
            System.out.println(Arrays.deepToString(new Object[]{System.currentTimeMillis() - startTime + " ms"}));
        }
    }

    private void solve() {
        int[][] pascal = generatePascalTriangle(35);
        int[] dx = {-1, -1, 0, 0, 1, 1};
        int[] dy = {-1, 0, -1, 1, 0, 1};

        int T = scn.nextInt();
        for (int tt = 1; tt <= T; tt++) {
            out.print("Case #" + tt + ": ");
            int n = scn.nextInt();
            int[][] ans = new int[1005][2];
            int pos = 0;

            int r = 1, c = 1;
            ans[pos++] = new int[]{r, c};
            n--;

            A = null;
            findPath(pascal, dx, dy, n, r, c, ans, pos);
            if (A != null) {
                out.println();
                for (int[] a : A) {
                    out.println(a[0] + " " + a[1]);
                }
            }
        }
    }

    private int[][] A;

    private void findPath(int[][] pascal, int[] dx, int[] dy, int n, int r, int c, int[][] ans, int pos) {
        if (pos > 500) return;
        if (n == 0) {
            A = Arrays.copyOf(ans, pos);
            return;
        }

        List<int[]> moves = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            int row = r + dx[i], col = c + dy[i];
            if (row > 0 && row < 35 && col > 0 && col <= row) {
                int x = pascal[row][col];
                moves.add(new int[]{n - x, i});
            }
        }

        moves.sort(Comparator.comparingInt(o -> o[0]));
        for (int[] move : moves) {
            if (move[0] < 0) continue;
            int i = move[1];
            int row = r + dx[i], col = c + dy[i];
            int x = pascal[row][col];
            ans[pos] = new int[]{row, col};
            findPath(pascal, dx, dy, n - x, row, col, ans, pos + 1);
            if (A != null) return;
            ans[pos] = new int[2];
        }
    }

    private int[][] generatePascalTriangle(int size) {
        int[][] pascal = new int[size][];
        pascal[1] = new int[2];
        pascal[1][1] = 1;

        for (int i = 2; i < size; i++) {
            pascal[i] = new int[i + 1];
            for (int j = 1; j <= i; j++) {
                pascal[i][j] = pascal[i - 1][j - 1];
                if (j != i) {
                    pascal[i][j] += pascal[i - 1][j];
                }
            }
        }
        return pascal;
    }

    class FastReader {
        private final InputStream is;
        private final byte[] inbuf = new byte[1024];
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
    }
}