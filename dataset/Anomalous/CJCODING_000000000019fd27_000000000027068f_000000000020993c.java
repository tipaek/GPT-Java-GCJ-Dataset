import java.io.*;
import java.util.HashSet;

public class Solution {

    static class Reader {
        private static final int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            this(System.in);
        }

        public Reader(String fileName) throws IOException {
            this(new FileInputStream(fileName));
        }

        private Reader(InputStream in) {
            din = new DataInputStream(in);
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

    static int gcd(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        return a > b ? gcd(a - b, b) : gcd(a, b - a);
    }

    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        int t = reader.nextInt();
        for (int caseNumber = 1; caseNumber <= t; caseNumber++) {
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
                for (int j = 0; j < n; j++) rowSet.add(matrix[i][j]);
                if (rowSet.size() != n) rows++;
            }
            for (int j = 0; j < n; j++) {
                HashSet<Integer> colSet = new HashSet<>();
                for (int i = 0; i < n; i++) colSet.add(matrix[i][j]);
                if (colSet.size() != n) cols++;
            }
            System.out.printf("Case #%d: %d %d %d%n", caseNumber, trace, rows, cols);
        }
    }
}