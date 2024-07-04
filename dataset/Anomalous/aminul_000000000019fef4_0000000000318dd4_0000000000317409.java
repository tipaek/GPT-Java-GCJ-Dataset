import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        FastReader reader = new FastReader(System.in);
        PrintWriter writer = new PrintWriter(System.out);
        int testCases = reader.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int x = reader.nextInt();
            int y = reader.nextInt();
            char[] directions = reader.next().toCharArray();
            long result = calculateMinimumMoves(x, y, directions);
            writer.println("Case #" + t + ": " + (result == -1 ? "IMPOSSIBLE" : result));
        }
        
        writer.close();
    }

    static long calculateMinimumMoves(long x, long y, char[] directions) {
        if (x == 0 && y == 0) return 0;
        
        int moves = 0;
        for (char direction : directions) {
            switch (direction) {
                case 'N': y++; break;
                case 'S': y--; break;
                case 'E': x++; break;
                case 'W': x--; break;
            }
            moves++;
            long distance = Math.abs(x) + Math.abs(y);
            if (distance <= moves) {
                return moves;
            }
        }
        
        return -1;
    }

    static class FastReader {
        private InputStream inputStream;
        private byte[] buffer = new byte[1024];
        private int bufferLength = 0, bufferPointer = 0;

        public FastReader(InputStream inputStream) {
            this.inputStream = inputStream;
        }

        private int readByte() {
            if (bufferLength == -1) throw new InputMismatchException();
            if (bufferPointer >= bufferLength) {
                bufferPointer = 0;
                try {
                    bufferLength = inputStream.read(buffer);
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
    }
}