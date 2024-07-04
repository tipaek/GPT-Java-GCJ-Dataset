import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        FastReader reader = new FastReader(System.in);
        PrintWriter writer = new PrintWriter(System.out);
        int testCases = reader.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = reader.nextInt();
            int d = reader.nextInt();
            long[] array = new long[n];

            for (int i = 0; i < n; i++) {
                array[i] = reader.nextLong();
            }

            int result = (d == 2) ? solveForD2(n, array) : solveForD3(n, array);
            writer.println("Case #" + t + ": " + result);
        }

        writer.close();
    }

    private static int solveForD3(int n, long[] array) {
        TreeMap<Long, Integer> frequencyMap = new TreeMap<>();
        boolean canBeOne = false;

        for (long value : array) {
            frequencyMap.put(value, frequencyMap.getOrDefault(value, 0) + 1);
        }

        int maxFrequency = 0;

        for (Map.Entry<Long, Integer> entry : frequencyMap.entrySet()) {
            long key = entry.getKey();
            int frequency = entry.getValue();
            maxFrequency = Math.max(maxFrequency, frequency);

            if (frequency + (frequencyMap.getOrDefault(key * 2, 0) * 2) >= 3) {
                canBeOne = true;
            }

            if (frequency >= 2 && frequencyMap.higherKey(key) != null) {
                canBeOne = true;
            }
        }

        if (maxFrequency >= 3) {
            return 0;
        } else if (canBeOne) {
            return 1;
        } else {
            return 2;
        }
    }

    private static int solveForD2(int n, long[] array) {
        TreeMap<Long, Integer> frequencyMap = new TreeMap<>();

        for (long value : array) {
            frequencyMap.put(value, frequencyMap.getOrDefault(value, 0) + 1);
        }

        int maxFrequency = 0;

        for (int frequency : frequencyMap.values()) {
            maxFrequency = Math.max(maxFrequency, frequency);
        }

        return (maxFrequency >= 2) ? 0 : 1;
    }

    static class FastReader {
        private InputStream stream;
        private byte[] buffer = new byte[1024];
        private int bufferLength = 0, bufferPointer = 0;

        public FastReader(InputStream stream) {
            this.stream = stream;
        }

        private int readByte() {
            if (bufferLength == -1) {
                throw new InputMismatchException();
            }
            if (bufferPointer >= bufferLength) {
                bufferPointer = 0;
                try {
                    bufferLength = stream.read(buffer);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (bufferLength <= 0) {
                    return -1;
                }
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
            while ((b = readByte()) != -1 && isSpaceChar(b)) ;
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
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
            if (b == '-') {
                minus = true;
                b = readByte();
            }
            while (true) {
                if (b >= '0' && b <= '9') {
                    num = num * 10 + (b - '0');
                } else {
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }

        public long nextLong() {
            long num = 0;
            int b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
            if (b == '-') {
                minus = true;
                b = readByte();
            }
            while (true) {
                if (b >= '0' && b <= '9') {
                    num = num * 10 + (b - '0');
                } else {
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public char[] next(int n) {
            char[] buffer = new char[n];
            int b = skip(), p = 0;
            while (p < n && !isSpaceChar(b)) {
                buffer[p++] = (char) b;
                b = readByte();
            }
            return (n == p) ? buffer : Arrays.copyOf(buffer, p);
        }

        public char readChar() {
            return (char) skip();
        }
    }
}