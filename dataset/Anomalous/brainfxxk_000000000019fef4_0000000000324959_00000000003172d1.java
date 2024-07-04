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
        int caseCount = scanner.nextInt();
        for (int caseIndex = 1; caseIndex <= caseCount; ++caseIndex) {
            writer.printf("Case #%d: ", caseIndex);
            int n = scanner.nextInt();
            int d = scanner.nextInt();
            List<Long> elements = new ArrayList<>(n);
            for (int i = 0; i < n; ++i) {
                elements.add(scanner.nextLong());
            }
            elements.sort(Comparator.naturalOrder());
            long result = d - 1;
            for (int i = 0; i < n; ++i) {
                long pieces = 0;
                long cuts = 0;
                for (int j = i; j < n && pieces < d; ++j) {
                    if (elements.get(j) % elements.get(i) == 0) {
                        long incrementPiece = elements.get(j) / elements.get(i);
                        long incrementCut = incrementPiece - 1;
                        if (pieces + incrementPiece > d) {
                            incrementPiece = d - pieces;
                            incrementCut = incrementPiece;
                        }
                        pieces += incrementPiece;
                        cuts += incrementCut;
                    }
                }
                if (pieces == d) {
                    result = Math.min(result, cuts);
                }
                for (int j = i; j < n && pieces < d; ++j) {
                    if (elements.get(j) % elements.get(i) != 0) {
                        long incrementPiece = elements.get(j) / elements.get(i);
                        long incrementCut = incrementPiece;
                        if (pieces + incrementPiece > d) {
                            incrementPiece = d - pieces;
                            incrementCut = incrementPiece;
                        }
                        pieces += incrementPiece;
                        cuts += incrementCut;
                    }
                }
                if (pieces == d) {
                    result = Math.min(result, cuts);
                }
            }
            writer.println(result);
            writer.flush();
        }
        writer.close();
    }

    private static class SimpleScanner {

        private static final int BUFFER_SIZE = 10240;
        private Readable input;
        private CharBuffer buffer;
        private boolean eof;

        private SimpleScanner(InputStream input) {
            this.input = new BufferedReader(new InputStreamReader(input));
            buffer = CharBuffer.allocate(BUFFER_SIZE);
            buffer.limit(0);
            eof = false;
        }

        private char readChar() {
            if (!buffer.hasRemaining()) {
                buffer.clear();
                int charsRead;
                try {
                    charsRead = input.read(buffer);
                } catch (IOException e) {
                    charsRead = -1;
                }
                if (charsRead <= 0) {
                    eof = true;
                    return '\0';
                }
                buffer.flip();
            }
            return buffer.get();
        }

        private void ensureNotEof() {
            if (eof) {
                throw new NoSuchElementException();
            }
        }

        private char nextChar() {
            ensureNotEof();
            char character = readChar();
            ensureNotEof();
            return character;
        }

        private String nextToken() {
            char character;
            do {
                character = readChar();
                ensureNotEof();
            } while (Character.isWhitespace(character));
            StringBuilder tokenBuilder = new StringBuilder();
            do {
                tokenBuilder.append(character);
                character = readChar();
            } while (!eof && !Character.isWhitespace(character));
            return tokenBuilder.toString();
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