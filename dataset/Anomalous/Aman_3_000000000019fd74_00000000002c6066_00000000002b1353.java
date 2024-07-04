import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

class Solution {
    static final Scanner sc = new Scanner(System.in);
    static final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    static final int MOD = (int) (1e9 + 7);
    static final Reader reader = new Reader();
    static final PrintWriter out = new PrintWriter(System.out);
    static int[][] pascalTriangle = new int[502][502];

    private static void generatePascalTriangle(int[][] pascalTriangle) {
        pascalTriangle[1][1] = 1;
        for (int i = 2; i <= 501; i++) {
            for (int j = 1; j <= i; j++) {
                pascalTriangle[i][j] = pascalTriangle[i - 1][j - 1] + pascalTriangle[i - 1][j];
            }
        }
    }

    public static void main(final String[] args) throws IOException {
        int testCases = in.nextInt();
        generatePascalTriangle(pascalTriangle);
        for (int i = 0; i < testCases; i++) {
            out.println("Case #" + (i + 1) + ": ");
            processTestCase(pascalTriangle);
        }
        out.flush();
        out.close();
        sc.close();
    }

    private static void processTestCase(int[][] pascalTriangle) throws IOException {
        int[][] visited = new int[502][502];
        int n = in.nextInt();
        long sum = 0;
        ArrayList<Integer> rowIndices = new ArrayList<>();
        ArrayList<Integer> colIndices = new ArrayList<>();
        boolean found = false;
        findPath(pascalTriangle, visited, rowIndices, colIndices, sum, n, 1, 1);
        for (int i = 0; i < rowIndices.size(); i++) {
            out.println(rowIndices.get(i) + " " + colIndices.get(i));
        }
    }

    private static void findPath(int[][] pascalTriangle, int[][] visited, ArrayList<Integer> rowIndices,
                                 ArrayList<Integer> colIndices, long sum, int target, int row, int col) {
        if (sum == target || found) {
            found = true;
            return;
        }
        if (visited[row][col] == 1 || pascalTriangle[row][col] == 0) {
            return;
        }
        if (sum > target || rowIndices.size() > 500) {
            return;
        }
        visited[row][col] = 1;
        sum += pascalTriangle[row][col];
        rowIndices.add(row);
        colIndices.add(col);
        if (sum == target) {
            found = true;
            return;
        }
        if (!found) {
            if (row % 2 == 1) {
                findPath(pascalTriangle, visited, rowIndices, colIndices, sum, target, row + 1, col);
            } else {
                findPath(pascalTriangle, visited, rowIndices, colIndices, sum, target, row + 1, col + 1);
            }
        }
        if (!found) {
            findPath(pascalTriangle, visited, rowIndices, colIndices, sum, target, row, col + 1);
            findPath(pascalTriangle, visited, rowIndices, colIndices, sum, target, row + 1, col + 1);
            findPath(pascalTriangle, visited, rowIndices, colIndices, sum, target, row - 1, col - 1);
        }
        if (!found) {
            rowIndices.remove(rowIndices.size() - 1);
            colIndices.remove(colIndices.size() - 1);
        }
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

        public Reader(final String fileName) throws IOException {
            din = new DataInputStream(new FileInputStream(fileName));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
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
            if (negative) return -result;
            return result;
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
            if (negative) return -result;
            return result;
        }

        public double nextDouble() throws IOException {
            double result = 0, divisor = 1;
            byte c = read();
            while (c <= ' ') c = read();
            boolean negative = (c == '-');
            if (negative) c = read();
            do {
                result = result * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    result += (c - '0') / (divisor *= 10);
                }
            }
            if (negative) return -result;
            return result;
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