import java.io.*;
import java.nio.CharBuffer;
import java.util.NoSuchElementException;

public class Solution {

    private static int queryCount;
    private static SimpleScanner scanner = new SimpleScanner(System.in);
    private static PrintWriter writer = new PrintWriter(System.out);

    public static void main(String[] args) {
        int caseCount = scanner.nextInt();
        int arraySize = scanner.nextInt();
        for (int caseIndex = 1; caseIndex <= caseCount; ++caseIndex) {
            int[] result = new int[arraySize];
            queryCount = 0;
            int currentIndex = 0;
            int firstEqualIndex = -1;
            int firstDifferentIndex = -1;
            while (currentIndex < arraySize - currentIndex - 1) {
                if (queryCount >= 10 && queryCount % 10 == 0) {
                    boolean shouldComplement = false;
                    boolean shouldReverse = false;
                    if (firstEqualIndex >= 0 && firstDifferentIndex >= 0) {
                        if (result[firstEqualIndex] != query(firstEqualIndex))
                            shouldComplement = true;
                        if (!shouldComplement) {
                            if (result[firstDifferentIndex] != query(firstDifferentIndex))
                                shouldReverse = true;
                        } else {
                            if (result[firstDifferentIndex] == query(firstDifferentIndex))
                                shouldReverse = true;
                        }
                    } else if (firstEqualIndex >= 0) {
                        if (result[firstEqualIndex] != query(firstEqualIndex))
                            shouldComplement = true;
                        query(firstEqualIndex);
                    } else {
                        if (result[firstDifferentIndex] != query(firstDifferentIndex))
                            shouldComplement = true;
                    }
                    if (shouldComplement)
                        for (int i = 0; i < currentIndex; ++i)
                            result[i] ^= 1;
                    if (shouldReverse)
                        for (int i = 0; i < currentIndex; ++i) {
                            int temp = result[i];
                            result[i] = result[arraySize - i - 1];
                            result[arraySize - i - 1] = temp;
                        }
                } else {
                    result[currentIndex] = query(currentIndex);
                    result[arraySize - currentIndex - 1] = query(arraySize - currentIndex - 1);
                    if (result[currentIndex] == result[arraySize - currentIndex - 1])
                        firstEqualIndex = firstEqualIndex < 0 ? currentIndex : firstEqualIndex;
                    else
                        firstDifferentIndex = firstDifferentIndex < 0 ? currentIndex : firstDifferentIndex;
                    ++currentIndex;
                }
            }
            for (int i = 0; i < arraySize; ++i)
                writer.print(result[i]);
            writer.println();
            writer.flush();
            char response = scanner.nextChar();
            if (response != 'Y')
                break;
        }
        writer.close();
    }

    private static int query(int index) {
        writer.println(index + 1);
        writer.flush();
        return scanner.nextInt();
    }

    private static class SimpleScanner {

        private static final int BUFFER_SIZE = 10240;

        private Readable input;
        private CharBuffer buffer;
        private boolean endOfFile;

        private SimpleScanner(InputStream inputStream) {
            this.input = new BufferedReader(new InputStreamReader(inputStream));
            buffer = CharBuffer.allocate(BUFFER_SIZE);
            buffer.limit(0);
            endOfFile = false;
        }

        private char read() {
            if (!buffer.hasRemaining()) {
                buffer.clear();
                int charsRead;
                try {
                    charsRead = input.read(buffer);
                } catch (IOException e) {
                    charsRead = -1;
                }
                if (charsRead <= 0) {
                    endOfFile = true;
                    return '\0';
                }
                buffer.flip();
            }
            return buffer.get();
        }

        private void checkEndOfFile() {
            if (endOfFile)
                throw new NoSuchElementException();
        }

        private char nextChar() {
            checkEndOfFile();
            char character = read();
            checkEndOfFile();
            return character;
        }

        private String next() {
            char character;
            do {
                character = read();
                checkEndOfFile();
            } while (Character.isWhitespace(character));
            StringBuilder sb = new StringBuilder();
            do {
                sb.append(character);
                character = read();
            } while (!endOfFile && !Character.isWhitespace(character));
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