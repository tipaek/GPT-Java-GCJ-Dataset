import java.io.*;
import java.util.*;

public class Solution {

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

        public Reader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
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

    public static void main(String[] args) throws IOException {
        Reader sc = new Reader();
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int N = sc.nextInt();
            List<Integer> startTimes = new ArrayList<>();
            List<Integer> endTimes = new ArrayList<>();
            List<String> status = new ArrayList<>();

            for (int j = 0; j < N; j++) {
                startTimes.add(sc.nextInt());
                endTimes.add(sc.nextInt());
            }
            status.add("ok");

            for (int j = 0; j < N; j++) {
                if ((j + 1) < N && endTimes.get(j) > startTimes.get(j + 1)) {
                    status.add("overlap");
                } else if ((j + 1) < N) {
                    status.add("nooverlap");
                }
            }

            StringBuilder result = new StringBuilder("C");
            for (int j = 0; j < N; j++) {
                if ((j + 1) < N && "overlap".equals(status.get(j + 1))) {
                    result.append(result.charAt(j) == 'C' ? "J" : "C");
                } else if ((j + 1) < N) {
                    result.append("C");
                }
            }

            int overlapCount = 0;
            for (String s : status) {
                if ("overlap".equals(s)) overlapCount++;
            }

            if (overlapCount == status.size() - 1) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (i + 1) + ": " + result);
            }
        }
    }
}