import java.io.*;
import java.util.*;

public class Solution implements Runnable {
    private boolean judge = true;
    private FastReader scn;
    private PrintWriter out;
    private String INPUT = "";
    private int[][] A;

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

        int testCases = scn.nextInt();
        for (int t = 1; t <= testCases; t++) {
            out.print("Case #" + t + ": ");
            int n = scn.nextInt();
            int[][] path = new int[1005][2];
            int r = 1, c = 1, pos = 0;
            path[pos++] = new int[]{r, c};
            n--;

            A = null;
            findPath(pascal, dx, dy, n, r, c, path, pos);
            if (A != null) {
                out.println();
                for (int[] coord : A) {
                    out.println(coord[0] + " " + coord[1]);
                }
            }
        }
    }

    private void findPath(int[][] pascal, int[] dx, int[] dy, int n, int r, int c, int[][] path, int pos) {
        if (pos >= 500 || n < 0) return;
        if (n == 0) {
            A = Arrays.copyOf(path, pos);
            return;
        }

        for (int i = 0; i < 6; i++) {
            int newRow = r + dx[i], newCol = c + dy[i];
            if (newRow > 0 && newRow < 35 && newCol > 0 && newCol <= newRow) {
                int value = pascal[newRow][newCol];
                path[pos] = new int[]{newRow, newCol};
                findPath(pascal, dx, dy, n - value, newRow, newCol, path, pos + 1);
                if (A != null) return;
                path[pos] = new int[]{0, 0};
            }
        }
    }

    private int[][] generatePascalTriangle(int size) {
        int[][] triangle = new int[size][];
        triangle[1] = new int[]{0, 1};
        for (int i = 2; i < size; i++) {
            triangle[i] = new int[i + 1];
            for (int j = 1; j <= i; j++) {
                triangle[i][j] = triangle[i - 1][j - 1];
                if (j != i) {
                    triangle[i][j] += triangle[i - 1][j];
                }
            }
        }
        return triangle;
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