import java.io.*;
import java.nio.CharBuffer;
import java.util.NoSuchElementException;

public class Solution {

    private static int queryCount;
    private static SimpleScanner scanner = new SimpleScanner(System.in);
    private static PrintWriter writer = new PrintWriter(System.out);

    public static void main(String[] args) {
        int totalCases = scanner.nextInt();
        int arrayLength = scanner.nextInt();
        for (int caseIndex = 1; caseIndex <= totalCases; ++caseIndex) {
            int[] resultArray = new int[arrayLength];
            queryCount = 0;
            int currentIndex = 0;
            int samePairIndex = -1;
            int diffPairIndex = -1;
            while (currentIndex < arrayLength - currentIndex - 1) {
                if (queryCount >= 10 && queryCount % 10 == 0) {
                    boolean complement = false;
                    boolean reverse = false;
                    if (samePairIndex >= 0 && diffPairIndex >= 0) {
                        if (resultArray[samePairIndex] != query(samePairIndex))
                            complement = true;
                        if (!complement) {
                            if (resultArray[diffPairIndex] != query(diffPairIndex))
                                reverse = true;
                        } else {
                            if (resultArray[diffPairIndex] == query(diffPairIndex))
                                reverse = true;
                        }
                    } else if (samePairIndex >= 0) {
                        if (resultArray[samePairIndex] != query(samePairIndex))
                            complement = true;
                        query(samePairIndex);
                    } else {
                        if (resultArray[diffPairIndex] != query(diffPairIndex))
                            complement = true;
                    }
                    if (complement) {
                        for (int i = 0; i < currentIndex; ++i) {
                            resultArray[i] ^= 1;
                        }
                    }
                    if (reverse) {
                        for (int i = 0; i < currentIndex; ++i) {
                            int temp = resultArray[i];
                            resultArray[i] = resultArray[arrayLength - i - 1];
                            resultArray[arrayLength - i - 1] = temp;
                        }
                    }
                } else {
                    resultArray[currentIndex] = query(currentIndex);
                    resultArray[arrayLength - currentIndex - 1] = query(arrayLength - currentIndex - 1);
                    if (resultArray[currentIndex] == resultArray[arrayLength - currentIndex - 1]) {
                        samePairIndex = samePairIndex < 0 ? currentIndex : samePairIndex;
                    } else {
                        diffPairIndex = diffPairIndex < 0 ? currentIndex : diffPairIndex;
                    }
                    ++currentIndex;
                }
            }
            for (int i = 0; i < arrayLength; ++i) {
                writer.print(resultArray[i]);
            }
            writer.println();
            writer.flush();
            char response = scanner.nextChar();
            if (response != 'Y') {
                break;
            }
        }
        writer.close();
    }

    private static int query(int index) {
        writer.println(index + 1);
        writer.flush();
        ++queryCount;
        return scanner.nextInt();
    }

    private static class SimpleScanner {

        private static final int BUFFER_SIZE = 10240;

        private Readable input;
        private CharBuffer buffer;
        private boolean endOfFile;

        private SimpleScanner(InputStream inputStream) {
            this.input = new BufferedReader(new InputStreamReader(inputStream));
            this.buffer = CharBuffer.allocate(BUFFER_SIZE);
            this.buffer.limit(0);
            this.endOfFile = false;
        }

        private char read() {
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

        private void checkEndOfFile() {
            if (endOfFile) {
                throw new NoSuchElementException();
            }
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
            StringBuilder stringBuilder = new StringBuilder();
            do {
                stringBuilder.append(character);
                character = read();
            } while (!endOfFile && !Character.isWhitespace(character));
            return stringBuilder.toString();
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