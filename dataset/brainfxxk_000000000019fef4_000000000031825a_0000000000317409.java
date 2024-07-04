import java.io.*;
import java.nio.CharBuffer;
import java.util.NoSuchElementException;

public class Solution {
    public static void main(String[] args) {
        SimpleScanner scanner = new SimpleScanner(System.in);
        PrintWriter writer = new PrintWriter(System.out);
        int caseNum = scanner.nextInt();
        for (int caseNo = 1; caseNo <= caseNum; ++caseNo) {
            writer.print(String.format("Case #%d: ", caseNo));
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            char[] s = scanner.next().toCharArray();
            int ans = 0;
            int step = 0;
            for (char c : s) {
                ++step;
                switch (c) {
                    case 'N':
                        ++y;
                        break;
                    case 'S':
                        --y;
                        break;
                    case 'E':
                        ++x;
                        break;
                    case 'W':
                        --x;
                        break;
                    default:
                        break;
                }
                if (Math.abs(x) + Math.abs(y) <= step && ans == 0)
                    ans = step;
            }
            writer.println(ans == 0 ? "IMPOSSIBLE" : ans);
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