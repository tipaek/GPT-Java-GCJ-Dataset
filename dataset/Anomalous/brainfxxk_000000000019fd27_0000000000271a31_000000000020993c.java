import java.io.*;
import java.nio.CharBuffer;
import java.util.HashSet;
import java.util.NoSuchElementException;

public class Solution {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        PrintWriter writer = new PrintWriter(System.out);
        int caseCount = scanner.nextInt();
        for (int caseIndex = 1; caseIndex <= caseCount; ++caseIndex) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            for (int i = 0; i < size; ++i) {
                for (int j = 0; j < size; ++j) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = 0;
            for (int i = 0; i < size; ++i) {
                trace += matrix[i][i];
            }

            int duplicateRows = 0, duplicateCols = 0;
            for (int i = 0; i < size; ++i) {
                HashSet<Integer> rowSet = new HashSet<>();
                HashSet<Integer> colSet = new HashSet<>();
                boolean rowHasDuplicate = false;
                boolean colHasDuplicate = false;

                for (int j = 0; j < size; ++j) {
                    if (!rowSet.add(matrix[i][j])) {
                        rowHasDuplicate = true;
                    }
                    if (!colSet.add(matrix[j][i])) {
                        colHasDuplicate = true;
                    }
                }

                if (rowHasDuplicate) {
                    ++duplicateRows;
                }
                if (colHasDuplicate) {
                    ++duplicateCols;
                }
            }

            writer.println(String.format("Case #%d: %d %d %d", caseIndex, trace, duplicateRows, duplicateCols));
        }
        writer.close();
    }

    private static class FastScanner {
        private static final int BUFFER_SIZE = 10240;
        private Readable input;
        private CharBuffer buffer;
        private boolean endOfFile;

        private FastScanner(InputStream inputStream) {
            this.input = new BufferedReader(new InputStreamReader(inputStream));
            this.buffer = CharBuffer.allocate(BUFFER_SIZE);
            this.buffer.limit(0);
            this.endOfFile = false;
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

        private void verifyEndOfFile() {
            if (endOfFile) {
                throw new NoSuchElementException();
            }
        }

        private char nextChar() {
            verifyEndOfFile();
            char ch = readChar();
            verifyEndOfFile();
            return ch;
        }

        private String next() {
            char ch;
            do {
                ch = readChar();
                verifyEndOfFile();
            } while (Character.isWhitespace(ch));

            StringBuilder sb = new StringBuilder();
            do {
                sb.append(ch);
                ch = readChar();
            } while (!endOfFile && !Character.isWhitespace(ch));

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