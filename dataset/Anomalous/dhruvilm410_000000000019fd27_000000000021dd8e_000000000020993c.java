import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;

public class Solution {

    static class Reader {
        private static final int BUFFER_SIZE = 1 << 16;
        private final DataInputStream din;
        private final byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            this.din = new DataInputStream(System.in);
            this.buffer = new byte[BUFFER_SIZE];
            this.bufferPointer = this.bytesRead = 0;
        }

        public Reader(String fileName) throws IOException {
            this.din = new DataInputStream(new FileInputStream(fileName));
            this.buffer = new byte[BUFFER_SIZE];
            this.bufferPointer = this.bytesRead = 0;
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
            if (din != null) din.close();
        }
    }

    static int gcd(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        if (a == b) return a;
        return (a > b) ? gcd(a - b, b) : gcd(a, b - a);
    }

    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        int t = reader.nextInt();
        int caseNumber = 0;

        while (t-- > 0) {
            caseNumber++;
            int n = reader.nextInt();
            int trace = 0, rows = 0, cols = 0;
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int value = reader.nextInt();
                    matrix[i][j] = value;
                    if (i == j) trace += value;
                }
            }

            for (int i = 0; i < n; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    rowSet.add(matrix[i][j]);
                }
                if (rowSet.size() != n) rows++;
            }

            for (int j = 0; j < n; j++) {
                HashSet<Integer> colSet = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    colSet.add(matrix[i][j]);
                }
                if (colSet.size() != n) cols++;
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + rows + " " + cols);
        }
    }
}