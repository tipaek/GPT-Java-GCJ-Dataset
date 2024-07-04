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
            HashMap<Integer, HashSet<Integer>> rowMap = new HashMap<>();
            HashMap<Integer, HashSet<Integer>> colMap = new HashMap<>();
            
            for (int j = 0; j < n; j++) {
                rowMap.put(j, new HashSet<>());
                colMap.put(j, new HashSet<>());
            }
            
            boolean[] rowDuplicates = new boolean[n];
            boolean[] colDuplicates = new boolean[n];
            int sumDiagonal = 0;
            
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    int value = reader.nextInt();
                    if (row == col) {
                        sumDiagonal += value;
                    }
                    
                    if (rowMap.get(row).contains(value)) {
                        rowDuplicates[row] = true;
                    } else {
                        rowMap.get(row).add(value);
                    }
                    
                    if (colMap.get(col).contains(value)) {
                        colDuplicates[col] = true;
                    } else {
                        colMap.get(col).add(value);
                    }
                }
            }
            
            int rowCount = 0;
            int colCount = 0;
            for (int j = 0; j < n; j++) {
                if (rowDuplicates[j]) rowCount++;
                if (colDuplicates[j]) colCount++;
            }
            
            System.out.println(sumDiagonal + " " + rowCount + " " + colCount);
        }
    }

    static class Reader {
        private static final int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String fileName) throws IOException {
            din = new DataInputStream(new FileInputStream(fileName));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64];
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            return neg ? -ret : ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            return neg ? -ret : ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }
            return neg ? -ret : ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din != null) din.close();
        }
    }
}