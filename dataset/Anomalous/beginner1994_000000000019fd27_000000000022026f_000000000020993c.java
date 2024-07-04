import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    private static final int MOD = 1000000007;
    private static final FastReader in = new FastReader();

    public static void main(String[] args) throws Exception {
        int testCases = in.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = in.nextInt();
            long[][] matrix = new long[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = in.nextInt();
                }
            }

            long diagonalSum = 0;
            long rowDuplicates = 0;
            long columnDuplicates = 0;

            for (int i = 0; i < n; i++) {
                diagonalSum += matrix[i][i];
                Set<Long> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    rowSet.add(matrix[i][j]);
                }
                if (rowSet.size() != n) {
                    rowDuplicates++;
                }
            }

            for (int i = 0; i < n; i++) {
                Set<Long> columnSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    columnSet.add(matrix[j][i]);
                }
                if (columnSet.size() != n) {
                    columnDuplicates++;
                }
            }

            System.out.println("Case #" + testCase + ": " + diagonalSum + " " + rowDuplicates + " " + columnDuplicates);
        }
        in.close();
    }

    static class FastReader {
        private static final int BUFFER_SIZE = 1 << 16;
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
                if (c == '\n') {
                    break;
                }
                buf[count++] = (byte) c;
            }
            return new String(buf, 0, count);
        }

        public int nextInt() throws IOException {
            int result = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean negative = (c == '-');
            if (negative) {
                c = read();
            }
            do {
                result = result * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (negative) {
                return -result;
            }
            return result;
        }

        public long nextLong() throws IOException {
            long result = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean negative = (c == '-');
            if (negative) {
                c = read();
            }
            do {
                result = result * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (negative) {
                return -result;
            }
            return result;
        }

        public double nextDouble() throws IOException {
            double result = 0, divisor = 1;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean negative = (c == '-');
            if (negative) {
                c = read();
            }
            do {
                result = result * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    result += (c - '0') / (divisor *= 10);
                }
            }

            if (negative) {
                return -result;
            }
            return result;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) {
                buffer[0] = -1;
            }
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) {
                fillBuffer();
            }
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din != null) {
                din.close();
            }
        }
    }
}