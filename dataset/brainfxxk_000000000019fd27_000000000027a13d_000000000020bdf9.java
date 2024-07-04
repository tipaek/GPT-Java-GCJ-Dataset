import java.io.*;
import java.nio.CharBuffer;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        SimpleScanner scanner = new SimpleScanner(System.in);
        PrintWriter writer = new PrintWriter(System.out);
        int caseNum = scanner.nextInt();
        for (int caseNo = 1; caseNo <= caseNum; ++caseNo) {
            int n = scanner.nextInt();
            List<List<Integer>> links = new ArrayList<>();
            int[] s = new int[n];
            int[] e = new int[n];
            for (int i = 0; i < n; ++i) {
                links.add(new LinkedList<>());
                s[i] = scanner.nextInt();
                e[i] = scanner.nextInt();
            }
            for (int i = 0; i < n; ++i)
                for (int j = i + 1; j < n; ++j) {
                    if (s[i] >= e[j] || e[i] <= s[j])
                        continue;
                    links.get(i).add(j);
                    links.get(j).add(i);
                }
            int[] color = new int[n];
            Arrays.fill(color, -1);
            boolean valid = true;
            for (int i = 0; i < n; ++i) {
                if (color[i] < 0)
                    if (!search(links, i, 0, color)) {
                        valid = false;
                        break;
                    }
            }
            writer.print(String.format("Case #%d: ", caseNo));
            if (!valid)
                writer.println("IMPOSSIBLE");
            else {
                for (int i = 0; i < n; ++i)
                    writer.print(color[i] == 0 ? "C" : "J");
                writer.println();
            }
        }
        writer.close();
    }

    private static boolean search(List<List<Integer>> links, int u, int c, int[] color) {
        color[u] = c;
        for (int v : links.get(u)) {
            if (color[v] < 0) {
                if (!search(links, v, c ^ 1, color))
                    return false;
            } else {
                if (color[v] != (c ^ 1))
                    return false;
            }
        }
        return true;
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