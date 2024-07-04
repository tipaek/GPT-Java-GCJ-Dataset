import java.io.*;

public class Solution {
    static Reader sc;
    static Printer out;
    static int n, l, r, u, e, len;
    static int[] totLen;
    static String[] lPatterns, rPatterns, uPatterns, excess, maxStr;
    static StringBuilder[] output;

    public static void main(String[] args) throws IOException {
        sc = new Reader();
        out = new Printer();
        int testCases = sc.nextInt();

        for (int t = 0; t < testCases; t++) {
            n = sc.nextInt();
            lPatterns = new String[n];
            rPatterns = new String[n];
            uPatterns = new String[n];
            excess = new String[n];
            l = r = u = e = 0;
            totLen = new int[4];
            maxStr = new String[4];

            for (int i = 0; i < n; i++) {
                String pattern = sc.readLine();
                len = pattern.length();
                StringBuilder p = new StringBuilder(len);
                boolean lAst = pattern.charAt(0) == '*';

                for (int j = 0; j < len; j++) {
                    if (pattern.charAt(j) == '*' && j != 0) {
                        p.append('*');
                        if (lAst) {
                            uPatterns[u++] = p.toString();
                            if (len > totLen[0]) {
                                totLen[0] = p.length();
                                maxStr[0] = p.toString();
                            }
                        } else {
                            lPatterns[l++] = p.toString();
                            if (len > totLen[1]) {
                                totLen[1] = p.length();
                                maxStr[1] = p.toString();
                            }
                        }
                        p = new StringBuilder(len);
                        lAst = true;
                    } else {
                        p.append(pattern.charAt(j));
                    }
                }

                if (pattern.charAt(pattern.length() - 1) != '*') {
                    rPatterns[r++] = p.toString();
                    if (len > totLen[2]) {
                        totLen[2] = p.length();
                        maxStr[2] = p.toString();
                    }
                }
            }

            out.println("Case #" + (t + 1) + ": " + patternFinder());
        }

        out.close();
    }

    static String patternFinder() {
        output = new StringBuilder[4];
        for (int i = 0; i < 4; i++) {
            output[i] = new StringBuilder("");
        }

        if (totLen[1] != 0) {
            output[0] = new StringBuilder(maxStr[1].substring(0, maxStr[1].length() - 1));
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < lPatterns[i].length() - 1; j++) {
                    if (output[0].charAt(j) != lPatterns[i].charAt(j))
                        return "*";
                }
            }
        }

        if (totLen[2] != 0) {
            output[1] = new StringBuilder(maxStr[2].substring(1));
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < rPatterns[i].length() - 1; j++) {
                    if (output[1].charAt(output[1].length() - j - 1) != rPatterns[i].charAt(rPatterns[i].length() - j - 1))
                        return "*";
                }
            }
        }

        if (totLen[0] != 0) {
            output[2] = new StringBuilder(maxStr[0].length() * 50);
            for (int i = 0; i < u; i++) {
                output[2].append(uPatterns[i].substring(1, uPatterns[i].length() - 1));
            }
        }

        output[2].append(output[1]);
        return output[0].toString() + output[2].toString();
    }

    static class Printer {
        private OutputStream outputStream;

        public Printer() {
            outputStream = new BufferedOutputStream(System.out);
        }

        public void print(Object object) throws IOException {
            outputStream.write(String.valueOf(object).getBytes());
        }

        public void println(Object object) throws IOException {
            outputStream.write((object + "\n").getBytes());
        }

        public void close() throws IOException {
            outputStream.flush();
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
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }
}