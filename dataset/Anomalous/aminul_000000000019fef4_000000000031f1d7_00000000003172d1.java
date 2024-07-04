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

    static int solveForD3(int n, long[] array) {
        TreeMap<Long, Integer> frequencyMap = new TreeMap<>();
        boolean possible = false;
        for (long value : array) {
            frequencyMap.put(value, frequencyMap.getOrDefault(value, 0) + 1);
        }
        int maxFrequency = 0;
        for (long key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            maxFrequency = Math.max(maxFrequency, frequency);
            if (key % 2 == 0 && (frequency + frequencyMap.getOrDefault(key / 2, 0)) >= 3) {
                possible = true;
            }
            if (frequency + (frequencyMap.getOrDefault(key * 2, 0) * 2) >= 3) {
                possible = true;
            }
        }
        if (maxFrequency >= 3) return 0;
        if (possible) return 1;
        return 2;
    }

    static int solveForD2(int n, long[] array) {
        TreeMap<Long, Integer> frequencyMap = new TreeMap<>();
        for (long value : array) {
            frequencyMap.put(value, frequencyMap.getOrDefault(value, 0) + 1);
        }
        int maxFrequency = 0;
        for (long key : frequencyMap.keySet()) {
            maxFrequency = Math.max(maxFrequency, frequencyMap.get(key));
        }
        if (maxFrequency >= 2) return 0;
        return 1;
    }

    static class FastReader {
        private InputStream stream;
        private byte[] buffer = new byte[1024];
        private int bufferLength = 0, bufferPointer = 0;

        public FastReader(InputStream stream) {
            this.stream = stream;
        }

        private int readByte() {
            if (bufferLength == -1) throw new InputMismatchException();
            if (bufferPointer >= bufferLength) {
                bufferPointer = 0;
                try {
                    bufferLength = stream.read(buffer);
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
            int byteRead;
            while ((byteRead = readByte()) != -1 && isSpaceChar(byteRead));
            return byteRead;
        }

        public String next() {
            int byteRead = skip();
            StringBuilder sb = new StringBuilder();
            while (!isSpaceChar(byteRead)) {
                sb.appendCodePoint(byteRead);
                byteRead = readByte();
            }
            return sb.toString();
        }

        public String nextLine() {
            int byteRead = skip();
            StringBuilder sb = new StringBuilder();
            while (!isEndOfLine(byteRead)) {
                sb.appendCodePoint(byteRead);
                byteRead = readByte();
            }
            return sb.toString();
        }

        public int nextInt() {
            int number = 0, byteRead;
            boolean negative = false;
            while ((byteRead = readByte()) != -1 && !((byteRead >= '0' && byteRead <= '9') || byteRead == '-'));
            if (byteRead == '-') {
                negative = true;
                byteRead = readByte();
            }
            while (true) {
                if (byteRead >= '0' && byteRead <= '9') {
                    number = (number << 3) + (number << 1) + (byteRead - '0');
                } else {
                    return negative ? -number : number;
                }
                byteRead = readByte();
            }
        }

        public long nextLong() {
            long number = 0;
            int byteRead;
            boolean negative = false;
            while ((byteRead = readByte()) != -1 && !((byteRead >= '0' && byteRead <= '9') || byteRead == '-'));
            if (byteRead == '-') {
                negative = true;
                byteRead = readByte();
            }
            while (true) {
                if (byteRead >= '0' && byteRead <= '9') {
                    number = (number << 3) + (number << 1) + (byteRead - '0');
                } else {
                    return negative ? -number : number;
                }
                byteRead = readByte();
            }
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public char[] next(int n) {
            char[] buffer = new char[n];
            int byteRead = skip(), pointer = 0;
            while (pointer < n && !isSpaceChar(byteRead)) {
                buffer[pointer++] = (char) byteRead;
                byteRead = readByte();
            }
            return (pointer == n) ? buffer : Arrays.copyOf(buffer, pointer);
        }

        public char readChar() {
            return (char) skip();
        }
    }
}