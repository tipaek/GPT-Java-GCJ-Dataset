import java.io.IOException;
import java.io.InputStream;
import java.util.BitSet;
import java.util.InputMismatchException;

public class Solution {

    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        int testCases = reader.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            processTestCase(reader, i);
        }
    }

    private static void processTestCase(InputReader reader, int caseNumber) {
        int size = reader.nextInt();
        int expectedSum = size * (size + 1) / 2;
        
        int[][] matrix = new int[size][size];
        
        for (int i = 0; i < size; i++) {
            matrix[i] = reader.nextIntArray(size);
        }
        
        int trace = 0;
        int duplicateRows = 0;
        int duplicateColumns = 0;
        
        for (int i = 0; i < size; i++) {
            BitSet rowCheck = new BitSet(size);
            BitSet colCheck = new BitSet(size);
            
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    trace += matrix[i][j];
                }
                rowCheck.flip(matrix[i][j]);
                colCheck.flip(matrix[j][i]);
            }
            
            if (rowCheck.cardinality() != size) {
                duplicateRows++;
            }
            
            if (colCheck.cardinality() != size) {
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
        
        private int nextChar() {
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
            int c = nextChar();
            while (isSpaceChar(c)) {
                c = nextChar();
            }
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = nextChar();
            }
            int result = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                result = result * 10 + c - '0';
                c = nextChar();
            } while (!isSpaceChar(c));
            return result * sign;
        }
        
        public int[] nextIntArray(int size) {
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = nextInt();
            }
            return array;
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