import java.io.*;
import java.util.*;

public class Solution {

    static final long MOD = 998244353;

    public static void main(String[] args) throws IOException {
        Reader scn = new Reader();
        PrintWriter out = new PrintWriter(System.out);

        int t = scn.nextInt();

        for (int u = 1; u <= t; u++) {
            int r = scn.nextInt();
            int c = scn.nextInt();

            long[][] matrix = scn.nextLong2DArray(r, c);

            TreeSet<Integer>[] rows = new TreeSet[r];
            TreeSet<Integer>[] cols = new TreeSet[c];

            for (int i = 0; i < r; i++) {
                rows[i] = new TreeSet<>();
                for (int j = 0; j < c; j++) {
                    rows[i].add(j);
                }
            }

            for (int j = 0; j < c; j++) {
                cols[j] = new TreeSet<>();
                for (int i = 0; i < r; i++) {
                    cols[j].add(i);
                }
            }

            long totalSum = 0;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    totalSum += matrix[i][j];
                }
            }

            long ans = 0;

            while (true) {
                ArrayList<Pair> toBeRemoved = new ArrayList<>();
                ans += totalSum;

                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        if (matrix[i][j] != 0) {
                            double total = 0;
                            int count = 0;

                            if (rows[i].higher(j) != null) {
                                count++;
                                total += matrix[i][rows[i].higher(j)];
                            }

                            if (rows[i].lower(j) != null) {
                                count++;
                                total += matrix[i][rows[i].lower(j)];
                            }

                            if (cols[j].lower(i) != null) {
                                count++;
                                total += matrix[cols[j].lower(i)][j];
                            }

                            if (cols[j].higher(i) != null) {
                                count++;
                                total += matrix[cols[j].higher(i)][j];
                            }

                            if (count != 0 && matrix[i][j] < total / count) {
                                toBeRemoved.add(new Pair(i, j));
                            }
                        }
                    }
                }

                if (toBeRemoved.isEmpty()) {
                    break;
                }

                for (Pair pair : toBeRemoved) {
                    totalSum -= matrix[pair.i][pair.j];
                    matrix[pair.i][pair.j] = 0;

                    rows[pair.i].remove(pair.j);
                    cols[pair.j].remove(pair.i);
                }
            }

            out.println("Case #" + u + ": " + ans);
        }
        out.close();
    }

    private static class Pair {
        int i, j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static class Reader {
        private static final int BUFFER_SIZE = 1 << 16;
        private final DataInputStream din;
        private final byte[] buffer;
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
            byte[] buf = new byte[1000000 + 1];
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

        public long[][] nextLong2DArray(int rows, int cols) throws IOException {
            long[][] arr = new long[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    arr[i][j] = nextLong();
                }
            }
            return arr;
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