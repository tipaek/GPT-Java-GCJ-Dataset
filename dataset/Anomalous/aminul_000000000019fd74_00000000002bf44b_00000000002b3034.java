import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        FastReader in = new FastReader(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int testCases = in.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int n = in.nextInt();
            char[][] patterns = new char[n][];
            for (int i = 0; i < n; i++) {
                patterns[i] = in.next().toCharArray();
            }
            pw.println("Case #" + t + ": " + solve(n, patterns));
        }
        pw.close();
    }

    static String solve(int n, char[][] patterns) {
        int[] prefixLengths = new int[n];
        int[] suffixLengths = new int[n];
        int maxPrefixLength = 0, maxSuffixLength = 0;
        int prefixIndex = -1, suffixIndex = -1;

        for (int i = 0; i < n; i++) {
            int currentLength = 0;
            for (char c : patterns[i]) {
                if (c == '*') break;
                prefixLengths[i]++;
                currentLength++;
            }
            if (currentLength > maxPrefixLength) {
                maxPrefixLength = currentLength;
                prefixIndex = i;
            }
        }

        for (int i = 0; i < n; i++) {
            int currentLength = 0;
            suffixLengths[i] = patterns[i].length - 1;
            for (int j = patterns[i].length - 1; j >= 0; j--) {
                char c = patterns[i][j];
                if (c == '*') break;
                suffixLengths[i]--;
                currentLength++;
            }
            if (currentLength > maxSuffixLength) {
                maxSuffixLength = currentLength;
                suffixIndex = i;
            }
        }

        if (prefixIndex != -1) {
            for (char[] pattern : patterns) {
                if (!checkPrefix(maxPrefixLength, patterns[prefixIndex], pattern)) return "*";
            }
        }

        if (suffixIndex != -1) {
            for (char[] pattern : patterns) {
                if (!checkSuffix(maxSuffixLength, patterns[suffixIndex], pattern)) return "*";
            }
        }

        StringBuilder result = new StringBuilder();
        if (prefixIndex != -1) {
            for (int i = 0; i < maxPrefixLength; i++) {
                result.append(patterns[prefixIndex][i]);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = prefixLengths[i] + 1; j < suffixLengths[i]; j++) {
                if (patterns[i][j] != '*') result.append(patterns[i][j]);
            }
        }
        if (suffixIndex != -1) {
            for (int i = suffixLengths[suffixIndex] + 1; i < patterns[suffixIndex].length; i++) {
                result.append(patterns[suffixIndex][i]);
            }
        }

        return result.toString();
    }

    static boolean checkPrefix(int maxPrefixLength, char[] patternA, char[] patternB) {
        for (int i = 0; i < patternA.length && i < patternB.length && i < maxPrefixLength; i++) {
            if (patternB[i] == '*') break;
            if (patternA[i] != patternB[i]) return false;
        }
        return true;
    }

    static boolean checkSuffix(int maxSuffixLength, char[] patternA, char[] patternB) {
        for (int i = 0, j = patternA.length - 1, k = patternB.length - 1; j >= 0 && k >= 0 && i < maxSuffixLength; i++, j--, k--) {
            if (patternB[k] == '*') break;
            if (patternA[j] != patternB[k]) return false;
        }
        return true;
    }

    static class FastReader {
        InputStream is;
        byte[] buffer = new byte[1024];
        int bufferLength = 0, bufferPointer = 0;

        public FastReader(InputStream is) {
            this.is = is;
        }

        public int readByte() {
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

        public boolean isSpaceChar(int c) {
            return !(c >= 33 && c <= 126);
        }

        public int skip() {
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
    }
}