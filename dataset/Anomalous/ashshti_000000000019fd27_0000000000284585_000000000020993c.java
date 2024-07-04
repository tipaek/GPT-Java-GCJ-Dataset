import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

public class Test {

    public static void main(String[] args) throws IOException {
        FastReader reader = new FastReader();
        int testCases = reader.nextInt();
        
        for (int i = 0; i < testCases; i++) {
            int matrixSize = reader.nextInt();
            HashMap<Integer, HashSet<Integer>> rowMap = new HashMap<>();
            HashMap<Integer, HashSet<Integer>> colMap = new HashMap<>();
            
            for (int j = 0; j < matrixSize; j++) {
                rowMap.put(j, new HashSet<>());
                colMap.put(j, new HashSet<>());
            }
            
            boolean[] rowDuplicates = new boolean[matrixSize];
            boolean[] colDuplicates = new boolean[matrixSize];
            int diagonalSum = 0;
            
            for (int j = 0; j < matrixSize; j++) {
                for (int k = 0; k < matrixSize; k++) {
                    int value = reader.nextInt();
                    if (j == k) {
                        diagonalSum += value;
                    }
                    
                    if (rowMap.get(j).contains(value)) {
                        rowDuplicates[j] = true;
                    } else {
                        rowMap.get(j).add(value);
                    }
                    
                    if (colMap.get(k).contains(value)) {
                        colDuplicates[k] = true;
                    } else {
                        colMap.get(k).add(value);
                    }
                }
            }
            
            int rowDupCount = 0;
            int colDupCount = 0;
            
            for (int j = 0; j < matrixSize; j++) {
                if (rowDuplicates[j]) {
                    rowDupCount++;
                }
                if (colDuplicates[j]) {
                    colDupCount++;
                }
            }
            
            System.out.println(diagonalSum + " " + rowDupCount + " " + colDupCount);
        }
    }

    static class FastReader {
        private static final int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public FastReader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public FastReader(String fileName) throws IOException {
            din = new DataInputStream(new FileInputStream(fileName));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64];
            int count = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    break;
                }
                buf[count++] = (byte) c;
            }
            return new String(buf, 0, count);
        }

        public int nextInt() throws IOException {
            int result = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean negative = (c == '-');
            if (negative) {
                c = read();
            }
            do {
                result = result * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            
            if (negative) {
                return -result;
            }
            return result;
        }

        public long nextLong() throws IOException {
            long result = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean negative = (c == '-');
            if (negative) {
                c = read();
            }
            do {
                result = result * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            
            if (negative) {
                return -result;
            }
            return result;
        }

        public double nextDouble() throws IOException {
            double result = 0, divisor = 1;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean negative = (c == '-');
            if (negative) {
                c = read();
            }
            do {
                result = result * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            
            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    result += (c - '0') / (divisor *= 10);
                }
            }
            
            if (negative) {
                return -result;
            }
            return result;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) {
                buffer[0] = -1;
            }
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) {
                fillBuffer();
            }
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din != null) {
                din.close();
            }
        }
    }
}