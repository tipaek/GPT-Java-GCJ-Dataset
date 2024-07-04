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
            writer.print(String.format("Case #%d: ", caseIndex));
            int n = scanner.nextInt();
            int d = scanner.nextInt();
            List<Long> numbers = new ArrayList<>(n);
            for (int i = 0; i < n; ++i) {
                numbers.add(scanner.nextLong());
            }
            numbers.sort(Comparator.naturalOrder());
            long minimumCuts = d - 1;
            for (int i = 0; i < n; ++i) {
                long pieces = 0;
                long cuts = 0;
                for (int j = i; j < n && pieces < d; ++j) {
                    long additionalPieces = numbers.get(j) / numbers.get(i);
                    long additionalCuts = additionalPieces;
                    if (numbers.get(j) % numbers.get(i) == 0) {
                        --additionalCuts;
                    }
                    if (pieces + additionalPieces > d) {
                        additionalPieces = d - pieces;
                        additionalCuts = additionalPieces;
                    }
                    pieces += additionalPieces;
                    cuts += additionalCuts;
                }
                if (pieces == d) {
                    minimumCuts = Math.min(minimumCuts, cuts);
                }
            }
            writer.println(minimumCuts);
        }
        writer.close();
    }

    private static class SimpleScanner {

        private static final int BUFFER_SIZE = 10240;

        private Readable inputSource;
        private CharBuffer buffer;
        private boolean endOfFile;

        private SimpleScanner(InputStream inputStream) {
            this.inputSource = new BufferedReader(new InputStreamReader(inputStream));
            buffer = CharBuffer.allocate(BUFFER_SIZE);
            buffer.limit(0);
            endOfFile = false;
        }

        private char readCharacter() {
            if (!buffer.hasRemaining()) {
                buffer.clear();
                int numRead;
                try {
                    numRead = inputSource.read(buffer);
                } catch (IOException e) {
                    numRead = -1;
                }
                if (numRead <= 0) {
                    endOfFile = true;
                    return '\0';
                }
                buffer.flip();
            }
            return buffer.get();
        }

        private void ensureNotEndOfFile() {
            if (endOfFile) {
                throw new NoSuchElementException();
            }
        }

        private char nextCharacter() {
            ensureNotEndOfFile();
            char ch = readCharacter();
            ensureNotEndOfFile();
            return ch;
        }

        private String nextToken() {
            char ch;
            do {
                ch = readCharacter();
                ensureNotEndOfFile();
            } while (Character.isWhitespace(ch));
            StringBuilder token = new StringBuilder();
            do {
                token.append(ch);
                ch = readCharacter();
            } while (!endOfFile && !Character.isWhitespace(ch));
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