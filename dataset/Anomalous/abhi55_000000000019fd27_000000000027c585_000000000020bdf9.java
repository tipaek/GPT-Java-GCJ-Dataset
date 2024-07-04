import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        FastReader reader = new FastReader();
        int testCases = reader.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = reader.nextInt();
            int[][] events = new int[2 * n][3];
            
            for (int i = 0; i < n; i++) {
                int startTime = reader.nextInt();
                int endTime = reader.nextInt();
                events[2 * i] = new int[]{startTime, 0, i}; // Event start
                events[2 * i + 1] = new int[]{endTime, 1, i}; // Event end
            }
            
            Arrays.sort(events, (a, b) -> {
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(a[1], b[1]);
            });
            
            char[] result = new char[n];
            Stack<Character> available = new Stack<>();
            available.push('J');
            available.push('C');
            int activeEvents = 0;
            
            boolean impossible = false;
            for (int[] event : events) {
                if (event[1] == 0) { // Event start
                    if (available.isEmpty()) {
                        impossible = true;
                        break;
                    }
                    result[event[2]] = available.pop();
                    activeEvents++;
                } else { // Event end
                    activeEvents--;
                    available.push(result[event[2]]);
                }
            }
            
            if (impossible) {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseNum + ": " + new String(result));
            }
        }
    }
    
    static class FastReader {
        final private int BUFFER_SIZE = 1 << 16;
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

        public String nextLine() throws IOException {
            byte[] buf = new byte[1000];
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
            if (neg) return -ret;
            return ret;
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
            if (neg) return -ret;
            return ret;
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
            if (neg) return -ret;
            return ret;
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
            if (din == null) return;
            din.close();
        }
    }
}