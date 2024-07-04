import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int t = Integer.parseInt(in.readLine());
        for (int _t = 0; _t < t; _t++) {
            int n = Integer.parseInt(in.readLine());
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.readLine();
            }
            String result = findPattern(arr);
            System.out.print("Case #" + (_t + 1) + ": ");
            System.out.println(result != null ? result : "*");
        }
        in.close();
    }

    private static String findPattern(String[] arr) {
        String bestPattern = null;
        for (int i = 0; i < arr.length; i++) {
            String s = arr[i].replace("*", "");
            int matchCount = 0;
            for (int j = 0; j < arr.length; j++) {
                if (j != i) {
                    int starIndex = arr[j].indexOf('*');
                    boolean startMatch = starIndex == 0 || s.startsWith(arr[j].substring(0, starIndex));
                    boolean endMatch = s.endsWith(arr[j].substring(starIndex + 1));
                    if (startMatch && endMatch) {
                        matchCount++;
                    }
                }
            }
            if (matchCount == arr.length - 1) {
                if (bestPattern == null || bestPattern.length() < s.length()) {
                    bestPattern = s;
                }
            }
        }
        return bestPattern;
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
            byte[] buf = new byte[64]; // line length
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