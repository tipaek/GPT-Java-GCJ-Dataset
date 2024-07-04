import java.io.*;

public class Solution {
    static FastReader sc;
    static FastWriter out;

    public static void main(String[] args) throws IOException {
        sc = new FastReader();
        out = new FastWriter();
        int testCases = sc.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0, duplicateRows = 0, duplicateColumns = 0;

            for (int i = 0; i < n; i++) {
                boolean[] rowCheck = new boolean[n + 1];
                boolean rowDuplicate = false;
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    if (rowCheck[matrix[i][j]]) {
                        if (!rowDuplicate) {
                            duplicateRows++;
                            rowDuplicate = true;
                        }
                    } else {
                        rowCheck[matrix[i][j]] = true;
                    }
                }
            }

            for (int j = 0; j < n; j++) {
                boolean[] colCheck = new boolean[n + 1];
                boolean colDuplicate = false;
                for (int i = 0; i < n; i++) {
                    if (colCheck[matrix[i][j]]) {
                        if (!colDuplicate) {
                            duplicateColumns++;
                            colDuplicate = true;
                        }
                    } else {
                        colCheck[matrix[i][j]] = true;
                    }
                }
            }

            out.println("Case #" + t + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }

        out.close();
    }

    static class FastReader {
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public FastReader() {
            din = new DataInputStream(System.in);
            buffer = new byte[1 << 16];
            bufferPointer = bytesRead = 0;
        }

        public FastReader(String fileName) throws IOException {
            din = new DataInputStream(new FileInputStream(fileName));
            buffer = new byte[1 << 16];
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
            if (neg) return -ret;
            return ret;
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
            if (neg) return -ret;
            return ret;
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

            if (neg) return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, buffer.length);
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

    static class FastWriter {
        private final BufferedOutputStream outputStream;

        public FastWriter() {
            outputStream = new BufferedOutputStream(System.out);
        }

        public FastWriter(String fileName) throws FileNotFoundException {
            outputStream = new BufferedOutputStream(new FileOutputStream(fileName));
        }

        public void print(Object obj) throws IOException {
            outputStream.write(obj.toString().getBytes());
        }

        public void println(Object obj) throws IOException {
            outputStream.write((obj.toString() + "\n").getBytes());
        }

        public void close() throws IOException {
            outputStream.flush();
            outputStream.close();
        }
    }
}