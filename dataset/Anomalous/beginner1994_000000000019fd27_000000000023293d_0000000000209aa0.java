import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Solution {

    static final int MOD = 1000000007;
    static FastReader in = new FastReader();

    public static void main(String[] args) throws Exception {
        int testCases = in.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = in.nextInt();
            int k = in.nextInt();
            int[][] matrix = new int[n][n];
            int shift = 0;
            int diagonalSum = 0;

            for (int i = 0; i < n; i++) {
                int value = 1;
                for (int j = 0; j < n; j++) {
                    matrix[i][(j + shift) % n] = value++;
                }
                diagonalSum += matrix[i][i];
                shift++;
            }

            if (diagonalSum == k) {
                printMatrix(testCase, matrix, n);
                continue;
            }

            if (checkPossibleShift(matrix, n, k, testCase)) {
                continue;
            }

            if (checkPossibleColumnShift(matrix, n, k, testCase)) {
                continue;
            }

            System.out.println("Case #" + testCase + ": IMPOSSIBLE");
        }
        in.close();
    }

    private static boolean checkPossibleShift(int[][] matrix, int n, int k, int testCase) {
        int shift = 0;
        for (int v = 0; v < n; v++) {
            shift++;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += matrix[(i + shift) % n][i];
            }
            if (sum == k) {
                printShiftedMatrix(testCase, matrix, n, shift, true);
                return true;
            }
        }
        return false;
    }

    private static boolean checkPossibleColumnShift(int[][] matrix, int n, int k, int testCase) {
        int shift = 0;
        for (int v = 0; v < n; v++) {
            shift++;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += matrix[i][(i + shift) % n];
            }
            if (sum == k) {
                printShiftedMatrix(testCase, matrix, n, shift, false);
                return true;
            }
        }
        return false;
    }

    private static void printMatrix(int testCase, int[][] matrix, int n) {
        System.out.println("Case #" + testCase + ": POSSIBLE");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void printShiftedMatrix(int testCase, int[][] matrix, int n, int shift, boolean rowShift) {
        System.out.println("Case #" + testCase + ": POSSIBLE");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (rowShift) {
                    System.out.print(matrix[(i + shift) % n][j] + " ");
                } else {
                    System.out.print(matrix[i][(j + shift) % n] + " ");
                }
            }
            System.out.println();
        }
    }

    static class FastReader {
        private final int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
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
            if (din != null) din.close();
        }
    }
}