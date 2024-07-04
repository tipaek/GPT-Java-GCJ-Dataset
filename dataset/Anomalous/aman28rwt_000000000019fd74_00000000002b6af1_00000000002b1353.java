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
            System.out.println("Execution time: " + (System.currentTimeMillis() - startTime) + " ms");
        }
    }

    private void solve() {
        int[][] pascalTriangle = generatePascalTriangle(35);
        int[] dx = {-1, -1, 0, 0, 1, 1};
        int[] dy = {-1, 0, -1, 1, 0, 1};
        int T = scn.nextInt();

        for (int testCase = 1; testCase <= T; testCase++) {
            out.print("Case #" + testCase + ": ");
            int n = scn.nextInt();
            int pos = 0;
            int[][] result = new int[500][];
            int r = 1, c = 1;
            result[pos++] = new int[]{r, c};
            n--;

            while (n > 0) {
                int minDiff = n, chosenIndex = -1;
                for (int i = 0; i < 6; i++) {
                    int newRow = r + dx[i];
                    int newCol = c + dy[i];
                    if (isValidPosition(newRow, newCol, 35)) {
                        int value = pascalTriangle[newRow][newCol];
                        if (value <= n && n - value < minDiff) {
                            minDiff = n - value;
                            chosenIndex = i;
                        }
                    }
                }

                r += dx[chosenIndex];
                c += dy[chosenIndex];
                n -= pascalTriangle[r][c];
                result[pos++] = new int[]{r, c};
            }

            out.println();
            for (int i = 0; i < pos; i++) {
                out.println(result[i][0] + " " + result[i][1]);
            }
        }
    }

    private int[][] generatePascalTriangle(int size) {
        int[][] triangle = new int[size][];
        triangle[1] = new int[2];
        triangle[1][1] = 1;

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

    private boolean isValidPosition(int row, int col, int maxSize) {
        return row > 0 && row < maxSize && col > 0 && col <= row;
    }

    class FastReader {
        private InputStream is;
        private byte[] buffer = new byte[1024];
        private int lenbuf = 0, ptrbuf = 0;

        public FastReader(boolean onlineJudge) {
            is = onlineJudge ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        }

        private int readByte() {
            if (lenbuf == -1) throw new InputMismatchException();
            if (ptrbuf >= lenbuf) {
                ptrbuf = 0;
                try {
                    lenbuf = is.read(buffer);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (lenbuf <= 0) return -1;
            }
            return buffer[ptrbuf++];
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

        public String next() {
            int b = skip();
            StringBuilder sb = new StringBuilder();
            while (!isSpaceChar(b)) {
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }
    }
}