import java.io.*;
import java.util.*;

class Solution {
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

    static int getColumnDuplicates(ArrayList<ArrayList<Integer>> matrix, int colIndex) {
        Set<Integer> colSet = new HashSet<>();
        for (ArrayList<Integer> row : matrix) {
            if (!colSet.add(row.get(colIndex))) {
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        Reader in = new Reader();
        int testCases = in.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = in.nextInt();
            ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
            int trace = 0;

            for (int i = 0; i < n; i++) {
                ArrayList<Integer> row = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    int value = in.nextInt();
                    if (i == j) trace += value;
                    row.add(value);
                }
                matrix.add(row);
            }

            int rowDuplicates = 0, colDuplicates = 0;

            for (ArrayList<Integer> row : matrix) {
                Set<Integer> rowSet = new HashSet<>(row);
                if (rowSet.size() < n) rowDuplicates++;
            }

            for (int i = 0; i < n; i++) {
                colDuplicates += getColumnDuplicates(matrix, i);
            }

            System.out.printf("Case #%d: %d %d %d\n", testCase, trace, rowDuplicates, colDuplicates);
        }
    }
}