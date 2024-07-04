import java.io.*;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class Solution {

    public static void main(String[] args) {
        SimpleScanner scanner = new SimpleScanner(System.in);
        PrintWriter writer = new PrintWriter(System.out);
        int caseNum = scanner.nextInt();
        for (int caseNo = 1; caseNo <= caseNum; ++caseNo) {
            writer.print(String.format("Case #%d: ", caseNo));
            int n = scanner.nextInt();
            int d = scanner.nextInt();
            List<Long> a = new ArrayList<>(n);
            for (int i = 0; i < n; ++i)
                a.add(scanner.nextLong());
            a.sort(Comparator.naturalOrder());
            long ans = d - 1;
            for (int i = 0; i < n; ++i) {
                for (long r = 1; r * r <= a.get(i); ++r) {
                    if (a.get(i) % r != 0)
                        continue;
                    long t = calCut(i, r, d, a);
                    if (t >= 0)
                        ans = Math.min(ans, t);
                    t = calCut(i, a.get(i) / r, d, a);
                    if (t >= 0)
                        ans = Math.min(ans, t);
                }
            }
            writer.println(ans);
//            writer.flush();
        }
        writer.close();
    }

    private static long calCut(int i, long r, int d, List<Long> a) {
        long piece = 0;
        long cut = 0;
        for (int j = i; j < a.size() && piece < d; ++j) {
            if (a.get(j) % r == 0) {
                long incPiece = a.get(j) / r;
                long incCut = incPiece - 1;
                if (piece + incPiece > d) {
                    incPiece = d - piece;
                    incCut = incPiece;
                }
                piece += incPiece;
                cut += incCut;
            }
        }
        if (piece == d)
            return cut;
        for (int j = i; j < a.size() && piece < d; ++j) {
            if (a.get(j) % r != 0) {
                long incPiece = a.get(j) / r;
                long incCut = incPiece;
                if (piece + incPiece > d) {
                    incPiece = d - piece;
                    incCut = incPiece;
                }
                piece += incPiece;
                cut += incCut;
            }
        }
        if (piece == d)
            return cut;
        return -1;
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