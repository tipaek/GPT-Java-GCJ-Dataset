import java.io.*;
import java.nio.CharBuffer;
import java.util.NoSuchElementException;

public class Solution {
    public static void main(String[] args) {
        SimpleScanner scanner = new SimpleScanner(System.in);
        PrintWriter writer = new PrintWriter(System.out);
        int caseCount = scanner.nextInt();
        for (int caseIndex = 1; caseIndex <= caseCount; ++caseIndex) {
            writer.print(String.format("Case #%d: ", caseIndex));
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            char[] directions = scanner.next().toCharArray();
            int result = 0;
            int steps = 0;
            for (char direction : directions) {
                ++steps;
                switch (direction) {
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
                }
                if (Math.abs(x) + Math.abs(y) <= steps && result == 0)
                    result = steps;
            }
            writer.println(result == 0 ? "IMPOSSIBLE" : result);
        }
        writer.close();
    }

    private static class SimpleScanner {

        private static final int BUFFER_CAPACITY = 10240;

        private Readable input;
        private CharBuffer buffer;
        private boolean endOfFile;

        private SimpleScanner(InputStream inputStream) {
            this.input = new BufferedReader(new InputStreamReader(inputStream));
            this.buffer = CharBuffer.allocate(BUFFER_CAPACITY);
            this.buffer.limit(0);
            this.endOfFile = false;
        }

        private char readCharacter() {
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
            if (endOfFile)
                throw new NoSuchElementException();
        }

        private char nextCharacter() {
            ensureNotEof();
            char character = readCharacter();
            ensureNotEof();
            return character;
        }

        private String nextToken() {
            char character;
            do {
                character = readCharacter();
                ensureNotEof();
            } while (Character.isWhitespace(character));
            StringBuilder token = new StringBuilder();
            do {
                token.append(character);
                character = readCharacter();
            } while (!endOfFile && !Character.isWhitespace(character));
            return token.toString();
        }

        private int nextInt() {
            return Integer.parseInt(nextToken());
        }

        private long nextLong() {
            return Long.parseLong(nextToken());
        }

        private double nextDouble() {
            return Double.parseDouble(nextToken());
        }
    }
}