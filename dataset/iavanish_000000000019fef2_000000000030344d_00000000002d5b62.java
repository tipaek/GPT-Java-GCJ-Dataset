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

            long xx = x;
            long yy = y;

            if (x == 0) {
                StringBuilder result = new StringBuilder();
                long two = 1;
                long curr = 0;
                long yyy = Math.abs(y);
                while (curr < yyy) {
                    if (y < 0) {
                        result.append('S');
                    }
                    else {
                        result.append('N');
                    }
                    curr += two;
                    two *= 2;
                }
                if (curr == yyy) {
                    System.out.printf("Case #%d: %s\n", testCase, result.toString());
                    continue;
                }
            }
            if (y == 0) {
                StringBuilder result = new StringBuilder();
                long two = 1;
                long curr = 0;
                long xxx = Math.abs(x);
                while (curr < xxx) {
                    if (x < 0) {
                        result.append('W');
                    }
                    else {
                        result.append('E');
                    }
                    curr += two;
                    two *= 2;
                }
                if (curr == xxx) {
                    System.out.printf("Case #%d: %s\n", testCase, result.toString());
                    continue;
                }
            }

            if (xx == 0 || yy == 0) {
                System.out.printf("Case #%d: IMPOSSIBLE\n", testCase);
                continue;
            }


            StringBuilder result = new StringBuilder();
            long two = 1;
            long currX = 0;
            for (int i = 0; i < 10000 && x != currX; i++) {
                if (two == Math.abs(y)) {
                    if (y < 0) {
                        result.append('S');
                    }
                    else {
                        result.append('N');
                    }
                    y = 0;
                }
                else if (two == Math.abs(x - currX)) {
                    if (x < 0) {
                        result.append('W');
                        currX -= two;
                    }
                    else {
                        result.append('E');
                        currX += two;
                    }
                }
                else {
                    if (x < 0) {
                        result.append('E');
                        currX += two;
                    }
                    else {
                        result.append('W');
                        currX -= two;
                    }
                }
                two *= 2;
            }
            if (two == Math.abs(y)) {
                if (y < 0) {
                    result.append('S');
                }
                else {
                    result.append('N');
                }
                y = 0;
            }
            if (currX == x && y == 0) {
                System.out.printf("Case #%d: %s\n", testCase, result.toString());
                continue;
            }

            x = xx;
            y = yy;
            result = new StringBuilder();
            two = 1;
            currX = 0;
            for (int i = 0; i < 10000 && y != currX; i++) {
                if (two == Math.abs(x)) {
                    if (x < 0) {
                        result.append('W');
                    }
                    else {
                        result.append('E');
                    }
                    x = 0;
                }
                else if (two == Math.abs(y - currX)) {
                    if (y < 0) {
                        result.append('S');
                        currX -= two;
                    }
                    else {
                        result.append('N');
                        currX += two;
                    }
                }
                else {
                    if (y < 0) {
                        result.append('N');
                        currX += two;
                    }
                    else {
                        result.append('S');
                        currX -= two;
                    }
                }
                two *= 2;
            }
            if (two == Math.abs(x)) {
                if (x < 0) {
                    result.append('W');
                }
                else {
                    result.append('E');
                }
                x = 0;
            }
            if (currX == y && x == 0) {
                System.out.printf("Case #%d: %s\n", testCase, result.toString());
                continue;
            }

            System.out.printf("Case #%d: IMPOSSIBLE\n", testCase);
        }
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
