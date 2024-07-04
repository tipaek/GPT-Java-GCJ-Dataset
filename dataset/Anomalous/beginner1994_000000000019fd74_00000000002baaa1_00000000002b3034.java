import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Solution {

    private static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int t = Integer.parseInt(in.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            int n = Integer.parseInt(in.readLine());
            String[] patterns = new String[n];
            for (int i = 0; i < n; i++) {
                patterns[i] = in.readLine().replace("*", ".*");
            }
            String result = findMatchingString(patterns);
            System.out.printf("Case #%d: %s%n", testCase, result != null ? result : "*");
        }
        in.close();
    }

    private static String findMatchingString(String[] patterns) {
        for (String pattern : patterns) {
            String corePattern = pattern.replace(".*", "");
            boolean matchesAll = true;
            for (String otherPattern : patterns) {
                if (!Pattern.matches(otherPattern, corePattern)) {
                    matchesAll = false;
                    break;
                }
            }
            if (matchesAll) {
                return corePattern;
            }
        }
        return null;
    }

    static class FastReader {
        private static final int BUFFER_SIZE = 1 << 16;
        private final DataInputStream din;
        private final byte[] buffer;
        private int bufferPointer, bytesRead;

        public FastReader() {
            this.din = new DataInputStream(System.in);
            this.buffer = new byte[BUFFER_SIZE];
            this.bufferPointer = this.bytesRead = 0;
        }

        public FastReader(String fileName) throws IOException {
            this.din = new DataInputStream(new FileInputStream(fileName));
            this.buffer = new byte[BUFFER_SIZE];
            this.bufferPointer = this.bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64];
            int count = 0;
            int c;
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
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din != null) {
                din.close();
            }
        }
    }
}