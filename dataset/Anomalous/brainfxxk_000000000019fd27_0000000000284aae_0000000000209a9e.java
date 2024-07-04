import java.io.*;
import java.nio.CharBuffer;
import java.util.NoSuchElementException;

public class Solution {

    private static int queryCount;
    private static SimpleScanner scanner = new SimpleScanner(System.in);
    private static PrintWriter writer = new PrintWriter(System.out);

    public static void main(String[] args) {
        int totalCases = scanner.nextInt();
        int arraySize = scanner.nextInt();
        
        for (int currentCase = 1; currentCase <= totalCases; ++currentCase) {
            int[] resultArray = new int[arraySize];
            queryCount = 0;
            int currentIndex = 0;
            int firstEqualIndex = -1;
            int firstDifferentIndex = -1;
            
            while (currentIndex < arraySize - currentIndex - 1) {
                if (queryCount >= 10 && queryCount % 10 == 0) {
                    boolean complement = false;
                    boolean reverse = false;
                    
                    if (firstEqualIndex >= 0 && firstDifferentIndex >= 0) {
                        if (resultArray[firstEqualIndex] != performQuery(firstEqualIndex))
                            complement = true;
                        if (!complement) {
                            if (resultArray[firstDifferentIndex] != performQuery(firstDifferentIndex))
                                reverse = true;
                        } else {
                            if (resultArray[firstDifferentIndex] == performQuery(firstDifferentIndex))
                                reverse = true;
                        }
                    } else if (firstEqualIndex >= 0) {
                        if (resultArray[firstEqualIndex] != performQuery(firstEqualIndex))
                            complement = true;
                        performQuery(firstEqualIndex);
                    } else {
                        if (resultArray[firstDifferentIndex] != performQuery(firstDifferentIndex))
                            complement = true;
                        performQuery(firstDifferentIndex);
                    }
                    
                    if (complement) {
                        for (int i = 0; i < currentIndex; ++i) {
                            resultArray[i] ^= 1;
                            resultArray[arraySize - i - 1] ^= 1;
                        }
                    }
                    
                    if (reverse) {
                        for (int i = 0; i < currentIndex; ++i) {
                            int temp = resultArray[i];
                            resultArray[i] = resultArray[arraySize - i - 1];
                            resultArray[arraySize - i - 1] = temp;
                        }
                    }
                } else {
                    resultArray[currentIndex] = performQuery(currentIndex);
                    resultArray[arraySize - currentIndex - 1] = performQuery(arraySize - currentIndex - 1);
                    
                    if (resultArray[currentIndex] == resultArray[arraySize - currentIndex - 1])
                        firstEqualIndex = firstEqualIndex < 0 ? currentIndex : firstEqualIndex;
                    else
                        firstDifferentIndex = firstDifferentIndex < 0 ? currentIndex : firstDifferentIndex;
                    
                    ++currentIndex;
                }
            }
            
            for (int value : resultArray) {
                writer.print(value);
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

    private static int performQuery(int index) {
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

        private SimpleScanner(InputStream input) {
            this.input = new BufferedReader(new InputStreamReader(input));
            buffer = CharBuffer.allocate(BUFFER_SIZE);
            buffer.limit(0);
            endOfFile = false;
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
            
            StringBuilder stringBuilder = new StringBuilder();
            do {
                stringBuilder.append(character);
                character = readChar();
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