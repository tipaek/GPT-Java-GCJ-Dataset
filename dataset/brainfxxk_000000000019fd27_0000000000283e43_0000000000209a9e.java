import java.io.*;
import java.nio.CharBuffer;
import java.util.NoSuchElementException;

public class Solution {

    private static int times;
    private static SimpleScanner scanner = new SimpleScanner(System.in);
    private static PrintWriter writer = new PrintWriter(System.out);

    public static void main(String[] args) {
        int caseNum = scanner.nextInt();
        int n = scanner.nextInt();
        for (int caseNo = 1; caseNo <= caseNum; ++caseNo) {
            int[] ans = new int[n];
            times = 0;
            int cur = 0;
            int firstSame = -1;
            int firstDiff = -1;
            while (cur < n - cur - 1) {
                if (times >= 10 && times % 10 == 0) {
                    boolean complement = false;
                    boolean reverse = false;
                    if (firstSame >= 0 && firstDiff >= 0) {
                        if (ans[firstSame] != query(firstSame))
                            complement = true;
                        if (!complement) {
                            if (ans[firstDiff] != query(firstDiff))
                                reverse = true;
                        } else {
                            if (ans[firstDiff] == query(firstDiff))
                                reverse = true;
                        }
                    } else if (firstSame >= 0) {
                        if (ans[firstSame] != query(firstSame))
                            complement = true;
                        query(firstSame);
                    } else {
                        if (ans[firstDiff] != query(firstDiff))
                            complement = true;
                    }
                    if (complement)
                        for (int i = 0; i < cur; ++i)
                            ans[i] ^= 1;
                    if (reverse)
                        for (int i = 0; i < cur; ++i) {
                            int t = ans[i];
                            ans[i] = ans[n - i - 1];
                            ans[n - i - 1] = t;
                        }
                } else {
                    ans[cur] = query(cur);
                    ans[n - cur - 1] = query(n - cur - 1);
                    if (ans[cur] == ans[n - cur - 1])
                        firstSame = firstSame < 0 ? cur : firstSame;
                    else
                        firstDiff = firstDiff < 0 ? cur : firstDiff;
                    ++cur;
                }
            }
            for (int i = 0; i < n; ++i)
                writer.print(ans[i]);
            writer.println();
            writer.flush();
            char r = scanner.nextChar();
            if (r != 'Y')
                break;
        }
        writer.close();
    }

    private static int query(int idx) {
        writer.println(idx + 1);
        writer.flush();
        ++times;
        return scanner.nextInt();
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
