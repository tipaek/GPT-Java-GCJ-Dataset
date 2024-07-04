import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.InputMismatchException;

public class Solution {
    
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int testCases = scanner.nextInt();
        StringBuilder resultBuilder = new StringBuilder();
        
        for (int t = 1; t <= testCases; t++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            int trace = calculateTrace(matrix, matrixSize);
            int rowDuplicates = countRowDuplicates(matrix, matrixSize);
            int columnDuplicates = countColumnDuplicates(matrix, matrixSize);
            
            resultBuilder.append(String.format("Case #%d: %d %d %d%n", t, trace, rowDuplicates, columnDuplicates));
        }
        
        System.out.print(resultBuilder);
    }
    
    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }
    
    private static int countRowDuplicates(int[][] matrix, int size) {
        int duplicates = 0;
        for (int i = 0; i < size; i++) {
            HashSet<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < size; j++) {
                uniqueElements.add(matrix[i][j]);
            }
            if (uniqueElements.size() != size) {
                duplicates++;
            }
        }
        return duplicates;
    }
    
    private static int countColumnDuplicates(int[][] matrix, int size) {
        int duplicates = 0;
        for (int j = 0; j < size; j++) {
            HashSet<Integer> uniqueElements = new HashSet<>();
            for (int i = 0; i < size; i++) {
                uniqueElements.add(matrix[i][j]);
            }
            if (uniqueElements.size() != size) {
                duplicates++;
            }
        }
        return duplicates;
    }
    
    static class FastScanner {
        private InputStream stream;
        private byte[] buffer = new byte[1024];
        private int currentChar;
        private int numberOfChars;
        
        public FastScanner(InputStream stream) {
            this.stream = stream;
        }
        
        private int read() {
            if (numberOfChars == -1) {
                throw new InputMismatchException();
            }
            if (currentChar >= numberOfChars) {
                currentChar = 0;
                try {
                    numberOfChars = stream.read(buffer);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numberOfChars <= 0) {
                    return -1;
                }
            }
            return buffer[currentChar++];
        }
        
        private boolean isSpaceCharacter(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
        
        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }
        
        public int nextInt() {
            return Integer.parseInt(next());
        }
        
        public long nextLong() {
            return Long.parseLong(next());
        }
        
        public double nextDouble() {
            return Double.parseDouble(next());
        }
        
        public String next() {
            int c = read();
            while (isSpaceCharacter(c)) {
                c = read();
            }
            StringBuilder result = new StringBuilder();
            do {
                result.appendCodePoint(c);
                c = read();
            } while (!isSpaceCharacter(c));
            return result.toString();
        }
        
        public String nextLine() {
            int c = read();
            while (isEndOfLine(c)) {
                c = read();
            }
            StringBuilder result = new StringBuilder();
            do {
                result.appendCodePoint(c);
                c = read();
            } while (!isEndOfLine(c));
            return result.toString();
        }
    }
}