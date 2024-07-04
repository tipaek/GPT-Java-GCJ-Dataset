import java.io.IOException;
import java.io.InputStream;
import java.util.BitSet;
import java.util.InputMismatchException;

public class Vestigium {

    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        int testCases = reader.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            processTestCase(reader, caseNumber);
        }
    }

    private static void processTestCase(InputReader reader, int caseNumber) {
        int matrixSize = reader.nextInt();
        int expectedSum = (matrixSize * (matrixSize + 1)) / 2;
        
        int[][] matrix = new int[matrixSize][matrixSize];
        
        // Populate the matrix
        for (int i = 0; i < matrixSize; i++) {
            matrix[i] = reader.nextIntArray(matrixSize);
        }
        
        int trace = 0;
        int duplicateRows = 0;
        int duplicateColumns = 0;
        
        for (int i = 0; i < matrixSize; i++) {
            BitSet rowTracker = new BitSet(matrixSize);
            BitSet columnTracker = new BitSet(matrixSize);
            
            for (int j = 0; j < matrixSize; j++) {
                if (i == j) {
                    trace += matrix[i][j];
                }
                
                rowTracker.flip(matrix[i][j]);
                columnTracker.flip(matrix[j][i]);
            }
            
            if (rowTracker.cardinality() != matrixSize) {
                duplicateRows++;
            }
            
            if (columnTracker.cardinality() != matrixSize) {
                duplicateColumns++;
            }
        }
        
        System.out.println("Case #" + caseNumber + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
    }
    
    static class InputReader {

        private final InputStream stream;
        private final byte[] buffer = new byte[8192];
        private int currentChar, numChars;
        private SpaceCharFilter filter;
        
        public InputReader(InputStream stream) {
            this.stream = stream;
        }
        
        public int next() {
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
            int c = next();
            while (isSpaceChar(c)) {
                c = next();
            }
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = next();
            }
            int result = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                result *= 10;
                result += c - '0';
                c = next();
            } while (!isSpaceChar(c));
            return result * sign;
        }
        
        public long nextLong() {
            int c = next();
            while (isSpaceChar(c)) {
                c = next();
            }
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = next();
            }
            long result = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                result *= 10;
                result += c - '0';
                c = next();
            } while (!isSpaceChar(c));
            return result * sign;
        }
        
        public int[] nextIntArray(int n) {
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = nextInt();
            }
            return array;
        }
        
        public long[] nextLongArray(int n) {
            long[] array = new long[n];
            for (int i = 0; i < n; i++) {
                array[i] = nextLong();
            }
            return array;
        }
        
        public String readString() {
            int c = next();
            while (isSpaceChar(c)) {
                c = next();
            }
            StringBuilder result = new StringBuilder();
            do {
                result.appendCodePoint(c);
                c = next();
            } while (!isSpaceChar(c));
            return result.toString();
        }
        
        public String nextLine() {
            int c = next();
            while (isSpaceChar(c)) {
                c = next();
            }
            StringBuilder result = new StringBuilder();
            do {
                result.appendCodePoint(c);
                c = next();
            } while (!isEndOfLine(c));
            return result.toString();
        }
        
        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
        
        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }
        
        public interface SpaceCharFilter {
            boolean isSpaceChar(int ch);
        }
    }
}