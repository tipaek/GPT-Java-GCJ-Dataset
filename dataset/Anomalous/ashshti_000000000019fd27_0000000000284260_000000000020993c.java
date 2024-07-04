import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

public class Test {

    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        int testCases = reader.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int n = reader.nextInt();
            HashMap<Integer, HashSet<Integer>> rowMap = new HashMap<>();
            HashMap<Integer, HashSet<Integer>> colMap = new HashMap<>();
            
            for (int i = 0; i < n; i++) {
                rowMap.put(i, new HashSet<>());
                colMap.put(i, new HashSet<>());
            }
            
            boolean[] rowDuplicate = new boolean[n];
            boolean[] colDuplicate = new boolean[n];
            
            int diagonalSum = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int value = reader.nextInt();
                    if (i == j) {
                        diagonalSum += value;
                    }
                    
                    if (rowMap.get(i).contains(value)) {
                        rowDuplicate[i] = true;
                    } else {
                        rowMap.get(i).add(value);
                    }
                    
                    if (colMap.get(j).contains(value)) {
                        colDuplicate[j] = true;
                    } else {
                        colMap.get(j).add(value);
                    }
                }
            }
            
            int rowSum = 0;
            int colSum = 0;
            for (int i = 0; i < n; i++) {
                if (rowDuplicate[i]) rowSum++;
                if (colDuplicate[i]) colSum++;
            }
            
            System.out.println(diagonalSum + " " + rowSum + " " + colSum);
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
                if (c == '\n') break;
                buf[count++] = (byte) c;
            }
            return new String(buf, 0, count);
        }

        public int nextInt() throws IOException {
            int result = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean negative = (c == '-');
            if (negative) c = read();
            do {
                result = result * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            return negative ? -result : result;
        }

        public long nextLong() throws IOException {
            long result = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean negative = (c == '-');
            if (negative) c = read();
            do {
                result = result * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            return negative ? -result : result;
        }

        public double nextDouble() throws IOException {
            double result = 0, div = 1;
            byte c = read();
            while (c <= ' ') c = read();
            boolean negative = (c == '-');
            if (negative) c = read();
            do {
                result = result * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    result += (c - '0') / (div *= 10);
                }
            }
            return negative ? -result : result;
        }

        private void fillBuffer() throws IOException {
            bytesRead = dataInputStream.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (dataInputStream != null) dataInputStream.close();
        }
    }
}