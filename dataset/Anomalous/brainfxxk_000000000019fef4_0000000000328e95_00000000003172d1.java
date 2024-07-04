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
        int numberOfCases = scanner.nextInt();
        for (int caseIndex = 1; caseIndex <= numberOfCases; ++caseIndex) {
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
                for (long r = 1; r * r <= numbers.get(i); ++r) {
                    if (numbers.get(i) % r != 0) {
                        continue;
                    }
                    long cuts = calculateCuts(i, r, d, numbers);
                    if (cuts >= 0) {
                        minimumCuts = Math.min(minimumCuts, cuts);
                    }
                    cuts = calculateCuts(i, numbers.get(i) / r, d, numbers);
                    if (cuts >= 0) {
                        minimumCuts = Math.min(minimumCuts, cuts);
                    }
                }
            }
            writer.println(minimumCuts);
        }
        writer.close();
    }

    private static long calculateCuts(int index, long divisor, int desiredPieces, List<Long> numbers) {
        long currentPieces = 0;
        long cuts = 0;
        for (int j = index; j < numbers.size() && currentPieces < desiredPieces; ++j) {
            if (numbers.get(j) % divisor == 0) {
                long additionalPieces = numbers.get(j) / divisor;
                long additionalCuts = additionalPieces - 1;
                if (currentPieces + additionalPieces > desiredPieces) {
                    additionalPieces = desiredPieces - currentPieces;
                    additionalCuts = additionalPieces;
                }
                currentPieces += additionalPieces;
                cuts += additionalCuts;
            }
        }
        if (currentPieces == desiredPieces) {
            return cuts;
        }
        for (int j = index; j < numbers.size() && currentPieces < desiredPieces; ++j) {
            if (numbers.get(j) % divisor != 0) {
                long additionalPieces = numbers.get(j) / divisor;
                long additionalCuts = additionalPieces;
                if (currentPieces + additionalPieces > desiredPieces) {
                    additionalPieces = desiredPieces - currentPieces;
                    additionalCuts = additionalPieces;
                }
                currentPieces += additionalPieces;
                cuts += additionalCuts;
            }
        }
        return currentPieces == desiredPieces ? cuts : -1;
    }

    private static class SimpleScanner {

        private static final int BUFFER_SIZE = 10240;
        private final Readable input;
        private final CharBuffer buffer;
        private boolean endOfFile;

        private SimpleScanner(InputStream inputStream) {
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

        private void ensureNotEOF() {
            if (endOfFile) {
                throw new NoSuchElementException();
            }
        }

        private char nextChar() {
            ensureNotEOF();
            char character = readChar();
            ensureNotEOF();
            return character;
        }

        private String next() {
            char character;
            do {
                character = readChar();
                ensureNotEOF();
            } while (Character.isWhitespace(character));
            StringBuilder result = new StringBuilder();
            do {
                result.append(character);
                character = readChar();
            } while (!endOfFile && !Character.isWhitespace(character));
            return result.toString();
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