import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

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

    public static void main(String[] args) throws IOException {
        Reader sc = new Reader();
        int testCases = sc.nextInt();

        for (int k = 0; k < testCases; k++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            int temp = 0;

            for (int i = 0; i < n; i++) {
                temp = (i + 1) ^ temp;
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += arr[i][i];
            }

            int rowErrors = 0, colErrors = 0;
            for (int i = 0; i < n; i++) {
                int rowXor = 0;
                for (int j = 0; j < n; j++) {
                    rowXor ^= arr[i][j];
                }
                if (rowXor != temp) rowErrors++;
            }

            for (int i = 0; i < n; i++) {
                int colXor = 0;
                for (int j = 0; j < n; j++) {
                    colXor ^= arr[j][i];
                }
                if (colXor != temp) colErrors++;
            }

            System.out.println("Case #" + (k + 1) + ": " + sum + " " + rowErrors + " " + colErrors);
        }
    }
}