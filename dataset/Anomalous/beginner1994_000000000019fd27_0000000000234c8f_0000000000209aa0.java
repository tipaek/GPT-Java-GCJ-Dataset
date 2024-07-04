import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Solution {

    private static final int MOD = 1000000007;
    private static final FastReader in = new FastReader();
    private static boolean result = false;

    public static void main(String[] args) throws Exception {
        int testCases = in.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = in.nextInt();
            result = false;
            int k = in.nextInt();
            int[][] matrix = new int[n][n];
            solve(matrix, 0, 0, k, testCase);
            if (!result) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            }
        }
        in.close();
    }

    private static void solve(int[][] matrix, int row, int col, int k, int testCase) {
        if (row == matrix.length) {
            int sum = 0;
            for (int i = 0; i < matrix.length; i++) {
                sum += matrix[i][i];
            }
            if (k == sum && !result) {
                result = true;
                System.out.println("Case #" + testCase + ": POSSIBLE");
                for (int[] rowArray : matrix) {
                    for (int value : rowArray) {
                        System.out.print(value + " ");
                    }
                    System.out.println();
                }
            }
            return;
        }

        for (int num = 1; num <= matrix.length; num++) {
            if (isSafe(matrix, row, col, num)) {
                matrix[row][col] = num;
                if (col == matrix.length - 1) {
                    solve(matrix, row + 1, 0, k, testCase);
                } else {
                    solve(matrix, row, col + 1, k, testCase);
                }
                matrix[row][col] = 0;
            }
        }
    }

    private static boolean isSafe(int[][] matrix, int row, int col, int num) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[row][i] == num || matrix[i][col] == num) {
                return false;
            }
        }
        return true;
    }

    static class FastReader {
        private final int BUFFER_SIZE = 1 << 16;
        private final DataInputStream din;
        private final byte[] buffer;
        private int bufferPointer, bytesRead;

        public FastReader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public FastReader(String fileName) throws IOException {
            din = new DataInputStream(new FileInputStream(fileName));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64];
            int count = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') break;
                buf[count++] = (byte) c;
            }
            return new String(buf, 0, count);
        }

        public int nextInt() throws IOException {
            int result = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean negative = (c == '-');
            if (negative) c = read();
            do {
                result = result * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            return negative ? -result : result;
        }

        public long nextLong() throws IOException {
            long result = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean negative = (c == '-');
            if (negative) c = read();
            do {
                result = result * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            return negative ? -result : result;
        }

        public double nextDouble() throws IOException {
            double result = 0, div = 1;
            byte c = read();
            while (c <= ' ') c = read();
            boolean negative = (c == '-');
            if (negative) c = read();
            do {
                result = result * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    result += (c - '0') / (div *= 10);
                }
            }
            return negative ? -result : result;
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