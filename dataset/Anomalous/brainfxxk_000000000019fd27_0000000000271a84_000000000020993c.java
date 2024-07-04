import java.io.*;
import java.nio.CharBuffer;
import java.util.HashSet;
import java.util.NoSuchElementException;

public class Solution {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        PrintWriter writer = new PrintWriter(System.out);
        int caseCount = scanner.nextInt();
        for (int caseIndex = 1; caseIndex <= caseCount; caseIndex++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }
            int duplicateRows = 0;
            int duplicateCols = 0;
            for (int i = 0; i < n; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                HashSet<Integer> colSet = new HashSet<>();
                boolean rowHasDuplicate = false;
                boolean colHasDuplicate = false;
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        rowHasDuplicate = true;
                    }
                    if (!colSet.add(matrix[j][i])) {
                        colHasDuplicate = true;
                    }
                }
                if (rowHasDuplicate) {
                    duplicateRows++;
                }
                if (colHasDuplicate) {
                    duplicateCols++;
                }
            }
            writer.printf("Case #%d: %d %d %d%n", caseIndex, trace, duplicateRows, duplicateCols);
        }
        writer.close();
    }

    private static class FastScanner {
        private static final int BUFFER_CAPACITY = 10240;
        private Readable input;
        private CharBuffer buffer;
        private boolean endOfFile;

        private FastScanner(InputStream inputStream) {
            this.input = new BufferedReader(new InputStreamReader(inputStream));
            buffer = CharBuffer.allocate(BUFFER_CAPACITY);
            buffer.limit(0);
            endOfFile = false;
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

        private void ensureNotEndOfFile() {
            if (endOfFile) {
                throw new NoSuchElementException();
            }
        }

        private char nextChar() {
            ensureNotEndOfFile();
            char character = readChar();
            ensureNotEndOfFile();
            return character;
        }

        private String next() {
            char character;
            do {
                character = readChar();
                ensureNotEndOfFile();
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