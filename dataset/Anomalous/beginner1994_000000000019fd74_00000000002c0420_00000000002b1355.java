import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Solution {

    static FastReader in = new FastReader();

    static class Node {
        int i, j;

        Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        for (int testCase = 0; testCase < t; testCase++) {
            int rows = in.nextInt();
            int cols = in.nextInt();
            int[][] matrix = new int[rows][cols];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = in.nextInt();
                }
            }

            long totalValue = 0;

            while (true) {
                List<Node> nodesToMark = new ArrayList<>();
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        if (matrix[i][j] == -1) continue;

                        totalValue += matrix[i][j];
                        int count = 0, sum = 0;

                        // Check up
                        for (int k = i - 1; k >= 0; k--) {
                            if (matrix[k][j] != -1) {
                                count++;
                                sum += matrix[k][j];
                                break;
                            }
                        }

                        // Check left
                        for (int k = j - 1; k >= 0; k--) {
                            if (matrix[i][k] != -1) {
                                count++;
                                sum += matrix[i][k];
                                break;
                            }
                        }

                        // Check down
                        for (int k = i + 1; k < rows; k++) {
                            if (matrix[k][j] != -1) {
                                count++;
                                sum += matrix[k][j];
                                break;
                            }
                        }

                        // Check right
                        for (int k = j + 1; k < cols; k++) {
                            if (matrix[i][k] != -1) {
                                count++;
                                sum += matrix[i][k];
                                break;
                            }
                        }

                        if (count > 0 && (double) matrix[i][j] < (double) sum / count) {
                            nodesToMark.add(new Node(i, j));
                        }
                    }
                }

                if (nodesToMark.isEmpty()) {
                    break;
                } else {
                    for (Node node : nodesToMark) {
                        matrix[node.i][node.j] = -1;
                    }
                }
            }

            System.out.println("Case #" + (testCase + 1) + ": " + totalValue);
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