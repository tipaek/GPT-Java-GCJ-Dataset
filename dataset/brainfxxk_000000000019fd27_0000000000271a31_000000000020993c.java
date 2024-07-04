import java.io.*;
import java.nio.CharBuffer;
import java.util.HashSet;
import java.util.NoSuchElementException;

public class Solution {
    public static void main(String[] args) {
        SimpleScanner scanner = new SimpleScanner(System.in);
        PrintWriter writer = new PrintWriter(System.out);
        int caseNum = scanner.nextInt();
        for (int caseNo = 1; caseNo <= caseNum; ++caseNo) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; ++i)
                for (int j = 0; j < n; ++j)
                    matrix[i][j] = scanner.nextInt();
            int trace = 0;
            for (int i = 0; i < n; ++i)
                trace += matrix[i][i];
            int r = 0;
            int c = 0;
            for (int i = 0; i < n; ++i) {
                HashSet<Integer> rSet = new HashSet<>();
                HashSet<Integer> cSet = new HashSet<>();
                boolean rowR = false;
                boolean colR = false;
                for (int j = 0; j < n; ++j) {
                    if (!rSet.add(matrix[i][j]))
                        rowR = true;
                    if (!cSet.add(matrix[j][i]))
                        colR = true;
                }
                if (rowR)
                    ++r;
                if (colR)
                    ++c;
            }
            writer.println(String.format("Case #%d: %d %d %d", caseNo, trace, r, c));
        }
        writer.close();
    }

    private static class SimpleScanner {

        private static final int BUFFER_SIZE = 10240;

        private Readable in;
        private CharBuffer buffer;
        private boolean eof;

        private SimpleScanner(InputStream in) {
            this.in = new BufferedReader(new InputStreamReader(in));
            buffer = CharBuffer.allocate(BUFFER_SIZE);
            buffer.limit(0);
            eof = false;
        }


        private char read() {
            if (!buffer.hasRemaining()) {
                buffer.clear();
                int n;
                try {
                    n = in.read(buffer);
                } catch (IOException e) {
                    n = -1;
                }
                if (n <= 0) {
                    eof = true;
                    return '\0';
                }
                buffer.flip();
            }
            return buffer.get();
        }

        private void checkEof() {
            if (eof)
                throw new NoSuchElementException();
        }

        private char nextChar() {
            checkEof();
            char b = read();
            checkEof();
            return b;
        }

        private String next() {
            char b;
            do {
                b = read();
                checkEof();
            } while (Character.isWhitespace(b));
            StringBuilder sb = new StringBuilder();
            do {
                sb.append(b);
                b = read();
            } while (!eof && !Character.isWhitespace(b));
            return sb.toString();
        }

        private int nextInt() {
            return Integer.parseInt(next());
        }

        private long nextLong() {
            return Long.parseLong(next());
        }

        private double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}