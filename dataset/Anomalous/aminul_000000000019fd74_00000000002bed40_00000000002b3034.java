import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        FastReader in = new FastReader(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int testCases = in.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int n = in.nextInt();
            char[][] patterns = new char[n][];
            
            for (int i = 0; i < n; i++) {
                patterns[i] = in.next().toCharArray();
            }
            
            pw.println(findPattern(n, patterns));
        }
        
        pw.close();
    }

    static String findPattern(int n, char[][] patterns) {
        int[] prefixLengths = new int[n];
        int[] suffixLengths = new int[n];
        int maxPrefixLength = 0, maxSuffixLength = 0;
        int prefixIndex = -1, suffixIndex = -1;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (char c : patterns[i]) {
                if (c == '*') break;
                prefixLengths[i]++;
                count++;
            }
            if (count > maxPrefixLength) {
                maxPrefixLength = count;
                prefixIndex = i;
            }
        }

        for (int i = 0; i < n; i++) {
            int count = 0;
            suffixLengths[i] = patterns[i].length - 1;
            for (int j = patterns[i].length - 1; j >= 0; j--) {
                if (patterns[i][j] == '*') break;
                suffixLengths[i]--;
                count++;
            }
            if (count > maxSuffixLength) {
                maxSuffixLength = count;
                suffixIndex = i;
            }
        }

        if (prefixIndex != -1) {
            for (char[] pattern : patterns) {
                if (!isPrefixValid(maxPrefixLength, patterns[prefixIndex], pattern)) {
                    return "*";
                }
            }
        }

        if (suffixIndex != -1) {
            for (char[] pattern : patterns) {
                if (!isSuffixValid(maxSuffixLength, patterns[suffixIndex], pattern)) {
                    return "*";
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < maxPrefixLength; i++) {
            result.append(patterns[prefixIndex][i]);
        }
        for (int i = 0; i < n; i++) {
            for (int k = prefixLengths[i] + 1; k < suffixLengths[i]; k++) {
                if (patterns[i][k] != '*') {
                    result.append(patterns[i][k]);
                }
            }
        }
        if (suffixIndex != -1) {
            for (int i = suffixLengths[suffixIndex] + 1; i < patterns[suffixIndex].length; i++) {
                result.append(patterns[suffixIndex][i]);
            }
        }

        return result.toString();
    }

    static boolean isPrefixValid(int maxPrefixLength, char[] a, char[] b) {
        for (int i = 0; i < maxPrefixLength && i < a.length && i < b.length; i++) {
            if (b[i] == '*') break;
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    static boolean isSuffixValid(int maxSuffixLength, char[] a, char[] b) {
        for (int i = 0, j = a.length - 1, k = b.length - 1; i < maxSuffixLength && j >= 0 && k >= 0; i++, j--, k--) {
            if (b[k] == '*') break;
            if (a[j] != b[k]) return false;
        }
        return true;
    }

    static class FastReader {
        InputStream is;
        private byte[] buffer = new byte[1024];
        private int bufferLength = 0, bufferPointer = 0;

        public FastReader(InputStream is) {
            this.is = is;
        }

        private int readByte() {
            if (bufferLength == -1) throw new InputMismatchException();
            if (bufferPointer >= bufferLength) {
                bufferPointer = 0;
                try {
                    bufferLength = is.read(buffer);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (bufferLength <= 0) return -1;
            }
            return buffer[bufferPointer++];
        }

        private boolean isSpaceChar(int c) {
            return !(c >= 33 && c <= 126);
        }

        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }

        private int skip() {
            int b;
            while ((b = readByte()) != -1 && isSpaceChar(b));
            return b;
        }

        public String next() {
            int b = skip();
            StringBuilder sb = new StringBuilder();
            while (!isSpaceChar(b)) {
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }

        public String nextLine() {
            int c = skip();
            StringBuilder sb = new StringBuilder();
            while (!isEndOfLine(c)) {
                sb.appendCodePoint(c);
                c = readByte();
            }
            return sb.toString();
        }

        public int nextInt() {
            int num = 0, b;
            boolean negative = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
            if (b == '-') {
                negative = true;
                b = readByte();
            }
            while (true) {
                if (b >= '0' && b <= '9') {
                    num = num * 10 + (b - '0');
                } else {
                    return negative ? -num : num;
                }
                b = readByte();
            }
        }

        public long nextLong() {
            long num = 0;
            int b;
            boolean negative = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
            if (b == '-') {
                negative = true;
                b = readByte();
            }
            while (true) {
                if (b >= '0' && b <= '9') {
                    num = num * 10 + (b - '0');
                } else {
                    return negative ? -num : num;
                }
                b = readByte();
            }
        }
    }
}