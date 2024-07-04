import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        FastReader in = new FastReader(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int testCases = in.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            long n = in.nextInt();
            List<int[]> result = calculatePath(n);
            pw.println("Case #" + t + ":");
            for (int[] coordinates : result) {
                pw.println(coordinates[0] + " " + coordinates[1]);
            }
        }

        pw.close();
    }

    static List<int[]> calculatePath(long n) {
        int row = 1;
        long sum = 1;
        int direction = 0;
        List<int[]> path = new ArrayList<>();
        
        while (n > 0) {
            if (n > sum) {
                if (direction == 0) {
                    for (int i = 1; i <= row; i++) {
                        path.add(new int[]{row, i});
                    }
                } else {
                    for (int i = row; i >= 1; i--) {
                        path.add(new int[]{row, i});
                    }
                }
                n -= sum;
                direction ^= 1;
            } else {
                if (direction == 1) {
                    path.add(new int[]{row, row});
                } else {
                    path.add(new int[]{row, 1});
                }
                n--;
            }
            row++;
            sum *= 2;
        }
        
        return path;
    }

    static class FastReader {
        InputStream stream;
        private byte[] buffer = new byte[1024];
        private int bufferLength = 0, bufferPointer = 0;

        public FastReader(InputStream stream) {
            this.stream = stream;
        }

        public int readByte() {
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

        public String nextLine() {
            int c = skip();
            StringBuilder sb = new StringBuilder();
            while (c != '\n' && c != '\r' && c != -1) {
                sb.appendCodePoint(c);
                c = readByte();
            }
            return sb.toString();
        }

        public int nextInt() {
            int number = 0, b;
            boolean negative = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
            if (b == '-') {
                negative = true;
                b = readByte();
            }
            while (true) {
                if (b >= '0' && b <= '9') {
                    number = number * 10 + (b - '0');
                } else {
                    return negative ? -number : number;
                }
                b = readByte();
            }
        }

        public long nextLong() {
            long number = 0;
            int b;
            boolean negative = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
            if (b == '-') {
                negative = true;
                b = readByte();
            }
            while (true) {
                if (b >= '0' && b <= '9') {
                    number = number * 10 + (b - '0');
                } else {
                    return negative ? -number : number;
                }
                b = readByte();
            }
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public char readChar() {
            return (char) skip();
        }
    }
}