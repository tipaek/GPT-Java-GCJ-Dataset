import java.util.*;
import java.io.*;

public class Solution {

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
            byte[] buf = new byte[64]; // line length
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

    public static void main(String[] args) throws Exception {
        Reader sc = new Reader();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[][] array = new int[n][n];
            int sum = 0;

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    array[row][col] = ((row + 1) + col) % n;
                    if (array[row][col] == 0) array[row][col] = n;
                }
            }

            for (int l = 0; l < n; l++) {
                sum += array[l][l];
            }

            if (sum == k) {
                System.out.println("Case #" + (i + 1) + ": POSSIBLE");
                printArray(array);
            } else {
                int[] temp = new int[n];
                for (int l = 0; l < n; l++) {
                    System.arraycopy(array[l], 0, temp, 0, n);
                    Arrays.sort(temp);
                    System.arraycopy(temp, 0, array[l], 0, n);
                }

                sum = 0;
                for (int l = 0; l < n; l++) {
                    sum += array[l][l];
                }

                if (sum == k) {
                    System.out.println("Case #" + (i + 1) + ": POSSIBLE");
                    printArray(array);
                } else {
                    System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
                }
            }
        }
    }

    private static void printArray(int[][] array) {
        for (int[] row : array) {
            for (int elem : row) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }
}