import java.io.*;
import java.nio.CharBuffer;
import java.util.NoSuchElementException;

public class Solution {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        PrintWriter writer = new PrintWriter(System.out);
        int caseCount = scanner.nextInt();
        for (int caseIndex = 1; caseIndex <= caseCount; ++caseIndex) {
            char[] inputChars = scanner.next().toCharArray();
            StringBuilder result = new StringBuilder();
            int depth = 0;
            for (char ch : inputChars) {
                int value = ch - '0';
                while (value < depth) {
                    result.append(')');
                    --depth;
                }
                while (value > depth) {
                    result.append('(');
                    ++depth;
                }
                result.append(ch);
            }
            while (depth > 0) {
                result.append(')');
                --depth;
            }
            writer.println(String.format("Case #%d: %s", caseIndex, result));
        }
        writer.close();
    }

    private static class FastScanner {
        private static final int BUFFER_SIZE = 10240;
        private Readable input;
        private CharBuffer buffer;
        private boolean endOfFile;

        private FastScanner(InputStream inputStream) {
            this.input = new BufferedReader(new InputStreamReader(inputStream));
            this.buffer = CharBuffer.allocate(BUFFER_SIZE);
            this.buffer.limit(0);
            this.endOfFile = false;
        }

        private char readChar() {
            if (!buffer.hasRemaining()) {
                buffer.clear();
                int bytesRead;
                try {
                    bytesRead = input.read(buffer);
                } catch (IOException e) {
                    bytesRead = -1;
                }
                if (bytesRead <= 0) {
                    endOfFile = true;
                    return '\0';
                }
                buffer.flip();
            }
            return buffer.get();
        }

        private void ensureNotEof() {
            if (endOfFile) {
                throw new NoSuchElementException();
            }
        }

        private char nextCharacter() {
            ensureNotEof();
            char character = readChar();
            ensureNotEof();
            return character;
        }

        private String next() {
            char character;
            do {
                character = readChar();
                ensureNotEof();
            } while (Character.isWhitespace(character));
            StringBuilder token = new StringBuilder();
            do {
                token.append(character);
                character = readChar();
            } while (!endOfFile && !Character.isWhitespace(character));
            return token.toString();
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