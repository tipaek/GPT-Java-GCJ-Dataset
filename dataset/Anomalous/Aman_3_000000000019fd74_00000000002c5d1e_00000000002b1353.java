import java.io.*;
import java.util.*;

class Solution {
    static final Scanner sc = new Scanner(System.in);
    static final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    static final int MOD = (int) (1e9 + 7);
    static final Reader reader = new Reader();
    static final PrintWriter out = new PrintWriter(System.out);
    static int[][] pascalTriangle = new int[502][502];
    static boolean found = false;

    public static void main(String[] args) throws IOException {
        int testcases = in.nextInt();
        generatePascalTriangle(pascalTriangle);

        for (int i = 0; i < testcases; i++) {
            out.println("Case #" + (i + 1) + ": ");
            processTestCase(pascalTriangle);
        }

        out.flush();
        out.close();
        sc.close();
    }

    private static void generatePascalTriangle(int[][] p) {
        p[1][1] = 1;
        for (int i = 2; i < 501; i++) {
            for (int j = 1; j <= i; j++) {
                p[i][j] = p[i - 1][j - 1] + p[i - 1][j];
            }
        }
    }

    private static void processTestCase(int[][] p) throws IOException {
        int[][] visited = new int[502][502];
        int n = in.nextInt();
        long sum = 0;
        ArrayList<Integer> rowList = new ArrayList<>();
        ArrayList<Integer> colList = new ArrayList<>();
        found = false;

        findPath(p, visited, rowList, colList, sum, n, 1, 1);

        for (int i = 0; i < rowList.size(); i++) {
            out.println(rowList.get(i) + " " + colList.get(i));
        }
    }

    private static void findPath(int[][] p, int[][] visited, ArrayList<Integer> rowList, ArrayList<Integer> colList, long sum, int n, int i, int j) {
        if (sum == n || found) {
            found = true;
            return;
        }
        if (visited[i][j] == 1 || p[i][j] == 0 || sum > n || rowList.size() > 500) {
            return;
        }

        visited[i][j] = 1;
        sum += p[i][j];
        rowList.add(i);
        colList.add(j);

        if (sum == n) {
            found = true;
            return;
        }

        if (!found) {
            if (i % 2 == 1) {
                findPath(p, visited, rowList, colList, sum, n, i + 1, j);
            } else {
                findPath(p, visited, rowList, colList, sum, n, i + 1, j + 1);
            }
        }

        if (!found) {
            findPath(p, visited, rowList, colList, sum, n, i, j + 1);
            findPath(p, visited, rowList, colList, sum, n, i + 1, j + 1);
            findPath(p, visited, rowList, colList, sum, n, i - 1, j - 1);
        }

        if (!found) {
            rowList.remove(rowList.size() - 1);
            colList.remove(colList.size() - 1);
        }
    }

    static int gcd(int a, int b) {
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