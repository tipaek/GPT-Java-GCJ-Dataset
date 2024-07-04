import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    private static final Scanner sc = new Scanner(System.in);
    private static final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    private static final int MOD = (int) (1e9 + 7);
    private static final Reader r = new Reader();
    private static final PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        int testCases = in.nextInt();
        for (int i = 1; i <= testCases; i++) {
            out.print("Case #" + i + ": ");
            processTestCase();
        }
        out.flush();
        out.close();
        sc.close();
        in.close();
        r.close();
    }

    private static void processTestCase() throws IOException {
        int n = in.nextInt();
        int[][] matrix = new int[n][n];
        Set<Integer> set;
        long trace = 0, rowCount = 0, colCount = 0;

        for (int i = 0; i < n; i++) {
            set = new HashSet<>();
            for (int j = 0; j < n; j++) {
                matrix[i][j] = in.nextInt();
                if (i == j) {
                    trace += matrix[i][j];
                }
                set.add(matrix[i][j]);
            }
            if (set.size() != n) {
                rowCount++;
            }
        }

        for (int j = 0; j < n; j++) {
            set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                set.add(matrix[i][j]);
            }
            if (set.size() != n) {
                colCount++;
            }
        }

        out.println(trace + " " + rowCount + " " + colCount);
    }

    private static int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    static class Reader {
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