import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        int testCases = reader.nextInt();
        
        int[] Ns = new int[testCases];
        int[] Ks = new int[testCases];

        for (int i = 0; i < testCases; i++) {
            Ns[i] = reader.nextInt();
            Ks[i] = reader.nextInt();
        }
        
        for (int i = 0; i < testCases; i++) {
            int N = Ns[i];
            int K = Ks[i];

            int X = findX(N, K);
            if (X == -1) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                int[][] board = new int[N][N];
                for (int row = 0; row < N; row++) {
                    board[row][row] = X;
                }
                if (solveSudoku(board, N)) {
                    System.out.println("Case #" + (i + 1) + ": POSSIBLE");
                    printBoard(board, N);
                } else {
                    System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
                }
            }
        }
    }

    private static boolean isSafe(int[][] board, int row, int col, int num) {
        for (int d = 0; d < board.length; d++) {
            if (board[row][d] == num || board[d][col] == num) {
                return false;
            }
        }
        return true;
    }

    private static boolean solveSudoku(int[][] board, int n) {
        int row = -1, col = -1;
        boolean isEmpty = true;
        for (int i = 0; i < n && isEmpty; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;
                    isEmpty = false;
                    break;
                }
            }
        }

        if (isEmpty) {
            return true;
        }

        for (int num = 1; num <= n; num++) {
            if (isSafe(board, row, col, num)) {
                board[row][col] = num;
                if (solveSudoku(board, n)) {
                    return true;
                } else {
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }

    private static void printBoard(int[][] board, int N) {
        for (int r = 0; r < N; r++) {
            for (int d = 0; d < N; d++) {
                System.out.print(board[r][d] + " ");
            }
            System.out.println();
        }
    }

    private static int findX(int N, int K) {
        for (int i = 1; i <= N; i++) {
            if (i * N == K) {
                return i;
            }
        }
        return -1;
    }

    static class Reader {
        private static final int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String fileName) throws IOException {
            din = new DataInputStream(new FileInputStream(fileName));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64];
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            return neg ? -ret : ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            return neg ? -ret : ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }
            return neg ? -ret : ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null) return;
            din.close();
        }
    }
}