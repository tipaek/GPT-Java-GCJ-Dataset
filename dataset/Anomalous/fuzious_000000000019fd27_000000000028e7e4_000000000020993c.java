import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        InputReader inputReader = new InputReader(System.in);
        int testCaseCount = inputReader.nextInt();
        
        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            int matrixSize = inputReader.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int duplicateRows = 0, duplicateCols = 0, diagonalSum = 0;
            
            for (int i = 0; i < matrixSize; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = inputReader.nextInt();
                    rowSet.add(matrix[i][j]);
                }
                if (rowSet.size() < matrixSize) {
                    duplicateRows++;
                }
            }
            
            for (int j = 0; j < matrixSize; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int i = 0; i < matrixSize; i++) {
                    colSet.add(matrix[i][j]);
                }
                if (colSet.size() < matrixSize) {
                    duplicateCols++;
                }
            }
            
            for (int i = 0; i < matrixSize; i++) {
                diagonalSum += matrix[i][i];
            }
            
            out.println("Case #" + testCase + ": " + diagonalSum + " " + duplicateRows + " " + duplicateCols);
        }
        
        out.close();
    }

    private static final PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    
    static class InputReader {
        private final InputStream stream;
        private final byte[] buffer = new byte[8192];
        private int currentChar, numChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        private int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (currentChar >= numChars) {
                currentChar = 0;
                try {
                    numChars = stream.read(buffer);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buffer[currentChar++];
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            int result = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                result = result * 10 + (c - '0');
                c = read();
            } while (!isSpaceChar(c));
            return result * sign;
        }

        public String nextString() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder result = new StringBuilder();
            do {
                result.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return result.toString();
        }

        private boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public interface SpaceCharFilter {
            boolean isSpaceChar(int ch);
        }
    }
}