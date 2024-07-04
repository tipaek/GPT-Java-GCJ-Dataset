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
            List<Long> numbers = new ArrayList<>(n);
            
            for (int i = 0; i < n; ++i) {
                numbers.add(scanner.nextLong());
            }
            
            numbers.sort(Comparator.naturalOrder());
            long minCuts = d - 1;
            
            for (Long number : numbers) {
                for (long r = 1; r * r <= number; ++r) {
                    if (number % r != 0) {
                        continue;
                    }
                    long cuts = calculateCuts(r, d, numbers);
                    if (cuts >= 0) {
                        minCuts = Math.min(minCuts, cuts);
                    }
                    cuts = calculateCuts(number / r, d, numbers);
                    if (cuts >= 0) {
                        minCuts = Math.min(minCuts, cuts);
                    }
                }
            }
            writer.println(minCuts);
        }
        writer.close();
    }

    private static long calculateCuts(long divisor, int targetPieces, List<Long> numbers) {
        long totalPieces = 0;
        long totalCuts = 0;
        
        for (Long number : numbers) {
            if (totalPieces >= targetPieces) {
                break;
            }
            if (number % divisor == 0) {
                long pieces = number / divisor;
                long cuts = pieces - 1;
                
                if (totalPieces + pieces > targetPieces) {
                    pieces = targetPieces - totalPieces;
                    cuts = pieces;
                }
                totalPieces += pieces;
                totalCuts += cuts;
            }
        }
        
        if (totalPieces == targetPieces) {
            return totalCuts;
        }
        
        for (Long number : numbers) {
            if (totalPieces >= targetPieces) {
                break;
            }
            if (number % divisor != 0) {
                long pieces = number / divisor;
                long cuts = pieces;
                
                if (totalPieces + pieces > targetPieces) {
                    pieces = targetPieces - totalPieces;
                    cuts = pieces;
                }
                totalPieces += pieces;
                totalCuts += cuts;
            }
        }
        
        return totalPieces == targetPieces ? totalCuts : -1;
    }

    private static class SimpleScanner {
        private static final int BUFFER_SIZE = 10240;
        private final Readable input;
        private final CharBuffer buffer;
        private boolean endOfFile;

        private SimpleScanner(InputStream in) {
            this.input = new BufferedReader(new InputStreamReader(in));
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

        private void ensureNotEndOfFile() {
            if (endOfFile) {
                throw new NoSuchElementException();
            }
        }

        private char nextChar() {
            ensureNotEndOfFile();
            char character = read();
            ensureNotEndOfFile();
            return character;
        }

        private String next() {
            char character;
            do {
                character = read();
                ensureNotEndOfFile();
            } while (Character.isWhitespace(character));
            
            StringBuilder result = new StringBuilder();
            do {
                result.append(character);
                character = read();
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