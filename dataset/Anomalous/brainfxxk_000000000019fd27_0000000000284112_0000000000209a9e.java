import java.io.*;
import java.nio.CharBuffer;
import java.util.NoSuchElementException;

public class Solution {

    private static int queryCount;
    private static InputScanner scanner = new InputScanner(System.in);
    private static PrintWriter output = new PrintWriter(System.out);

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        int arrayLength = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; ++testCase) {
            int[] resultArray = new int[arrayLength];
            queryCount = 0;
            int currentIndex = 0;
            int sameIndex = -1;
            int diffIndex = -1;
            
            while (currentIndex < arrayLength - currentIndex - 1) {
                if (queryCount >= 10 && queryCount % 10 == 0) {
                    boolean needComplement = false;
                    boolean needReverse = false;
                    
                    if (sameIndex >= 0 && diffIndex >= 0) {
                        if (resultArray[sameIndex] != executeQuery(sameIndex)) {
                            needComplement = true;
                        }
                        if (!needComplement) {
                            if (resultArray[diffIndex] != executeQuery(diffIndex)) {
                                needReverse = true;
                            }
                        } else {
                            if (resultArray[diffIndex] == executeQuery(diffIndex)) {
                                needReverse = true;
                            }
                        }
                    } else if (sameIndex >= 0) {
                        if (resultArray[sameIndex] != executeQuery(sameIndex)) {
                            needComplement = true;
                        }
                        executeQuery(sameIndex);
                    } else {
                        if (resultArray[diffIndex] != executeQuery(diffIndex)) {
                            needComplement = true;
                        }
                        executeQuery(diffIndex);
                    }
                    
                    if (needComplement) {
                        for (int i = 0; i < currentIndex; ++i) {
                            resultArray[i] ^= 1;
                        }
                    }
                    if (needReverse) {
                        for (int i = 0; i < currentIndex; ++i) {
                            int temp = resultArray[i];
                            resultArray[i] = resultArray[arrayLength - i - 1];
                            resultArray[arrayLength - i - 1] = temp;
                        }
                    }
                } else {
                    resultArray[currentIndex] = executeQuery(currentIndex);
                    resultArray[arrayLength - currentIndex - 1] = executeQuery(arrayLength - currentIndex - 1);
                    
                    if (resultArray[currentIndex] == resultArray[arrayLength - currentIndex - 1]) {
                        sameIndex = sameIndex < 0 ? currentIndex : sameIndex;
                    } else {
                        diffIndex = diffIndex < 0 ? currentIndex : diffIndex;
                    }
                    ++currentIndex;
                }
            }
            
            for (int i = 0; i < arrayLength; ++i) {
                output.print(resultArray[i]);
            }
            output.println();
            output.flush();
            
            char response = scanner.nextChar();
            if (response != 'Y') {
                break;
            }
        }
        output.close();
    }

    private static int executeQuery(int index) {
        output.println(index + 1);
        output.flush();
        ++queryCount;
        return scanner.nextInt();
    }

    private static class InputScanner {

        private static final int BUFFER_SIZE = 10240;
        private Readable inputSource;
        private CharBuffer buffer;
        private boolean endOfFile;

        private InputScanner(InputStream inputStream) {
            this.inputSource = new BufferedReader(new InputStreamReader(inputStream));
            this.buffer = CharBuffer.allocate(BUFFER_SIZE);
            this.buffer.limit(0);
            this.endOfFile = false;
        }

        private char readChar() {
            if (!buffer.hasRemaining()) {
                buffer.clear();
                int bytesRead;
                try {
                    bytesRead = inputSource.read(buffer);
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

        private String nextString() {
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
            return Integer.parseInt(nextString());
        }

        private long nextLong() {
            return Long.parseLong(nextString());
        }

        private double nextDouble() {
            return Double.parseDouble(nextString());
        }
    }
}