import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

public class Test {

    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        int testCases = reader.nextInt();
        for (int i = 0; i < testCases; i++) {
            int n = reader.nextInt();
            HashMap<Integer, HashSet<Integer>> rowSets = new HashMap<>();
            HashMap<Integer, HashSet<Integer>> colSets = new HashMap<>();
            for (int j = 0; j < n; j++) {
                rowSets.put(j, new HashSet<>());
                colSets.put(j, new HashSet<>());
            }
            boolean[] rowDuplicates = new boolean[n];
            boolean[] colDuplicates = new boolean[n];
            
            int diagonalSum = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    int value = reader.nextInt();
                    if (j == k) {
                        diagonalSum += value;
                    }
                    if (rowSets.get(j).contains(value)) {
                        rowDuplicates[j] = true;
                    } else {
                        rowSets.get(j).add(value);
                    }
                    if (colSets.get(k).contains(value)) {
                        colDuplicates[k] = true;
                    } else {
                        colSets.get(k).add(value);
                    }
                }
            }
            
            int rowDuplicateCount = 0;
            int colDuplicateCount = 0;
            for (int j = 0; j < n; j++) {
                if (rowDuplicates[j]) {
                    rowDuplicateCount++;
                }
                if (colDuplicates[j]) {
                    colDuplicateCount++;
                }
            }
            System.out.println(diagonalSum + " " + rowDuplicateCount + " " + colDuplicateCount);
        }
    }

    static class Reader {
        private static final int BUFFER_SIZE = 1 << 16;
        private DataInputStream dataInputStream;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            dataInputStream = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String fileName) throws IOException {
            dataInputStream = new DataInputStream(new FileInputStream(fileName));
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

            return negative ? -result : result;
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
            return negative ? -result : result;
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

            return negative ? -result : result;
        }

        private void fillBuffer() throws IOException {
            bytesRead = dataInputStream.read(buffer, bufferPointer = 0, BUFFER_SIZE);
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
            if (dataInputStream != null) {
                dataInputStream.close();
            }
        }
    }
}