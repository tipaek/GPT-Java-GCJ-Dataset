import java.io.*;

public class Solution {
    static Reader sc;
    static Printer out;
    static int n, l, r, u, e, len;
    static int[] totLen;
    static String[] lPatterns, rPatterns, uPatterns, maxStr;
    static StringBuilder[] output;

    public static void main(String[] args) throws IOException {
        sc = new Reader();
        out = new Printer();
        int testCases = Integer.parseInt(sc.readLine());

        for (int t = 0; t < testCases; t++) {
            n = Integer.parseInt(sc.readLine());
            initializePatterns();

            for (int i = 0; i < n; i++) {
                processPattern(sc.readLine());
            }

            String resultPattern = findPattern();
            out.println("Case #" + (t + 1) + ": " + (resultPattern.isEmpty() ? "*" : resultPattern));
        }

        out.close();
    }

    static void initializePatterns() {
        lPatterns = new String[n * 100];
        rPatterns = new String[n * 100];
        uPatterns = new String[n * 100];
        l = r = u = e = 0;
        totLen = new int[4];
        maxStr = new String[4];
    }

    static void processPattern(String pattern) {
        len = pattern.length();
        StringBuilder p = new StringBuilder(len);
        boolean lAst = pattern.charAt(0) == '*';

        for (int j = 0; j < len; j++) {
            if (pattern.charAt(j) == '*' && j != 0) {
                p.append('*');
                if (lAst) {
                    uPatterns[u++] = p.toString();
                    updateMaxStr(p, 0);
                } else {
                    lPatterns[l++] = p.toString();
                    updateMaxStr(p, 1);
                }
                p = new StringBuilder(len).append('*');
                lAst = true;
            } else {
                p.append(pattern.charAt(j));
            }
        }

        if (pattern.charAt(len - 1) != '*') {
            rPatterns[r++] = p.toString();
            updateMaxStr(p, 2);
        }
    }

    static void updateMaxStr(StringBuilder p, int index) {
        if (len > totLen[index]) {
            totLen[index] = p.length();
            maxStr[index] = p.toString();
        }
    }

    static String findPattern() {
        output = new StringBuilder[4];
        for (int i = 0; i < 4; i++) {
            output[i] = new StringBuilder();
        }

        if (!validatePatterns(1, lPatterns, l, 0, true) || !validatePatterns(2, rPatterns, r, 1, false)) {
            return "*";
        }

        if (totLen[0] != 0) {
            for (int i = 0; i < u; i++) {
                output[2].append(uPatterns[i], 1, uPatterns[i].length() - 1);
            }
        }

        output[2].append(output[1]);
        return output[0].toString() + output[2].toString();
    }

    static boolean validatePatterns(int totLenIndex, String[] patterns, int patternCount, int outputIndex, boolean isLeft) {
        if (totLen[totLenIndex] != 0) {
            output[outputIndex].append(maxStr[totLenIndex], isLeft ? 0 : 1, maxStr[totLenIndex].length() - (isLeft ? 1 : 0));
            for (int i = 0; i < patternCount; i++) {
                for (int j = 0; j < patterns[i].length() - 1; j++) {
                    if (output[outputIndex].charAt(isLeft ? j : output[outputIndex].length() - j - 1) != patterns[i].charAt(j)) {
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
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[150];
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
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