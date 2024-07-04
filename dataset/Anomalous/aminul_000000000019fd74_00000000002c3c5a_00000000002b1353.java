import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        FastReader reader = new FastReader(System.in);
        PrintWriter writer = new PrintWriter(System.out);
        int testCases = reader.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            long n = reader.nextInt();
            List<int[]> result = calculatePaths(n);
            
            writer.println("Case #" + t + ":");
            for (int[] coordinates : result) {
                writer.println(coordinates[0] + " " + coordinates[1]);
            }
        }
        
        writer.close();
    }

    static List<int[]> calculatePaths(long n) {
        int row = 1;
        long sum = 1;
        int direction = 0;
        List<int[]> result = new ArrayList<>();
        
        while (n > 0) {
            if (n > sum) {
                if (direction == 0) {
                    for (int i = 1; i <= row; i++) {
                        result.add(new int[]{row, i});
                    }
                } else {
                    for (int i = row; i >= 1; i--) {
                        result.add(new int[]{row, i});
                    }
                }
                n -= sum;
                direction ^= 1;
            } else {
                if (direction == 0) {
                    result.add(new int[]{row, row});
                } else {
                    result.add(new int[]{row, 1});
                }
                n--;
            }
            row++;
            sum *= 2;
        }
        return result;
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
            boolean negative = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
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
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
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

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public char[] next(int n) {
            char[] buf = new char[n];
            int b = skip(), p = 0;
            while (p < n && !isSpaceChar(b)) {
                buf[p++] = (char) b;
                b = readByte();
            }
            return n == p ? buf : Arrays.copyOf(buf, p);
        }

        public char readChar() {
            return (char) skip();
        }
    }
}