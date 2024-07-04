import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

class Solution {

    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();

        int t = reader.nextInt();
        for (int testCase = 1; testCase <= t; testCase++) {
            long x = reader.nextLong();
            long y = reader.nextLong();

            result = new StringBuilder();
            if (backTrack(0, 0, x, y, 1, new StringBuilder())) {
                System.out.printf("Case #%d: %s\n", testCase, result.toString());
            }
            else {
                System.out.printf("Case #%d: IMPOSSIBLE\n", testCase);
            }
        }
    }

    private static StringBuilder result;
    private static boolean backTrack(long x, long y, long targetX, long targetY, long two, StringBuilder currResult) {
        if (x == targetX && y == targetY) {
            result = currResult;
            return true;
        }
        else if (Math.abs(x) > targetX || Math.abs(y) > targetY) {
            return false;
        }
        else {
            currResult.append('E');
            boolean first = backTrack(x + two, y, targetX, targetY, two * 2, currResult);
            if (first) {
                return true;
            }
            currResult.deleteCharAt(currResult.length()-1);

            currResult.append('W');
            boolean second = backTrack(x - two, y, targetX, targetY, two * 2, currResult);
            if (second) {
                return true;
            }
            currResult.deleteCharAt(currResult.length()-1);

            currResult.append('N');
            boolean third = backTrack(x, y + two, targetX, targetY, two * 2, currResult);
            if (third) {
                return true;
            }
            currResult.deleteCharAt(currResult.length()-1);

            currResult.append('S');
            boolean fourth = backTrack(x, y - two, targetX, targetY, two * 2, currResult);
            if (fourth) {
                return true;
            }
            currResult.deleteCharAt(currResult.length()-1);
        }
        return false;
    }

    /**
     * Fast input code borrowed from
     * http://www.geeksforgeeks.org/fast-io-in-java-in-competitive-programming/
     */
    private static class Reader {
        private final int BUFFER_SIZE = 1 << 16;
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
            byte[] buf = new byte[10000000];
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    break;
                }
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg) {
                c = read();
            }
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg) {
                return -ret;
            }
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg) {
                c = read();
            }
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg) {
                return -ret;
            }
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg) {
                c = read();
            }
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }
            if (neg) {
                return -ret;
            }
            return ret;
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
    }

}
