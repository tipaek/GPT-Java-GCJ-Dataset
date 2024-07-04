import java.io.*;

public class Solution {
    static Reader sc;
    static Printer out;
    static final String dir = System.getProperty("user.dir");
    static int n, l, r, u, e, len;
    static int[] totLen;
    static String[] lPatterns, rPatterns, uPatterns, excess, maxStr;
    static String pattern;
    static StringBuilder[] output;

    public static void main(String[] args) throws IOException {
        sc = new Reader();
        out = new Printer();
        int testCases = Integer.parseInt(sc.readLine());

        for (int t = 0; t < testCases; t++) {
            n = Integer.parseInt(sc.readLine());
            initializeArrays(n);
            l = r = u = e = 0;
            totLen = new int[4];
            maxStr = new String[4];

            for (int i = 0; i < n; i++) {
                pattern = sc.readLine();
                len = pattern.length();
                processPattern();
            }

            String result = patternFinder();
            if (result.isEmpty()) {
                out.println("Case #" + (t + 1) + ": *");
            } else {
                out.println("Case #" + (t + 1) + ": " + result);
            }
        }

        out.close();
    }

    static void initializeArrays(int n) {
        lPatterns = new String[n * 10000];
        rPatterns = new String[n * 10000];
        uPatterns = new String[n * 10000];
        excess = new String[n];
    }

    static void processPattern() {
        StringBuilder p = new StringBuilder(len);
        boolean lAst = pattern.charAt(0) == '*';

        for (int j = 0; j < len; j++) {
            if (pattern.charAt(j) == '*' && j != 0) {
                p.append('*');
                if (lAst) {
                    uPatterns[u++] = p.toString();
                    updateMaxStr(0, p);
                } else {
                    lPatterns[l++] = p.toString();
                    updateMaxStr(1, p);
                }
                p = new StringBuilder(len);
                p.append('*');
                while (j < pattern.length() - 1 && pattern.charAt(j + 1) == '*') {
                    j++;
                }
                lAst = true;
            } else {
                p.append(pattern.charAt(j));
            }
        }

        if (pattern.charAt(pattern.length() - 1) != '*') {
            rPatterns[r++] = p.toString();
            updateMaxStr(2, p);
        }
    }

    static void updateMaxStr(int index, StringBuilder p) {
        if (len > totLen[index]) {
            totLen[index] = p.length();
            maxStr[index] = p.toString();
        }
    }

    static String patternFinder() {
        output = new StringBuilder[4];
        for (int i = 0; i < 4; i++) {
            output[i] = new StringBuilder();
        }

        if (totLen[1] != 0) {
            output[0] = new StringBuilder(maxStr[1].substring(0, maxStr[1].length() - 1));
            if (!validatePatterns(lPatterns, l, output[0], false)) return "*";
        }

        if (totLen[2] != 0) {
            output[1] = new StringBuilder(maxStr[2].substring(1));
            if (!validatePatterns(rPatterns, r, output[1], true)) return "*";
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

    static boolean validatePatterns(String[] patterns, int count, StringBuilder output, boolean reverse) {
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < patterns[i].length() - 1; j++) {
                if (reverse) {
                    if (output.charAt(output.length() - j - 1) != patterns[i].charAt(patterns[i].length() - j - 1)) {
                        return false;
                    }
                } else {
                    if (output.charAt(j) != patterns[i].charAt(j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    static class Printer {
        private OutputStream outputStream;

        public Printer() {
            outputStream = new BufferedOutputStream(System.out);
        }

        public Printer(String file_name) {
            try {
                outputStream = new BufferedOutputStream(new FileOutputStream(file_name));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public void print(Object object) throws IOException {
            outputStream.write(String.valueOf(object).getBytes());
        }

        public void println() throws IOException {
            outputStream.write("\n".getBytes());
        }

        public void println(Object object) throws IOException {
            outputStream.write((object + "\n").getBytes());
        }

        public void close() throws IOException {
            outputStream.flush();
        }
    }

    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
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
            byte[] buf = new byte[250];
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
            if (din == null) return;
            din.close();
        }
    }
}